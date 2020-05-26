package pl.krawczykpatryk.onlineshop.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.krawczykpatryk.onlineshop.dtos.UserDto;

@Component
public class EqualPasswordsValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto userDto = (UserDto) o;
        if (!userDto.getPassword1().equals(userDto.getPassword2())) {
            errors.rejectValue("password2", "registration.user.validation.message.passwordsAreNotTheSame");
        }
    }
}
