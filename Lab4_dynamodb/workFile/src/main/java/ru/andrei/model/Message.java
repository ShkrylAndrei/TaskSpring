package ru.andrei.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.andrei.model.util.Status;
import ru.andrei.model.util.Type;

import java.util.Date;


@Document(collection = "Message")
public class Message {

    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long id;

    private Status status;
    private Type type;
    private Date created;
    private Date modified;
    private String createdBy;
    private String modifiedBy;
    private String textMessage;

    public Message() {
    }

    public Message(Long id, Status status, Type type, Date created, Date modified, String createdBy, String modifiedBy, String textMessage) {
        this.id = id;
        this.status = status;
        this.type = type;
        this.created = created;
        this.modified = modified;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.textMessage = textMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != null ? !id.equals(message.id) : message.id != null) return false;
        if (status != message.status) return false;
        if (type != message.type) return false;
        if (created != null ? !created.equals(message.created) : message.created != null) return false;
        if (modified != null ? !modified.equals(message.modified) : message.modified != null) return false;
        if (createdBy != null ? !createdBy.equals(message.createdBy) : message.createdBy != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(message.modifiedBy) : message.modifiedBy != null) return false;
        return textMessage != null ? textMessage.equals(message.textMessage) : message.textMessage == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (textMessage != null ? textMessage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", status=" + status +
                ", type=" + type +
                ", created=" + created +
                ", modified=" + modified +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", textMessage='" + textMessage + '\'' +
                '}';
    }
}
