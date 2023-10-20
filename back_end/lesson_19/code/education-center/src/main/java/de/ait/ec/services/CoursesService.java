package de.ait.ec.services;

import de.ait.ec.dto.*;

import java.util.List;

public interface CoursesService {
    CourseDto addCourse(NewCourseDto newCourse);

    List<CourseDto> getCourses();

    CourseDto getCourse(Long courseId);

    LessonDto addLessonToCourse(Long courseId, NewLessonDto newLesson);

    List<LessonDto> getLessonsOfCourse(Long courseId);

    LessonDto deleteLessonFromCourse(Long courseId, Long lessonId);

    LessonDto updateLessonInCourse(Long courseId, Long lessonId, UpdateLessonDto updateLesson);

    List<UserDto> addStudentToCourse(Long courseId, StudentToCourseDto studentData);

    List<UserDto> getStudentsOfCourse(Long courseId);

    List<CourseDto> getPublishedCourses();
}
