package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiWappCallAccountWSDTO;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

import java.util.List;

public class ApiOperationWappMessageChannelWSDTO {

    private ApiWappCallAccountWSDTO wappMessageAccount;
    private List<OperationWappMessageDBModel>operationWappMessages;
    private List<ProcessWappMessageTempDBModel>operationWappMessageTemps;

    public ApiOperationWappMessageChannelWSDTO() {
    }

    public ApiOperationWappMessageChannelWSDTO(ApiWappCallAccountWSDTO wappMessageAccount, List<OperationWappMessageDBModel> operationWappMessages, List<ProcessWappMessageTempDBModel> operationWappMessageTemps) {
        this.wappMessageAccount = wappMessageAccount;
        this.operationWappMessages = operationWappMessages;
        this.operationWappMessageTemps = operationWappMessageTemps;
    }

    public ApiWappCallAccountWSDTO getWappMessageAccount() {
        return wappMessageAccount;
    }

    public void setWappMessageAccount(ApiWappCallAccountWSDTO wappMessageAccount) {
        this.wappMessageAccount = wappMessageAccount;
    }

    public List<OperationWappMessageDBModel> getOperationWappMessages() {
        return operationWappMessages;
    }

    public void setOperationWappMessages(List<OperationWappMessageDBModel> operationWappMessages) {
        this.operationWappMessages = operationWappMessages;
    }

    public List<ProcessWappMessageTempDBModel> getOperationWappMessageTemps() {
        return operationWappMessageTemps;
    }

    public void setOperationWappMessageTemps(List<ProcessWappMessageTempDBModel> operationWappMessageTemps) {
        this.operationWappMessageTemps = operationWappMessageTemps;
    }
}
