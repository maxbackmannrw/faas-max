package com.faas.core.base.model.db.remote;

import com.faas.core.base.model.db.remote.dao.RemoteConnDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "remote_conn_table")
public class RemoteConnDBModel {

    @Id
    private String id;
    private long clientId;
    private long sessionId;
    private String operationId;
    private RemoteConnDAO remoteConn;
    private String connType;
    private String connState;
    private long uDate;
    private long cDate;
    private int status;

    public RemoteConnDBModel() {
    }

    public RemoteConnDBModel(String id, long clientId, long sessionId, String operationId, RemoteConnDAO remoteConn, String connType, String connState, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.operationId = operationId;
        this.remoteConn = remoteConn;
        this.connType = connType;
        this.connState = connState;
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

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public RemoteConnDAO getRemoteConn() {
        return remoteConn;
    }

    public void setRemoteConn(RemoteConnDAO remoteConn) {
        this.remoteConn = remoteConn;
    }

    public String getConnType() {
        return connType;
    }

    public void setConnType(String connType) {
        this.connType = connType;
    }

    public String getConnState() {
        return connState;
    }

    public void setConnState(String connState) {
        this.connState = connState;
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
