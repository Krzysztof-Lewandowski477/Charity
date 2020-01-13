package pl.coderslab.charity.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.domain.repository.UserRepository;
import pl.coderslab.charity.dtos.PasswordDTO;
import pl.coderslab.charity.services.DonationServices;
import pl.coderslab.charity.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.security.Principal;

    @Controller
    @RequestMapping("/user")
    public class UserController {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final DonationRepository donationRepository;
        private final DonationServices donationServices;
        private final UserService userService;

        public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, DonationRepository donationRepository, DonationServices donationServices, UserService userService) {

            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
            this.donationRepository = donationRepository;
            this.donationServices = donationServices;
            this.userService = userService;
        }

        @GetMapping("/manage")
        public String userManage() {
            return "/user/manage";
        }

        @GetMapping("/changeEmail")
        public String prepageChangeEmailPage(Principal principal, Model model) {
            User user = userRepository.findUserByEmail ( principal.getName () );
            model.addAttribute ( "user", user );
            return "/user/changeemail";
        }

        @PostMapping("/changeEmail")
        public String processChangeEmailPage(@ModelAttribute User user, Principal principal, HttpServletRequest req) throws ServletException {
            User userToChange = userRepository.findUserByEmail ( principal.getName () );
            userToChange.getId ();
            userRepository.changeEmailUser ( user.getEmail (), userToChange.getId () );
            req.logout ();
            return "/login";
        }

        @GetMapping("/changePassword")
        public String preparePasswordChange(Model model) {
            model.addAttribute ( "user", new PasswordDTO () );
            return "user/changepassword";
        }

        @PostMapping("/changePassword")
        public String processPasswordChange(@ModelAttribute("user") @Valid PasswordDTO changePassword,HttpServletRequest request,
                                            BindingResult result) throws ServletException {
            if (result.hasErrors()) {
                return "user/edit-user-profile";
            }
            userService.userChangePassword (changePassword);
            request.logout ();
            return "redirect:/login";
        }

        @GetMapping("/donations")
        public String userDonationsPage(Model model, Principal principal) {
            User user = userRepository.findUserByEmail ( principal.getName () );
            model.addAttribute ( "donations", donationRepository.findAllByUserId ( user.getId () ) );
            return "user/userdonations";
        }
///////////////////////////////////////////////////////////
        @GetMapping("/changedetalis")
        public String detailsChange(Model model , Long id){

            model.addAttribute("user", userRepository.findUserById ( id ) );
            return "user/changedetails";
        }

        @PostMapping("/changedetails")
        public String detailsChange(@ModelAttribute User user ){

            userRepository.save ( user );
            return "user/manage";
        }




    }


