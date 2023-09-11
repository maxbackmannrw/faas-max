package com.faas.core.base.model.db.process.details.inquiry.dao;

public class ProcessInquiryUrlDAO {

    private String urlId;
    private String urlType;
    private String url;
    private long cDate;
    private int status;

    public ProcessInquiryUrlDAO() {
    }

    public ProcessInquiryUrlDAO(String urlId, String urlType, String url, long cDate, int status) {
        this.urlId = urlId;
        this.urlType = urlType;
        this.url = url;
        this.cDate = cDate;
        this.status = status;
    }

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
