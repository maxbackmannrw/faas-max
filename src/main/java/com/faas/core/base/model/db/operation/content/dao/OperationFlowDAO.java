package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;

public class OperationFlowDAO {

    private String id;
    private String operationFlow;
    private List<OperationDataDAO> flowDatas;
    private String flowState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationFlowDAO() {
    }

    public OperationFlowDAO(String id, String operationFlow, List<OperationDataDAO> flowDatas, String flowState, long uDate, long cDate, int status) {
        this.id = id;
        this.operationFlow = operationFlow;
        this.flowDatas = flowDatas;
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

    public String getOperationFlow() {
        return operationFlow;
    }

    public void setOperationFlow(String operationFlow) {
        this.operationFlow = operationFlow;
    }

    public List<OperationDataDAO> getFlowDatas() {
        return flowDatas;
    }

    public void setFlowDatas(List<OperationDataDAO> flowDatas) {
        this.flowDatas = flowDatas;
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
