package fr.arthurbr02.vue3templateback.backend.app.user;

import fr.arthurbr02.vue3templateback.backend.app.user.dto.CurrentUserDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.LoginResponse;
import fr.arthurbr02.vue3templateback.backend.core.base.BaseWS;
import fr.arthurbr02.vue3templateback.backend.core.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/user")
public class UserWS extends BaseWS {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PutMapping("/")
    public LoginResponse update(@RequestBody CurrentUserDTO currentUserDTO) {
        User user = userService.update(currentUserDTO);
        return new LoginResponse()
                .setToken(jwtService.generateToken(user))
                .setExpiresIn(jwtService.getExpirationTime());
    }
}
