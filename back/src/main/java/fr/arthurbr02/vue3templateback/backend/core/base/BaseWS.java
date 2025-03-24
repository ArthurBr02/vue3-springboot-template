package fr.arthurbr02.vue3templateback.backend.core.base;

import fr.arthurbr02.vue3templateback.backend.app.user.User;
import fr.arthurbr02.vue3templateback.backend.app.user.UserService;
import fr.arthurbr02.vue3templateback.backend.core.exception.ForbiddenException;
import fr.arthurbr02.vue3templateback.backend.core.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseWS {
    @Autowired
    private UserService userService;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) return null;
        Object user = authentication.getPrincipal();
        if (!(user instanceof User)) return null;
        return (User) user;
    }
}
