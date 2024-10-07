package com.faas.core.data.db.client.intel;

import javax.persistence.*;

@Entity
@Table(name = "client_intel_table")
public class ClientIntelDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "intel_type")
    private String intelType;

    @Column(name = "intel_key")
    private String intelKey;

    @Column(name = "intel_value")
    private String intelValue;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public ClientIntelDBModel() {
    }

    public ClientIntelDBModel(long id, long clientId, String intelType, String intelKey, String intelValue, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.intelType = intelType;
        this.intelKey = intelKey;
        this.intelValue = intelValue;
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

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getIntelType() {
        return intelType;
    }

    public void setIntelType(String intelType) {
        this.intelType = intelType;
    }

    public String getIntelKey() {
        return intelKey;
    }

    public void setIntelKey(String intelKey) {
        this.intelKey = intelKey;
    }

    public String getIntelValue() {
        return intelValue;
    }

    public void setIntelValue(String intelValue) {
        this.intelValue = intelValue;
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
