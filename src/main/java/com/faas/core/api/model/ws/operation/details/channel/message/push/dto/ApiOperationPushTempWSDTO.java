package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;

import java.util.List;

public class ApiOperationPushTempWSDTO {

    private ApiPushAccountWSDTO pushAccount;
    private List<ProcessPushTempDBModel>operationPushTemps;

    public ApiOperationPushTempWSDTO() {
    }

    public ApiOperationPushTempWSDTO(ApiPushAccountWSDTO pushAccount, List<ProcessPushTempDBModel> operationPushTemps) {
        this.pushAccount = pushAccount;
        this.operationPushTemps = operationPushTemps;
    }

    public ApiPushAccountWSDTO getPushAccount() {
        return pushAccount;
    }

    public void setPushAccount(ApiPushAccountWSDTO pushAccount) {
        this.pushAccount = pushAccount;
    }

    public List<ProcessPushTempDBModel> getOperationPushTemps() {
        return operationPushTemps;
    }

    public void setOperationPushTemps(List<ProcessPushTempDBModel> operationPushTemps) {
        this.operationPushTemps = operationPushTemps;
    }
}
