package fr.arthurbr02.vue3templateback.backend.core.authentication;

import fr.arthurbr02.vue3templateback.backend.app.user.User;
import fr.arthurbr02.vue3templateback.backend.app.user.UserRepository;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.AuthenticationDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.RegisterDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.ResetPasswordDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.SendResetPasswordDTO;
import fr.arthurbr02.vue3templateback.backend.core.exception.ForbiddenException;
import fr.arthurbr02.vue3templateback.backend.core.exception.NotFoundException;
import fr.arthurbr02.vue3templateback.backend.core.mail.MailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.UUID;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Autowired
    private transient MailService mailService;

    @Value("${validity-reset-token-minutes}")
    private Integer validityResetTokenMinutes;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User signup(RegisterDTO input) {
        User user = new User();
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setLocale(input.getLocale());
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

    public User authenticate(AuthenticationDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        User user = userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new NotFoundException("User not found"));

        if (user != null) {
            user.setDateLastLogin(new Date());
            userRepository.save(user);
        }

        return user;
    }

    @Transactional
    public void sendResetPassword(SendResetPasswordDTO sendResetPasswordDTO) {
        User user = userRepository.findByEmail(sendResetPasswordDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UUID resetToken = UUID.randomUUID();
        user.setResetToken(resetToken.toString());
        user.setDateResetToken(new Date());
        userRepository.save(user);

        // Send email with reset token
        mailService.sendResetPasswordEmail(user.getEmail(), resetToken.toString(), validityResetTokenMinutes);
    }

    @Transactional
    public void resetPassword(ResetPasswordDTO resetPasswordDTO) {
        User user = userRepository.findByResetToken(resetPasswordDTO.getToken())
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        // Expiration après ${validityResetTokenMinutes} minutes
        long duration = validityResetTokenMinutes * 60 * 1000L;
        if (user.getDateResetToken().getTime() + duration  < new Date().getTime()) {
            throw new RuntimeException("Token expired");
        }

        user.setPassword(passwordEncoder.encode(resetPasswordDTO.getPassword()));
        user.setDatePasswordChanged(new Date());
        user.setResetToken(null);
        userRepository.save(user);
    }
}
