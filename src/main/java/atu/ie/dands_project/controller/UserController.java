package atu.ie.dands_project.controller;

import atu.ie.dands_project.model.Profile;
import atu.ie.dands_project.model.User;
import atu.ie.dands_project.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

    @GetMapping("/profile/{userId}")
    public Profile getProfile(@PathVariable Long userId) {
        return userService.getProfile(userId);
    }

    @PutMapping("/profile/{userId}")
    public Profile updateProfile(@PathVariable Long userId,
                                 @RequestBody Profile profile) {
        return userService.updateProfile(userId, profile);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

@Controller
class ViewController {

    @GetMapping("/register")
    public String registerPage() {
        return "register.html";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "profile.html";
    }
}