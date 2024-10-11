package com.faas.core.data.db.utilz;

import javax.persistence.*;

@Entity
@Table(name = "activity_table")
public class ActivityDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "operation_id")
    private String operationId;

    @Column(name = "activity")
    private String activity;

    @Column(name = "activity_desc")
    private String activityDesc;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "object_id")
    private String objectId;

    @Column(name = "agent_id")
    private long agentId;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public ActivityDBModel() {
    }

    public ActivityDBModel(long id, String operationId, String activity, String activityDesc, String activityType, String objectId, long agentId, long uDate, long cDate, int status) {
        this.id = id;
        this.operationId = operationId;
        this.activity = activity;
        this.activityDesc = activityDesc;
        this.activityType = activityType;
        this.objectId = objectId;
        this.agentId = agentId;
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

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
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
