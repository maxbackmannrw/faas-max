package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

import java.util.List;

public class ApiOperationWappMessageWSDTO {

    private ApiWappAccountWSDTO wappAccount;
    private List<OperationWappMessageDBModel>wappMessages;
    private List<ProcessWappMessageTempDBModel>wappTemps;

    public ApiOperationWappMessageWSDTO() {
    }

    public ApiOperationWappMessageWSDTO(ApiWappAccountWSDTO wappAccount, List<OperationWappMessageDBModel> wappMessages, List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappAccount = wappAccount;
        this.wappMessages = wappMessages;
        this.wappTemps = wappTemps;
    }

    public ApiWappAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiWappAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<OperationWappMessageDBModel> getWappMessages() {
        return wappMessages;
    }

    public void setWappMessages(List<OperationWappMessageDBModel> wappMessages) {
        this.wappMessages = wappMessages;
    }

    public List<ProcessWappMessageTempDBModel> getWappTemps() {
        return wappTemps;
    }

    public void setWappTemps(List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappTemps = wappTemps;
    }
}
