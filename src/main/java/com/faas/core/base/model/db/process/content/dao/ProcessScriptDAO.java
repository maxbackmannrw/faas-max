package com.faas.core.base.model.db.process.content.dao;

public class ProcessScriptDAO {

    private String scriptId;
    private int scriptOrder;
    private String scriptTitle;
    private String scriptBody;
    private long cDate;
    private int status;

    public ProcessScriptDAO() {
    }

    public ProcessScriptDAO(String scriptId, int scriptOrder, String scriptTitle, String scriptBody, long cDate, int status) {
        this.scriptId = scriptId;
        this.scriptOrder = scriptOrder;
        this.scriptTitle = scriptTitle;
        this.scriptBody = scriptBody;
        this.cDate = cDate;
        this.status = status;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }

    public int getScriptOrder() {
        return scriptOrder;
    }

    public void setScriptOrder(int scriptOrder) {
        this.scriptOrder = scriptOrder;
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
