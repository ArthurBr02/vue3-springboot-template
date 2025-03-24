package fr.arthurbr02.vue3templateback.backend.app.user;

import fr.arthurbr02.vue3templateback.backend.app.user.dto.CurrentUserDTO;
import fr.arthurbr02.vue3templateback.backend.core.base.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService extends BaseService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void update(CurrentUserDTO currentUserDTO) {
        User user = userRepository.findById(currentUserDTO.getId()).orElseThrow();
        user.setFirstName(currentUserDTO.getFirstName());
        user.setLastName(currentUserDTO.getLastName());
        user.setLocale(currentUserDTO.getLocale());
        userRepository.save(user);
    }
}
