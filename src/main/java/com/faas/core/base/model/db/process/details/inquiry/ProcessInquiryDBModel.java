package com.faas.core.base.model.db.process.details.inquiry;

import com.faas.core.base.model.db.process.details.inquiry.dao.InquiryDataDAO;
import com.faas.core.base.model.db.process.details.inquiry.dao.InquiryUrlDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_inquiry_table")
public class ProcessInquiryDBModel {

    @Id
    private String id;
    private String processId;
    private String processInquiry;
    private List<InquiryUrlDAO>inquiryUrls;
    private List<InquiryDataDAO>inquiryDatas;
    private String inquiryType;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessInquiryDBModel() {
    }

    public ProcessInquiryDBModel(String id, String processId, String processInquiry, List<InquiryUrlDAO> inquiryUrls, List<InquiryDataDAO> inquiryDatas, String inquiryType, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.processInquiry = processInquiry;
        this.inquiryUrls = inquiryUrls;
        this.inquiryDatas = inquiryDatas;
        this.inquiryType = inquiryType;
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

    public List<InquiryUrlDAO> getInquiryUrls() {
        return inquiryUrls;
    }

    public void setInquiryUrls(List<InquiryUrlDAO> inquiryUrls) {
        this.inquiryUrls = inquiryUrls;
    }

    public List<InquiryDataDAO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<InquiryDataDAO> inquiryDatas) {
        this.inquiryDatas = inquiryDatas;
    }

    public String getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(String inquiryType) {
        this.inquiryType = inquiryType;
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
