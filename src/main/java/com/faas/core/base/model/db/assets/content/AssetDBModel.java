package com.faas.core.base.model.db.assets.content;

import javax.persistence.*;

@Entity
@Table(name = "asset_table")
public class AssetDBModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "asset_desc")
    private String assetDesc;

    @Column(name = "asset_url")
    private String assetUrl;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "asset_type")
    private String assetType;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;


    public AssetDBModel() {
    }

    public AssetDBModel(long id, String assetName, String assetDesc, String assetUrl, long typeId, String assetType, String baseType, long uDate, long cDate, int status) {
        this.id = id;
        this.assetName = assetName;
        this.assetDesc = assetDesc;
        this.assetUrl = assetUrl;
        this.typeId = typeId;
        this.assetType = assetType;
        this.baseType = baseType;
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

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetDesc() {
        return assetDesc;
    }

    public void setAssetDesc(String assetDesc) {
        this.assetDesc = assetDesc;
    }

    public String getAssetUrl() {
        return assetUrl;
    }

    public void setAssetUrl(String assetUrl) {
        this.assetUrl = assetUrl;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
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
