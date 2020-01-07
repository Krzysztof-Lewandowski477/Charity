package pl.coderslab.charity.services;

import pl.coderslab.charity.domain.entities.User;

public interface UserService {

    User findByUsername(String username);

    void save(User user);

    boolean checkIfValidOldPassword(User user, String password);
}
