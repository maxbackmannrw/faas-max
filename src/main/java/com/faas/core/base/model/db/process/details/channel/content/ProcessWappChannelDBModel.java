package com.faas.core.base.model.db.process.details.channel.content;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "process_wapp_channel_table")
public class ProcessWappChannelDBModel {

    @Id
    private String id;
    private String processId;
    private String callStatus;
    private String messageStatus;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessWappChannelDBModel() {
    }

    public ProcessWappChannelDBModel(String id, String processId, String callStatus, String messageStatus, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.callStatus = callStatus;
        this.messageStatus = messageStatus;
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

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
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
