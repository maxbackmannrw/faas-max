package com.faas.core.api.model.ws.operation.details.campaign.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;

public class ApiOperationCampaignWSDTO {

    private CampaignDBModel operationCampaign;
    private ProcessDBModel operationProcess;

    public ApiOperationCampaignWSDTO() {
    }

    public ApiOperationCampaignWSDTO(CampaignDBModel operationCampaign, ProcessDBModel operationProcess) {
        this.operationCampaign = operationCampaign;
        this.operationProcess = operationProcess;
    }

    public CampaignDBModel getOperationCampaign() {
        return operationCampaign;
    }

    public void setOperationCampaign(CampaignDBModel operationCampaign) {
        this.operationCampaign = operationCampaign;
    }

    public ProcessDBModel getOperationProcess() {
        return operationProcess;
    }

    public void setOperationProcess(ProcessDBModel operationProcess) {
        this.operationProcess = operationProcess;
    }
}
