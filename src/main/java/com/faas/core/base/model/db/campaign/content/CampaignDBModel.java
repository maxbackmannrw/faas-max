package com.faas.core.base.model.db.campaign.content;

import com.faas.core.base.model.db.campaign.content.dao.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "campaign_table")
public class CampaignDBModel {

    @Id
    private String id;
    private String campaign;
    private String campaignDesc;
    private long campaignTypeId;
    private String campaignType;
    private String campaignCategory;
    private CampaignFlowDAO campaignFlow;
    private CampaignInquiryDAO campaignInquiry;
    private List<CampaignScriptDAO>campaignScripts;
    private List<CampaignDataDAO>campaignDatas;
    private String campaignState;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignDBModel() {
    }

    public CampaignDBModel(String id, String campaign, String campaignDesc, long campaignTypeId, String campaignType, String campaignCategory, CampaignFlowDAO campaignFlow, CampaignInquiryDAO campaignInquiry, List<CampaignScriptDAO> campaignScripts, List<CampaignDataDAO> campaignDatas, String campaignState, long uDate, long cDate, int status) {
        this.id = id;
        this.campaign = campaign;
        this.campaignDesc = campaignDesc;
        this.campaignTypeId = campaignTypeId;
        this.campaignType = campaignType;
        this.campaignCategory = campaignCategory;
        this.campaignFlow = campaignFlow;
        this.campaignInquiry = campaignInquiry;
        this.campaignScripts = campaignScripts;
        this.campaignDatas = campaignDatas;
        this.campaignState = campaignState;
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

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getCampaignDesc() {
        return campaignDesc;
    }

    public void setCampaignDesc(String campaignDesc) {
        this.campaignDesc = campaignDesc;
    }

    public long getCampaignTypeId() {
        return campaignTypeId;
    }

    public void setCampaignTypeId(long campaignTypeId) {
        this.campaignTypeId = campaignTypeId;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    public String getCampaignCategory() {
        return campaignCategory;
    }

    public void setCampaignCategory(String campaignCategory) {
        this.campaignCategory = campaignCategory;
    }

    public CampaignFlowDAO getCampaignFlow() {
        return campaignFlow;
    }

    public void setCampaignFlow(CampaignFlowDAO campaignFlow) {
        this.campaignFlow = campaignFlow;
    }

    public CampaignInquiryDAO getCampaignInquiry() {
        return campaignInquiry;
    }

    public void setCampaignInquiry(CampaignInquiryDAO campaignInquiry) {
        this.campaignInquiry = campaignInquiry;
    }

    public List<CampaignScriptDAO> getCampaignScripts() {
        return campaignScripts;
    }

    public void setCampaignScripts(List<CampaignScriptDAO> campaignScripts) {
        this.campaignScripts = campaignScripts;
    }

    public List<CampaignDataDAO> getCampaignDatas() {
        return campaignDatas;
    }

    public void setCampaignDatas(List<CampaignDataDAO> campaignDatas) {
        this.campaignDatas = campaignDatas;
    }

    public String getCampaignState() {
        return campaignState;
    }

    public void setCampaignState(String campaignState) {
        this.campaignState = campaignState;
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
