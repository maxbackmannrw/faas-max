package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;

public class OperationFlowDAO {

    private String flowId;
    private String operationFlow;
    private List<OperationDataDAO> operationFlowDatas;
    private String operationFlowState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationFlowDAO() {
    }

    public OperationFlowDAO(String flowId, String operationFlow, List<OperationDataDAO> operationFlowDatas, String operationFlowState, long uDate, long cDate, int status) {
        this.flowId = flowId;
        this.operationFlow = operationFlow;
        this.operationFlowDatas = operationFlowDatas;
        this.operationFlowState = operationFlowState;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
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

    public String getOperationFlowState() {
        return operationFlowState;
    }

    public void setOperationFlowState(String operationFlowState) {
        this.operationFlowState = operationFlowState;
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
