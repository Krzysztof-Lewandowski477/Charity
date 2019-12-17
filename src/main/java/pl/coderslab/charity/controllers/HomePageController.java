package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.repository.InstitutionRepository;
import pl.coderslab.charity.services.DonationServices;


@Controller
@RequestMapping
public class HomePageController {
    private final InstitutionRepository institutionRepository;
    private final DonationServices donationServices;


    public HomePageController( InstitutionRepository institutionRepository, DonationServices donationServices) {
        this.institutionRepository = institutionRepository;
        this.donationServices = donationServices;


    }

    @GetMapping("/")
    public String getHomePage(Model model) {

        model.addAttribute ( "institutions", institutionRepository.findAll () );
        model.addAttribute ( "quantityBags", donationServices.sumQuantitiesBags () );
        model.addAttribute ( "organizations", donationServices.institutionsSum () );
        return "index";
    }


}
