package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String prepareLoginPage(HttpServletRequest request){
        if(request.isUserInRole ( "ROLE_USER" )){
            return "index";
        }else if(request.isUserInRole ( "ROLE_ADMIN" )){
            return "admin/admin";
        }
        return "login";
    }

    // nie da się GÓWNA ODPALIĆ DO ADMINA
    @GetMapping("/logged")
    public String onlyForLoggedIn(HttpServletRequest request) {
        if (request.isUserInRole ( "ROLE_USER" )) {
            return "logged";
        }
        return "redirect:/";
    }


    @GetMapping("/admin")
    public String onlyForLoggedAdmin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "admin/admin";
        }
        return "redirect:/admin";
    }
}
