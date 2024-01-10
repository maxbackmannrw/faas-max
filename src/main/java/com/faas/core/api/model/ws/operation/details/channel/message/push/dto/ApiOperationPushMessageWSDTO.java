package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;


import com.faas.core.base.model.db.operation.details.channel.OperationPushMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;

import java.util.List;

public class ApiOperationPushMessageWSDTO {

    private ApiPushAccountWSDTO pushAccount;
    private List<OperationPushMessageDBModel>pushMessages;
    private List<ProcessPushTempDBModel>pushTemps;

    public ApiOperationPushMessageWSDTO() {
    }

    public ApiOperationPushMessageWSDTO(ApiPushAccountWSDTO pushAccount, List<OperationPushMessageDBModel> pushMessages, List<ProcessPushTempDBModel> pushTemps) {
        this.pushAccount = pushAccount;
        this.pushMessages = pushMessages;
        this.pushTemps = pushTemps;
    }

    public ApiPushAccountWSDTO getPushAccount() {
        return pushAccount;
    }

    public void setPushAccount(ApiPushAccountWSDTO pushAccount) {
        this.pushAccount = pushAccount;
    }

    public List<OperationPushMessageDBModel> getPushMessages() {
        return pushMessages;
    }

    public void setPushMessages(List<OperationPushMessageDBModel> pushMessages) {
        this.pushMessages = pushMessages;
    }

    public List<ProcessPushTempDBModel> getPushTemps() {
        return pushTemps;
    }

    public void setPushTemps(List<ProcessPushTempDBModel> pushTemps) {
        this.pushTemps = pushTemps;
    }
}
