package de.ait.template.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 9/25/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ValidationError", description = "Описание ошибки валидации")
public class ValidationErrorDto {

    @Schema(description = "название поля, в котором возникла ошибка", example = "price")
    private String field;
    @Schema(description = "значение, которое ввел пользовать и которое было отвергнуто сервером", example = "1000.0")
    private String rejectedValue;
    @Schema(description = "сообщение, которое мы должны показать пользователю", example = "must be less than or equal to 200")
    private String message;
}
