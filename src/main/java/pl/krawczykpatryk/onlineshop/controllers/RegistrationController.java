package pl.krawczykpatryk.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.krawczykpatryk.onlineshop.dtos.UserDto;
import pl.krawczykpatryk.onlineshop.services.UserService;
import pl.krawczykpatryk.onlineshop.validators.UniqueUsernameValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;
    private UniqueUsernameValidator uniqueUsernameValidator;

    @Autowired
    public RegistrationController(UserService userService, UniqueUsernameValidator uniqueUsernameValidator) {
        this.userService = userService;
        this.uniqueUsernameValidator = uniqueUsernameValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(uniqueUsernameValidator);
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
        userService.registerNewUser(userDto);
        return "redirect:/";
    }
}