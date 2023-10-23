package de.ait.ec.repositories;

import de.ait.ec.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CoursesRepository extends JpaRepository<Course, Long> {
    @Query("select course from Course course where course.state = 'PUBLISHED'")
    List<Course> findAllPublishedCourses();
}
