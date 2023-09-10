package com.faas.core.base.model.db.process.details.inquiry;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "process_inquiry_table")
public class ProcessInquiryDBModel {

    @Id
    private String id;
    private String processId;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessInquiryDBModel() {
    }

    public ProcessInquiryDBModel(String id, String processId, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
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
