package pl.krawczykpatryk.onlineshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userDto.username.size}")
    private String username;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userDto.password.size}")
    private String password1;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userDto.password.size}")
    private String password2;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userDto.firstName.size}")
    private String firstName;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userDto.lastName.size}")
    private String lastName;

    private Boolean active = false;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userDto.country.size}")
    private String country;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userDto.country.size}")
    private String city;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "{userDto.postal.pattern}")
    private String postal;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 2, max = 30, message = "{userDto.street.size}")
    private String street;

    @NotBlank(message = "{field.cannot.beBlank}")
    @Size(min = 1, max = 30, message = "{userDto.number.size}")
    private String number;
}