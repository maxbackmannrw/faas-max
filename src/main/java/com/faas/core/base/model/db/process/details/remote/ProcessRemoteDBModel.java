package com.faas.core.base.model.db.process.details.remote;

import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.model.db.remote.content.dao.RemoteUrlDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_remote_table")
public class ProcessRemoteDBModel {

    @Id
    private String id;
    private String processId;
    private String process;
    private String remoteId;
    private String remote;
    private String remoteDesc;
    private String remoteVersion;
    private List<RemoteDataDAO> remoteDatas;
    private List<RemoteUrlDAO>remoteUrls;
    private String remoteCategory;
    private long typeId;
    private String remoteType;
    private String baseType;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessRemoteDBModel() {
    }

    public ProcessRemoteDBModel(String id, String processId, String process, String remoteId, String remote, String remoteDesc, String remoteVersion, List<RemoteDataDAO> remoteDatas, List<RemoteUrlDAO> remoteUrls, String remoteCategory, long typeId, String remoteType, String baseType, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.process = process;
        this.remoteId = remoteId;
        this.remote = remote;
        this.remoteDesc = remoteDesc;
        this.remoteVersion = remoteVersion;
        this.remoteDatas = remoteDatas;
        this.remoteUrls = remoteUrls;
        this.remoteCategory = remoteCategory;
        this.typeId = typeId;
        this.remoteType = remoteType;
        this.baseType = baseType;
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

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public String getRemoteDesc() {
        return remoteDesc;
    }

    public void setRemoteDesc(String remoteDesc) {
        this.remoteDesc = remoteDesc;
    }

    public String getRemoteVersion() {
        return remoteVersion;
    }

    public void setRemoteVersion(String remoteVersion) {
        this.remoteVersion = remoteVersion;
    }

    public List<RemoteDataDAO> getRemoteDatas() {
        return remoteDatas;
    }

    public void setRemoteDatas(List<RemoteDataDAO> remoteDatas) {
        this.remoteDatas = remoteDatas;
    }

    public List<RemoteUrlDAO> getRemoteUrls() {
        return remoteUrls;
    }

    public void setRemoteUrls(List<RemoteUrlDAO> remoteUrls) {
        this.remoteUrls = remoteUrls;
    }

    public String getRemoteCategory() {
        return remoteCategory;
    }

    public void setRemoteCategory(String remoteCategory) {
        this.remoteCategory = remoteCategory;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getRemoteType() {
        return remoteType;
    }

    public void setRemoteType(String remoteType) {
        this.remoteType = remoteType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
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
