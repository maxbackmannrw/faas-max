package com.faas.core.base.model.db.operation.channel;

import javax.persistence.*;

@Entity
@Table(name = "operation_wapp_call_table")
public class OperationWappCallDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "session_id")
    private long sessionId;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "agent_id")
    private long agentId;

    @Column(name = "campaign_id")
    private String campaignId;

    @Column(name = "process_id")
    private String processId;

    @Column(name = "number_id")
    private long numberId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "caller_id")
    private String callerId;

    @Column(name = "connection_id")
    private String connectionId;

    @Column(name = "call_state")
    private String callState;

    @Column(name = "s_date")
    private long sDate;

    @Column(name = "f_date")
    private long fDate;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public OperationWappCallDBModel() {
    }

    public OperationWappCallDBModel(long id, long sessionId, long clientId, long agentId, String campaignId, String processId, long numberId, String phoneNumber, String accountId, String callerId, String connectionId, String callState, long sDate, long fDate, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.agentId = agentId;
        this.campaignId = campaignId;
        this.processId = processId;
        this.numberId = numberId;
        this.phoneNumber = phoneNumber;
        this.accountId = accountId;
        this.callerId = callerId;
        this.connectionId = connectionId;
        this.callState = callState;
        this.sDate = sDate;
        this.fDate = fDate;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
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

    public long getNumberId() {
        return numberId;
    }

    public void setNumberId(long numberId) {
        this.numberId = numberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getCallState() {
        return callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
    }

    public long getsDate() {
        return sDate;
    }

    public void setsDate(long sDate) {
        this.sDate = sDate;
    }

    public long getfDate() {
        return fDate;
    }

    public void setfDate(long fDate) {
        this.fDate = fDate;
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
