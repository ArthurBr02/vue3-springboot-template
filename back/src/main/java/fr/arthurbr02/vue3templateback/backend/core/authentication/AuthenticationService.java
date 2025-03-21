package fr.arthurbr02.vue3templateback.backend.core.authentication;

import fr.arthurbr02.vue3templateback.backend.app.user.User;
import fr.arthurbr02.vue3templateback.backend.app.user.UserRepository;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.AuthenticationDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.RegisterDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.ResetPasswordDTO;
import fr.arthurbr02.vue3templateback.backend.core.authentication.dto.SendResetPasswordDTO;
import fr.arthurbr02.vue3templateback.backend.core.mail.MailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Autowired
    private transient MailService mailService;

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
        if (userRepository.countByEmail(input.getEmail()) > 0) {
            throw new RuntimeException("Email already in use");
        }

        if (!input.passwordMatch()) {
            throw new RuntimeException("Passwords do not match");
        }

        User user = new User();
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setLocale(input.getLocale());
        return userRepository.save(user);
    }

    public User authenticate(AuthenticationDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public void sendResetPassword(SendResetPasswordDTO sendResetPasswordDTO) {
        User user = userRepository.findByEmail(sendResetPasswordDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UUID resetToken = UUID.randomUUID();
        user.setResetToken(resetToken.toString());
        userRepository.save(user);

        // Send email with reset token
        mailService.sendResetPasswordEmail(user.getEmail(), resetToken.toString());
    }

    @Transactional
    public void resetPassword(ResetPasswordDTO resetPasswordDTO) {
        User user = userRepository.findByResetToken(resetPasswordDTO.getToken())
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        user.setPassword(passwordEncoder.encode(resetPasswordDTO.getPassword()));
        user.setResetToken(null);
        userRepository.save(user);
    }
}
