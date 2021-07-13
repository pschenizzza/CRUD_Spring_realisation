package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ModelAndView allUsers() {
        List<User> users = userService.listUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") long id, ModelAndView modelAndView) {
        User userById = userService.getUserById(id);
        modelAndView.setViewName("editUser");
        modelAndView.addObject("user", userById);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editUser(@ModelAttribute("user") User userForm,
                                 @RequestParam(name = "AddAdmin", required = false) String addAdmin) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(userService.getRoleById(1L));
        if ((addAdmin != null) && (addAdmin.equals("add"))) {
            roleSet.add(userService.getRoleById(2L));
        }
        User user = new User(userForm.getId(), userForm.getLogin(), userForm.getPassword(), roleSet);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/users");
        userService.editUser(user);
        return modelAndView;
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/users");
        userService.deleteUser(id);
        return modelAndView;
    }

    @GetMapping(value = "/addUser")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @PostMapping(value = "/addUser")
    public ModelAndView addUser(@ModelAttribute("user") User userForm) {
        ModelAndView modelAndView = new ModelAndView();
        userService.addUser(new User(userForm.getLogin(), userForm.getPassword()));
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}