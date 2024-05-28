package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.TempAssetDAO;
import com.faas.core.base.model.db.process.details.channel.temp.dao.TempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "email_temp_table")
public class EmailTempDBModel {

    @Id
    private String id;
    private String processId;
    private String emailSubject;
    private String emailBody;
    private String emailSender;
    private long typeId;
    private String emailType;
    private List<TempAssetDAO>tempAssets;
    private List<TempDataDAO>tempDatas;
    private long uDate;
    private long cDate;
    private int status;

    public EmailTempDBModel() {
    }

    public EmailTempDBModel(long cDate, String emailBody, String emailSender, String emailSubject, String emailType, String id, String processId, int status, List<TempAssetDAO> tempAssets, List<TempDataDAO> tempDatas, long typeId, long uDate) {
        this.cDate = cDate;
        this.emailBody = emailBody;
        this.emailSender = emailSender;
        this.emailSubject = emailSubject;
        this.emailType = emailType;
        this.id = id;
        this.processId = processId;
        this.status = status;
        this.tempAssets = tempAssets;
        this.tempDatas = tempDatas;
        this.typeId = typeId;
        this.uDate = uDate;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
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

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }
}
