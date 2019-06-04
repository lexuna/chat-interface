package de.lexuna.school.chat.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.jupiter.api.Test;

import de.lexuna.school.chat.dto.Message;

class StreamDeserializerTest {

    @Test
    void test() throws IOException {
        byte[] bytes = { 1, 0, 0, 0, 95, 123, 34, 109, 101, 115, 115, 97, 103, 101, 34, 58, 34, 72, 101, 121, 34, 44,
                34, 116, 105, 109, 101, 34, 58, 49, 50, 51, 52, 53, 54, 55, 56, 57, 44, 34, 115, 101, 110, 100, 101,
                114, 73, 100, 34, 58, 34, 115, 101, 110, 100, 101, 114, 64, 99, 104, 97, 116, 46, 100, 101, 34, 44, 34,
                114, 101, 99, 101, 118, 101, 114, 73, 100, 34, 58, 34, 101, 109, 112, 102, -61, -92, 110, 103, 101, 114,
                64, 99, 104, 97, 116, 46, 100, 101, 34, 125 };
        StreamDeserializer sd = new StreamDeserializer(new ByteArrayInputStream(bytes));
        Object obj = sd.read();
        Message message = new Message("Hey", 123456789, "sender@chat.de", "empfänger@chat.de");
        sd.close();
        assertEquals(obj, message);
    }

    @Test
    void test2() throws IOException {
        try (ServerSocket listener = new ServerSocket(59590)) {
            System.out.println("The server is running...");
            new Thread(() -> {
                try (Socket client = new Socket("localhost", 59590)) {
                    Thread.sleep(100);
                    OutputStream outputStream = client.getOutputStream();
                    outputStream.write("Hallo!".getBytes());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }).start();
            while (true) {
                try (Socket socket = listener.accept()) {
//                    PrintWriter out= new PrintWriter(socket.getOutputStream(), true);
                    StreamDeserializer deSer = new StreamDeserializer(socket.getInputStream());
                    System.out.println(deSer.read());
                    deSer.close();
                }
            }
        }
    }

}
