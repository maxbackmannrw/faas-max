package com.faas.core.base.model.db.process.details.channel.content;

import com.faas.core.base.model.db.process.details.channel.content.dao.ProcessSmsAccountDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "process_sms_channel_table")
public class ProcessSmsChannelDBModel {

    @Id
    private String id;
    private String processId;
    private String accountId;
    private ProcessSmsAccountDAO smsAccount;
    private String channelState;
    private long uDate;
    private long cDate;
    private int status;


    public ProcessSmsChannelDBModel() {
    }

    public ProcessSmsChannelDBModel(String id, String processId, String accountId, ProcessSmsAccountDAO smsAccount, String channelState, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.accountId = accountId;
        this.smsAccount = smsAccount;
        this.channelState = channelState;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public ProcessSmsAccountDAO getSmsAccount() {
        return smsAccount;
    }

    public void setSmsAccount(ProcessSmsAccountDAO smsAccount) {
        this.smsAccount = smsAccount;
    }

    public String getChannelState() {
        return channelState;
    }

    public void setChannelState(String channelState) {
        this.channelState = channelState;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
