package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.charity.dtos.RegistrationDataDTO;

import pl.coderslab.charity.mail.EmailService;
import pl.coderslab.charity.services.RegistrationService;
import pl.coderslab.charity.services.TokenService;

import javax.validation.Valid;


@Controller
public class RegisterController {

    private final RegistrationService registrationService;
    private final EmailService mailService;
    private final TokenService tokenService;


    public RegisterController(RegistrationService registrationService, EmailService mailService, TokenService tokenService) {
        this.registrationService = registrationService;
        this.mailService = mailService;
        this.tokenService = tokenService;
    }

    @RequestMapping("/confirm-account")
    public String confirmRegistration(@RequestParam("token") String tokenUrl) {
        if (tokenService.ActiveUser ( tokenUrl ).equals ( false )) {
            return "index";
        }
        return "login";
    }


    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute ( "registrationData", new RegistrationDataDTO () );
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@ModelAttribute("registrationData") @Valid RegistrationDataDTO registrationData, BindingResult results) {
        if (results.hasErrors ()) {
            return "register";
        }
        registrationService.register ( registrationData );

        return "redirect:/";
    }


}





