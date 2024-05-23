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
    private List<TempDataDAO>tempDatas;
    private List<TempAssetDAO>tempAssets;
    private long uDate;
    private long cDate;
    private int status;

    public PushTempDBModel() {
    }

    public PushTempDBModel(String id, String processId, String pushHeader, String pushBody, String pushSender, long typeId, String pushType, List<TempDataDAO> tempDatas, List<TempAssetDAO> tempAssets, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.pushHeader = pushHeader;
        this.pushBody = pushBody;
        this.pushSender = pushSender;
        this.typeId = typeId;
        this.pushType = pushType;
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

    public List<TempDataDAO> getTempDatas() {
        return tempDatas;
    }

    public void setTempDatas(List<TempDataDAO> tempDatas) {
        this.tempDatas = tempDatas;
    }

    public List<TempAssetDAO> getTempAssets() {
        return tempAssets;
    }

    public void setTempAssets(List<TempAssetDAO> tempAssets) {
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