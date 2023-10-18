package de.ait.ec.services.impl;

import de.ait.ec.dto.*;
import de.ait.ec.exceptions.RestException;
import de.ait.ec.models.Course;
import de.ait.ec.models.Lesson;
import de.ait.ec.models.User;
import de.ait.ec.repositories.CoursesRepository;
import de.ait.ec.repositories.LessonsRepository;
import de.ait.ec.repositories.UsersRepository;
import de.ait.ec.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import static de.ait.ec.dto.CourseDto.from;
import static de.ait.ec.dto.LessonDto.from;
import static de.ait.ec.dto.UserDto.from;

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

    private final UsersRepository studentsRepository;

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
        Course course = getCourseOrThrow(courseId); // либо выбрасываем ошибку

        return from(course);
    }

    @Override
    public LessonDto addLessonToCourse(Long courseId, NewLessonDto newLesson) {
        // найдем курс, в который хотим добавить
        Course course = getCourseOrThrow(courseId);

        Lesson lesson;

        if (newLesson.getExistsLessonId() == null) { // если id существующего урока не был указан
            // создаем урок, который нужно будет сохранить в базу данных
            lesson = Lesson.builder()
                    .name(newLesson.getName())
                    .dayOfWeek(DayOfWeek.valueOf(newLesson.getDayOfWeek()))
                    .startTime(LocalTime.parse(newLesson.getStartTime()))
                    .finishTime(LocalTime.parse(newLesson.getFinishTime()))
                    .course(course) // проставляем, к какому курсу привязан урок
                    .build();
        } else { // если был указан id существующего урока
            // нашли этот урок
            lesson = lessonsRepository.findById(newLesson.getExistsLessonId())
                    .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                            "Lesson with id <" + newLesson.getExistsLessonId() + "> not found"));
            // проставили ему курс
            lesson.setCourse(course);
        }

        lessonsRepository.save(lesson); // сохраняем/обновляем существующий урок

        return from(lesson); // возвращаем пользователю ответ
    }

    @Override
    public List<LessonDto> getLessonsOfCourse(Long courseId) {
        // найдем курс, у которого хотим забрать уроки
        Course course = getCourseOrThrow(courseId);

        // получим все уроки этого курса:
        Set<Lesson> lessons = lessonsRepository.findAllByCourseOrderById(course);
        // сконвертировали в DTO
        return from(lessons);
    }

    @Override
    public LessonDto deleteLessonFromCourse(Long courseId, Long lessonId) {
        Course course = getCourseOrThrow(courseId);

        // получаем урок по курсу и id урока
        Lesson lesson = lessonsRepository.findByCourseAndId(course, lessonId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">"));

        lesson.setCourse(null); // у этого урока делаем ссылку на курс null
        lessonsRepository.save(lesson);
        return from(lesson);

        /*
        Set<Lesson> lessonsOfCourse = course.getLessons(); // получили все уроки конкретного курса

        // нужно найти в этом списке урок, который хотим удалить
        for (Lesson lesson : lessonsOfCourse) { // пробегаем все уроки курса
            if (lesson.getId().equals(lessonId)) { // если у урока в курсе совпал ID с ID урока, который мы хотим удалить
                lesson.setCourse(null); // у этого урока делаем ссылку на курс null
                // сохраняем этот урок в базу заново (выполняем обновление)
                lessonsRepository.save(lesson);
                // завершаем работу метода
                return from(lesson);
            }
        }
        // мы оказались здесь, только если среди уроков данного курса не смогли найти нужный
        throw new RestException(HttpStatus.NOT_FOUND,
                "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">");
         */
    }

    // TODO: показать правильное решение
    @Override
    public LessonDto updateLessonInCourse(Long courseId, Long lessonId, UpdateLessonDto updateLesson) {
        Course course = getCourseOrThrow(courseId);

        // получаем урок по курсу и id урока
        Lesson lesson = lessonsRepository.findByCourseAndId(course, lessonId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">"));

        lesson.setName(updateLesson.getName()); // имя точно не пустое
        // проверяем, если поля не равны null - то сохраняем в базу

        if (lesson.getStartTime() != null) {
            lesson.setStartTime(LocalTime.parse(updateLesson.getStartTime()));
        } else {
            lesson.setStartTime(null);
        }

        if (lesson.getFinishTime() != null) {
            lesson.setFinishTime(LocalTime.parse(updateLesson.getFinishTime()));
        } else {
            lesson.setFinishTime(null);
        }

        if (lesson.getDayOfWeek() != null) {
            lesson.setDayOfWeek(DayOfWeek.valueOf(updateLesson.getDayOfWeek()));
        } else {
            lesson.setDayOfWeek(null);
        }

        // обновляем урок
        lessonsRepository.save(lesson);

        // возвращаем обновленный урок
        return from(lesson);

        /*

        // берем все уроки этого курса
        Set<Lesson> lessonsOfCourse = course.getLessons();
        // нужно среди этих уроков найти тот, который хотим обновить
        for (Lesson lesson : lessonsOfCourse) {
            if (lesson.getId().equals(lessonId)) { // нашли урок, который хотим обновить
                // задаем новые значения
                lesson.setName(updateLesson.getName());
                lesson.setDayOfWeek(DayOfWeek.valueOf(updateLesson.getDayOfWeek()));
                lesson.setStartTime(LocalTime.parse(updateLesson.getStartTime()));
                lesson.setFinishTime(LocalTime.parse(updateLesson.getFinishTime()));

                // обновляем урок
                lessonsRepository.save(lesson);

                // возвращаем обновленный урок
                return from(lesson);
            }
        }

        // здесь мы оказались, если не нашли урок в этом курсе
        throw new RestException(HttpStatus.NOT_FOUND,
                "Lesson with id <" + lessonId + "> not found in course with id <" + courseId + ">");
         */
    }

    @Override
    public List<UserDto> addStudentToCourse(Long courseId, StudentToCourseDto studentData) {
        // получаем курс, в который хотим добавить студента
        Course course = getCourseOrThrow(courseId);
        // получаем студена, которого хотим добавить в этот курс
        User student = studentsRepository.findById(studentData.getUserId())
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "User with id <" + studentData.getUserId() + "> not found"));

//        // не рабочий вариант
//        course.getStudents().add(student);
//        coursesRepository.save(course);

        // этому студенту в множество курсов нужно добавить этот самый курс
        if (!student.getCourses().add(course)) { // если метод add вернул false, т.е. не смог добавить, потому что такой курс уже есть
           throw new RestException(HttpStatus.BAD_REQUEST, "User with id <"
                   + student.getId() + "> already in course with id <" + course.getId() + ">");
        }

        studentsRepository.save(student); // обновляем студента (ему добавится курс)
        // получим список студентов данного курса
        Set<User> studentsOfCourse = studentsRepository.findAllByCoursesContainsOrderById(course);
        return from(studentsOfCourse);
    }

    @Override
    public List<UserDto> getStudentsOfCourse(Long courseId) {
        Course course = getCourseOrThrow(courseId);

        Set<User> studentsOfCourse = studentsRepository.findAllByCoursesContainsOrderById(course);

        return from(studentsOfCourse);
    }

    @Override
    public List<CourseDto> getPublishedCourses() {
//        List<Course> courses = coursesRepository.findAllByState(Course.State.PUBLISHED);

        List<Course> courses = coursesRepository.findAllPublishedCourses();
        return from(courses);
    }

    private Course getCourseOrThrow(Long courseId) {
        return coursesRepository.findById(courseId) // либо находим курс по id
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Course with id <" + courseId + "> not found"));
    }
}
