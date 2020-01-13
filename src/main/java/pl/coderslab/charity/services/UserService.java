package pl.coderslab.charity.services;

import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.dtos.PasswordDTO;

public interface UserService {

    User findByUsername(String username);

    void save(User user);

    boolean checkIfValidOldPassword(User user, String password);
    void userChangePassword(PasswordDTO passwordDTO);
}
