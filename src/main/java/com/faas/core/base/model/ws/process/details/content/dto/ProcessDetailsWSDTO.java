package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.process.details.assets.dto.ProcessAssetWSDTO;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessChannelWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;

import java.util.List;

public class ProcessDetailsWSDTO {

    private ProcessDBModel process;
    private ProcessTempWSDTO processTemps;
    private ProcessChannelWSDTO processChannels;
    private ProcessTriggerWSDTO processTrigger;
    private List<ProcessScenarioWSDTO> processScenarios;

    public ProcessDetailsWSDTO() {
    }

    public ProcessDetailsWSDTO(ProcessDBModel process, ProcessTempWSDTO processTemps, ProcessChannelWSDTO processChannels, ProcessTriggerWSDTO processTrigger, List<ProcessScenarioWSDTO> processScenarios) {
        this.process = process;
        this.processTemps = processTemps;
        this.processChannels = processChannels;
        this.processTrigger = processTrigger;
        this.processScenarios = processScenarios;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }

    public ProcessTempWSDTO getProcessTemps() {
        return processTemps;
    }

    public void setProcessTemps(ProcessTempWSDTO processTemps) {
        this.processTemps = processTemps;
    }

    public ProcessChannelWSDTO getProcessChannels() {
        return processChannels;
    }

    public void setProcessChannels(ProcessChannelWSDTO processChannels) {
        this.processChannels = processChannels;
    }

    public ProcessTriggerWSDTO getProcessTrigger() {
        return processTrigger;
    }

    public void setProcessTrigger(ProcessTriggerWSDTO processTrigger) {
        this.processTrigger = processTrigger;
    }

    public List<ProcessScenarioWSDTO> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ProcessScenarioWSDTO> processScenarios) {
        this.processScenarios = processScenarios;
    }
}
