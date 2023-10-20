package de.ait.ec.models;

import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 10/2/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalTime startTime;
    private LocalTime finishTime;

    @Enumerated(value = EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "course_id")
    @ToString.Exclude
    private Course course;
}
