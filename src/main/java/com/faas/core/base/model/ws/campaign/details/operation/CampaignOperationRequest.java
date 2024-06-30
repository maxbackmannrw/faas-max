package com.faas.core.base.model.ws.campaign.details.operation;

import com.faas.core.base.model.ws.campaign.details.operation.dto.CampaignOperationRequestDTO;

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
