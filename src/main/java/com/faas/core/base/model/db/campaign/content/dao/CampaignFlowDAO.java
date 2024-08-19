package com.faas.core.base.model.db.campaign.content.dao;

import java.util.List;

public class CampaignFlowDAO {

    private String flowId;
    private String campaignFlow;
    private List<CampaignDataDAO> flowDatas;
    private String flowState;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignFlowDAO() {
    }

    public CampaignFlowDAO(String flowId, String campaignFlow, List<CampaignDataDAO> flowDatas, String flowState, long uDate, long cDate, int status) {
        this.flowId = flowId;
        this.campaignFlow = campaignFlow;
        this.flowDatas = flowDatas;
        this.flowState = flowState;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getCampaignFlow() {
        return campaignFlow;
    }

    public void setCampaignFlow(String campaignFlow) {
        this.campaignFlow = campaignFlow;
    }

    public List<CampaignDataDAO> getFlowDatas() {
        return flowDatas;
    }

    public void setFlowDatas(List<CampaignDataDAO> flowDatas) {
        this.flowDatas = flowDatas;
    }

    public String getFlowState() {
        return flowState;
    }

    public void setFlowState(String flowState) {
        this.flowState = flowState;
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
