package de.ait.ec.repositories;

import de.ait.ec.models.Course;
import de.ait.ec.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UsersRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Set<User> findAllByCoursesContainsOrderById(Course course);

    Optional<User> findByEmail(String email);

//    @Query(nativeQuery = true, value = "select account.* " +
//            "                from account " +
//            "                         join student_course on account.id = student_course.student_id " +
//            "                         join course on course.id = student_course.course_id " +
//            "                where course.state = 'PUBLISHED';")
    @Query(value = "select user from User user " +
            "           join user.courses course " +
            "               where course.state = 'PUBLISHED'")
    List<User> findAllByCoursesPublished();


    @Query(nativeQuery = true, value = "SELECT a.*\n" +
            "FROM account a " +
            "         INNER JOIN student_course sc ON a.id = sc.student_id " +
            "         INNER JOIN course c ON sc.course_id = c.id " +
            "WHERE c.begin_date > :date -- получили все пересечения студентов и крусов, которые еще не стартовали\n" +
            "  AND NOT EXISTS ( -- и нам нужно, чтобы не существовало записи\n" +
            "    SELECT 1 -- берем число 1, если условие далее выполняется если нет - null\n" +
            "    FROM student_course sc2 -- пересекаем студентов с таблицей студентов и крусов\n" +
            "             INNER JOIN course c2 ON sc2.course_id = c2.id -- потом берем все курсы\n" +
            "    WHERE sc2.student_id = a.id -- и проверяем, нет ли строки с этим студентом и курсом, который начался\n" +
            "      AND c2.begin_date < :date " +
            ")\n")
    List<User> findAllByCourses_BeginDateAfter(@Param("date") LocalDate now);

    List<User> findFirst4ByOrderByIdDesc();
}
