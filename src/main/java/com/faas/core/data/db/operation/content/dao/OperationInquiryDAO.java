package com.faas.core.data.db.operation.content.dao;

import java.util.List;

public class OperationInquiryDAO {

    private String inquiryId;
    private String operationInquiry;
    private List<OperationDataDAO> operationInquiryDatas;
    private String operationInquiryState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationInquiryDAO() {
    }

    public OperationInquiryDAO(String inquiryId, String operationInquiry, List<OperationDataDAO> operationInquiryDatas, String operationInquiryState, long uDate, long cDate, int status) {
        this.inquiryId = inquiryId;
        this.operationInquiry = operationInquiry;
        this.operationInquiryDatas = operationInquiryDatas;
        this.operationInquiryState = operationInquiryState;
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

    public String getOperationInquiry() {
        return operationInquiry;
    }

    public void setOperationInquiry(String operationInquiry) {
        this.operationInquiry = operationInquiry;
    }

    public List<OperationDataDAO> getOperationInquiryDatas() {
        return operationInquiryDatas;
    }

    public void setOperationInquiryDatas(List<OperationDataDAO> operationInquiryDatas) {
        this.operationInquiryDatas = operationInquiryDatas;
    }

    public String getOperationInquiryState() {
        return operationInquiryState;
    }

    public void setOperationInquiryState(String operationInquiryState) {
        this.operationInquiryState = operationInquiryState;
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
