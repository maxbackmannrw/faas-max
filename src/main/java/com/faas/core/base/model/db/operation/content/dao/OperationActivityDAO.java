package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;

public class OperationActivityDAO {

    private String id;
    private long sessionId;
    private String operationId;
    private String activity;
    private String activityDesc;
    private String activityType;
    private String creatorId;
    private String creatorName;
    private String creatorType;
    private String createdId;
    private String createdName;
    private String createdType;
    private List<OperationActivityDataDAO>activityDatas;
    private long cDate;
    private int status;

    public OperationActivityDAO() {
    }

    public OperationActivityDAO(String id, long sessionId, String operationId, String activity, String activityDesc, String activityType, String creatorId, String creatorName, String creatorType, String createdId, String createdName, String createdType, List<OperationActivityDataDAO> activityDatas, long cDate, int status) {
        this.id = id;
        this.sessionId = sessionId;
        this.operationId = operationId;
        this.activity = activity;
        this.activityDesc = activityDesc;
        this.activityType = activityType;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.creatorType = creatorType;
        this.createdId = createdId;
        this.createdName = createdName;
        this.createdType = createdType;
        this.activityDatas = activityDatas;
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorType() {
        return creatorType;
    }

    public void setCreatorType(String creatorType) {
        this.creatorType = creatorType;
    }

    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getCreatedType() {
        return createdType;
    }

    public void setCreatedType(String createdType) {
        this.createdType = createdType;
    }

    public List<OperationActivityDataDAO> getActivityDatas() {
        return activityDatas;
    }

    public void setActivityDatas(List<OperationActivityDataDAO> activityDatas) {
        this.activityDatas = activityDatas;
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
