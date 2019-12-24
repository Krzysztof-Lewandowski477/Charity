package pl.coderslab.charity.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.entities.Role;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repository.RoleRepository;
import pl.coderslab.charity.domain.repository.UserRepository;
import pl.coderslab.charity.dtos.RegistrationDataDTO;
import pl.coderslab.charity.services.RegistrationService;

@Service
@Slf4j
public class DefaultRegistrationService implements RegistrationService {


        private final PasswordEncoder passwordEncoder;
        private final UserRepository userRepository;
        private final RoleRepository roleRepository;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void register(RegistrationDataDTO registrationDataDTO) {
        ModelMapper modelMapper = new ModelMapper ();
        User user = modelMapper.map(registrationDataDTO, User.class);
        user.setActive ( Boolean.TRUE );
        String encodedPassword = passwordEncoder.encode ( registrationDataDTO.getPassword () );
        user.setPassword ( encodedPassword );
        Role roleUser = roleRepository.getByName ( "ROLE_USER" );
        user.getRoles ().add ( roleUser );
        userRepository.save ( user );
    }
}
