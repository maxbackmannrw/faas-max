package com.faas.core.data.db.campaign.details.remote;

import com.faas.core.data.db.remote.content.dao.RemoteDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "campaign_remote_table")
public class CampaignRemoteDBModel {

    @Id
    private String id;
    private String campaignId;
    private String remoteId;
    private String remote;
    private String remoteDesc;
    private String version;
    private List<RemoteDataDAO> remoteDatas;
    private String remoteCategory;
    private long typeId;
    private String remoteType;
    private String baseType;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignRemoteDBModel() {
    }

    public CampaignRemoteDBModel(String id, String campaignId, String remoteId, String remote, String remoteDesc, String version, List<RemoteDataDAO> remoteDatas, String remoteCategory, long typeId, String remoteType, String baseType, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.remoteId = remoteId;
        this.remote = remote;
        this.remoteDesc = remoteDesc;
        this.version = version;
        this.remoteDatas = remoteDatas;
        this.remoteCategory = remoteCategory;
        this.typeId = typeId;
        this.remoteType = remoteType;
        this.baseType = baseType;
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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<RemoteDataDAO> getRemoteDatas() {
        return remoteDatas;
    }

    public void setRemoteDatas(List<RemoteDataDAO> remoteDatas) {
        this.remoteDatas = remoteDatas;
    }

    public String getRemoteCategory() {
        return remoteCategory;
    }

    public void setRemoteCategory(String remoteCategory) {
        this.remoteCategory = remoteCategory;
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
