package de.ait.ec.security.details;

import de.ait.ec.models.User;
import de.ait.ec.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
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

        User user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email <" + email + "> not found"));

        return new AuthenticatedUser(user);
    }
}
