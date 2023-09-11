package com.faas.core.base.model.db.process.content.dao;

public class ProcessScriptDAO {

    private String scriptId;
    private String scriptTitle;
    private String scriptBody;
    private int order;
    private long cDate;
    private int status;

    public ProcessScriptDAO() {
    }

    public ProcessScriptDAO(String scriptId, String scriptTitle, String scriptBody, int order, long cDate, int status) {
        this.scriptId = scriptId;
        this.scriptTitle = scriptTitle;
        this.scriptBody = scriptBody;
        this.order = order;
        this.cDate = cDate;
        this.status = status;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptTitle() {
        return scriptTitle;
    }

    public void setScriptTitle(String scriptTitle) {
        this.scriptTitle = scriptTitle;
    }

    public String getScriptBody() {
        return scriptBody;
    }

    public void setScriptBody(String scriptBody) {
        this.scriptBody = scriptBody;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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
