package de.ait.ec.dto;

import de.ait.ec.models.Course;
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
public class CourseDto {

    private Long id;
    private String title;
    private String description;
    private String beginDate;
    private String endDate;
    private Double price;
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
