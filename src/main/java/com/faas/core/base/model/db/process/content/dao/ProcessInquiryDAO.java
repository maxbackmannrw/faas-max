package com.faas.core.base.model.db.process.content.dao;


import java.util.List;

public class ProcessInquiryDAO {

    private String inquiryId;
    private String processInquiry;
    private List<ProcessDataDAO>inquiryDatas;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessInquiryDAO() {
    }

    public ProcessInquiryDAO(String inquiryId, String processInquiry, List<ProcessDataDAO> inquiryDatas, long uDate, long cDate, int status) {
        this.inquiryId = inquiryId;
        this.processInquiry = processInquiry;
        this.inquiryDatas = inquiryDatas;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getProcessInquiry() {
        return processInquiry;
    }

    public void setProcessInquiry(String processInquiry) {
        this.processInquiry = processInquiry;
    }

    public List<ProcessDataDAO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<ProcessDataDAO> inquiryDatas) {
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
