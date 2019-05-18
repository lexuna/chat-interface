package de.lexuna.school.chat.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.lexuna.school.chat.dto.MessageType;

public class StreamDeserializer {

    private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();

    private final InputStream inputStream;

    public StreamDeserializer(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Object read() throws IOException {
        byte[] message = inputStream.readAllBytes();
        byte type = message[0];
        int length = getLength(message);
        byte[] messageBytes = getMessage(message, length);

        return MAPPER.readValue(messageBytes, MessageType.BYTE_OT_CLASS.get(type));
    }

    private byte[] getMessage(byte[] message, int length) {
        byte[] messageBytes = new byte[length];
        for (int i = 5; i < length; i++) {
            messageBytes[i - 5] = message[i];
        }
        return messageBytes;
    }

    private int getLength(byte[] message) throws IOException {
        byte first = message[1];
        byte second = message[2];
        byte third = message[3];
        byte fourth = message[4];

        byte[] lengthByte = { first, second, third, fourth };

        ByteBuffer wrapped = ByteBuffer.wrap(lengthByte);
        return wrapped.getInt();
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
