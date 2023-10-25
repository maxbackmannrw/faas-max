package com.faas.core.api.model.ws.operation.channel.message.push.dto;


import com.faas.core.base.model.db.operation.channel.OperationPushMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;

import java.util.List;

public class ApiOperationPushMessageWSDTO {

    private ApiPushAccountWSDTO pushAccount;
    private List<OperationPushMessageDBModel>pushMessages;
    private List<PushTempDBModel>pushTemps;

    public ApiOperationPushMessageWSDTO() {
    }

    public ApiOperationPushMessageWSDTO(ApiPushAccountWSDTO pushAccount, List<OperationPushMessageDBModel> pushMessages, List<PushTempDBModel> pushTemps) {
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

    public List<PushTempDBModel> getPushTemps() {
        return pushTemps;
    }

    public void setPushTemps(List<PushTempDBModel> pushTemps) {
        this.pushTemps = pushTemps;
    }
}
