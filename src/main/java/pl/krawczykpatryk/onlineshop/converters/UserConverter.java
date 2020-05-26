package pl.krawczykpatryk.onlineshop.converters;

import org.springframework.stereotype.Component;
import pl.krawczykpatryk.onlineshop.dtos.UserDto;
import pl.krawczykpatryk.onlineshop.models.User;

import java.util.function.Function;

@Component
public class UserConverter implements Function<UserDto, User> {

    @Override
    public User apply(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .build();
    }
}