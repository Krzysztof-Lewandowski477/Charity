package pl.coderslab.charity.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Role;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.entities.VerificationToken;
import pl.coderslab.charity.domain.repository.RoleRepository;
import pl.coderslab.charity.domain.repository.TokenRepository;
import pl.coderslab.charity.domain.repository.UserRepository;
import pl.coderslab.charity.dtos.RegistrationDataDTO;

import pl.coderslab.charity.mail.EmailService;
import pl.coderslab.charity.services.RegistrationService;
@Transactional
@Service
@Slf4j
public class DefaultRegistrationService implements RegistrationService {


        private final PasswordEncoder passwordEncoder;
        private final UserRepository userRepository;
        private final RoleRepository roleRepository;
        private final ModelMapper mapper;
        private final TokenRepository tokenRepository;
        private final EmailService emailService;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, ModelMapper mapper, TokenRepository tokenRepository, EmailService emailService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
    }

    @Override
    public void register(RegistrationDataDTO registrationDataDTO) {
        log.debug("Registration data to create user: {}", registrationDataDTO);
        User user = mapper.map(registrationDataDTO, User.class);
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(registrationDataDTO.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        VerificationToken verificationToken = new VerificationToken(user);
        emailService.sendSimpleMessage(user.getEmail(), "Charity donation app: Complete your Registration!",
                "To activate your account, please click here (link valid 24 hours) : "
                        +"http://localhost:8080/confirm-account?token="+verificationToken.getToken());
        userRepository.save(user);
        verificationToken.getUser().setId(userRepository.findUserByEmail(user.getEmail()).getId());
        tokenRepository.save(verificationToken);
    }


}
