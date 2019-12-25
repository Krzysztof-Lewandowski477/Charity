package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.domain.entities.Role;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findById(long id);
    Role getByName (String name);
}
