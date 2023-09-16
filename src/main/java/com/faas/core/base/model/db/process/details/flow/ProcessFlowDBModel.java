package com.faas.core.base.model.db.process.details.flow;

import com.faas.core.base.model.db.process.details.flow.dao.FlowDataDAO;
import com.faas.core.base.model.db.process.details.flow.dao.FlowUrlDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_flow_table")
public class ProcessFlowDBModel {

    @Id
    private String id;
    private String processId;
    private String processFlow;
    private String flowDesc;
    private List<FlowUrlDAO>flowUrls;
    private List<FlowDataDAO>flowDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessFlowDBModel() {
    }

    public ProcessFlowDBModel(String id, String processId, String processFlow, String flowDesc, List<FlowUrlDAO> flowUrls, List<FlowDataDAO> flowDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.processFlow = processFlow;
        this.flowDesc = flowDesc;
        this.flowUrls = flowUrls;
        this.flowDatas = flowDatas;
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcessFlow() {
        return processFlow;
    }

    public void setProcessFlow(String processFlow) {
        this.processFlow = processFlow;
    }

    public String getFlowDesc() {
        return flowDesc;
    }

    public void setFlowDesc(String flowDesc) {
        this.flowDesc = flowDesc;
    }

    public List<FlowUrlDAO> getFlowUrls() {
        return flowUrls;
    }

    public void setFlowUrls(List<FlowUrlDAO> flowUrls) {
        this.flowUrls = flowUrls;
    }

    public List<FlowDataDAO> getFlowDatas() {
        return flowDatas;
    }

    public void setFlowDatas(List<FlowDataDAO> flowDatas) {
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
