package pl.coderslab.charity.domain.entities;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.*;

@Getter
@Setter

@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Transient
    private String passwordConfirm;
    private Boolean active = Boolean.FALSE;
    @ManyToMany
    private Set<Role> roles = new HashSet<> (  );
    @OneToMany(mappedBy = "user")
    private List<Donation> donations = new ArrayList<>();




//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
//    private List<Role> roles;
}
