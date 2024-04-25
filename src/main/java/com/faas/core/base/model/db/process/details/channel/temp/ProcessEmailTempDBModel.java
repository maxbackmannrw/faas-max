package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempAssetDAO;
import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_email_temp_table")
public class ProcessEmailTempDBModel {

    @Id
    private String id;
    private String processId;
    private String emailSubject;
    private String emailBody;
    private String emailSender;
    private long typeId;
    private String emailType;
    private List<ProcessTempDataDAO>tempDatas;
    private List<ProcessTempAssetDAO>tempAssets;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessEmailTempDBModel() {
    }

    public ProcessEmailTempDBModel(String id, String processId, String emailSubject, String emailBody, String emailSender, long typeId, String emailType, List<ProcessTempDataDAO> tempDatas, List<ProcessTempAssetDAO> tempAssets, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
        this.emailSender = emailSender;
        this.typeId = typeId;
        this.emailType = emailType;
        this.tempDatas = tempDatas;
        this.tempAssets = tempAssets;
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
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

    public List<ProcessTempDataDAO> getTempDatas() {
        return tempDatas;
    }

    public void setTempDatas(List<ProcessTempDataDAO> tempDatas) {
        this.tempDatas = tempDatas;
    }

    public List<ProcessTempAssetDAO> getTempAssets() {
        return tempAssets;
    }

    public void setTempAssets(List<ProcessTempAssetDAO> tempAssets) {
        this.tempAssets = tempAssets;
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
