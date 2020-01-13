package pl.coderslab.charity.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {
    public static String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
