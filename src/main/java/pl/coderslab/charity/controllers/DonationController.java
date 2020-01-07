package pl.coderslab.charity.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.entities.Category;
import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.domain.entities.Institution;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.domain.repository.InstitutionRepository;
import pl.coderslab.charity.domain.repository.UserRepository;
import pl.coderslab.charity.services.DonationServices;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping
@Slf4j
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final DonationServices donationServices;
    private final InstitutionRepository institutionRepository;
    private final UserRepository userRepository;
    private final DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, DonationServices donationServices, InstitutionRepository institutionRepository, UserRepository userRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.donationServices = donationServices;
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
        this.donationRepository = donationRepository;
    }


    @GetMapping("/form")
    public String prepareDonation(Model model){
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "form";
    }

    @PostMapping("/form")
    public String processDonation(HttpServletRequest req, Model model, Principal principal){
        Donation donation = new Donation();
        List<Category> categories = new ArrayList<> ();
        List<String> categoriesNames = Collections.singletonList(req.getParameter("categories"));
        for(String category : categoriesNames){
            categories.add(categoryRepository.findByName(category));
        }
        donation.setCategories(categories);
        donation.setCity(req.getParameter("city"));
        donation.setPickUpComment(req.getParameter("comment"));
        donation.setPickUpDate( LocalDate.parse(req.getParameter("date")));
        donation.setPickUpTime( LocalTime.parse(req.getParameter("time")));
        donation.setUser(userRepository.findUserByEmail(principal.getName()));
        donation.setQuantity(Integer.parseInt ( req.getParameter("bags")));
        donation.setStreet(req.getParameter("street"));
        donation.setZipCode(req.getParameter("zipCode"));
        donation.setStatus("nieodebrany");
        donation.setInstitution(institutionRepository.findByName(req.getParameter("organization")));
        model.addAttribute("org", req.getParameter("organization"));
        donationRepository.save(donation);


        return "form-confirmation";
    }

}
