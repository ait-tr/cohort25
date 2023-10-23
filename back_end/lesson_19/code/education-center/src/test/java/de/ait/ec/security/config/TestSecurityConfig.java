package de.ait.ec.security.config;

import de.ait.ec.models.User;
import de.ait.ec.security.details.AuthenticatedUser;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 10/17/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@TestConfiguration
@Profile("test")
public class TestSecurityConfig {

    public static final String MOCK_USER = "user";

    public static final String MOCK_ADMIN = "admin";

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                if (username.equals(MOCK_USER)) {
                    return new AuthenticatedUser(User.builder()
                            .id(1L)
                            .email(MOCK_USER)
                            .role(User.Role.USER)
                            .build());
                } else if (username.equals(MOCK_ADMIN)) {
                    return new AuthenticatedUser(User.builder()
                            .id(1L)
                            .email(MOCK_ADMIN)
                            .role(User.Role.ADMIN)
                            .build());
                } else throw new UsernameNotFoundException("User not found");
            }
        };
    }
}
