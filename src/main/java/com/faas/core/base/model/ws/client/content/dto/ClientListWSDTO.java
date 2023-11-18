package com.faas.core.base.model.ws.client.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ClientListWSDTO {

    private PaginationWSDTO pagination;
    private List<ClientWSDTO> clients;

    public ClientListWSDTO() {
    }

    public ClientListWSDTO(PaginationWSDTO pagination, List<ClientWSDTO> clients) {
        this.pagination = pagination;
        this.clients = clients;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }

    public List<ClientWSDTO> getClients() {
        return clients;
    }

    public void setClients(List<ClientWSDTO> clients) {
        this.clients = clients;
    }
}
