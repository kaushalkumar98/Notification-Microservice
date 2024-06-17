package com.app.team1.technotribe.krasvbank;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.app.team2.technotribe.krasvbank.dto.EmailDetailsDto;

public class EmailDetailsDtoTest {

    @Test
    public void testEmailDetailsDto() {
        EmailDetailsDto emailDetails = new EmailDetailsDto("recipient@example.com", "body", "subject", "attachment");

        assertEquals("recipient@example.com", emailDetails.getRecipient());
        assertEquals("body", emailDetails.getMessageBody());
        assertEquals("subject", emailDetails.getSubject());
        assertEquals("attachment", emailDetails.getAttachment());
    }

    @Test
    public void testEmailDetailsDtoBuilder() {
        EmailDetailsDto emailDetails = EmailDetailsDto.builder()
                .recipient("recipient@example.com")
                .messageBody("body")
                .subject("subject")
                .attachment("attachment")
                .build();

        assertEquals("recipient@example.com", emailDetails.getRecipient());
        assertEquals("body", emailDetails.getMessageBody());
        assertEquals("subject", emailDetails.getSubject());
        assertEquals("attachment", emailDetails.getAttachment());
    }
}
