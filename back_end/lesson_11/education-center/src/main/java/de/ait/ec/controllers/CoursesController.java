package de.ait.ec.controllers;

import de.ait.ec.dto.CourseDto;
import de.ait.ec.dto.NewCourseDto;
import de.ait.ec.dto.StandardResponseDto;
import de.ait.ec.services.CoursesService;
import de.ait.ec.validation.dto.ValidationErrorDto;
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
 * 9/20/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
@Tags(value = {
        @Tag(name = "Courses")
})
public class CoursesController {

    private final CoursesService coursesService;

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
    public ResponseEntity<CourseDto> addCourse(@RequestBody @Valid NewCourseDto newCourse) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(coursesService.addCourse(newCourse));
    }

    @Operation(summary = "Получение списка курсов", description = "Доступно всем пользователям")
    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses() {
        return ResponseEntity
                .ok(coursesService.getCourses());
    }

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
    public ResponseEntity<CourseDto> getCourse(@Parameter(description = "идентификатор курса", example = "1")
                                               @PathVariable("course-id") Long courseId) {
        return ResponseEntity
                .ok(coursesService.getCourse(courseId));
    }
}
