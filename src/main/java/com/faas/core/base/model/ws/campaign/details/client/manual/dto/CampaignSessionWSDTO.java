package com.faas.core.base.model.ws.campaign.details.client.manual.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.client.session.content.dto.SessionWSDTO;

import java.util.List;

public class CampaignSessionWSDTO {

    private List<SessionWSDTO> sessions;
    private PaginationWSDTO pagination;

    public CampaignSessionWSDTO() {
    }

    public CampaignSessionWSDTO(List<SessionWSDTO> sessions, PaginationWSDTO pagination) {
        this.sessions = sessions;
        this.pagination = pagination;
    }

    public List<SessionWSDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionWSDTO> sessions) {
        this.sessions = sessions;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
