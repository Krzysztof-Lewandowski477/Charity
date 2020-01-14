package pl.coderslab.charity.services;

public interface TokenService {

    Boolean ActiveUser(String tokenUrl);
    Boolean remindPasswordToken(String tokenUrl);
}
