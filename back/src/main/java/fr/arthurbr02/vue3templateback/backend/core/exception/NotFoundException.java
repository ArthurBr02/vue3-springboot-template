package fr.arthurbr02.vue3templateback.backend.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
