package com.faas.core.data.ws.base.campaign.manager.client.dto;

import com.faas.core.data.ws.base.client.content.dto.ClientWSDTO;
import com.faas.core.data.ws.base.general.PaginationWSDTO;

import java.util.List;

public class CampaignClientWSDTO {

    private List<ClientWSDTO> clients;
    private PaginationWSDTO pagination;

    public CampaignClientWSDTO() {
    }

    public CampaignClientWSDTO(List<ClientWSDTO> clients, PaginationWSDTO pagination) {
        this.clients = clients;
        this.pagination = pagination;
    }

    public List<ClientWSDTO> getClients() {
        return clients;
    }

    public void setClients(List<ClientWSDTO> clients) {
        this.clients = clients;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}
