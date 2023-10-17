package de.ait.ec.validation.validators;

import de.ait.ec.validation.constraints.DayOfWeek;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * 10/17/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class DayOfWeekValidator implements ConstraintValidator<DayOfWeek, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        for (java.time.DayOfWeek dayOfWeek : java.time.DayOfWeek.values()) {
            if (dayOfWeek.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
