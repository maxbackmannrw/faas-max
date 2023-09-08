package com.faas.core.base.model.ws.client.inquiry.dto;

import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class InquiryCampaignWSDTO {

    private CampaignWSDTO campaign;
    private PaginationWSDTO pagination;
    private List<InquiryWSDTO>inquiries;

    public InquiryCampaignWSDTO() {
    }

    public InquiryCampaignWSDTO(CampaignWSDTO campaign, PaginationWSDTO pagination, List<InquiryWSDTO> inquiries) {
        this.campaign = campaign;
        this.pagination = pagination;
        this.inquiries = inquiries;
    }

    public CampaignWSDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignWSDTO campaign) {
        this.campaign = campaign;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<InquiryWSDTO> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<InquiryWSDTO> inquiries) {
        this.inquiries = inquiries;
    }
}
