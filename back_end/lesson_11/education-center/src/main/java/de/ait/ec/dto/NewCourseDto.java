package de.ait.ec.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * 9/20/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@Schema(name = "NewCourse")
public class NewCourseDto {

    @Schema(description = "название курса", example = "Java")
    @NotNull
    @NotBlank
    @NotEmpty
    private String title;

    @Schema(description = "описание курса", example = "Курс по основам разработки на Java")
    @Size(min = 5, max = 1000)
    @NotBlank
    @NotNull
    private String description;

    @Schema(description = "дата начала", example = "2022-02-02")
    @Pattern(regexp = "^(?:(?:19|20)\\d\\d)-(?:0[1-9]|1[0-2])-(?:0[1-9]|1\\d|2\\d|3[0-1])$")
    private String beginDate;

    @Schema(description = "дата окончания", example = "2023-02-02")
    @Pattern(regexp = "^(?:(?:19|20)\\d\\d)-(?:0[1-9]|1[0-2])-(?:0[1-9]|1\\d|2\\d|3[0-1])$")
    private String endDate;

    @Schema(description = "стоимость курса", example = "50.0")
    @Min(value = 0)
    @Max(value = 200)
    private Double price;
}
