package de.ait.ec.repositories;

import de.ait.ec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
