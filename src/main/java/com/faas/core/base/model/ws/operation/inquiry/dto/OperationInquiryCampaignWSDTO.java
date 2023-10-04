package com.faas.core.base.model.ws.operation.inquiry.dto;

import com.faas.core.base.model.ws.campaign.content.dto.CampaignWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class OperationInquiryCampaignWSDTO {

    private CampaignWSDTO campaign;
    private PaginationWSDTO pagination;
    private List<OperationInquiryWSDTO>inquiries;

    public OperationInquiryCampaignWSDTO() {
    }

    public OperationInquiryCampaignWSDTO(CampaignWSDTO campaign, PaginationWSDTO pagination, List<OperationInquiryWSDTO> inquiries) {
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

    public List<OperationInquiryWSDTO> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<OperationInquiryWSDTO> inquiries) {
        this.inquiries = inquiries;
    }
}
