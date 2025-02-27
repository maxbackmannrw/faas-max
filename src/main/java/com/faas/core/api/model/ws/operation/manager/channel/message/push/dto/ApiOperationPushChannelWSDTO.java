package com.faas.core.api.model.ws.operation.manager.channel.message.push.dto;


import com.faas.core.data.db.campaign.details.temp.PushTempDBModel;
import com.faas.core.data.db.operation.details.channel.OperationPushDBModel;

import java.util.List;

public class ApiOperationPushChannelWSDTO {

    private ApiOperationPushAccountWSDTO pushAccount;
    private List<OperationPushDBModel> operationPushes;
    private List<PushTempDBModel> operationPushTemps;

    public ApiOperationPushChannelWSDTO() {
    }

    public ApiOperationPushChannelWSDTO(ApiOperationPushAccountWSDTO pushAccount, List<OperationPushDBModel> operationPushes, List<PushTempDBModel> operationPushTemps) {
        this.pushAccount = pushAccount;
        this.operationPushes = operationPushes;
        this.operationPushTemps = operationPushTemps;
    }

    public ApiOperationPushAccountWSDTO getPushAccount() {
        return pushAccount;
    }

    public void setPushAccount(ApiOperationPushAccountWSDTO pushAccount) {
        this.pushAccount = pushAccount;
    }

    public List<OperationPushDBModel> getOperationPushes() {
        return operationPushes;
    }

    public void setOperationPushes(List<OperationPushDBModel> operationPushes) {
        this.operationPushes = operationPushes;
    }

    public List<PushTempDBModel> getOperationPushTemps() {
        return operationPushTemps;
    }

    public void setOperationPushTemps(List<PushTempDBModel> operationPushTemps) {
        this.operationPushTemps = operationPushTemps;
    }
}
