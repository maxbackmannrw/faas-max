package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;

import com.faas.core.data.db.campaign.details.temp.PushTempDBModel;

import java.util.List;

public class ApiOperationPushTempWSDTO {

    private ApiOperationPushAccountWSDTO pushAccount;
    private List<PushTempDBModel> operationPushTemps;

    public ApiOperationPushTempWSDTO() {
    }

    public ApiOperationPushTempWSDTO(ApiOperationPushAccountWSDTO pushAccount, List<PushTempDBModel> operationPushTemps) {
        this.pushAccount = pushAccount;
        this.operationPushTemps = operationPushTemps;
    }

    public ApiOperationPushAccountWSDTO getPushAccount() {
        return pushAccount;
    }

    public void setPushAccount(ApiOperationPushAccountWSDTO pushAccount) {
        this.pushAccount = pushAccount;
    }

    public List<PushTempDBModel> getOperationPushTemps() {
        return operationPushTemps;
    }

    public void setOperationPushTemps(List<PushTempDBModel> operationPushTemps) {
        this.operationPushTemps = operationPushTemps;
    }
}
