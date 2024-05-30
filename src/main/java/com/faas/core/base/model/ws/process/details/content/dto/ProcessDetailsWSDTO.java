package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessChannelWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.content.dto.ProcessTriggerTempWSDTO;

import java.util.List;

public class ProcessDetailsWSDTO {

    private ProcessDBModel process;
    private ProcessTempWSDTO processTemp;
    private ProcessChannelWSDTO processChannels;
    private ProcessTriggerTempWSDTO processTriggerTemp;
    private List<ProcessScenarioWSDTO> processScenarios;
    private List<ProcessRemoteWSDTO> processRemotes;

    public ProcessDetailsWSDTO() {
    }

    public ProcessDetailsWSDTO(ProcessDBModel process, ProcessChannelWSDTO processChannels, List<ProcessRemoteWSDTO> processRemotes, List<ProcessScenarioWSDTO> processScenarios, ProcessTempWSDTO processTemp, ProcessTriggerTempWSDTO processTriggerTemp) {
        this.process = process;
        this.processChannels = processChannels;
        this.processRemotes = processRemotes;
        this.processScenarios = processScenarios;
        this.processTemp = processTemp;
        this.processTriggerTemp = processTriggerTemp;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }

    public ProcessChannelWSDTO getProcessChannels() {
        return processChannels;
    }

    public void setProcessChannels(ProcessChannelWSDTO processChannels) {
        this.processChannels = processChannels;
    }

    public List<ProcessRemoteWSDTO> getProcessRemotes() {
        return processRemotes;
    }

    public void setProcessRemotes(List<ProcessRemoteWSDTO> processRemotes) {
        this.processRemotes = processRemotes;
    }

    public List<ProcessScenarioWSDTO> getProcessScenarios() {
        return processScenarios;
    }

    public void setProcessScenarios(List<ProcessScenarioWSDTO> processScenarios) {
        this.processScenarios = processScenarios;
    }

    public ProcessTempWSDTO getProcessTemp() {
        return processTemp;
    }

    public void setProcessTemp(ProcessTempWSDTO processTemp) {
        this.processTemp = processTemp;
    }

    public ProcessTriggerTempWSDTO getProcessTriggerTemp() {
        return processTriggerTemp;
    }

    public void setProcessTriggerTemp(ProcessTriggerTempWSDTO processTriggerTemp) {
        this.processTriggerTemp = processTriggerTemp;
    }
}
