package pl.krawczykpatryk.onlineshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krawczykpatryk.onlineshop.converters.UserConverter;
import pl.krawczykpatryk.onlineshop.dtos.UserDto;
import pl.krawczykpatryk.onlineshop.models.User;
import pl.krawczykpatryk.onlineshop.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public void registerNewUser(UserDto userDto) {
        User user = userConverter.apply(userDto);
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public boolean checkIsUserExist(String username) {
        Optional<User> oneByUsername = userRepository.findOneByUsername(username);
        return oneByUsername.filter(user -> username.equals(user.getUsername())).isPresent();
    }
}