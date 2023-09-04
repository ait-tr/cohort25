package de.ait.shop.validation;

public interface EmailValidator {

    /**
     * Метод для проверки корректности email
     * @param email который нужно проверить
     * @throws IllegalArgumentException в случае, если email-плохой
     */
    void validate(String email) throws IllegalArgumentException;
}
