package com.faas.core.base.model.db.remote.app;

import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.model.db.remote.content.dao.RemoteUrlDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "remote_app_table")
public class RemoteAppDBModel {

    @Id
    private String id;
    private long clientId;
    private long sessionId;
    private String operationId;
    private String campaignId;
    private String campaign;
    private String processId;
    private String process;
    private String remoteId;
    private String remote;
    private String remoteDesc;
    private String remoteVersion;
    private List<RemoteDataDAO> remoteDatas;
    private List<RemoteUrlDAO>remoteUrls;
    private long remoteTypeId;
    private String remoteType;
    private String baseType;
    private String connState;
    private long uDate;
    private long cDate;
    private int status;

    public RemoteAppDBModel() {
    }

    public RemoteAppDBModel(String id, long clientId, long sessionId, String operationId, String campaignId, String campaign, String processId, String process, String remoteId, String remote, String remoteDesc, String remoteVersion, List<RemoteDataDAO> remoteDatas, List<RemoteUrlDAO> remoteUrls, long remoteTypeId, String remoteType, String baseType, String connState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.operationId = operationId;
        this.campaignId = campaignId;
        this.campaign = campaign;
        this.processId = processId;
        this.process = process;
        this.remoteId = remoteId;
        this.remote = remote;
        this.remoteDesc = remoteDesc;
        this.remoteVersion = remoteVersion;
        this.remoteDatas = remoteDatas;
        this.remoteUrls = remoteUrls;
        this.remoteTypeId = remoteTypeId;
        this.remoteType = remoteType;
        this.baseType = baseType;
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
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

    public String getRemoteDesc() {
        return remoteDesc;
    }

    public void setRemoteDesc(String remoteDesc) {
        this.remoteDesc = remoteDesc;
    }

    public String getRemoteVersion() {
        return remoteVersion;
    }

    public void setRemoteVersion(String remoteVersion) {
        this.remoteVersion = remoteVersion;
    }

    public List<RemoteDataDAO> getRemoteDatas() {
        return remoteDatas;
    }

    public void setRemoteDatas(List<RemoteDataDAO> remoteDatas) {
        this.remoteDatas = remoteDatas;
    }

    public List<RemoteUrlDAO> getRemoteUrls() {
        return remoteUrls;
    }

    public void setRemoteUrls(List<RemoteUrlDAO> remoteUrls) {
        this.remoteUrls = remoteUrls;
    }

    public long getRemoteTypeId() {
        return remoteTypeId;
    }

    public void setRemoteTypeId(long remoteTypeId) {
        this.remoteTypeId = remoteTypeId;
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
