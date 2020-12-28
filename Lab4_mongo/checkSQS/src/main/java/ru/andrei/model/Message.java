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
