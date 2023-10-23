package de.ait.template.mail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 10/23/2023
 * OnlineShop
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class TemplateProjectMailSender {

    private final JavaMailSender javaMailSender;

    @Async
    public void send(String email, String subject, String text) {

        MimeMessage message = javaMailSender.createMimeMessage(); // создаем сообщение
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8"); // делаем Spring-обертку, чтобы было удобнее

        try {
            // задаем данные для письма
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text, true);
        } catch (MessagingException e) {
            throw new IllegalStateException(e);
        }
        // отправляем это сообщение на почту
        javaMailSender.send(message);
    }
}
