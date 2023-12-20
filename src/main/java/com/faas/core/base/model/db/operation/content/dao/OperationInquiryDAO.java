package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;

public class OperationInquiryDAO {

    private String id;
    private String operationInquiry;
    private List<OperationDataDAO> inquiryDatas;
    private String inquiryState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationInquiryDAO() {
    }

    public OperationInquiryDAO(String id, String operationInquiry, List<OperationDataDAO> inquiryDatas, String inquiryState, long uDate, long cDate, int status) {
        this.id = id;
        this.operationInquiry = operationInquiry;
        this.inquiryDatas = inquiryDatas;
        this.inquiryState = inquiryState;
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

    public String getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(String operationInquiry) {
        this.operationInquiry = operationInquiry;
    }

    public List<OperationDataDAO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<OperationDataDAO> inquiryDatas) {
        this.inquiryDatas = inquiryDatas;
    }

    public String getInquiryState() {
        return inquiryState;
    }

    public void setInquiryState(String inquiryState) {
        this.inquiryState = inquiryState;
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
