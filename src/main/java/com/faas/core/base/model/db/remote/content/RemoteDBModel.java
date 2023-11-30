package com.faas.core.base.model.db.remote.content;

import com.faas.core.base.model.db.remote.content.dao.RemoteDetails;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "remote_table")
public class RemoteDBModel {

    @Id
    private String id;
    private String remote;
    private String remoteDesc;
    private RemoteDetails remoteDetails;
    private long typeId;
    private String remoteType;
    private String baseType;
    private long uDate;
    private long cDate;
    private int status;

    public RemoteDBModel() {
    }

    public RemoteDBModel(String id, String remote, String remoteDesc, RemoteDetails remoteDetails, long typeId, String remoteType, String baseType, long uDate, long cDate, int status) {
        this.id = id;
        this.remote = remote;
        this.remoteDesc = remoteDesc;
        this.remoteDetails = remoteDetails;
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

    public RemoteDetails getRemoteDetails() {
        return remoteDetails;
    }

    public void setRemoteDetails(RemoteDetails remoteDetails) {
        this.remoteDetails = remoteDetails;
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
