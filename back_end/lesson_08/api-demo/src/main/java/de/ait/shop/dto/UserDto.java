package de.ait.shop.dto;

import de.ait.shop.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 9/11/2023
 * api-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "User", description = "Информация о пользователе")
public class UserDto {

    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long id;

    @Schema(description = "Имя пользователя", example = "Marsel")
    private String firstName;

    @Schema(description = "Фамилия пользователя", example = "Sidikov")
    private String lastName;

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName());
    }

    public static List<UserDto> from(List<User> users) {

        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());

    }
}
