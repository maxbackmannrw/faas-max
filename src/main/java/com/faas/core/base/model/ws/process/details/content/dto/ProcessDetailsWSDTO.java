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
    private ProcessFlowWSDTO processFlow;
    private ProcessInquiryWSDTO processInquiry;
    private ProcessTempWSDTO processTemps;
    private ProcessChannelWSDTO processChannels;
    private ProcessTriggerWSDTO processTrigger;
    private List<ProcessScenarioWSDTO> processScenarios;
    private List<ProcessAssetWSDTO>processAssets;

    public ProcessDetailsWSDTO() {
    }

    public ProcessDetailsWSDTO(ProcessDBModel process, ProcessFlowWSDTO processFlow, ProcessInquiryWSDTO processInquiry, ProcessTempWSDTO processTemps, ProcessChannelWSDTO processChannels, ProcessTriggerWSDTO processTrigger, List<ProcessScenarioWSDTO> processScenarios, List<ProcessAssetWSDTO> processAssets) {
        this.process = process;
        this.processFlow = processFlow;
        this.processInquiry = processInquiry;
        this.processTemps = processTemps;
        this.processChannels = processChannels;
        this.processTrigger = processTrigger;
        this.processScenarios = processScenarios;
        this.processAssets = processAssets;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }

    public ProcessFlowWSDTO getProcessFlow() {
        return processFlow;
    }

    public void setProcessFlow(ProcessFlowWSDTO processFlow) {
        this.processFlow = processFlow;
    }

    public ProcessInquiryWSDTO getProcessInquiry() {
        return processInquiry;
    }

    public void setProcessInquiry(ProcessInquiryWSDTO processInquiry) {
        this.processInquiry = processInquiry;
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

    public List<ProcessAssetWSDTO> getProcessAssets() {
        return processAssets;
    }

    public void setProcessAssets(List<ProcessAssetWSDTO> processAssets) {
        this.processAssets = processAssets;
    }
}
