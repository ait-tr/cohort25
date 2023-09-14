package de.ait.shop.models;

import lombok.*;

import java.util.Objects;

/**
 * 9/6/2023
 * mvc-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class User {

    private Long id; // null
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
