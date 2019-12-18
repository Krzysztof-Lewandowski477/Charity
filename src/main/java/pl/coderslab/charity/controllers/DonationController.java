package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.dtos.DonationDataDTO;
import pl.coderslab.charity.services.DonationServices;

import javax.validation.Valid;

@Controller
@RequestMapping
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final DonationServices donationServices;

    public DonationController(CategoryRepository categoryRepository, DonationServices donationServices) {
        this.categoryRepository = categoryRepository;
        this.donationServices = donationServices;
    }

    @GetMapping("/form")
    public String formGet(Model model){

        model.addAttribute ( "categories", categoryRepository.findAll () );

        return "form";
    }

    @PostMapping("/form")
    public String formPost(@ModelAttribute("categories")@Valid DonationDataDTO donationData, BindingResult result){

        if(result.hasErrors ()){
            return "redirect:/form";
        }
        donationServices.addDonation ( donationData );
        return "form-confirmation";
    }

}
