package pl.coderslab.charity.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.entities.Category;
import pl.coderslab.charity.domain.entities.Institution;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.domain.repository.InstitutionRepository;
import pl.coderslab.charity.dtos.DonationDataDTO;
import pl.coderslab.charity.services.DonationServices;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
@Slf4j
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final DonationServices donationServices;
    private final InstitutionRepository institutionRepository;

    public DonationController(CategoryRepository categoryRepository, DonationServices donationServices, InstitutionRepository institutionRepository) {
        this.categoryRepository = categoryRepository;
        this.donationServices = donationServices;
        this.institutionRepository = institutionRepository;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

//    @ModelAttribute("institutions")
//    public List<Institution> getInstitutions() {
//        return institutionRepository.findAll();
//    }

    @GetMapping("/form")
    public String formGet(Model model){
        model.addAttribute ( "institutions", institutionRepository.findAll () );
        model.addAttribute ( "donations" , new DonationDataDTO ());

        return "donation" ;
    }

    @PostMapping(value = "/form")
    public String formPost(@ModelAttribute("donations")@Valid DonationDataDTO donationData, BindingResult result){

        if(result.hasErrors ()){
            return "donation";
        }
        log.debug ( "co sie stało {}", donationData );
        donationServices.addDonation ( donationData );
        log.debug ( "co sie stało :{}", donationData );
        return "form-confirmation";
    }

}
