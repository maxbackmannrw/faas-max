package com.faas.core.data.db.remoteapp;

import com.faas.core.data.db.remoteapp.dao.RemoteAppDataDAO;
import com.faas.core.data.db.remoteapp.dao.RemoteAppUrlDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "remote_app_table")
public class RemoteAppDBModel {

    @Id
    private String id;
    private long clientId;
    private String clientName;
    private String operationId;
    private String campaignId;
    private String campaign;
    private String remoteId;
    private String remote;
    private long typeId;
    private String remoteType;
    private String baseType;
    private List<RemoteAppDataDAO> remoteAppDatas;
    private List<RemoteAppUrlDAO> remoteAppUrls;
    private String connState;
    private long uDate;
    private long cDate;
    private int status;

    public RemoteAppDBModel() {
    }

    public RemoteAppDBModel(String id, long clientId, String clientName, String operationId, String campaignId, String campaign, String remoteId, String remote, long typeId, String remoteType, String baseType, List<RemoteAppDataDAO> remoteAppDatas, List<RemoteAppUrlDAO> remoteAppUrls, String connState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.clientName = clientName;
        this.operationId = operationId;
        this.campaignId = campaignId;
        this.campaign = campaign;
        this.remoteId = remoteId;
        this.remote = remote;
        this.typeId = typeId;
        this.remoteType = remoteType;
        this.baseType = baseType;
        this.remoteAppDatas = remoteAppDatas;
        this.remoteAppUrls = remoteAppUrls;
        this.connState = connState;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getRemoteType() {
        return remoteType;
    }

    public void setRemoteType(String remoteType) {
        this.remoteType = remoteType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public List<RemoteAppDataDAO> getRemoteAppDatas() {
        return remoteAppDatas;
    }

    public void setRemoteAppDatas(List<RemoteAppDataDAO> remoteAppDatas) {
        this.remoteAppDatas = remoteAppDatas;
    }

    public List<RemoteAppUrlDAO> getRemoteAppUrls() {
        return remoteAppUrls;
    }

    public void setRemoteAppUrls(List<RemoteAppUrlDAO> remoteAppUrls) {
        this.remoteAppUrls = remoteAppUrls;
    }

    public String getConnState() {
        return connState;
    }

    public void setConnState(String connState) {
        this.connState = connState;
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
