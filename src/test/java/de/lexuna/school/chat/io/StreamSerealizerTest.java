package de.lexuna.school.chat.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import de.lexuna.school.chat.dto.Message;

class StreamSerealizerTest {

    @Test
    void test() throws IOException {
        Message message = new Message("Hey", 123456789, "sender@chat.de", "empfänger@chat.de");

        StreamSerealizer serealizer = new StreamSerealizer(new ByteArrayOutputStream());
        serealizer.send(message);
        ByteArrayOutputStream out = (ByteArrayOutputStream) serealizer.getOutputStream();
        out.toByteArray();
        byte[] bytes = { 1, 95, 123, 34, 109, 101, 115, 115, 97, 103, 101, 34, 58, 34, 72, 101, 121, 34, 44, 34, 116,
                105, 109, 101, 34, 58, 49, 50, 51, 52, 53, 54, 55, 56, 57, 44, 34, 115, 101, 110, 100, 101, 114, 73,
                100, 34, 58, 34, 115, 101, 110, 100, 101, 114, 64, 99, 104, 97, 116, 46, 100, 101, 34, 44, 34, 114, 101,
                99, 101, 118, 101, 114, 73, 100, 34, 58, 34, 101, 109, 112, 102, -61, -92, 110, 103, 101, 114, 64, 99,
                104, 97, 116, 46, 100, 101, 34, 125 };
        assertArrayEquals(bytes, out.toByteArray());
    }

}
