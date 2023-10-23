package de.ait.ec.validation.constraints;

import de.ait.ec.validation.validators.DayOfWeekValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // хотим, чтобы аннотацию можно было вешать только на поля
@Retention(RetentionPolicy.RUNTIME) // мы хотим, чтобы после компиляции и запуска аннотация никуда не исчезала
@Constraint(validatedBy = DayOfWeekValidator.class)
public @interface DayOfWeek {

    String message() default "must be day of week"; // сообщение, которое получит пользователь при ошибке

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
