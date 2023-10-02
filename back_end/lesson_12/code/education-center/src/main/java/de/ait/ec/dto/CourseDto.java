package de.ait.ec.dto;

import de.ait.ec.models.Course;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 9/20/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Course", description = "Описание курса")
public class CourseDto {

    @Schema(description = "идентификатор курса", example = "1")
    private Long id;
    @Schema(description = "название курса", example = "Java")
    private String title;
    @Schema(description = "описание курса", example = "Курс по основам разработки на Java")
    private String description;
    @Schema(description = "дата начала", example = "2022-02-02")
    private String beginDate;
    @Schema(description = "дата окончания", example = "2023-02-02")
    private String endDate;
    @Schema(description = "стоимость курса", example = "50.0")
    private Double price;
    @Schema(description = "статус курса - DRAFT, PUBLISHED", example = "PUBLISHED")
    private String state;

    public static CourseDto from(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .description(course.getDescription())
                .title(course.getTitle())
                .beginDate(course.getBeginDate().toString())
                .endDate(course.getEndDate().toString())
                .price(course.getPrice())
                .state(course.getState().toString())
                .build();
    }

    public static List<CourseDto> from(List<Course> courses) {
       return courses
               .stream()
               .map(CourseDto::from)
               .collect(Collectors.toList());
    }
}
