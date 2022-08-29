package mvc_springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import mvc_springboot.web.model.User;
import mvc_springboot.web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "show-users";
    }

    @RequestMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "new-user";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}