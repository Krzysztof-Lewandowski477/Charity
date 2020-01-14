package pl.coderslab.charity.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Role;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.entities.VerificationToken;
import pl.coderslab.charity.domain.repository.RoleRepository;
import pl.coderslab.charity.domain.repository.TokenRepository;
import pl.coderslab.charity.domain.repository.UserRepository;
import pl.coderslab.charity.dtos.PasswordDTO;
import pl.coderslab.charity.mail.EmailService;
import pl.coderslab.charity.services.UserService;
import pl.coderslab.charity.util.Utils;

import java.util.Arrays;
import java.util.HashSet;
@Service
@Transactional
@Slf4j
public class DefaultUserService implements UserService {

    final private UserRepository userRepository;
    final private TokenRepository tokenRepository;
    final private RoleRepository roleRepository;
    final private PasswordEncoder passwordEncoder;
    final private EmailService emailService;

    public DefaultUserService(UserRepository userRepository,
                              TokenRepository tokenRepository, RoleRepository roleRepository,
                              PasswordEncoder passwordEncoder, EmailService emailService){
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.emailService = emailService;
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
    public void userChangePassword(PasswordDTO passwordDTO) {

        String username = Utils.getName();
        User user = userRepository.findUserByEmail(username);
        user.setPassword(passwordEncoder.encode(passwordDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Boolean sendEmailToResetPassword(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            VerificationToken verificationToken = new VerificationToken(user);
            emailService.sendSimpleMessage(email, "Charity donation app: Reset your password!",
                    "To reset your password, please click here (link valid 24 hours) : "
                            +"http://localhost:8080/repassword?token="+verificationToken.getToken());
            verificationToken.getUser().setId(userRepository.findUserByEmail(user.getEmail()).getId());
            tokenRepository.save(verificationToken);
            return true;
        }
        return false;
    }

    @Override
    public void changePasswordRemind(PasswordDTO passwordDTO, String tokenUrl) {

        VerificationToken token = tokenRepository.findByToken(tokenUrl);
        User user = userRepository.getOne(token.getUser().getId());
        user.setPassword(passwordEncoder.encode(passwordDTO.getPassword()));
        userRepository.save(user);
    }


}

