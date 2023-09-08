package com.faas.core.base.model.db.client.flow;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "flow_table")
public class FlowDBModel {

    @Id
    private String id;
    private long sessionId;

    private String flowState;
    private long uDate;
    private long cDate;
    private int status;

    public FlowDBModel() {
    }

    public FlowDBModel(String id, long sessionId, String flowState, long uDate, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.flowState = flowState;
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

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getFlowState() {
        return flowState;
    }

    public void setFlowState(String flowState) {
        this.flowState = flowState;
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
