package de.lexuna.school.chat.dto;

/**
 * Diese Klasse dient der Übermittlung von usergeschriebenen Nachrichten
 * zwischen Client und Server,
 * 
 * Die TYPE_ID muss das erste byte einer über das Socket übermittelten Nachricht
 * sein um die Art der Nachricht zu identifizieren.
 * 
 * Eine Nachricht enthällt die vom User geschriebene Nachricht, einen
 * Zeitstämpel als long und die Sender und Empfänder IDs.
 * 
 * @author Hannah
 *
 */
public class Message {

    public static final byte TYPE_ID = 1;

    private byte[] message;
    private long time;
    private String senderId;
    private String receverId;

    public Message() {
    }

    public Message(byte[] message, long time, String senderId, String receverId) {
        this.message = message;
        this.time = time;
        this.senderId = senderId;
        this.receverId = receverId;
    }

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceverId() {
        return receverId;
    }

    public void setReceverId(String receverId) {
        this.receverId = receverId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((receverId == null) ? 0 : receverId.hashCode());
        result = prime * result + ((senderId == null) ? 0 : senderId.hashCode());
        result = prime * result + (int) (time ^ (time >>> 32));
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
        Message other = (Message) obj;
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        if (receverId == null) {
            if (other.receverId != null) {
                return false;
            }
        } else if (!receverId.equals(other.receverId)) {
            return false;
        }
        if (senderId == null) {
            if (other.senderId != null) {
                return false;
            }
        } else if (!senderId.equals(other.senderId)) {
            return false;
        }
        return time == other.time;
    }

    @Override
    public String toString() {
        return "Message [message=" + message + ", time=" + time + ", senderId=" + senderId + ", receverId=" + receverId
                + "]";
    }
}