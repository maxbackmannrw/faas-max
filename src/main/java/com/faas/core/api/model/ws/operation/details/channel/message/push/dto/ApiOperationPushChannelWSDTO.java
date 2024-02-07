package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;


import com.faas.core.base.model.db.operation.details.channel.OperationPushMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;

import java.util.List;

public class ApiOperationPushChannelWSDTO {

    private ApiPushAccountWSDTO pushAccount;
    private List<OperationPushMessageDBModel>operationPushes;
    private List<ProcessPushTempDBModel>operationPushTemps;

    public ApiOperationPushChannelWSDTO() {
    }

    public ApiOperationPushChannelWSDTO(ApiPushAccountWSDTO pushAccount, List<OperationPushMessageDBModel> operationPushes, List<ProcessPushTempDBModel> operationPushTemps) {
        this.pushAccount = pushAccount;
        this.operationPushes = operationPushes;
        this.operationPushTemps = operationPushTemps;
    }

    public ApiPushAccountWSDTO getPushAccount() {
        return pushAccount;
    }

    public void setPushAccount(ApiPushAccountWSDTO pushAccount) {
        this.pushAccount = pushAccount;
    }

    public List<OperationPushMessageDBModel> getOperationPushes() {
        return operationPushes;
    }

    public void setOperationPushes(List<OperationPushMessageDBModel> operationPushes) {
        this.operationPushes = operationPushes;
    }

    public List<ProcessPushTempDBModel> getOperationPushTemps() {
        return operationPushTemps;
    }

    public void setOperationPushTemps(List<ProcessPushTempDBModel> operationPushTemps) {
        this.operationPushTemps = operationPushTemps;
    }
}
