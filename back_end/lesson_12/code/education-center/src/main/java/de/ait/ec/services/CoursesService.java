package de.ait.ec.services;

import de.ait.ec.dto.CourseDto;
import de.ait.ec.dto.LessonDto;
import de.ait.ec.dto.NewCourseDto;
import de.ait.ec.dto.NewLessonDto;

import java.util.List;

public interface CoursesService {
    CourseDto addCourse(NewCourseDto newCourse);

    List<CourseDto> getCourses();

    CourseDto getCourse(Long courseId);

    LessonDto addLessonToCourse(Long courseId, NewLessonDto newLesson);

    List<LessonDto> getLessonsOfCourse(Long courseId);
}
