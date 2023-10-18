package de.ait.ec.models;

import lombok.*;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * 9/20/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Course {

    public enum State {
        DRAFT, PUBLISHED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    private LocalDate beginDate;

    private LocalDate endDate;

    @Column(nullable = false)
    private Double price;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @ToString.Exclude
    @ManyToMany(mappedBy = "courses")
    private Set<User> students;

    @ToString.Exclude
    @OneToMany(mappedBy = "course")
    private Set<Lesson> lessons;

}
