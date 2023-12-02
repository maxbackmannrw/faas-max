package com.faas.core.base.model.db.remote.content;

import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "remote_table")
public class RemoteDBModel {

    @Id
    private String id;
    private String remote;
    private String remoteDesc;
    private String remoteUrl;
    private String remoteModel;
    private String remoteVersion;
    private List<RemoteDataDAO>datas;
    private long typeId;
    private String remoteType;
    private String baseType;
    private long uDate;
    private long cDate;
    private int status;

    public RemoteDBModel() {
    }

    public RemoteDBModel(String id, String remote, String remoteDesc, String remoteUrl, String remoteModel, String remoteVersion, List<RemoteDataDAO> datas, long typeId, String remoteType, String baseType, long uDate, long cDate, int status) {
        this.id = id;
        this.remote = remote;
        this.remoteDesc = remoteDesc;
        this.remoteUrl = remoteUrl;
        this.remoteModel = remoteModel;
        this.remoteVersion = remoteVersion;
        this.datas = datas;
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

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
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

    public List<RemoteDataDAO> getDatas() {
        return datas;
    }

    public void setDatas(List<RemoteDataDAO> datas) {
        this.datas = datas;
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
