package de.lexuna.school.chat.dto;

public class Login {

    public static final byte TYPE_ID = 3;

    private String userId;
    private String password;

    public Login() {}
    
    public Login(String userId) {
        this.userId = userId;
    }

    public Login(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
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
        if (this.password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!this.password.equals(other.password)) {
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
        return "Login [userId=" + this.userId + ", password=" + this.password + "]";
    }
}
