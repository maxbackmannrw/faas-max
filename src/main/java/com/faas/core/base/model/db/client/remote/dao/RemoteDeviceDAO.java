package com.faas.core.base.model.db.client.remote.dao;

public class RemoteDeviceDAO {

    private String deviceId;
    private String deviceBrand;
    private String deviceModel;
    private String deviceOS;
    private String deviceUrl;
    private long uDate;
    private long cDate;
    private int status;

    public RemoteDeviceDAO() {
    }

    public RemoteDeviceDAO(String deviceId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, long uDate, long cDate, int status) {
        this.deviceId = deviceId;
        this.deviceBrand = deviceBrand;
        this.deviceModel = deviceModel;
        this.deviceOS = deviceOS;
        this.deviceUrl = deviceUrl;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceOS() {
        return deviceOS;
    }

    public void setDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    public String getDeviceUrl() {
        return deviceUrl;
    }

    public void setDeviceUrl(String deviceUrl) {
        this.deviceUrl = deviceUrl;
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
