package springapp.controller;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import springapp.model.User;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String role;
    private String enabled;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(fullname ,
                passwordEncoder.encode(password),
                username,
                "USER"); }

    public User toUser()   {
                return new User(fullname ,
                                password,
                        username,
            "USER"); }

}