package de.ait.template.exceptions;

import org.springframework.http.HttpStatus;

/**
 * 9/25/2023
 * education-center
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class RestException extends RuntimeException {
    private final HttpStatus status;

    public RestException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
