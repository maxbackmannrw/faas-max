package com.faas.core.base.model.ws.campaign.details.client.inquiry.dto;

import com.faas.core.base.model.ws.client.inquiry.dto.InquirySessionWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class CampaignInquirySessionWSDTO {

    private List<InquirySessionWSDTO>inquirySessions;
    private PaginationWSDTO pagination;

    public CampaignInquirySessionWSDTO() {
    }

    public CampaignInquirySessionWSDTO(List<InquirySessionWSDTO> inquirySessions, PaginationWSDTO pagination) {
        this.inquirySessions = inquirySessions;
        this.pagination = pagination;
    }

    public List<InquirySessionWSDTO> getInquirySessions() {
        return inquirySessions;
    }

    public void setInquirySessions(List<InquirySessionWSDTO> inquirySessions) {
        this.inquirySessions = inquirySessions;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
