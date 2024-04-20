package com.faas.core.base.model.db.process.details.channel.temp.dao;

public class ProcessTempUrlDAO {

    private int id;
    private String tempUrl;
    private String urlType;
    private long cDate;
    private int status;

    public ProcessTempUrlDAO() {
    }

    public ProcessTempUrlDAO(int id, String tempUrl, String urlType, long cDate, int status) {
        this.id = id;
        this.tempUrl = tempUrl;
        this.urlType = urlType;
        this.cDate = cDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTempUrl() {
        return tempUrl;
    }

    public void setTempUrl(String tempUrl) {
        this.tempUrl = tempUrl;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
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


