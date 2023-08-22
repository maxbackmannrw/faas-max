package com.faas.core.base.model.db.process.content.dao;

public class ProcessAssetDAO {

    private String id;
    private String assetId;
    private long cDate;
    private int status;

    public ProcessAssetDAO() {
    }

    public ProcessAssetDAO(String id, String assetId, long cDate, int status) {
        this.id = id;
        this.assetId = assetId;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
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
