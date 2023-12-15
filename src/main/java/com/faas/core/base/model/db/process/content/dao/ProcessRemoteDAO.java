package com.faas.core.base.model.db.process.content.dao;

import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.model.db.remote.content.dao.RemoteUrlDAO;

import java.util.List;

public class ProcessRemoteDAO {

    private String id;
    private String remoteId;
    private String remote;
    private String remoteDesc;
    private String remoteModel;
    private String remoteVersion;
    private List<RemoteDataDAO>remoteDatas;
    private List<RemoteUrlDAO>remoteUrls;
    private long typeId;
    private String remoteType;
    private String baseType;
    private String remoteState;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessRemoteDAO() {
    }

    public ProcessRemoteDAO(String id, String remoteId, String remote, String remoteDesc, String remoteModel, String remoteVersion, List<RemoteDataDAO> remoteDatas, List<RemoteUrlDAO> remoteUrls, long typeId, String remoteType, String baseType, String remoteState, long uDate, long cDate, int status) {
        this.id = id;
        this.remoteId = remoteId;
        this.remote = remote;
        this.remoteDesc = remoteDesc;
        this.remoteModel = remoteModel;
        this.remoteVersion = remoteVersion;
        this.remoteDatas = remoteDatas;
        this.remoteUrls = remoteUrls;
        this.typeId = typeId;
        this.remoteType = remoteType;
        this.baseType = baseType;
        this.remoteState = remoteState;
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

    public String getRemoteModel() {
        return remoteModel;
    }

    public void setRemoteModel(String remoteModel) {
        this.remoteModel = remoteModel;
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

    public String getRemoteState() {
        return remoteState;
    }

    public void setRemoteState(String remoteState) {
        this.remoteState = remoteState;
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
