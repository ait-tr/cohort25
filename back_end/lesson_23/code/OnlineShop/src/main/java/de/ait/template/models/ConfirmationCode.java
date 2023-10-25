package de.ait.template.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 10/23/2023
 * OnlineShop
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ConfirmationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime expiredDateTime;
}
