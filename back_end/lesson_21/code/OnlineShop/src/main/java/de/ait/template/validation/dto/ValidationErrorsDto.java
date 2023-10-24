package de.ait.template.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
@Schema(name = "ValidationErrors", description = "информация об ошибках валидации")
public class ValidationErrorsDto {

    @Schema(description = "список ошибок валидации")
    private List<ValidationErrorDto> errors;
}
