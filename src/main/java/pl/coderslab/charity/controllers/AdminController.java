package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.entities.Category;
import pl.coderslab.charity.domain.entities.Institution;
import pl.coderslab.charity.domain.entities.Role;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.domain.repository.InstitutionRepository;
import pl.coderslab.charity.domain.repository.RoleRepository;
import pl.coderslab.charity.domain.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final InstitutionRepository institutionRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;
@Autowired

    public AdminController(InstitutionRepository institutionRepository, UserRepository userRepository, RoleRepository roleRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.categoryRepository = categoryRepository;
    }


    //@ModelAtrribute
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionRepository.findAll ();
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userRepository.findAll ();
    }

    @ModelAttribute("roles")
    public List<Role> roles() {
        return roleRepository.findAll ();
    }


    /*model categories vwievs*/
    @ModelAttribute("catrgories")
    public List<Category> categories() {
        return categoryRepository.findAll ();
    }

    /*moddel implements in adnim.jsp
     * method findById(role)*/
    @ModelAttribute("admins")
    public List<User> admins() {
        Role role = roleRepository.findById ( 2 );
        return userRepository.findUsersByRoles ( role );
    }

    @GetMapping("/institutions")
    public String allInsPageShow() {
        return "admin/institutions";
    }

    @GetMapping("/admins")
    public String allAdminsPageShow() {
        return "admin/admins";
    }
    //------INSTITUTIONS--------------



    //---------------USERS------------------

    @GetMapping("/users")
    public String allUsersPageShow() {
        return "admin/users";
    }

    @GetMapping("/user/add")
    public String userAdd(Model model) {
        model.addAttribute ( "user", new User () );
        return "admin/userlist";
    }

    @PostMapping("/user/add")
    public String userAddPost(@ModelAttribute @Valid User user,
                              BindingResult result) {
        if (result.hasErrors ()) {
            return "admin/userlist";
        }
        userRepository.save ( user );
        return "redirect:/admin/users";
    }

    @GetMapping("/user/edit/{id}")
    public String userEdit(@PathVariable long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "admin/userlist";
    }

    @PostMapping("/user/edit/{id}")
    public String userEditPost(@ModelAttribute @Valid User user,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "admin/userlist";
        }
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/delete/{id}")
    public String userDelete(@PathVariable long id) {
        User user = userRepository.findById ( id ).get ();
        userRepository.delete ( user );
        return "redirect:/admin/users";
    }



    //------INSTITUTIONS--------------

    @GetMapping("/institution/add")
    public String insAdd(Model model) {
        model.addAttribute("institution", new Institution());
        return "admin/institutionlist";
    }

    @PostMapping("/institution/add")
    public String insAddPost(@ModelAttribute @Valid Institution institution,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "admin/institutionlist";
        }
        institutionRepository.save(institution);
        return "redirect:/admin/institutions";
    }



    @GetMapping("/institution/edit/{id}")
    public String insEdit(@PathVariable long id, Model model) {
        model.addAttribute("institution", institutionRepository.findById(id));
        return "admin/institutionlist";
    }

    @PostMapping("/institution/edit/{id}")
    public String insEditPost(@ModelAttribute @Valid Institution institution,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "admin/institutionlist";
        }
        institutionRepository.save(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/institution/delete/{id}")
    public String insDelete(@PathVariable long id) {
        Institution institution = institutionRepository.findById(id).get();
        institutionRepository.delete(institution);
        return "redirect:/admin/institutions";
    }

    //---------------ADMINS------------------

        @GetMapping("/")
        public String adminPageShow() {
            return "admin/admin";
        }
    }
