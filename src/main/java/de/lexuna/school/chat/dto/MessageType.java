package de.lexuna.school.chat.dto;

import java.util.HashMap;
import java.util.Map;

public class MessageType {

    public static final Map<Class<?>, Byte> CLASS_TO_BYTE = new HashMap<>();
    public static final Map<Byte, Class<?>> BYTE_OT_CLASS = new HashMap<>();

    static {
        CLASS_TO_BYTE.put(Login.class, Login.TYPE_ID);
        CLASS_TO_BYTE.put(Message.class, Message.TYPE_ID);
        CLASS_TO_BYTE.put(SignUp.class, SignUp.TYPE_ID);
        CLASS_TO_BYTE.put(Status.class, Status.TYPE_ID);
        CLASS_TO_BYTE.put(User.class, User.TYPE_ID);
        CLASS_TO_BYTE.put(Contacts.class, Contacts.TYPE_ID);

        BYTE_OT_CLASS.put(Login.TYPE_ID, Login.class);
        BYTE_OT_CLASS.put(Message.TYPE_ID, Message.class);
        BYTE_OT_CLASS.put(SignUp.TYPE_ID, SignUp.class);
        BYTE_OT_CLASS.put(Status.TYPE_ID, Status.class);
        BYTE_OT_CLASS.put(User.TYPE_ID, User.class);
        BYTE_OT_CLASS.put(Contacts.TYPE_ID, Contacts.class);
    }
}
