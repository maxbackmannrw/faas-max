package com.faas.core.base.model.db.operation.channel;

import com.faas.core.base.model.db.operation.channel.dao.PushMessageDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "push_message_table")
public class PushMessageDBModel {


    @Id
    private String id;
    private long sessionId;
    private String sessionUUID;
    private long clientId;
    private long agentId;
    private String tempId;
    private String campaignId;
    private String processId;
    private String header;
    private String body;
    private String footer;
    private List<PushMessageDataDAO>messageDatas;
    private String sender;
    private String pushType;
    private String mainType;
    private String accountId;
    private String sentId;
    private String targetId;
    private String pushState;
    private long uDate;
    private long cDate;
    private int status;

    public PushMessageDBModel() {
    }

    public PushMessageDBModel(String id, long sessionId, String sessionUUID, long clientId, long agentId, String tempId, String campaignId, String processId, String header, String body, String footer, List<PushMessageDataDAO> messageDatas, String sender, String pushType, String mainType, String accountId, String sentId, String targetId, String pushState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.sessionUUID = sessionUUID;
        this.clientId = clientId;
        this.agentId = agentId;
        this.tempId = tempId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.header = header;
        this.body = body;
        this.footer = footer;
        this.messageDatas = messageDatas;
        this.sender = sender;
        this.pushType = pushType;
        this.mainType = mainType;
        this.accountId = accountId;
        this.sentId = sentId;
        this.targetId = targetId;
        this.pushState = pushState;
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

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionUUID() {
        return sessionUUID;
    }

    public void setSessionUUID(String sessionUUID) {
        this.sessionUUID = sessionUUID;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
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

    public List<PushMessageDataDAO> getMessageDatas() {
        return messageDatas;
    }

    public void setMessageDatas(List<PushMessageDataDAO> messageDatas) {
        this.messageDatas = messageDatas;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSentId() {
        return sentId;
    }

    public void setSentId(String sentId) {
        this.sentId = sentId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getPushState() {
        return pushState;
    }

    public void setPushState(String pushState) {
        this.pushState = pushState;
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
