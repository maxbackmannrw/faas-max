package com.faas.core.base.model.db.process.details.trigger.dao;

public class ProcessTriggerDetails {

    private ProcessAiTriggerDAO processAiTrigger;
    private ProcessEmailTriggerDAO processEmailTrigger;
    private ProcessSipTriggerDAO processSipTrigger;
    private ProcessSmsTriggerDAO processSmsTrigger;
    private ProcessWappCallTriggerDAO processWappCallTrigger;
    private ProcessWappMessageTriggerDAO processWappMessageTrigger;

    public ProcessTriggerDetails() {
    }

    public ProcessTriggerDetails(ProcessAiTriggerDAO processAiTrigger, ProcessEmailTriggerDAO processEmailTrigger, ProcessSipTriggerDAO processSipTrigger, ProcessSmsTriggerDAO processSmsTrigger, ProcessWappCallTriggerDAO processWappCallTrigger, ProcessWappMessageTriggerDAO processWappMessageTrigger) {
        this.processAiTrigger = processAiTrigger;
        this.processEmailTrigger = processEmailTrigger;
        this.processSipTrigger = processSipTrigger;
        this.processSmsTrigger = processSmsTrigger;
        this.processWappCallTrigger = processWappCallTrigger;
        this.processWappMessageTrigger = processWappMessageTrigger;
    }

    public ProcessAiTriggerDAO getProcessAiTrigger() {
        return processAiTrigger;
    }

    public void setProcessAiTrigger(ProcessAiTriggerDAO processAiTrigger) {
        this.processAiTrigger = processAiTrigger;
    }

    public ProcessEmailTriggerDAO getProcessEmailTrigger() {
        return processEmailTrigger;
    }

    public void setProcessEmailTrigger(ProcessEmailTriggerDAO processEmailTrigger) {
        this.processEmailTrigger = processEmailTrigger;
    }

    public ProcessSipTriggerDAO getProcessSipTrigger() {
        return processSipTrigger;
    }

    public void setProcessSipTrigger(ProcessSipTriggerDAO processSipTrigger) {
        this.processSipTrigger = processSipTrigger;
    }

    public ProcessSmsTriggerDAO getProcessSmsTrigger() {
        return processSmsTrigger;
    }

    public void setProcessSmsTrigger(ProcessSmsTriggerDAO processSmsTrigger) {
        this.processSmsTrigger = processSmsTrigger;
    }

    public ProcessWappCallTriggerDAO getProcessWappCallTrigger() {
        return processWappCallTrigger;
    }

    public void setProcessWappCallTrigger(ProcessWappCallTriggerDAO processWappCallTrigger) {
        this.processWappCallTrigger = processWappCallTrigger;
    }

    public ProcessWappMessageTriggerDAO getProcessWappMessageTrigger() {
        return processWappMessageTrigger;
    }

    public void setProcessWappMessageTrigger(ProcessWappMessageTriggerDAO processWappMessageTrigger) {
        this.processWappMessageTrigger = processWappMessageTrigger;
    }
}
