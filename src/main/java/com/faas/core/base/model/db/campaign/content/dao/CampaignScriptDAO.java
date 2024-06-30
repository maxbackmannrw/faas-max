package com.faas.core.base.model.db.campaign.content.dao;

public class CampaignScriptDAO {

    private String scriptId;
    private String scriptTitle;
    private String scriptBody;
    private int scriptOrder;
    private long cDate;
    private int status;

    public CampaignScriptDAO() {
    }

    public CampaignScriptDAO(String scriptId, String scriptTitle, String scriptBody, int scriptOrder, long cDate, int status) {
        this.scriptId = scriptId;
        this.scriptTitle = scriptTitle;
        this.scriptBody = scriptBody;
        this.scriptOrder = scriptOrder;
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

    public int getScriptOrder() {
        return scriptOrder;
    }

    public void setScriptOrder(int scriptOrder) {
        this.scriptOrder = scriptOrder;
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
