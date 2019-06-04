package springapp.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springapp.dao.RoleDAO;
import springapp.dao.UserDAO;
import springapp.model.Role;
import springapp.model.User;

@Controller
public class RegistrationController {

    private UserDAO userDAO;
    private RoleDAO roleDAO;
    private PasswordEncoder passwordEncoder;


    public RegistrationController( UserDAO userRepo, RoleDAO roleRepo, PasswordEncoder passwordEncoder) {
        this.userDAO = userRepo;
        this.roleDAO = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerForm() {
        return "registration2";
    }

    @PostMapping("/register/process")
    public String processRegistration(RegistrationForm form) {
        Role userRole = roleDAO.findeRoleByName("USER");
        User newUser = form.toUser();
        newUser.addRoleToUser(userRole);
        userDAO.saveUser(newUser);

        return "redirect:/login";
    }

}
