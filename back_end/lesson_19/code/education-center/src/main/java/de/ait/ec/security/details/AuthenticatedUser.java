package de.ait.ec.security.details;

import de.ait.ec.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * 10/13/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class AuthenticatedUser implements UserDetails {

    private final User user;

    public AuthenticatedUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // права пользователя
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString()));
    }

    @Override
    public String getPassword() { // в качестве пароля берем наш хэш
        return user.getPassword();
    }

    @Override
    public String getUsername() { // в качестве имени пользователя в нашем случае выступает email
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() { // аккаунт не просрочен?
        return true; // не просрочен
    }

    @Override
    public boolean isAccountNonLocked() { // аккаунт не заблокирован?
        return true; // не заблокирован
    }

    @Override
    public boolean isCredentialsNonExpired() { // данные пользователя не просрочены?
        return true; // не просрочены
    }

    @Override
    public boolean isEnabled() { // аккаунт включен/активен?
        return true; // аккаунт включен
    }

    public Long getId() {
        return this.user.getId();
    }
}
