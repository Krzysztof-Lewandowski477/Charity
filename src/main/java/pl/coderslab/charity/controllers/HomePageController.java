package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.repository.DonationRepository;

@Controller
@RequestMapping
public class HomePageController {
    private final DonationRepository donationRepository;

    public HomePageController(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {

        model.addAttribute ( "donations", donationRepository.findAll () );

        return "index";
    }


}
