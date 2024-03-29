package com.faas.core.base.model.db.process.details.channel.content;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "process_wapp_channel_table")
public class ProcessWappChannelDBModel {

    @Id
    private String id;
    private String processId;
    private String callState;
    private String messageState;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessWappChannelDBModel() {
    }

    public ProcessWappChannelDBModel(String id, String processId, String callState, String messageState, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.callState = callState;
        this.messageState = messageState;
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

    public String getCallState() {
        return callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
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
