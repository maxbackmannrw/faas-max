package com.faas.core.base.model.db.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempDataDAO;
import com.faas.core.base.model.db.process.details.channel.temp.dao.ProcessTempRemoteUrlDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_push_temp_table")
public class ProcessPushTempDBModel {

    @Id
    private String id;
    private String processId;
    private String pushHeader;
    private String pushBody;
    private String pushFooter;
    private String pushSender;
    private long typeId;
    private String pushType;
    private List<ProcessTempRemoteUrlDAO>remotes;
    private List<ProcessTempDataDAO>datas;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessPushTempDBModel() {
    }

    public ProcessPushTempDBModel(String id, String processId, String pushHeader, String pushBody, String pushFooter, String pushSender, long typeId, String pushType, List<ProcessTempRemoteUrlDAO> remotes, List<ProcessTempDataDAO> datas, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.pushHeader = pushHeader;
        this.pushBody = pushBody;
        this.pushFooter = pushFooter;
        this.pushSender = pushSender;
        this.typeId = typeId;
        this.pushType = pushType;
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

    public String getPushHeader() {
        return pushHeader;
    }

    public void setPushHeader(String pushHeader) {
        this.pushHeader = pushHeader;
    }

    public String getPushBody() {
        return pushBody;
    }

    public void setPushBody(String pushBody) {
        this.pushBody = pushBody;
    }

    public String getPushFooter() {
        return pushFooter;
    }

    public void setPushFooter(String pushFooter) {
        this.pushFooter = pushFooter;
    }

    public String getPushSender() {
        return pushSender;
    }

    public void setPushSender(String pushSender) {
        this.pushSender = pushSender;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
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
