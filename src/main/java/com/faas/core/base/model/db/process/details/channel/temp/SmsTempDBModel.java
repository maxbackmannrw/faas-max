package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.TempAssetDAO;
import com.faas.core.base.model.db.process.details.channel.temp.dao.TempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sms_temp_table")
public class SmsTempDBModel {

    @Id
    private String id;
    private String processId;
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

    public SmsTempDBModel(long cDate, String id, String messageType, String processId, String senderId, String smsBody, String smsTitle, int status, List<TempAssetDAO> tempAssets, List<TempDataDAO> tempDatas, long typeId, long uDate) {
        this.cDate = cDate;
        this.id = id;
        this.messageType = messageType;
        this.processId = processId;
        this.senderId = senderId;
        this.smsBody = smsBody;
        this.smsTitle = smsTitle;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
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