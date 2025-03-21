package fr.arthurbr02.vue3templateback.backend.core.authentication;

import fr.arthurbr02.vue3templateback.backend.app.user.User;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.AuthenticationDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.RegisterDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.ResetPasswordDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.SendResetPasswordDTO;
import fr.arthurbr02.vue3templateback.backend.core.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/v1/auth")
@RestController
public class AuthenticationWS {
    @Autowired
    private transient JwtService jwtService;

    @Autowired
    private transient AuthenticationService authenticationService;

    public AuthenticationWS(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO dto) {
        User registeredUser = authenticationService.signup(dto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody AuthenticationDTO authenticationDTO) {
        User authenticatedUser = authenticationService.authenticate(authenticationDTO);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse()
                .setToken(jwtToken)
                .setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            SecurityContextHolder.clearContext();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/checkSession")
    public ResponseEntity<Boolean> checkSession() {
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication() != null);
    }

    @PostMapping("/send-reset-password")
    public ResponseEntity<Void> resetPassword(@RequestBody SendResetPasswordDTO sendResetPasswordDTO) {
        authenticationService.sendResetPassword(sendResetPasswordDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        authenticationService.resetPassword(resetPasswordDTO);
        return ResponseEntity.ok().build();
    }
}
