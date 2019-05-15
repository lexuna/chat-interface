package de.lexuna.school.chat.dto;

import java.util.Arrays;
import java.util.Set;

public class User {

    public static final byte TYPE_ID = 0;

    private String id;
    private String name;
    private byte[] publicKey;
    private Set<String> contacts;

    public User() {
    }

    public User(String id, String name, byte[] publicKey, Set<String> contacts) {
        this.id = id;
        this.name = name;
        this.publicKey = publicKey;
        this.contacts = contacts;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
    }

    public Set<String> getContacts() {
        return this.contacts;
    }

    public void setContacts(Set<String> contacts) {
        this.contacts = contacts;
    }

    public static byte getTypeId() {
        return TYPE_ID;
    }

    @Override
    public String toString() {
        return "User [id=" + this.id + ", name=" + this.name + ", publicKey=" + Arrays.toString(this.publicKey)
                + ", contacts=" + this.contacts + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + Arrays.hashCode(this.publicKey);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (!Arrays.equals(this.publicKey, other.publicKey)) {
            return false;
        }
        return true;
    }

}
