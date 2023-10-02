import java.util.Set;

/**
 * 10/2/2023
 * Relationships
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Car {

    private Long id;

    private String model;

    private String color;

    // many-to-one
    private Account owner;

    // many-to-many
    private Set<Account> drivers;
}
