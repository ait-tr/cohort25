package de.ait.ec.controllers.api;

import de.ait.ec.dto.*;
import de.ait.ec.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 10/17/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequestMapping("/api/courses")
@Tags(value = {
        @Tag(name = "Courses", description = "Работа с курсами")
})
@ApiResponses(value = {
        @ApiResponse(responseCode = "401",
                description = "Пользователь не авторизован",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = StandardResponseDto.class))),
        @ApiResponse(responseCode = "403",
                description = "Запрещено",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = StandardResponseDto.class)))})
public interface CoursesApi {

    @Operation(summary = "Создание курса", description = "Доступно менеджеру образовательного центра")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Курс был создан успешно",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Ошибка валидации",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ValidationErrorsDto.class)))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CourseDto addCourse(@RequestBody @Valid NewCourseDto newCourse);

    @Operation(summary = "Получение списка курсов", description = "Доступно всем пользователям")
    @GetMapping
    List<CourseDto> getCourses();

    @Operation(summary = "Получение курса", description = "Доступно всем пользователям")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Запрос обработан успешно",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDto.class))
            ),
            @ApiResponse(responseCode = "404",
                    description = "Курс не найден",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class)))
    })
    @GetMapping("/{course-id}")
    CourseDto getCourse(@Parameter(description = "идентификатор курса", example = "1")
                        @PathVariable("course-id") Long courseId);

    @PostMapping("/{course-id}/lessons")
    @ResponseStatus(HttpStatus.CREATED)
    LessonDto addLessonToCourse(@PathVariable("course-id") Long courseId,
                                @RequestBody @Valid NewLessonDto newLesson);

    @GetMapping("/{course-id}/lessons")
    List<LessonDto> getLessonsOfCourse(@PathVariable("course-id") Long courseId);

    @DeleteMapping("/{course-id}/lessons/{lesson-id}")
    LessonDto deleteLessonFromCourse(@PathVariable("course-id") Long courseId,
                                     @PathVariable("lesson-id") Long lessonId);

    @PutMapping("/{course-id}/lessons/{lesson-id}")
    LessonDto updateLessonInCourse(@PathVariable("course-id") Long courseId,
                                   @PathVariable("lesson-id") Long lessonId,
                                   @RequestBody @Valid UpdateLessonDto updateLesson);

    @PostMapping("/{course-id}/students")
    @ResponseStatus(HttpStatus.CREATED)
    List<UserDto> addStudentToCourse(@PathVariable("course-id") Long courseId,
                                     @RequestBody StudentToCourseDto studentData);

    @GetMapping("/{course-id}/students")
    List<UserDto> getStudentsOfCourse(@PathVariable("course-id") Long courseId);

    @GetMapping("/byState/published")
    List<CourseDto> getPublishedCourses();
}
