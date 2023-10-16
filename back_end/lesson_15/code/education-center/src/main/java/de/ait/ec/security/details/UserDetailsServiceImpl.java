package de.ait.ec.security.details;

import de.ait.ec.models.User;
import de.ait.ec.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 10/13/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /*

        Optional<User> userOptional = usersRepository.findByEmail(email); // находим пользователя по email-у

        if (userOptional.isPresent()) { // если пользователь найден
            User user = userOptional.get(); // получаем непосредственно объект пользователя
            AuthenticatedUser authenticatedUser = new AuthenticatedUser(user); // кладем пользователя в объект для Spring Security
            return authenticatedUser; // возвращаем результат работы метода - пользователь из базы данных, адаптированный для Spring Security
        } else {
            // если пользователя не нашли - возвращаем ошибку
            throw new UsernameNotFoundException(("User with email <" + email + "> not found"));
        }

         */

        User user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email <" + email + "> not found"));

        return new AuthenticatedUser(user);
    }
}
