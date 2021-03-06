package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.domain.entities.VerificationToken;

public interface TokenRepository extends JpaRepository <VerificationToken, Long>{

    VerificationToken findByToken(String token);
}
