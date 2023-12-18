package com.faas.core.api.model.ws.operation.channel.message.wapp.dto;

import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiWappAccountWSDTO;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessWappMessageTempDBModel;

import java.util.List;

public class ApiWappMessageTempWSDTO {

    private ApiWappAccountWSDTO wappAccount;
    private List<ProcessWappMessageTempDBModel>wappTemps;

    public ApiWappMessageTempWSDTO() {
    }

    public ApiWappMessageTempWSDTO(ApiWappAccountWSDTO wappAccount, List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappAccount = wappAccount;
        this.wappTemps = wappTemps;
    }

    public ApiWappAccountWSDTO getWappAccount() {
        return wappAccount;
    }

    public void setWappAccount(ApiWappAccountWSDTO wappAccount) {
        this.wappAccount = wappAccount;
    }

    public List<ProcessWappMessageTempDBModel> getWappTemps() {
        return wappTemps;
    }

    public void setWappTemps(List<ProcessWappMessageTempDBModel> wappTemps) {
        this.wappTemps = wappTemps;
    }
}
