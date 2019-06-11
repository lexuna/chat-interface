package de.lexuna.school.chat.dto;

public class Login {

    public static final byte TYPE_ID = 3;

    private String userId;
    private byte[] key;

    public Login() {
    }

    public Login(String userId) {
        this.userId = userId;
    }

    public Login(String userId, byte[] key) {
        this.userId = userId;
        this.key = key;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public byte[] getKey() {
        return this.key;
    }

    public void setKey(byte[] key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.key == null) ? 0 : this.key.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
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
        Login other = (Login) obj;
        if (this.key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!this.key.equals(other.key)) {
            return false;
        }
        if (this.userId == null) {
            if (other.userId != null) {
                return false;
            }
        } else if (!this.userId.equals(other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Login [userId=" + this.userId + ", password=" + this.key + "]";
    }
}
