package de.lexuna.school.chat.dto;

import java.util.Map;

public class Contacts {

    public static final byte TYPE_ID = 5;

    private Map<String, byte[]> contacts;

    public Map<String, byte[]> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, byte[]> contacts) {
        this.contacts = contacts;
    }
}
