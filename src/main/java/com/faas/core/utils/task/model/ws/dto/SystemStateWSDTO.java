package com.faas.core.utils.task.model.ws.dto;

public class SystemStateWSDTO {

    private String id;
    private String from;
    private long cDate;
    private int status;

    public SystemStateWSDTO() {
    }

    public SystemStateWSDTO(String id, String from, long cDate, int status) {
        this.id = id;
        this.from = from;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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
