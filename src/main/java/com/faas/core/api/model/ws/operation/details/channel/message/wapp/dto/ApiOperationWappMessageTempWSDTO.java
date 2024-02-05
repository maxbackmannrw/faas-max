package com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto;

import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiWappCallAccountWSDTO;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

import java.util.List;

public class ApiOperationWappMessageTempWSDTO {

    private ApiWappCallAccountWSDTO wappAccount;
    private List<ProcessWappMessageTempDBModel>wappTemps;

    public ApiOperationWappMessageTempWSDTO() {
    }

    public ApiOperationWappMessageTempWSDTO(ApiWappCallAccountWSDTO wappAccount, List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappAccount = wappAccount;
        this.wappTemps = wappTemps;
    }

    public ApiWappCallAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiWappCallAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<ProcessWappMessageTempDBModel> getWappTemps() {
        return wappTemps;
    }

    public void setWappTemps(List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappTemps = wappTemps;
    }
}
