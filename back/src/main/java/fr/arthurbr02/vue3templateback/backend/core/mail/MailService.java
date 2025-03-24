package fr.arthurbr02.vue3templateback.backend.core.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.sender-email}")
    private String senderEmail;

    @Value("${appFullUrl}")
    private String appFullUrl;

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        if (toEmail == null || toEmail.isEmpty()) return;
        message.setFrom(senderEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        emailSender.send(message);

        System.out.println("Message sent successfully");
    }

//    public void sendAccountCreationEmail(String toEmail, String adminName, String username, String password){
//        String subject = "Création d'un compte utilisateur par l'administrateur " + adminName;
//        String body = "Bienvenue sur ServiceManager!\nVotre compte a bien été créé. Vous trouverez vos identifiants ci-après.\n" +
//                "Nom d'utilisateur: " + username + "\n" +
//                "Mot de passe: " + password + "\n" +
//                "Vous pouvez vous connecter à l'adresse suivante: " + appFullUrl + "/login\n";
//
//        sendEmail(toEmail, subject, body);
//    }

    public void sendResetPasswordEmail(String toEmail, String token, int validityResetTokenMinutes) {
        String subject = "Réinitialisation de votre mot de passe";
        String body = "Bonjour,\n\n" +
                "Vous avez demandé la réinitialisation de votre mot de passe.\n" +
                "Pour cela, veuillez cliquer sur le lien suivant: " + appFullUrl + "/reset-password?token=" + token + "\n" +
                "Ce lien est valable " + validityResetTokenMinutes + " minutes.\n\n" +
                "Si vous n'êtes pas à l'origine de cette demande, veuillez ignorer ce message.\n\n" +
                "Cordialement";

        sendEmail(toEmail, subject, body);
    }
}
