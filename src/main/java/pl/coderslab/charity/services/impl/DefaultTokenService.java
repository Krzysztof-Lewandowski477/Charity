package pl.coderslab.charity.services.impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.entities.VerificationToken;
import pl.coderslab.charity.domain.repository.TokenRepository;
import pl.coderslab.charity.domain.repository.UserRepository;
import pl.coderslab.charity.services.TokenService;

import java.time.LocalDateTime;
@Service
@Transactional
@Slf4j
public class DefaultTokenService implements TokenService {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;

    public DefaultTokenService(TokenRepository tokenRepository, UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Boolean ActiveUser(String tokenUrl) {
        VerificationToken token = tokenRepository.findByToken(tokenUrl);
        boolean validTokenTime = LocalDateTime.now().isBefore(token.getExpiryDate());
        if (validTokenTime) {
            User user = userRepository.getOne(token.getUser().getId());
            user.setActive(Boolean.TRUE);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean remindPasswordToken(String tokenUrl) {
        VerificationToken token = tokenRepository.findByToken(tokenUrl);
        boolean tokenTime = LocalDateTime.now().isBefore(token.getExpiryDate());
        return tokenTime;
    }
}
