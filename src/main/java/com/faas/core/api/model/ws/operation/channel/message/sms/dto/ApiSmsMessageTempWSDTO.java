package com.faas.core.api.model.ws.operation.channel.message.sms.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;

import java.util.List;

public class ApiSmsMessageTempWSDTO {

    private ApiSmsAccountWSDTO smsAccount;
    private List<ProcessSmsMessageTempDBModel>smsTemps;

    public ApiSmsMessageTempWSDTO() {
    }

    public ApiSmsMessageTempWSDTO(ApiSmsAccountWSDTO smsAccount, List<ProcessSmsMessageTempDBModel> smsTemps) {
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
