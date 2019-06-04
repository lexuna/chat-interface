package de.lexuna.school.chat.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.lexuna.school.chat.dto.MessageType;

public class StreamSerealizer implements Closeable {

    private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();

    private final OutputStream outputStream;

    public StreamSerealizer(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void send(Object obj) throws IOException {
        byte type = MessageType.CLASS_TO_BYTE.get(obj.getClass());
        byte[] json = MAPPER.writeValueAsBytes(obj);
        byte[] length = ByteBuffer.allocate(4).putInt(json.length).array();

        synchronized (outputStream) {
            outputStream.write(type);
            outputStream.write(length);
            outputStream.write(json);

            outputStream.flush();
        }
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
