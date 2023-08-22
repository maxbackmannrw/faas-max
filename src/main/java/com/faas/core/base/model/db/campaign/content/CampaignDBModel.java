package com.faas.core.base.model.db.campaign.content;

import com.faas.core.base.model.db.campaign.content.dao.CampaignDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "campaigns_table")
public class CampaignDBModel {

    @Id
    private String id;
    private String campaign;
    private String campaignDesc;
    private long campaignTypeId;
    private String campaignType;
    private String campaignCategory;
    private String processId;
    private String process;
    private String processType;
    private String processCategory;
    private List<CampaignDataDAO>campaignDatas;
    private String campaignState;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignDBModel() {
    }

    public CampaignDBModel(String id, String campaign, String campaignDesc, long campaignTypeId, String campaignType, String campaignCategory, String processId, String process, String processType, String processCategory, List<CampaignDataDAO> campaignDatas, String campaignState, long uDate, long cDate, int status) {
        this.id = id;
        this.campaign = campaign;
        this.campaignDesc = campaignDesc;
        this.campaignTypeId = campaignTypeId;
        this.campaignType = campaignType;
        this.campaignCategory = campaignCategory;
        this.processId = processId;
        this.process = process;
        this.processType = processType;
        this.processCategory = processCategory;
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

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getProcessCategory() {
        return processCategory;
    }

    public void setProcessCategory(String processCategory) {
        this.processCategory = processCategory;
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
