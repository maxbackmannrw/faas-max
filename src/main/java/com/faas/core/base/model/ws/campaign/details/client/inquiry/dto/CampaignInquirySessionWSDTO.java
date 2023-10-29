package com.faas.core.base.model.ws.campaign.details.client.inquiry.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.details.inquiry.dto.OperationInquirySessionWSDTO;

import java.util.List;

public class CampaignInquirySessionWSDTO {

    private List<OperationInquirySessionWSDTO>inquirySessions;
    private PaginationWSDTO pagination;

    public CampaignInquirySessionWSDTO() {
    }

    public CampaignInquirySessionWSDTO(List<OperationInquirySessionWSDTO> inquirySessions, PaginationWSDTO pagination) {
        this.inquirySessions = inquirySessions;
        this.pagination = pagination;
    }

    public List<OperationInquirySessionWSDTO> getInquirySessions() {
        return inquirySessions;
    }

    public void setInquirySessions(List<OperationInquirySessionWSDTO> inquirySessions) {
        this.inquirySessions = inquirySessions;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
