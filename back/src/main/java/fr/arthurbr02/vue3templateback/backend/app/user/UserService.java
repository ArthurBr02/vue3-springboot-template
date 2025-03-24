package fr.arthurbr02.vue3templateback.backend.app.user;

import fr.arthurbr02.vue3templateback.backend.app.file.Fic;
import fr.arthurbr02.vue3templateback.backend.app.file.FicService;
import fr.arthurbr02.vue3templateback.backend.app.file.constant.FicType;
import fr.arthurbr02.vue3templateback.backend.app.user.dto.CurrentUserDTO;
import fr.arthurbr02.vue3templateback.backend.core.base.BaseService;
import fr.arthurbr02.vue3templateback.backend.core.exception.ForbiddenException;
import fr.arthurbr02.vue3templateback.backend.core.exception.NotAuthorizedException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserService extends BaseService {
    @Value("${data-dir}")
    private String dataDir;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FicService ficService;

    @Transactional
    public User update(CurrentUserDTO currentUserDTO) {
        List<User> users = userRepository.findAllByEmail(currentUserDTO.getEmail()).orElse(new ArrayList<>());
        users.removeIf(user -> user.getId().equals(getCurrentUser().getId()));

        if (!users.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.resolve(409), "Email already in use");
        }

        User user = userRepository.findById(getCurrentUser().getId()).orElseThrow();
        user.setFirstName(currentUserDTO.getFirstName());
        user.setLastName(currentUserDTO.getLastName());
        user.setEmail(currentUserDTO.getEmail());
        user.setLocale(currentUserDTO.getLocale());
        user.setUpdatedAt(new Date());
        userRepository.save(user);
        return user;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public int countByEmail(String email) {
        return userRepository.countByEmail(email);
    }
}
