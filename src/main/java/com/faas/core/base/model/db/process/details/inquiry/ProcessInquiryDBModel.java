package com.faas.core.base.model.db.process.details.inquiry;

import com.faas.core.base.model.db.process.content.dao.ProcessRemoteDAO;
import com.faas.core.base.model.db.process.details.inquiry.dao.ProcessInquiryDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_inquiry_table")
public class ProcessInquiryDBModel {

    @Id
    private String id;
    private String processId;
    private String processInquiry;
    private List<ProcessRemoteDAO>inquiryRemotes;
    private List<ProcessInquiryDataDAO>inquiryDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessInquiryDBModel() {
    }

    public ProcessInquiryDBModel(String id, String processId, String processInquiry, List<ProcessRemoteDAO> inquiryRemotes, List<ProcessInquiryDataDAO> inquiryDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.processInquiry = processInquiry;
        this.inquiryRemotes = inquiryRemotes;
        this.inquiryDatas = inquiryDatas;
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

    public String getProcessInquiry() {
        return processInquiry;
    }

    public void setProcessInquiry(String processInquiry) {
        this.processInquiry = processInquiry;
    }

    public List<ProcessRemoteDAO> getInquiryRemotes() {
        return inquiryRemotes;
    }

    public void setInquiryRemotes(List<ProcessRemoteDAO> inquiryRemotes) {
        this.inquiryRemotes = inquiryRemotes;
    }

    public List<ProcessInquiryDataDAO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<ProcessInquiryDataDAO> inquiryDatas) {
        this.inquiryDatas = inquiryDatas;
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
