package com.faas.core.base.model.ws.campaign.details.client.inquiry.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.client.inquiry.dto.ClientInquiryWSDTO;

import java.util.List;

public class CampaignInquirySessionWSDTO {

    private List<ClientInquiryWSDTO>inquiries;
    private PaginationWSDTO pagination;

    public CampaignInquirySessionWSDTO() {
    }

    public CampaignInquirySessionWSDTO(PaginationWSDTO pagination, List<ClientInquiryWSDTO> inquiries) {
        this.pagination = pagination;
        this.inquiries = inquiries;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<ClientInquiryWSDTO> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<ClientInquiryWSDTO> inquiries) {
        this.inquiries = inquiries;
    }
}
