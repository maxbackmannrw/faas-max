package com.faas.core.base.model.db.process.content;

import com.faas.core.base.model.db.process.content.dao.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_table")
public class ProcessDBModel {

    @Id
    private String id;
    private String process;
    private String processDesc;
    private long processTypeId;
    private String processType;
    private String processCategory;
    private List<ProcessUrlDAO>processUrls;
    private List<ProcessDataDAO>processDatas;
    private List<ProcessAssetDAO>processAssets;
    private List<ProcessScriptDAO>processScripts;
    private String processState;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessDBModel() {
    }

    public ProcessDBModel(String id, String process, String processDesc, long processTypeId, String processType, String processCategory, List<ProcessUrlDAO> processUrls, List<ProcessDataDAO> processDatas, List<ProcessAssetDAO> processAssets, List<ProcessScriptDAO> processScripts, String processState, long uDate, long cDate, int status) {
        this.id = id;
        this.process = process;
        this.processDesc = processDesc;
        this.processTypeId = processTypeId;
        this.processType = processType;
        this.processCategory = processCategory;
        this.processUrls = processUrls;
        this.processDatas = processDatas;
        this.processAssets = processAssets;
        this.processScripts = processScripts;
        this.processState = processState;
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

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getProcessDesc() {
        return processDesc;
    }

    public void setProcessDesc(String processDesc) {
        this.processDesc = processDesc;
    }

    public long getProcessTypeId() {
        return processTypeId;
    }

    public void setProcessTypeId(long processTypeId) {
        this.processTypeId = processTypeId;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getProcessCategory() {
        return processCategory;
    }

    public void setProcessCategory(String processCategory) {
        this.processCategory = processCategory;
    }

    public List<ProcessUrlDAO> getProcessUrls() {
        return processUrls;
    }

    public void setProcessUrls(List<ProcessUrlDAO> processUrls) {
        this.processUrls = processUrls;
    }

    public List<ProcessDataDAO> getProcessDatas() {
        return processDatas;
    }

    public void setProcessDatas(List<ProcessDataDAO> processDatas) {
        this.processDatas = processDatas;
    }

    public List<ProcessAssetDAO> getProcessAssets() {
        return processAssets;
    }

    public void setProcessAssets(List<ProcessAssetDAO> processAssets) {
        this.processAssets = processAssets;
    }

    public List<ProcessScriptDAO> getProcessScripts() {
        return processScripts;
    }

    public void setProcessScripts(List<ProcessScriptDAO> processScripts) {
        this.processScripts = processScripts;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
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
