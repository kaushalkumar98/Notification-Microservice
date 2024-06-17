package com.app.team1.technotribe.krasvbank;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.app.team2.technotribe.krasvbank.config.MailConfig;

public class MailConfigTest {

    @Test
    public void testJavaMailSender() {
        MailConfig mailConfig = new MailConfig();
        JavaMailSender javaMailSender = mailConfig.javaMailSender();
        
        assertNotNull(javaMailSender);
        assertEquals("smtp.gmail.com", ((JavaMailSenderImpl) javaMailSender).getHost());
        assertEquals(587, ((JavaMailSenderImpl) javaMailSender).getPort());
        assertEquals("krasvbank@gmail.com", ((JavaMailSenderImpl) javaMailSender).getUsername());
    }
}
