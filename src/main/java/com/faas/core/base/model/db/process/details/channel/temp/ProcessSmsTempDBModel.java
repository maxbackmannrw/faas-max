package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempAssetDAO;
import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_sms_temp_table")
public class ProcessSmsTempDBModel {

    @Id
    private String id;
    private String processId;
    private String smsTitle;
    private String smsBody;
    private String senderId;
    private long typeId;
    private String messageType;
    private List<ProcessTempDataDAO>tempDatas;
    private List<ProcessTempAssetDAO>tempAssets;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessSmsTempDBModel() {
    }

    public ProcessSmsTempDBModel(String id, String processId, String smsTitle, String smsBody, String senderId, long typeId, String messageType, List<ProcessTempDataDAO> tempDatas, List<ProcessTempAssetDAO> tempAssets, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.smsTitle = smsTitle;
        this.smsBody = smsBody;
        this.senderId = senderId;
        this.typeId = typeId;
        this.messageType = messageType;
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