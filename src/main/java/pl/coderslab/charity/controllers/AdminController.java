package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.entities.Category;
import pl.coderslab.charity.domain.entities.Role;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.domain.repository.InstitutionRepository;
import pl.coderslab.charity.domain.repository.RoleRepository;
import pl.coderslab.charity.domain.repository.UserRepository;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final InstitutionRepository institutionRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;


    public AdminController(InstitutionRepository institutionRepository, UserRepository userRepository, RoleRepository roleRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.categoryRepository = categoryRepository;
    }
/*model categories vwievs*/
    @ModelAttribute("catrgories")
    public List<Category> categories () {
        return categoryRepository.findAll (  );
    }
/*moddel implements in adnim.jsp
* method findById(role)*/
    @ModelAttribute("admins")
    public List<User> admins() {
        Role role = roleRepository.findById(2);
        return userRepository.findUsersByRoles(role); }



    @GetMapping("/admins")
    public String allAdminsPageShow() {
        return "admin/admins";
    }
}
