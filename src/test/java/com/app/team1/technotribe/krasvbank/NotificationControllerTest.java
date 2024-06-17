package com.app.team1.technotribe.krasvbank;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.team2.technotribe.krasvbank.controller.NotificationController;
import com.app.team2.technotribe.krasvbank.dto.EmailDetailsDto;
import com.app.team2.technotribe.krasvbank.service.impl.EmailService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotificationControllerTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private NotificationController notificationController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(notificationController).build();
    }

    @Test
    public void testSendEmail() throws Exception {
        EmailDetailsDto emailDetails = new EmailDetailsDto("recipient@example.com", "body", "subject", null);
        doNothing().when(emailService).sendEmailAlert(any(EmailDetailsDto.class));

        mockMvc.perform(post("/api/notification/sendEmail")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(emailDetails)))
                .andExpect(status().isOk());

        verify(emailService).sendEmailAlert(any(EmailDetailsDto.class));
    }

    @Test
    public void testSendEmailWithAttachment() throws Exception {
        EmailDetailsDto emailDetails = new EmailDetailsDto("recipient@example.com", "body", "subject", "path/to/attachment");
        doNothing().when(emailService).sendEmailWithAttachment(any(EmailDetailsDto.class));

        mockMvc.perform(post("/api/notification/sendEmailwithAttachment")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(emailDetails)))
                .andExpect(status().isOk());

        verify(emailService).sendEmailWithAttachment(any(EmailDetailsDto.class));
    }
}

