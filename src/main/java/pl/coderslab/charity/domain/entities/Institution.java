package pl.coderslab.charity.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString(exclude = {""})
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Fundacja "bez domu"
    @Column(unique = true, nullable = false)
    private String name;
    //cel i misja
    private String description;

    @OneToMany(mappedBy = "institution")
    private List<Donation> donations;
}
