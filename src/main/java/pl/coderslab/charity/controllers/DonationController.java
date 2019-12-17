package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.DonationDataDTO;

import javax.validation.Valid;

@Controller
@RequestMapping
public class DonationController {

    @GetMapping("/form")
    public String formGet(Model model){

        model.addAttribute ( "donations", new DonationDataDTO () );

        return "form";
    }

    @PostMapping("/form")
    public String formPost(@ModelAttribute("donations")@Valid DonationDataDTO donationData, BindingResult result){

        if(result.hasErrors ()){
            return "redirect:/form";
        }

        return "form-confirmation";
    }

}
