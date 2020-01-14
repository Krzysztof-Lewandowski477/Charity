package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.dtos.PasswordDTO;
import pl.coderslab.charity.dtos.PasswordRemindDTO;
import pl.coderslab.charity.services.TokenService;
import pl.coderslab.charity.services.UserService;

import javax.validation.Valid;

@Controller
public class PasswordRemindController {
    private final UserService userService;
    private final TokenService tokenService;

    public PasswordRemindController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }


    @GetMapping("/sendingpassword")
    public String emailSendPasswordResetGet(Model model) {
        model.addAttribute("rePassword", new PasswordRemindDTO());
        return "passwordremind";
    }

    @PostMapping("/sendingpassword")
    public String emailSendPasswordResetPost(@ModelAttribute("rePassword") @Valid PasswordRemindDTO
                                                   passwordRemindDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "passwordremind";
        }
        else {
            if (userService.sendEmailToResetPassword( passwordRemindDTO.getEmail()).equals(false)) {
                return "bademail";
            }
            return "repassword-sending-complete";
        }
    }

    @GetMapping("/repassword")
    public String changePasswordGet (Model model, @RequestParam("token") String tokenUrl) {
        if (tokenService.remindPasswordToken (tokenUrl).equals(false)) {
            return "bademail";
        }
        model.addAttribute("changePassword", new PasswordDTO ());
        return "passwordreset";
    }

    @PostMapping("/repassword")
    public String changePasswordPost (@ModelAttribute("changePassword") @Valid PasswordDTO passwordDTO,
                                         BindingResult result, @RequestParam("token") String tokenUrl) {
        if (result.hasErrors()) {
            return "passwordreset";
        }
        userService.changePasswordRemind(passwordDTO, tokenUrl);
        return "index";
    }
}
