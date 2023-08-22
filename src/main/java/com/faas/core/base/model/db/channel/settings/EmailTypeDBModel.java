package com.faas.core.base.model.db.channel.settings;

import javax.persistence.*;

@Entity
@Table(name = "email_type_table")
public class EmailTypeDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email_type")
    private String emailType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;


    public EmailTypeDBModel() {
    }


    public EmailTypeDBModel(long id, String emailType, long uDate, long cDate, int status) {
        this.id = id;
        this.emailType = emailType;
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

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
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
