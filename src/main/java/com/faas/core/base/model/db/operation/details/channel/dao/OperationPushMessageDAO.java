package com.faas.core.base.model.db.operation.details.channel.dao;


import java.util.List;

public class OperationPushMessageDAO {

    private String tempId;
    private String header;
    private String body;
    private String footer;
    private List<OperationChannelDataDAO> pushDatas;
    private String pushType;
    private String mainType;
    private int status;

    public OperationPushMessageDAO() {
    }

    public OperationPushMessageDAO(String tempId, String header, String body, String footer, List<OperationChannelDataDAO> pushDatas, String pushType, String mainType, int status) {
        this.tempId = tempId;
        this.header = header;
        this.body = body;
        this.footer = footer;
        this.pushDatas = pushDatas;
        this.pushType = pushType;
        this.mainType = mainType;
        this.status = status;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public List<OperationChannelDataDAO> getPushDatas() {
        return pushDatas;
    }

    public void setPushDatas(List<OperationChannelDataDAO> pushDatas) {
        this.pushDatas = pushDatas;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
