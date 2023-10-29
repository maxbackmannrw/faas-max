package com.faas.core.api.model.ws.operation.channel.message.sms.dto;

import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;

import java.util.List;

public class ApiOperationSmsMessageWSDTO {

    private ApiSmsAccountWSDTO smsAccount;
    private List<ClientPhoneDBModel>phones;
    private List<OperationSmsMessageDBModel>smsMessages;
    private List<SmsMessageTempDBModel>smsTemps;

    public ApiOperationSmsMessageWSDTO() {
    }

    public ApiOperationSmsMessageWSDTO(ApiSmsAccountWSDTO smsAccount, List<ClientPhoneDBModel> phones, List<OperationSmsMessageDBModel> smsMessages, List<SmsMessageTempDBModel> smsTemps) {
        this.smsAccount = smsAccount;
        this.phones = phones;
        this.smsMessages = smsMessages;
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

    public List<OperationSmsMessageDBModel> getSmsMessages() {
        return smsMessages;
    }

    public void setSmsMessages(List<OperationSmsMessageDBModel> smsMessages) {
        this.smsMessages = smsMessages;
    }

    public List<SmsMessageTempDBModel> getSmsTemps() {
        return smsTemps;
    }

    public void setSmsTemps(List<SmsMessageTempDBModel> smsTemps) {
        this.smsTemps = smsTemps;
    }
}
