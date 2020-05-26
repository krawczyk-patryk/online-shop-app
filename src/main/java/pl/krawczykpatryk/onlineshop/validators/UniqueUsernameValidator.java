package pl.krawczykpatryk.onlineshop.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.krawczykpatryk.onlineshop.dtos.UserDto;
import pl.krawczykpatryk.onlineshop.services.UserService;

@Component
public class UniqueUsernameValidator implements Validator {

    private UserService userService;

    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto userDto = (UserDto) o;
        String username = userDto.getUsername();
        boolean isUsernameExist = userService.checkIsUserExist(username);
        if (isUsernameExist) {
            errors.rejectValue("username", "user.registration.validation.message.usernameAlreadyExist");
        }
    }
}