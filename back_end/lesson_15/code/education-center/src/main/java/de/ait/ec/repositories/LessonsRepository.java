package de.ait.ec.repositories;

import de.ait.ec.models.Course;
import de.ait.ec.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {

    Set<Lesson> findAllByCourseOrderById(Course course);

    Optional<Lesson> findByCourseAndId(Course course, Long lessonId);
}
