package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "Popraw błędy w formularzu!");
            return "register";
        } else if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("message", "Adres " + user.getEmail() + " jest już zarejestrowany!");
            return "register";
        } else {
            model.addAttribute("message", "Użytkownik został zarejestrowany!");
            userService.saveUser(user);
        }
        model.addAttribute("user", user);
        return "register";
    }
}
