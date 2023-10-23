package de.ait.ec.controllers;

import de.ait.ec.controllers.api.CoursesApi;
import de.ait.ec.dto.*;
import de.ait.ec.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 9/20/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
public class CoursesController implements CoursesApi {

    private final CoursesService coursesService;

    @Override
    public CourseDto addCourse(NewCourseDto newCourse) {
        return coursesService.addCourse(newCourse);
    }

    @Override
    public List<CourseDto> getCourses() {
        return coursesService.getCourses();
    }

    @Override
    public CourseDto getCourse(Long courseId) {
        return coursesService.getCourse(courseId);
    }

    @Override
    public LessonDto addLessonToCourse(Long courseId, NewLessonDto newLesson) {
        return coursesService.addLessonToCourse(courseId, newLesson);
    }

    @Override
    public List<LessonDto> getLessonsOfCourse(Long courseId) {
        return coursesService.getLessonsOfCourse(courseId);
    }

    @Override
    public LessonDto deleteLessonFromCourse(Long courseId, Long lessonId) {
        return coursesService.deleteLessonFromCourse(courseId, lessonId);
    }

    @Override
    public LessonDto updateLessonInCourse(Long courseId, Long lessonId, UpdateLessonDto updateLesson) {
        return coursesService.updateLessonInCourse(courseId, lessonId, updateLesson);
    }

    @Override
    public List<UserDto> addStudentToCourse(Long courseId, StudentToCourseDto studentData) {
        return coursesService.addStudentToCourse(courseId, studentData);
    }

    @Override
    public List<UserDto> getStudentsOfCourse(Long courseId) {
        return coursesService.getStudentsOfCourse(courseId);
    }

    @Override
    public List<CourseDto> getPublishedCourses() {
        return coursesService.getPublishedCourses();
    }

}