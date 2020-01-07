package pl.coderslab.charity.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.domain.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.security.Principal;

    @Controller
    @RequestMapping("/user")
    public class UserController {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final DonationRepository donationRepository;

        public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, DonationRepository donationRepository) {

            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
            this.donationRepository = donationRepository;
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
        public String preparePasswordChange() {
            return "user/changepassword";
        }

        @PostMapping("/changePassword")
        public String processPasswordChange(String password, Principal principal, HttpServletRequest request) throws ServletException {
            String username = principal.getName ();
            userRepository.changePasswordByUsername ( username, passwordEncoder.encode ( password ) );
            request.logout ();
            return "redirect:/login";
        }

        @GetMapping("/donations")
        public String userDonationsPage(Model model, Principal principal) {
            User user = userRepository.findUserByEmail ( principal.getName () );
            model.addAttribute ( "donations", donationRepository.findAllByUserId ( user.getId () ) );
            return "user/userdonations";
        }

    }


