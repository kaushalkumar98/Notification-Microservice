package com.app.team1.technotribe.krasvbank;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.app.team2.technotribe.krasvbank.dto.EmailDetailsDto;
import com.app.team2.technotribe.krasvbank.service.impl.EmailServiceImpl;

public class EmailServiceImplTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailServiceImpl emailServiceImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        emailServiceImpl.setSenderEmail("sender@example.com");
    }

    @Test
    public void testSendEmailAlert() {
        EmailDetailsDto emailDetails = new EmailDetailsDto("recipient@example.com", "body", "subject", null);
        doNothing().when(javaMailSender).send(any(SimpleMailMessage.class));

        emailServiceImpl.sendEmailAlert(emailDetails);

        verify(javaMailSender).send(any(SimpleMailMessage.class));
    }

}
