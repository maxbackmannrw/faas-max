package com.faas.core.data.db.operation.details.activity;

import javax.persistence.*;

@Entity
@Table(name = "operation_activity_table")
public class OperationActivityDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "activity")
    private String activity;

    @Column(name = "activity_desc")
    private String activityDesc;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "object_id")
    private String objectId;

    @Column(name = "operation_id")
    private String operationId;

    @Column(name = "agent_id")
    private long agentId;

    @Column(name = "campaign_id")
    private String campaignId;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public OperationActivityDBModel() {
    }

    public OperationActivityDBModel(long id, String activity, String activityDesc, String activityType, String objectId, String operationId, long agentId, String campaignId, long uDate, long cDate, int status) {
        this.id = id;
        this.activity = activity;
        this.activityDesc = activityDesc;
        this.activityType = activityType;
        this.objectId = objectId;
        this.operationId = operationId;
        this.agentId = agentId;
        this.campaignId = campaignId;
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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
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
