package de.ait.shop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 9/18/2023
 * api-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "UpdateUser", description = "Информация для обновления имени и фамилии пользователя")
public class UpdateUserDto {

    @Schema(description = "Имя пользователя", example = "Marsel")
    private String firstName;
    @Schema(description = "Фамилия пользователя", example = "Sidikov")
    private String lastName;

}
