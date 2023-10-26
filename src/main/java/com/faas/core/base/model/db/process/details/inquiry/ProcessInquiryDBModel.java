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
    private String inquiryDesc;
    private List<InquiryDataDAO>inquiryDatas;
    private List<InquiryUrlDAO>inquiryUrls;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessInquiryDBModel() {
    }

    public ProcessInquiryDBModel(String id, String processId, String processInquiry, String inquiryDesc, List<InquiryDataDAO> inquiryDatas, List<InquiryUrlDAO> inquiryUrls, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.processInquiry = processInquiry;
        this.inquiryDesc = inquiryDesc;
        this.inquiryDatas = inquiryDatas;
        this.inquiryUrls = inquiryUrls;
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

    public String getInquiryDesc() {
        return inquiryDesc;
    }

    public void setInquiryDesc(String inquiryDesc) {
        this.inquiryDesc = inquiryDesc;
    }

    public List<InquiryDataDAO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<InquiryDataDAO> inquiryDatas) {
        this.inquiryDatas = inquiryDatas;
    }

    public List<InquiryUrlDAO> getInquiryUrls() {
        return inquiryUrls;
    }

    public void setInquiryUrls(List<InquiryUrlDAO> inquiryUrls) {
        this.inquiryUrls = inquiryUrls;
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
