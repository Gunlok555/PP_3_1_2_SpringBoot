package ru.javamentor.PP_3_1_2_SpringBoot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.PP_3_1_2_SpringBoot.model.User;
import ru.javamentor.PP_3_1_2_SpringBoot.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/all")
    public String showAllUsers(Model model) {
        List<User> allUsers = service.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "all-Users";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "add-User";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/{id}/edit")
    public String editUsers(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user",service.getUserById(id));
        return "edit-User";
    }

    @PatchMapping("/{id}")
    public String updateUsers(@ModelAttribute("user") User user,
                         @PathVariable("id") Integer id) {
        service.updateUser(id,user);
        return "redirect:/users/all";
    }

    @DeleteMapping("/{id}")
    public String deleteUsers(@ModelAttribute("user") User user,
                         @PathVariable("id") Integer id) {
        service.dropUser(id);
        return "redirect:/users/all";
    }
}
