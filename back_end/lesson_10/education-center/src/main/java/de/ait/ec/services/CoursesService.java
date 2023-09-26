package de.ait.ec.services;

import de.ait.ec.dto.CourseDto;
import de.ait.ec.dto.NewCourseDto;

import java.util.List;

public interface CoursesService {
    CourseDto addCourse(NewCourseDto newCourse);

    List<CourseDto> getCourses();

    CourseDto getCourse(Long courseId);
}
