package com.faas.core.api.model.ws.operation.channel.push.dto;


import com.faas.core.base.model.db.operation.channel.PushMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;

import java.util.List;

public class ApiOperationPushMessageWSDTO {

    private ApiPushAccountWSDTO pushAccount;
    private List<PushMessageDBModel>pushMessages;
    private List<PushTempDBModel>pushTemps;

    public ApiOperationPushMessageWSDTO() {
    }

    public ApiOperationPushMessageWSDTO(ApiPushAccountWSDTO pushAccount, List<PushMessageDBModel> pushMessages, List<PushTempDBModel> pushTemps) {
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

    public List<PushMessageDBModel> getPushMessages() {
        return pushMessages;
    }

    public void setPushMessages(List<PushMessageDBModel> pushMessages) {
        this.pushMessages = pushMessages;
    }

    public List<PushTempDBModel> getPushTemps() {
        return pushTemps;
    }

    public void setPushTemps(List<PushTempDBModel> pushTemps) {
        this.pushTemps = pushTemps;
    }
}
