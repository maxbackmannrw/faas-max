package com.faas.core.api.model.ws.operation.details.campaign.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;

import java.util.List;

public class ApiOperationCampaignWSDTO {

    private CampaignDBModel operationCampaign;
    private ProcessDBModel operationProcess;
    private List<ProcessScenarioDBModel> processScenarios;

    public ApiOperationCampaignWSDTO() {
    }

    public ApiOperationCampaignWSDTO(CampaignDBModel operationCampaign, ProcessDBModel operationProcess, List<ProcessScenarioDBModel> processScenarios) {
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

    public List<ProcessScenarioDBModel> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ProcessScenarioDBModel> processScenarios) {
        this.processScenarios = processScenarios;
    }
}
