package com.faas.core.base.model.ws.campaign.manager.operation;

import com.faas.core.base.model.ws.campaign.manager.operation.dto.CampaignOperationRequestDTO;

import java.util.List;

public class CampaignOperationRequest {

    private List<CampaignOperationRequestDTO>operationRequests;

    public CampaignOperationRequest() {
    }

    public CampaignOperationRequest(List<CampaignOperationRequestDTO> operationRequests) {
        this.operationRequests = operationRequests;
    }

    public List<CampaignOperationRequestDTO> getOperationRequests() {
        return operationRequests;
    }

    public void setOperationRequests(List<CampaignOperationRequestDTO> operationRequests) {
        this.operationRequests = operationRequests;
    }
}
