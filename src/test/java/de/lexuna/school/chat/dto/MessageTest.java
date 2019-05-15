package de.lexuna.school.chat.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

class MessageTest {

    @Test
    void test() throws IOException {
        Message message = new Message("test", 123456789, "sender@chat.de", "empfänger@chat.de");
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
        byte[] json = mapper.writeValueAsBytes(message);
        assertEquals(message, mapper.readValue(json, Message.class));
    }
}
