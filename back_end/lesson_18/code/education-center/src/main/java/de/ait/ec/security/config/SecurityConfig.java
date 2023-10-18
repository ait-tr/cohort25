package de.ait.ec.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ait.ec.dto.StandardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletResponse;

import static de.ait.ec.security.config.SecurityExceptionHandlers.*;

/**
 * 10/13/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@EnableWebSecurity // включили собственную настройку безопасности
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
public class SecurityConfig {

    // опишем бин SecurityFilterChain - цепочка фильтров безопасности
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception { // httpSecurity - это безопасность Spring
        httpSecurity.csrf().disable(); // отключаем CSRF, принять как данность, иначе работать ничего не будет
        httpSecurity.headers().frameOptions().disable(); // аналогично пункту выше

        httpSecurity
                .authorizeRequests()
                .antMatchers("/swagger-ui/**").permitAll() // разрешаем всем доступ к Swagger
                .antMatchers(HttpMethod.POST, "/api/users/register/**").permitAll()
                .antMatchers("/api/**").authenticated(); // разрешаем доступ для всех остальных endpoints только аутентифицированным пользователям

        httpSecurity
                .exceptionHandling() // настраиваем собственную обработку ошибок безопасности
                .defaultAuthenticationEntryPointFor(ENTRY_POINT, new AntPathRequestMatcher("/api/**")) // указываем, что эта обработка будет работать на всех endpoint-ах, начинающихся с api
                .accessDeniedHandler(ACCESS_DENIED_HANDLER);

        httpSecurity
                .formLogin() // включили страницу с входом по адресу /login, которая уже в Spring Security
                .loginProcessingUrl("/api/login")
                .successHandler(LOGIN_SUCCESS_HANDLER) // опишем поведение при успешном входе
                .failureHandler(LOGIN_FAILURE_HANDLER);  // опишем поведение при неправильных данных для входа

        httpSecurity
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessHandler(LOGOUT_SUCCESS_HANDLER);

        return httpSecurity.build(); // собираем цепочку безопасности
    }


    // покажем Spring Security, что надо работать с нашим UserDetailsServiceImpl и что мы используем хеширование паролей
    @Autowired
    public void bindUserDetailsServiceAndPasswordEncoder(UserDetailsService userDetailsServiceImpl,
                                                         PasswordEncoder passwordEncoder,
                                                         AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsServiceImpl)
                .passwordEncoder(passwordEncoder); // связали все в одном
    }
}
