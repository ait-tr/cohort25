package de.ait.shop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Schema(name = "NewUser", description = "Информация для добавления пользователя")
public class NewUserDto {

    @Schema(description = "Имя пользователя", example = "Marsel")
    private String firstName;
    @Schema(description = "Фамилия пользователя", example = "Sidikov")
    private String lastName;
    @Schema(description = "Email пользователя", example = "sidikov.marsel@gmail.com")
    private String email;
    @Schema(description = "Пароль пользователя", example = "qwerty007")
    private String password;

}
