package de.ait.template.repositories;

import de.ait.template.models.ConfirmationCode;
import de.ait.template.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findFirstByCodesContains(ConfirmationCode code);
}
