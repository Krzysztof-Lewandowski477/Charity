package pl.coderslab.charity.services;

import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.dtos.PasswordDTO;
import pl.coderslab.charity.dtos.PasswordRemindDTO;

public interface UserService {

    void save(User user);
    void userChangePassword(PasswordDTO passwordDTO);
    Boolean sendEmailToResetPassword(String email);
    void changePasswordRemind(PasswordDTO passwordDTO, String tokenUrl);

}
