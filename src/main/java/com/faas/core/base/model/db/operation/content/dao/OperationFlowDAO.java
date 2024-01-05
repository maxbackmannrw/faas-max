package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;

public class OperationFlowDAO {

    private String id;
    private String operationFlow;
    private List<OperationDataDAO> operationFlowDatas;
    private long uDate;
    private long cDate;
    private int status;

    public OperationFlowDAO() {
    }

    public OperationFlowDAO(String id, String operationFlow, List<OperationDataDAO> operationFlowDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.operationFlow = operationFlow;
        this.operationFlowDatas = operationFlowDatas;
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

    public String getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(String operationFlow) {
        this.operationFlow = operationFlow;
    }

    public List<OperationDataDAO> getOperationFlowDatas() {
        return operationFlowDatas;
    }

    public void setOperationFlowDatas(List<OperationDataDAO> operationFlowDatas) {
        this.operationFlowDatas = operationFlowDatas;
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
