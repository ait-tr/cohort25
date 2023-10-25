package de.ait.template.dto;

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
@Schema(name = "Message", description = "Какое-либо сообщение с сервера")
public class StandardResponseDto {
    @Schema(description = "Возможно: сообщение об ошибке, об изменении состояния и т.д.", example = "Не найден курс")
    private String message;
}
