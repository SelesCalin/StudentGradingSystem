package art.entity;


import art.entity.enumeration.MessageStatus;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_chat")
    private Integer idChat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sender_user")
    private User sender;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="reciver_user")
    private User reciver;

    @Column(name="text")
    private String text;


    @Column(name="timestamp")
    private Timestamp timestamp;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="read")
    private MessageStatus status;

    public Chat(User sender, User reciver, String text, Timestamp timestamp, MessageStatus status) {
        this.sender = sender;
        this.reciver = reciver;
        this.text = text;
        this.timestamp = timestamp;
        this.status = status;
    }

    public Chat() {
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReciver() {
        return reciver;
    }

    public void setReciver(User reciver) {
        this.reciver = reciver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }
}
