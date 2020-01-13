package pl.coderslab.charity.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Role;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repository.RoleRepository;
import pl.coderslab.charity.domain.repository.UserRepository;
import pl.coderslab.charity.dtos.PasswordDTO;
import pl.coderslab.charity.services.UserService;
import pl.coderslab.charity.util.Utils;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
@Service
@Transactional
@Slf4j
public class DefaultUserService implements UserService {
    final private UserRepository userRepository;


    final private RoleRepository roleRepository;

    final private PasswordEncoder passwordEncoder;

    public DefaultUserService(UserRepository userRepository,
                               RoleRepository roleRepository,
                              PasswordEncoder passwordEncoder){


        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive (true);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role> ( Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(final User user, final String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public void userChangePassword(PasswordDTO passwordDTO) {

        String username = Utils.getName();
        User user = userRepository.findUserByEmail(username);
        user.setPassword(passwordEncoder.encode(passwordDTO.getPassword()));
        userRepository.save(user);
    }
}

