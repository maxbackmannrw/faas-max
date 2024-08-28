package com.faas.core.base.model.db.campaign.details.agent;

import javax.persistence.*;


@Entity
@Table(name = "campaign_agent_table")
public class CampaignAgentDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "campaign_id")
    private String campaignId;

    @Column(name = "agent_id")
    private long agentId;

    @Column(name = "agent_state")
    private String agentState;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;


    public CampaignAgentDBModel() {
    }

    public CampaignAgentDBModel(long id, String campaignId, long agentId, String agentState, long uDate, long cDate, int status) {
        this.id = id;
        this.campaignId = campaignId;
        this.agentId = agentId;
        this.agentState = agentState;
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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getAgentState() {
        return agentState;
    }

    public void setAgentState(String agentState) {
        this.agentState = agentState;
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
