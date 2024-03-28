package com.faas.core.base.model.db.process.content.dao;

import java.util.List;

public class ProcessFlowDAO {

    private String flowId;
    private String processFlow;
    private List<ProcessDataDAO>flowDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessFlowDAO() {
    }

    public ProcessFlowDAO(String flowId, String processFlow, List<ProcessDataDAO> flowDatas, long uDate, long cDate, int status) {
        this.flowId = flowId;
        this.processFlow = processFlow;
        this.flowDatas = flowDatas;
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

    public String getProcessFlow() {
        return processFlow;
    }

    public void setProcessFlow(String processFlow) {
        this.processFlow = processFlow;
    }

    public List<ProcessDataDAO> getFlowDatas() {
        return flowDatas;
    }

    public void setFlowDatas(List<ProcessDataDAO> flowDatas) {
        this.flowDatas = flowDatas;
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
