package com.faas.core.base.model.db.process.details.channel.content;

import com.faas.core.base.model.db.process.details.channel.content.dao.ProcessEmailAccountDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "process_email_channel_table")
public class ProcessEmailChannelDBModel {

    @Id
    private String id;
    private String processId;
    private ProcessEmailAccountDAO emailAccount;
    private String channelState;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessEmailChannelDBModel() {
    }

    public ProcessEmailChannelDBModel(String id, String processId, ProcessEmailAccountDAO emailAccount, String channelState, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.emailAccount = emailAccount;
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

    public ProcessEmailAccountDAO getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(ProcessEmailAccountDAO emailAccount) {
        this.emailAccount = emailAccount;
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
