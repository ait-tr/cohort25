package de.ait.ec.services.impl;

import de.ait.ec.dto.CourseDto;
import de.ait.ec.dto.LessonDto;
import de.ait.ec.dto.NewCourseDto;
import de.ait.ec.dto.NewLessonDto;
import de.ait.ec.exceptions.RestException;
import de.ait.ec.models.Course;
import de.ait.ec.models.Lesson;
import de.ait.ec.repositories.CoursesRepository;
import de.ait.ec.repositories.LessonsRepository;
import de.ait.ec.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static de.ait.ec.dto.CourseDto.from;
import static de.ait.ec.dto.LessonDto.from;

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

    private final LessonsRepository lessonsRepository;

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

    @Override
    public CourseDto getCourse(Long courseId) {
        /*
        Optional<Course> courseOptional = coursesRepository.findById(courseId); // находим Optional в базе

        Course course;

        if (courseOptional.isPresent()) { // если в этом Optional данные есть (нашли курс)
            course = courseOptional.get(); // получаем объект этого курса
        } else {
            // если там ничего на самом деле не лежит, то выбрасываем ошибку
            throw new IllegalArgumentException("Course with id <" + courseId + "> not found");
        }
        */

        // Optional
        Course course = coursesRepository.findById(courseId) // либо находим курс по id
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Course with id <" + courseId + "> not found")); // либо выбрасываем ошибку

        return from(course);
    }

    @Override
    public LessonDto addLessonToCourse(Long courseId, NewLessonDto newLesson) {
        // найдем курс, в который хотим добавить
        Course course = coursesRepository.findById(courseId) // либо находим курс по id
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Course with id <" + courseId + "> not found"));

        // создаем урок, который нужно будет сохранить в базу данных
        Lesson lesson = Lesson.builder()
                .name(newLesson.getName())
                .dayOfWeek(DayOfWeek.valueOf(newLesson.getDayOfWeek()))
                .startTime(LocalTime.parse(newLesson.getStartTime()))
                .finishTime(LocalTime.parse(newLesson.getFinishTime()))
                .course(course) // проставляем, к какому курсу привязан урок
                .build();

        lessonsRepository.save(lesson); // сохраняем урок

        return from(lesson); // возвращаем пользователю ответ
    }

    @Override
    public List<LessonDto> getLessonsOfCourse(Long courseId) {
        // найдем курс, у которого хотим забрать уроки
        Course course = coursesRepository.findById(courseId) // либо находим курс по id
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Course with id <" + courseId + "> not found"));

        // получим все уроки этого курса:
        Set<Lesson> lessons = course.getLessons();
        // сконвертировали в DTO
        return from(lessons);
    }
}
