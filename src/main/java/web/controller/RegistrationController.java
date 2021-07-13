package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(@ModelAttribute("user") User userForm, HttpServletRequest request) {
        User user = userForm;
        userService.addUser(new User(user.getLogin(), user.getPassword()));
        try {
            request.login(user.getUsername(), user.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "user";
    }

}