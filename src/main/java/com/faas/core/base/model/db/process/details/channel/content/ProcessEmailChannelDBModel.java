package com.faas.core.base.model.db.process.details.channel.content;

import com.faas.core.base.model.db.process.details.channel.content.dao.EmailAccountDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "process_email_channel_table")
public class ProcessEmailChannelDBModel {

    @Id
    private String id;
    private String processId;
    private String accountId;
    private EmailAccountDAO emailAccount;
    private String emailStatus;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessEmailChannelDBModel() {
    }

    public ProcessEmailChannelDBModel(String id, String processId, String accountId, EmailAccountDAO emailAccount, String emailStatus, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.accountId = accountId;
        this.emailAccount = emailAccount;
        this.emailStatus = emailStatus;
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

    public EmailAccountDAO getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(EmailAccountDAO emailAccount) {
        this.emailAccount = emailAccount;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
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
