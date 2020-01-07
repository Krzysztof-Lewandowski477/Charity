package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Role;
import pl.coderslab.charity.domain.entities.User;

import java.util.List;


public interface UserRepository  extends JpaRepository<User, Long> {


    User findUserById (Long id);
    User findByName(String name);
    User findUserByEmail(String email);
    List<User> findUsersByRoles(Role role);


    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET email = ?1 WHERE id = ?2",nativeQuery = true)
    void changeEmailUser(String email, Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET password = ?2 WHERE email = ?1",nativeQuery = true)
    void changePasswordByUsername(String email, String password);

}
