package com.faas.core.base.model.db.campaign.details.channel.temp.dao;

public class TempAssetDAO {

    private int id;
    private long assetId;
    private String asset;
    private String assetUrl;
    private String assetType;
    private String baseType;
    private long cDate;
    private int status;

    public TempAssetDAO() {
    }

    public TempAssetDAO(int id, long assetId, String asset, String assetUrl, String assetType, String baseType, long cDate, int status) {
        this.id = id;
        this.assetId = assetId;
        this.asset = asset;
        this.assetUrl = assetUrl;
        this.assetType = assetType;
        this.baseType = baseType;
        this.cDate = cDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getAssetUrl() {
        return assetUrl;
    }

    public void setAssetUrl(String assetUrl) {
        this.assetUrl = assetUrl;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
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


