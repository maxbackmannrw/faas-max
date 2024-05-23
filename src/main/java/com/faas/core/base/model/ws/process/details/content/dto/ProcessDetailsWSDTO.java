package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessChannelWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.content.dto.ProcessTriggerWSDTO;

import java.util.List;

public class ProcessDetailsWSDTO {

    private ProcessDBModel process;
    private ProcessTempWSDTO processTemp;
    private ProcessChannelWSDTO processChannels;
    private ProcessTriggerWSDTO processTrigger;
    private List<ProcessScenarioWSDTO> processScenarios;
    private List<ProcessRemoteWSDTO>processRemotes;

    public ProcessDetailsWSDTO() {
    }

    public ProcessDetailsWSDTO(ProcessDBModel process, ProcessTempWSDTO processTemp, ProcessChannelWSDTO processChannels, ProcessTriggerWSDTO processTrigger, List<ProcessScenarioWSDTO> processScenarios, List<ProcessRemoteWSDTO> processRemotes) {
        this.process = process;
        this.processTemp = processTemp;
        this.processChannels = processChannels;
        this.processTrigger = processTrigger;
        this.processScenarios = processScenarios;
        this.processRemotes = processRemotes;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }

    public ProcessTempWSDTO getProcessTemp() {
        return processTemp;
    }

    public void setProcessTemp(ProcessTempWSDTO processTemp) {
        this.processTemp = processTemp;
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

    public List<ProcessRemoteWSDTO> getProcessRemotes() {
        return processRemotes;
    }

    public void setProcessRemotes(List<ProcessRemoteWSDTO> processRemotes) {
        this.processRemotes = processRemotes;
    }
}
