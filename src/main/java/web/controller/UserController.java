package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addUser(User user) {
        return "new";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/edit")
    public String update(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}
