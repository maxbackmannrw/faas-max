package com.faas.core.base.model.db.inquiry;

import javax.persistence.*;


@Entity
@Table(name = "inquiry_table")
public class InquiryDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "session_id")
    private long sessionId;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "client_city")
    private String clientCity;

    @Column(name = "client_country")
    private String clientCountry;

    @Column(name = "campaign_id")
    private String campaignId;

    @Column(name = "campaign")
    private String campaign;

    @Column(name = "process_id")
    private String processId;

    @Column(name = "process")
    private String process;

    @Column(name = "agent_id")
    private long agentId;

    @Column(name = "agent_name")
    private String agentName;

    @Column(name = "inquiry_state")
    private String inquiryState;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public InquiryDBModel() {
    }

    public InquiryDBModel(long id, long sessionId, long clientId, String clientName, String phoneNumber, String emailAddress, String clientCity, String clientCountry, String campaignId, String campaign, String processId, String process, long agentId, String agentName, String inquiryState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.clientCity = clientCity;
        this.clientCountry = clientCountry;
        this.campaignId = campaignId;
        this.campaign = campaign;
        this.processId = processId;
        this.process = process;
        this.agentId = agentId;
        this.agentName = agentName;
        this.inquiryState = inquiryState;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientCountry() {
        return clientCountry;
    }

    public void setClientCountry(String clientCountry) {
        this.clientCountry = clientCountry;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getInquiryState() {
        return inquiryState;
    }

    public void setInquiryState(String inquiryState) {
        this.inquiryState = inquiryState;
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
