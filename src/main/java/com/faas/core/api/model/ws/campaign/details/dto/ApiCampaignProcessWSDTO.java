package com.faas.core.api.model.ws.campaign.details.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;

import java.util.List;

public class ApiCampaignProcessWSDTO {

    private ProcessDBModel process;
    private List<ProcessScenarioWSDTO> processScenarios;

    public ApiCampaignProcessWSDTO() {
    }

    public ApiCampaignProcessWSDTO(ProcessDBModel process, List<ProcessScenarioWSDTO> processScenarios) {
        this.process = process;
        this.processScenarios = processScenarios;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }

    public List<ProcessScenarioWSDTO> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ProcessScenarioWSDTO> processScenarios) {
        this.processScenarios = processScenarios;
    }
}
