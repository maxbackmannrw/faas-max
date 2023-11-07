package com.faas.core.base.model.db.client.details.dao;

public class ClientRemoteDeviceDAO {

    private String deviceId;
    private long sessionId;
    private String operationId;
    private String remoteType;
    private String remoteState;
    private long uDate;
    private long cDate;
    private int status;

    public ClientRemoteDeviceDAO() {
    }

    public ClientRemoteDeviceDAO(String deviceId, long sessionId, String operationId, String remoteType, String remoteState, long uDate, long cDate, int status) {
        this.deviceId = deviceId;
        this.sessionId = sessionId;
        this.operationId = operationId;
        this.remoteType = remoteType;
        this.remoteState = remoteState;
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

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getRemoteType() {
        return remoteType;
    }

    public void setRemoteType(String remoteType) {
        this.remoteType = remoteType;
    }

    public String getRemoteState() {
        return remoteState;
    }

    public void setRemoteState(String remoteState) {
        this.remoteState = remoteState;
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
