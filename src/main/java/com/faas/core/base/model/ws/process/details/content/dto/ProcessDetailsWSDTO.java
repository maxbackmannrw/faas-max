package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessChannelWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.channel.trigger.dto.ProcessChannelTriggerWSDTO;

import java.util.List;

public class ProcessDetailsWSDTO {

    private ProcessDBModel process;
    private ProcessTempWSDTO processTemps;
    private ProcessChannelWSDTO processChannels;
    private ProcessChannelTriggerWSDTO processChannelTrigger;
    private List<ProcessScenarioWSDTO> processScenarios;

    public ProcessDetailsWSDTO() {
    }

    public ProcessDetailsWSDTO(ProcessDBModel process, ProcessTempWSDTO processTemps, ProcessChannelWSDTO processChannels, ProcessChannelTriggerWSDTO processChannelTrigger, List<ProcessScenarioWSDTO> processScenarios) {
        this.process = process;
        this.processTemps = processTemps;
        this.processChannels = processChannels;
        this.processChannelTrigger = processChannelTrigger;
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

    public ProcessChannelTriggerWSDTO getProcessChannelTrigger() {
        return processChannelTrigger;
    }

    public void setProcessChannelTrigger(ProcessChannelTriggerWSDTO processChannelTrigger) {
        this.processChannelTrigger = processChannelTrigger;
    }

    public List<ProcessScenarioWSDTO> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ProcessScenarioWSDTO> processScenarios) {
        this.processScenarios = processScenarios;
    }
}
