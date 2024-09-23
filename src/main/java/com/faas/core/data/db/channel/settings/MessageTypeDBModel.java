package com.faas.core.data.db.channel.settings;

import javax.persistence.*;

@Entity
@Table(name = "message_type_table")
public class MessageTypeDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "main_type")
    private String mainType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;


    public MessageTypeDBModel() {
    }

    public MessageTypeDBModel(long id, String messageType, String mainType, long uDate, long cDate, int status) {
        this.id = id;
        this.messageType = messageType;
        this.mainType = mainType;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}