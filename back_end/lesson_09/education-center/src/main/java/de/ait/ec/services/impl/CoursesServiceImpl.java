package de.ait.ec.services.impl;

import de.ait.ec.dto.CourseDto;
import de.ait.ec.dto.NewCourseDto;
import de.ait.ec.models.Course;
import de.ait.ec.repositories.CoursesRepository;
import de.ait.ec.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static de.ait.ec.dto.CourseDto.from;

/**
 * 9/20/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;

    @Override
    public CourseDto addCourse(NewCourseDto newCourse) {

        Course course = Course.builder()
                .title(newCourse.getTitle())
                .description(newCourse.getDescription())
                .price(newCourse.getPrice())
                .beginDate(LocalDate.parse(newCourse.getBeginDate()))
                .endDate(LocalDate.parse(newCourse.getEndDate()))
                .state(Course.State.DRAFT)
                .build();

        coursesRepository.save(course);

        return from(course);
    }

    @Override
    public List<CourseDto> getCourses() {
        List<Course> courses = coursesRepository.findAll();
        return from(courses);
    }
}
