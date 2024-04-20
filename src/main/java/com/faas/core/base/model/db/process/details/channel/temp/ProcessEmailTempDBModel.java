package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempAssetDAO;
import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempDataDAO;
import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempUrlDAO;
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
    private String emailFooter;
    private String emailSender;
    private long typeId;
    private String emailType;
    private List<ProcessTempUrlDAO>tempUrls;
    private List<ProcessTempAssetDAO>tempAssets;
    private List<ProcessTempDataDAO>tempDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessEmailTempDBModel() {
    }

    public ProcessEmailTempDBModel(String id, String processId, String emailSubject, String emailBody, String emailFooter, String emailSender, long typeId, String emailType, List<ProcessTempUrlDAO> tempUrls, List<ProcessTempAssetDAO> tempAssets, List<ProcessTempDataDAO> tempDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
        this.emailFooter = emailFooter;
        this.emailSender = emailSender;
        this.typeId = typeId;
        this.emailType = emailType;
        this.tempUrls = tempUrls;
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

    public String getEmailFooter() {
        return emailFooter;
    }

    public void setEmailFooter(String emailFooter) {
        this.emailFooter = emailFooter;
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

    public List<ProcessTempUrlDAO> getTempUrls() {
        return tempUrls;
    }

    public void setTempUrls(List<ProcessTempUrlDAO> tempUrls) {
        this.tempUrls = tempUrls;
    }

    public List<ProcessTempAssetDAO> getTempAssets() {
        return tempAssets;
    }

    public void setTempAssets(List<ProcessTempAssetDAO> tempAssets) {
        this.tempAssets = tempAssets;
    }

    public List<ProcessTempDataDAO> getTempDatas() {
        return tempDatas;
    }

    public void setTempDatas(List<ProcessTempDataDAO> tempDatas) {
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
