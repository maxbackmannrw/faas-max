package com.faas.core.base.model.db.campaign.content.dao;

import java.util.List;

public class CampaignInquiryDAO {

    private String inquiryId;
    private String campaignInquiry;
    private List<CampaignDataDAO> inquiryDatas;
    private String inquiryState;
    private long uDate;
    private long cDate;
    private int status;

    public CampaignInquiryDAO() {
    }

    public CampaignInquiryDAO(String inquiryId, String campaignInquiry, List<CampaignDataDAO> inquiryDatas, String inquiryState, long uDate, long cDate, int status) {
        this.inquiryId = inquiryId;
        this.campaignInquiry = campaignInquiry;
        this.inquiryDatas = inquiryDatas;
        this.inquiryState = inquiryState;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getCampaignInquiry() {
        return campaignInquiry;
    }

    public void setCampaignInquiry(String campaignInquiry) {
        this.campaignInquiry = campaignInquiry;
    }

    public List<CampaignDataDAO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<CampaignDataDAO> inquiryDatas) {
        this.inquiryDatas = inquiryDatas;
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
