package fr.arthurbr02.vue3templateback.backend.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotAuthorizedException extends ResponseStatusException {
    public NotAuthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
