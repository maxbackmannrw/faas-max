package com.faas.core.api.model.ws.operation.channel.message.sms.dto;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;

import java.util.List;

public class ApiSmsMessageTempWSDTO {

    private ApiSmsAccountWSDTO smsAccount;
    private List<ClientPhoneDBModel> phones;
    private List<ProcessSmsMessageTempDBModel>smsTemps;

    public ApiSmsMessageTempWSDTO() {
    }

    public ApiSmsMessageTempWSDTO(ApiSmsAccountWSDTO smsAccount, List<ClientPhoneDBModel> phones, List<ProcessSmsMessageTempDBModel> smsTemps) {
        this.smsAccount = smsAccount;
        this.phones = phones;
        this.smsTemps = smsTemps;
    }

    public ApiSmsAccountWSDTO getSmsAccount() {
        return smsAccount;
    }

    public void setSmsAccount(ApiSmsAccountWSDTO smsAccount) {
        this.smsAccount = smsAccount;
    }

    public List<ClientPhoneDBModel> getPhones() {
        return phones;
    }

    public void setPhones(List<ClientPhoneDBModel> phones) {
        this.phones = phones;
    }

    public List<ProcessSmsMessageTempDBModel> getSmsTemps() {
        return smsTemps;
    }

    public void setSmsTemps(List<ProcessSmsMessageTempDBModel> smsTemps) {
        this.smsTemps = smsTemps;
    }
}
