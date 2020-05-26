package pl.krawczykpatryk.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.krawczykpatryk.onlineshop.dtos.UserDto;
import pl.krawczykpatryk.onlineshop.services.UserService;
import pl.krawczykpatryk.onlineshop.validators.EqualPasswordsValidator;
import pl.krawczykpatryk.onlineshop.validators.UniqueUsernameValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    private UserService userService;
    private UniqueUsernameValidator uniqueUsernameValidator;
    private EqualPasswordsValidator equalPasswordsValidator;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationController(UserService userService, UniqueUsernameValidator uniqueUsernameValidator,
                                      EqualPasswordsValidator equalPasswordsValidator, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uniqueUsernameValidator = uniqueUsernameValidator;
        this.equalPasswordsValidator = equalPasswordsValidator;
        this.passwordEncoder = passwordEncoder;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(uniqueUsernameValidator, equalPasswordsValidator);
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("userModel", new UserDto());
        return "registrationView";
    }

    @PostMapping
    public String registerNewUser(@Valid @ModelAttribute("userModel") UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registrationView";
        }
        userDto.setPassword1(passwordEncoder.encode(userDto.getPassword1()));
        userDto.setPassword2(passwordEncoder.encode(userDto.getPassword2()));
        userService.registerNewUser(userDto);
        return "redirect:/";
    }
}