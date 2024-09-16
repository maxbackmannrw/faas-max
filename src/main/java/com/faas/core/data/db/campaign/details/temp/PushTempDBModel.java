package com.faas.core.data.db.campaign.details.temp;

import com.faas.core.data.db.campaign.details.temp.dao.TempAssetDAO;
import com.faas.core.data.db.campaign.details.temp.dao.TempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "push_temp_table")
public class PushTempDBModel {

    @Id
    private String id;
    private String campaignId;
    private String pushHeader;
    private String pushBody;
    private String pushSender;
    private long typeId;
    private String pushType;
    private List<TempAssetDAO> tempAssets;
    private List<TempDataDAO> tempDatas;
    private long uDate;
    private long cDate;
    private int status;

    public PushTempDBModel() {
    }

    public PushTempDBModel(String id, String campaignId, String pushHeader, String pushBody, String pushSender, long typeId, String pushType, List<TempAssetDAO> tempAssets, List<TempDataDAO> tempDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.pushHeader = pushHeader;
        this.pushBody = pushBody;
        this.pushSender = pushSender;
        this.typeId = typeId;
        this.pushType = pushType;
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

    public String getPushHeader() {
        return pushHeader;
    }

    public void setPushHeader(String pushHeader) {
        this.pushHeader = pushHeader;
    }

    public String getPushBody() {
        return pushBody;
    }

    public void setPushBody(String pushBody) {
        this.pushBody = pushBody;
    }

    public String getPushSender() {
        return pushSender;
    }

    public void setPushSender(String pushSender) {
        this.pushSender = pushSender;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
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