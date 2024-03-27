package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import java.util.List;

public class ProcessTriggerWSDTO {

    private List<ProcessAITriggerWSDTO> processAITriggers;
    private List<ProcessEmailTriggerWSDTO>processEmailTriggers;
    private List<ProcessSipTriggerWSDTO>processSipTriggers;
    private List<ProcessSmsTriggerWSDTO>processSmsTriggers;
    private List<ProcessWappCallTriggerWSDTO>processWappCallTriggers;
    private List<ProcessWappMessageTriggerWSDTO>processWappMessageTriggers;

    public ProcessTriggerWSDTO() {
    }

    public ProcessTriggerWSDTO(List<ProcessAITriggerWSDTO> processAITriggers, List<ProcessEmailTriggerWSDTO> processEmailTriggers, List<ProcessSipTriggerWSDTO> processSipTriggers, List<ProcessSmsTriggerWSDTO> processSmsTriggers, List<ProcessWappCallTriggerWSDTO> processWappCallTriggers, List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggers) {
        this.processAITriggers = processAITriggers;
        this.processEmailTriggers = processEmailTriggers;
        this.processSipTriggers = processSipTriggers;
        this.processSmsTriggers = processSmsTriggers;
        this.processWappCallTriggers = processWappCallTriggers;
        this.processWappMessageTriggers = processWappMessageTriggers;
    }

    public List<ProcessAITriggerWSDTO> getProcessAITriggers() {
        return processAITriggers;
    }

    public void setProcessAITriggers(List<ProcessAITriggerWSDTO> processAITriggers) {
        this.processAITriggers = processAITriggers;
    }

    public List<ProcessEmailTriggerWSDTO> getProcessEmailTriggers() {
        return processEmailTriggers;
    }

    public void setProcessEmailTriggers(List<ProcessEmailTriggerWSDTO> processEmailTriggers) {
        this.processEmailTriggers = processEmailTriggers;
    }

    public List<ProcessSipTriggerWSDTO> getProcessSipTriggers() {
        return processSipTriggers;
    }

    public void setProcessSipTriggers(List<ProcessSipTriggerWSDTO> processSipTriggers) {
        this.processSipTriggers = processSipTriggers;
    }

    public List<ProcessSmsTriggerWSDTO> getProcessSmsTriggers() {
        return processSmsTriggers;
    }

    public void setProcessSmsTriggers(List<ProcessSmsTriggerWSDTO> processSmsTriggers) {
        this.processSmsTriggers = processSmsTriggers;
    }

    public List<ProcessWappCallTriggerWSDTO> getProcessWappCallTriggers() {
        return processWappCallTriggers;
    }

    public void setProcessWappCallTriggers(List<ProcessWappCallTriggerWSDTO> processWappCallTriggers) {
        this.processWappCallTriggers = processWappCallTriggers;
    }

    public List<ProcessWappMessageTriggerWSDTO> getProcessWappMessageTriggers() {
        return processWappMessageTriggers;
    }

    public void setProcessWappMessageTriggers(List<ProcessWappMessageTriggerWSDTO> processWappMessageTriggers) {
        this.processWappMessageTriggers = processWappMessageTriggers;
    }
}
