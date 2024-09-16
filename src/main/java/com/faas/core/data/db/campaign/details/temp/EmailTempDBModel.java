package com.faas.core.data.db.campaign.details.temp;

import com.faas.core.data.db.campaign.details.temp.dao.TempAssetDAO;
import com.faas.core.data.db.campaign.details.temp.dao.TempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "email_temp_table")
public class EmailTempDBModel {

    @Id
    private String id;
    private String campaignId;
    private String emailSubject;
    private String emailBody;
    private String emailSender;
    private long typeId;
    private String emailType;
    private List<TempAssetDAO> tempAssets;
    private List<TempDataDAO> tempDatas;
    private long uDate;
    private long cDate;
    private int status;

    public EmailTempDBModel() {
    }

    public EmailTempDBModel(String id, String campaignId, String emailSubject, String emailBody, String emailSender, long typeId, String emailType, List<TempAssetDAO> tempAssets, List<TempDataDAO> tempDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
        this.emailSender = emailSender;
        this.typeId = typeId;
        this.emailType = emailType;
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

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
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
