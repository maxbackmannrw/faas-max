package com.faas.core.api.model.ws.session.dto;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;

public class ApiSessionDetailsWSDTO {

    private SessionDBModel session;
    private OperationDBModel operation;
    private CampaignDBModel campaign;
    private ProcessDBModel process;

    public ApiSessionDetailsWSDTO() {
    }

    public ApiSessionDetailsWSDTO(SessionDBModel session, OperationDBModel operation, CampaignDBModel campaign, ProcessDBModel process) {
        this.session = session;
        this.operation = operation;
        this.campaign = campaign;
        this.process = process;
    }

    public SessionDBModel getSession() {
        return session;
    }

    public void setSession(SessionDBModel session) {
        this.session = session;
    }

    public OperationDBModel getOperation() {
        return operation;
    }

    public void setOperation(OperationDBModel operation) {
        this.operation = operation;
    }

    public CampaignDBModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDBModel campaign) {
        this.campaign = campaign;
    }

    public ProcessDBModel getProcess() {
        return process;
    }

    public void setProcess(ProcessDBModel process) {
        this.process = process;
    }
}
