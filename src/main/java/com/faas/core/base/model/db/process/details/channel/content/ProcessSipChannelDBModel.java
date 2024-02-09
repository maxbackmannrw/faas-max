package com.faas.core.base.model.db.process.details.channel.content;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "process_sip_channel_table")
public class ProcessSipChannelDBModel {

    @Id
    private String id;
    private String processId;
    private String callerId;
    private String channelState;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessSipChannelDBModel() {
    }

    public ProcessSipChannelDBModel(String id, String processId, String callerId, String channelState, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.callerId = callerId;
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

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
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
