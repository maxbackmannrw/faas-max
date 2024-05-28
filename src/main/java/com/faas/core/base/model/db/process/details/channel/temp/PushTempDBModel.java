package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.TempAssetDAO;
import com.faas.core.base.model.db.process.details.channel.temp.dao.TempDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "push_temp_table")
public class PushTempDBModel {

    @Id
    private String id;
    private String processId;
    private String pushHeader;
    private String pushBody;
    private String pushSender;
    private long typeId;
    private String pushType;
    private List<TempAssetDAO>tempAssets;
    private List<TempDataDAO>tempDatas;
    private long uDate;
    private long cDate;
    private int status;

    public PushTempDBModel() {
    }

    public PushTempDBModel(long cDate, String id, String processId, String pushBody, String pushHeader, String pushSender, String pushType, int status, List<TempAssetDAO> tempAssets, List<TempDataDAO> tempDatas, long typeId, long uDate) {
        this.cDate = cDate;
        this.id = id;
        this.processId = processId;
        this.pushBody = pushBody;
        this.pushHeader = pushHeader;
        this.pushSender = pushSender;
        this.pushType = pushType;
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getPushBody() {
        return pushBody;
    }

    public void setPushBody(String pushBody) {
        this.pushBody = pushBody;
    }

    public String getPushHeader() {
        return pushHeader;
    }

    public void setPushHeader(String pushHeader) {
        this.pushHeader = pushHeader;
    }

    public String getPushSender() {
        return pushSender;
    }

    public void setPushSender(String pushSender) {
        this.pushSender = pushSender;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
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