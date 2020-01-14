package pl.coderslab.charity.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "certificationTokens")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class VerificationToken {
    private static final int EXPIRATION =24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private LocalDateTime expiryDate;

    private LocalDateTime calculateExpiryDate() {

        return LocalDateTime.now().plusHours(EXPIRATION);
    }

    public VerificationToken(User user) {
        this.user = user;
        expiryDate = calculateExpiryDate();
        token = UUID.randomUUID().toString();
    }



}
