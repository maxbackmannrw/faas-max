package com.faas.core.data.db.operation.details.activity;

import javax.persistence.*;

@Entity
@Table(name = "operation_activity_table")
public class OperationActivityDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "operation_id")
    private String operationId;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "agent_id")
    private long agentId;

    @Column(name = "creator_id")
    private long creatorId;

    @Column(name = "outcome_id")
    private String outcomeId;

    @Column(name = "activity")
    private String activity;

    @Column(name = "activity_desc")
    private String activityDesc;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public OperationActivityDBModel() {
    }

    public OperationActivityDBModel(long id, String operationId, long clientId, long agentId, long creatorId, String outcomeId, String activity, String activityDesc, String activityType, long uDate, long cDate, int status) {
        this.id = id;
        this.operationId = operationId;
        this.clientId = clientId;
        this.agentId = agentId;
        this.creatorId = creatorId;
        this.outcomeId = outcomeId;
        this.activity = activity;
        this.activityDesc = activityDesc;
        this.activityType = activityType;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getOutcomeId() {
        return outcomeId;
    }

    public void setOutcomeId(String outcomeId) {
        this.outcomeId = outcomeId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
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
