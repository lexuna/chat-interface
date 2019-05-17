package de.lexuna.school.chat.io;

import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.lexuna.school.chat.dto.MessageType;

public class StreamSerealizer {

    private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();

    private final OutputStream outputStream;

    public StreamSerealizer(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void send(Object obj) throws IOException {
        byte type = MessageType.CLASS_TO_BYTE.get(obj.getClass());
        byte[] json = MAPPER.writeValueAsBytes(obj);
        int length = json.length;

        outputStream.write(type);
        outputStream.write(length);
        outputStream.write(json);

        outputStream.flush();
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
