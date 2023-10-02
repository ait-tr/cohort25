import java.util.Set;

/**
 * 10/2/2023
 * Relationships
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Account {

    private Long id;

    private String firstName;
    private String lastName;

    // one-to-many
    private Set<Car> ownedCars;

    // many-to-many
    private Set<Car> rentalCars;
}
