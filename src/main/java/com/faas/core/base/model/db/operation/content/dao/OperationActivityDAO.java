package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;

public class OperationActivityDAO {

    private String id;
    private String activity;
    private String activityDesc;
    private String creatorId;
    private String creator;
    private String createdId;
    private String created;
    private List<OperationActivityDataDAO>activityDatas;
    private long cDate;
    private int status;

    public OperationActivityDAO() {
    }

    public OperationActivityDAO(String id, String activity, String activityDesc, String creatorId, String creator, String createdId, String created, List<OperationActivityDataDAO> activityDatas, long cDate, int status) {
        this.id = id;
        this.activity = activity;
        this.activityDesc = activityDesc;
        this.creatorId = creatorId;
        this.creator = creator;
        this.createdId = createdId;
        this.created = created;
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
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
