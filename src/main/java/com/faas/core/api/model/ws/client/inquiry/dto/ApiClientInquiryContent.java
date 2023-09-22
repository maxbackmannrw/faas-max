 package com.faas.core.api.model.ws.client.inquiry.dto;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiClientInquiryContent {

    private List<SessionDBModel> sessions;
    private PaginationWSDTO pagination;

    public ApiClientInquiryContent() {
    }

    public ApiClientInquiryContent(List<SessionDBModel> sessions, PaginationWSDTO pagination) {
        this.sessions = sessions;
        this.pagination = pagination;
    }

    public List<SessionDBModel> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDBModel> sessions) {
        this.sessions = sessions;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
