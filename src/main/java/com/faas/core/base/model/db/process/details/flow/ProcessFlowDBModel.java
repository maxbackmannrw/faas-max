package com.faas.core.base.model.db.process.details.flow;

import com.faas.core.base.model.db.process.details.flow.dao.ProcessFlowAssetDAO;
import com.faas.core.base.model.db.process.details.flow.dao.ProcessFlowDataDAO;
import com.faas.core.base.model.db.process.details.flow.dao.ProcessFlowUrlDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_flow_table")
public class ProcessFlowDBModel {

    @Id
    private String id;
    private String processId;
    private String processFlow;
    private List<ProcessFlowUrlDAO>flowUrls;
    private List<ProcessFlowDataDAO>flowDatas;
    private List<ProcessFlowAssetDAO>flowAssets;
    private long flowTypeId;
    private String flowType;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessFlowDBModel() {
    }

    public ProcessFlowDBModel(String id, String processId, String processFlow, List<ProcessFlowUrlDAO> flowUrls, List<ProcessFlowDataDAO> flowDatas, List<ProcessFlowAssetDAO> flowAssets, long flowTypeId, String flowType, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.processFlow = processFlow;
        this.flowUrls = flowUrls;
        this.flowDatas = flowDatas;
        this.flowAssets = flowAssets;
        this.flowTypeId = flowTypeId;
        this.flowType = flowType;
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

    public List<ProcessFlowUrlDAO> getFlowUrls() {
        return flowUrls;
    }

    public void setFlowUrls(List<ProcessFlowUrlDAO> flowUrls) {
        this.flowUrls = flowUrls;
    }

    public List<ProcessFlowDataDAO> getFlowDatas() {
        return flowDatas;
    }

    public void setFlowDatas(List<ProcessFlowDataDAO> flowDatas) {
        this.flowDatas = flowDatas;
    }

    public List<ProcessFlowAssetDAO> getFlowAssets() {
        return flowAssets;
    }

    public void setFlowAssets(List<ProcessFlowAssetDAO> flowAssets) {
        this.flowAssets = flowAssets;
    }

    public long getFlowTypeId() {
        return flowTypeId;
    }

    public void setFlowTypeId(long flowTypeId) {
        this.flowTypeId = flowTypeId;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
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
