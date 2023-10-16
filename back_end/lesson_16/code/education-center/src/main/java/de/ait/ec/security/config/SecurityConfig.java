package de.ait.ec.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ait.ec.dto.StandardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletResponse;

/**
 * 10/13/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@EnableWebSecurity // включили собственную настройку безопасности
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
public class SecurityConfig {

    @Autowired
    private ObjectMapper objectMapper;

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
                .defaultAuthenticationEntryPointFor((
                                (request, response, authException) ->
                                        fillResponse(response, HttpStatus.UNAUTHORIZED, "User unauthorized")),
                        new AntPathRequestMatcher("/api/**")); // указываем, что эта обработка будет работать на всех endpoint-ах, начинающихся с api

        httpSecurity
                .formLogin() // включили страницу с входом по адресу /login, которая уже в Spring Security
                .loginProcessingUrl("/api/login")
                .successHandler((  // опишем поведение при успешном входе
                        (request, response, authentication) ->
                                fillResponse(response, HttpStatus.OK, "Login successful")))
                .failureHandler((  // опишем поведение при неправильных данных для входа
                        (request, response, exception) ->
                                fillResponse(response, HttpStatus.UNAUTHORIZED, "Incorrect password or username")));

        httpSecurity
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessHandler((
                        (request, response, authentication) ->
                                fillResponse(response, HttpStatus.OK, "Logout successful")));

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

    // для ручного заполнения ответа
    private void fillResponse(HttpServletResponse response, HttpStatus status, String message) {
        try {
            response.setStatus(status.value()); // забираем статус ответа (код), который хотим передать клиенту
            response.setContentType(MediaType.APPLICATION_JSON_VALUE); // говорим, что передаем JSON

            StandardResponseDto responseDto = StandardResponseDto.builder()
                    .message(message)
                    .build();

            String body = objectMapper.writeValueAsString(responseDto);

            response.getWriter().write(body);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
