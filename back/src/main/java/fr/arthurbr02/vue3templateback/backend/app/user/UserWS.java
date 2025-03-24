package fr.arthurbr02.vue3templateback.backend.app.user;

import fr.arthurbr02.vue3templateback.backend.app.user.dto.CurrentUserDTO;
import fr.arthurbr02.vue3templateback.backend.core.base.BaseWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/user")
public class UserWS extends BaseWS {

    @Autowired
    private UserService userService;

    @PutMapping("/")
    public void update(@RequestBody CurrentUserDTO currentUserDTO) {
        userService.update(currentUserDTO);
    }
}
