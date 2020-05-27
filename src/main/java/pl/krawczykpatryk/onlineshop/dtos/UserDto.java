package pl.krawczykpatryk.onlineshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userdto.username.size}")
    private String username;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userdto.password.size}")
    private String password1;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userdto.password.size}")
    private String password2;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userdto.firstName.size}")
    private String firstName;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userdto.lastName.size}")
    private String lastName;

    private Boolean active = false;
}