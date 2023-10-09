package de.ait.ec.dto;

import de.ait.ec.models.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 10/2/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDto {

    private Long id;
    private String name;
    private String startTime;
    private String finishTime;
    private String  dayOfWeek;
    private Long courseId;

    public static LessonDto from(Lesson lesson) {
        LessonDto result = LessonDto.builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .startTime(lesson.getStartTime().toString())
                .finishTime(lesson.getFinishTime().toString())
                .dayOfWeek(lesson.getDayOfWeek().toString())
                .build();

        if (lesson.getCourse() != null) {
            result.setCourseId(lesson.getCourse().getId());
        }

        return result;
    }

    public static List<LessonDto> from(Set<Lesson> lessons) {
        return lessons.stream()
                .map(LessonDto::from)
                .collect(Collectors.toList());
    }
}
