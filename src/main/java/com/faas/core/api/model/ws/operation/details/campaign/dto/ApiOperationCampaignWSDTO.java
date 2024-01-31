package com.faas.core.api.model.ws.operation.details.campaign.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;

import java.util.List;

public class ApiOperationCampaignWSDTO {

    private CampaignDBModel operationCampaign;
    private ProcessDBModel operationProcess;
    private List<ApiProcessScenarioWSDTO> processScenarios;

    public ApiOperationCampaignWSDTO() {
    }

    public ApiOperationCampaignWSDTO(CampaignDBModel operationCampaign, ProcessDBModel operationProcess, List<ApiProcessScenarioWSDTO> processScenarios) {
        this.operationCampaign = operationCampaign;
        this.operationProcess = operationProcess;
        this.processScenarios = processScenarios;
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

    public List<ApiProcessScenarioWSDTO> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ApiProcessScenarioWSDTO> processScenarios) {
        this.processScenarios = processScenarios;
    }
}
