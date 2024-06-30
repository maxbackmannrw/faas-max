package com.faas.core.base.model.db.campaign.details.channel.temp;

import com.faas.core.base.model.db.campaign.details.channel.temp.dao.TempAssetDAO;
import com.faas.core.base.model.db.campaign.details.channel.temp.dao.TempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sms_temp_table")
public class SmsTempDBModel {

    @Id
    private String id;
    private String campaignId;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private long typeId;
    private String messageType;
    private List<TempAssetDAO>tempAssets;
    private List<TempDataDAO>tempDatas;
    private long uDate;
    private long cDate;
    private int status;

    public SmsTempDBModel() {
    }

    public SmsTempDBModel(String id, String campaignId, String smsTitle, String smsBody, String senderId, long typeId, String messageType, List<TempAssetDAO> tempAssets, List<TempDataDAO> tempDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
        this.typeId = typeId;
        this.messageType = messageType;
        this.tempAssets = tempAssets;
        this.tempDatas = tempDatas;
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

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public List<TempAssetDAO> getTempAssets() {
        return tempAssets;
    }

    public void setTempAssets(List<TempAssetDAO> tempAssets) {
        this.tempAssets = tempAssets;
    }

    public List<TempDataDAO> getTempDatas() {
        return tempDatas;
    }

    public void setTempDatas(List<TempDataDAO> tempDatas) {
        this.tempDatas = tempDatas;
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