package de.lexuna.school.chat.dto;

/**
 * Diese Klasse dien der Übermittlung von Statusänderungen der User.
 * 
 * Die TYPE_ID muss das erste byte einer über das Socket übermittelten Nachricht
 * sein um die Art der Nachricht zu identifizieren.
 * 
 * Eine Statusänderung enthält die UserId der Senders und den StatusType auf
 * welchen gewechselt wurde.
 *
 * @author Hannah
 *
 */
public class Status {

    public static final byte TYPE_ID = 2;

    enum StatusType {
        WRITING, ONLINE, OFFLINE;
    }

    private String senderId;
    private StatusType type;

    public Status() {
    }

    public Status(String senderId, StatusType type) {
        this.senderId = senderId;
        this.type = type;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public StatusType getType() {
        return this.type;
    }

    public void setType(StatusType type) {
        this.type = type;
    }

    public static byte getTypeId() {
        return TYPE_ID;
    }

    @Override
    public String toString() {
        return "Status [senderId=" + this.senderId + ", type=" + this.type + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.senderId == null) ? 0 : this.senderId.hashCode());
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
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
        Status other = (Status) obj;
        if (this.senderId == null) {
            if (other.senderId != null) {
                return false;
            }
        } else if (!this.senderId.equals(other.senderId)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

}
