package de.ait.ec.validation.handler;

import de.ait.ec.dto.StandardResponseDto;
import de.ait.ec.validation.dto.ValidationErrorDto;
import de.ait.ec.validation.dto.ValidationErrorsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 9/25/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
@ControllerAdvice
public class ValidationExceptionHandler {

    // перехватывает ошибки валидации и возвращает клиенту читаемый JSON со всеми ошибками
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorsDto> handleValidationException(MethodArgumentNotValidException e) {

        List<ValidationErrorDto> validationErrors = new ArrayList<>(); // готовим список ошибок валидации

        List<ObjectError> errors = e.getBindingResult().getAllErrors(); // получение всех возникших ошибок

        for (ObjectError error : errors) { // пробегаем по всем ошибкам
            FieldError fieldError = (FieldError)error; // получаем из ObjectError значение FieldError (чтобы получить информацию по конкретному полю)
            // формируем информацию об ошибке для будущего JSON
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .field(fieldError.getField()) // указываем название поля
                    .message(fieldError.getDefaultMessage()) // указываем текст ошибки
                    .build();

            if (fieldError.getRejectedValue() != null) { // если пользователь все-таки что-то ввел - мы это отправим ему обратно
                errorDto.setRejectedValue(fieldError.getRejectedValue().toString()); // кладем в ответ
            }

            validationErrors.add(errorDto); // положили ошибку в список
        }

        return ResponseEntity
                .badRequest()
                .body(ValidationErrorsDto.builder()
                        .errors(validationErrors) // формируем общий список ошибок
                        .build());
    }
}
