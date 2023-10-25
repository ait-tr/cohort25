package de.ait.template.controllers.api;

import de.ait.template.dto.NewUserDto;
import de.ait.template.dto.StandardResponseDto;
import de.ait.template.dto.UserDto;
import de.ait.template.security.details.AuthenticatedUser;
import de.ait.template.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 10/17/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Tags(
        @Tag(name = "Users")
)
@RequestMapping("/api/users")
public interface UsersApi {

    @Operation(summary = "Регистрация пользователя", description = "Доступно всем. По умолчанию роль - USER")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Пользователь зарегистрирован",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Ошибка валидации",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ValidationErrorsDto.class))),
            @ApiResponse(responseCode = "409",
                    description = "Пользователь с таким email уже есть",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class))),
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    UserDto register(@RequestBody @Valid NewUserDto newUser);

    @GetMapping("/confirm/{confirm-code}")
    UserDto getConfirmation(@PathVariable("confirm-code") String confirmCode);

    @GetMapping("/profile")
    UserDto getProfile(@Parameter(hidden = true) @AuthenticationPrincipal AuthenticatedUser user);

}
