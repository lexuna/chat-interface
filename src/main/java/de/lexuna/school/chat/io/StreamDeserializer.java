package de.lexuna.school.chat.io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.lexuna.school.chat.dto.MessageType;

public class StreamDeserializer implements Closeable {

    private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();

    private final BufferedReader inputStream;

    public StreamDeserializer(InputStream inputStream) {
        this.inputStream = new BufferedReader(new InputStreamReader(inputStream));
    }

    public Object read() throws IOException {
        byte type = getInput(1)[0];
        int length = getLength(getInput(4));
        byte[] message = getInput(length);

        return MAPPER.readValue(message, MessageType.BYTE_OT_CLASS.get(type));
    }

    private byte[] getInput(int length) throws IOException {
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = (byte) inputStream.read();
        }
        return array;
    }

    private int getLength(byte[] message) throws IOException {
        byte first = message[0];
        byte second = message[1];
        byte third = message[2];
        byte fourth = message[3];

        byte[] lengthByte = { first, second, third, fourth };

        ByteBuffer wrapped = ByteBuffer.wrap(lengthByte);
        return wrapped.getInt();
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
