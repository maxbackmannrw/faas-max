package com.faas.core.data.db.operation.content.dao;

import java.util.List;

public class OperationFlowDAO {

    private String flowId;
    private String operationFlow;
    private List<OperationDataDAO> flowDatas;
    private long uDate;
    private int status;

    public OperationFlowDAO() {
    }

    public OperationFlowDAO(String flowId, String operationFlow, List<OperationDataDAO> flowDatas, long uDate, int status) {
        this.flowId = flowId;
        this.operationFlow = operationFlow;
        this.flowDatas = flowDatas;
        this.uDate = uDate;
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

    public List<OperationDataDAO> getFlowDatas() {
        return flowDatas;
    }

    public void setFlowDatas(List<OperationDataDAO> flowDatas) {
        this.flowDatas = flowDatas;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
