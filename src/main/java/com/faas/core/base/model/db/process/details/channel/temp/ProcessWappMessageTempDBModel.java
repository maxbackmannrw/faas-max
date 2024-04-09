package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempDataDAO;
import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempRemoteUrlDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "process_wapp_message_temp_table")
public class ProcessWappMessageTempDBModel {

    @Id
    private String id;
    private String processId;
    private String wappTitle;
    private String wappBody;
    private long typeId;
    private String messageType;
    private List<ProcessTempRemoteUrlDAO>remotes;
    private List<ProcessTempDataDAO>datas;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessWappMessageTempDBModel() {
    }

    public ProcessWappMessageTempDBModel(String id, String processId, String wappTitle, String wappBody, long typeId, String messageType, List<ProcessTempRemoteUrlDAO> remotes, List<ProcessTempDataDAO> datas, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.wappTitle = wappTitle;
        this.wappBody = wappBody;
        this.typeId = typeId;
        this.messageType = messageType;
        this.remotes = remotes;
        this.datas = datas;
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

    public String getWappTitle() {
        return wappTitle;
    }

    public void setWappTitle(String wappTitle) {
        this.wappTitle = wappTitle;
    }

    public String getWappBody() {
        return wappBody;
    }

    public void setWappBody(String wappBody) {
        this.wappBody = wappBody;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public List<ProcessTempRemoteUrlDAO> getRemotes() {
        return remotes;
    }

    public void setRemotes(List<ProcessTempRemoteUrlDAO> remotes) {
        this.remotes = remotes;
    }

    public List<ProcessTempDataDAO> getDatas() {
        return datas;
    }

    public void setDatas(List<ProcessTempDataDAO> datas) {
        this.datas = datas;
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


