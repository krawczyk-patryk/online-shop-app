package pl.krawczykpatryk.onlineshop.services;

import pl.krawczykpatryk.onlineshop.dtos.UserDto;

public interface UserService {

    void registerNewUser(UserDto userDto);
    boolean checkIsUserExist(String username);
}
