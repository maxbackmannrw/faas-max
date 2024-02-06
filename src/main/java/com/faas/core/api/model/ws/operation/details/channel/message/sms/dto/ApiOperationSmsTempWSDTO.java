package com.faas.core.api.model.ws.operation.details.channel.message.sms.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;

import java.util.List;

public class ApiOperationSmsTempWSDTO {

    private ApiSmsAccountWSDTO smsAccount;
    private List<ProcessSmsMessageTempDBModel>smsTemps;

    public ApiOperationSmsTempWSDTO() {
    }

    public ApiOperationSmsTempWSDTO(ApiSmsAccountWSDTO smsAccount, List<ProcessSmsMessageTempDBModel> smsTemps) {
        this.smsAccount = smsAccount;
        this.smsTemps = smsTemps;
    }

    public ApiSmsAccountWSDTO getSmsAccount() {
        return smsAccount;
    }

    public void setSmsAccount(ApiSmsAccountWSDTO smsAccount) {
        this.smsAccount = smsAccount;
    }

    public List<ProcessSmsMessageTempDBModel> getSmsTemps() {
        return smsTemps;
    }

    public void setSmsTemps(List<ProcessSmsMessageTempDBModel> smsTemps) {
        this.smsTemps = smsTemps;
    }
}