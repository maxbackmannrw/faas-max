package com.faas.core.api.model.ws.client.content.dto;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ApiClientWSDTO {

    private List<ApiClientWSDTO> clients;
    private PaginationWSDTO pagination;

    public ApiClientWSDTO() {
    }

    public ApiClientWSDTO(List<ApiClientWSDTO> clients, PaginationWSDTO pagination) {
        this.clients = clients;
        this.pagination = pagination;
    }

    public List<ApiClientWSDTO> getClients() {
        return clients;
    }

    public void setClients(List<ApiClientWSDTO> clients) {
        this.clients = clients;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
