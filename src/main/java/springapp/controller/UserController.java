package springapp.controller;

import org.springframework.web.servlet.ModelAndView;
import springapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springapp.service.UserService;

import java.util.List;

@Controller
//@RequestMapping()
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
//    public String firstPage(Model theModel) {
//        return "redirect:/list";
//    }

//    @GetMapping("/list")
//    public String listUsers(Model theModel) {
//        List<User> theUsers = userService.getUsers();
//        theModel.addAttribute("users", theUsers);
//        return "user-list";
//    }

    @GetMapping ("/login")
    public String authorize() {
        return "/login";
    }

    @RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
    public String loginError(Model model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @GetMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("home", "hello", "Hello!");
    }

    @GetMapping("/list")
    public ModelAndView listUsers() {
        List<User> theUsers = userService.getUsers();
        return new ModelAndView("user-list", "users", theUsers);
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        User theUser = new User();
        theModel.addAttribute("user", theUser);
        return "/user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser) {
        userService.saveUser(theUser);
        return "redirect:/list";
    }

    @GetMapping("updateForm")
    public String showFormForUpdate(@RequestParam("userId") int theId,
                                    Model theModel) {
        User theUser = userService.getUser(theId);
        theModel.addAttribute("user", theUser);
        return "/user-form";
    }

    @GetMapping("user/delete")
    public String deleteUser(@RequestParam("userId") int theId) {
        userService.deleteUser(theId);
        return "redirect:/list";
    }
}
