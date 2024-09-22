package com.faas.core.data.db.operation.content.dao;

import java.util.List;

public class OperationInquiryDAO {

    private String inquiryId;
    private String operationInquiry;
    private List<OperationDataDAO> inquiryDatas;
    private long uDate;
    private int status;

    public OperationInquiryDAO() {
    }

    public OperationInquiryDAO(String inquiryId, String operationInquiry, List<OperationDataDAO> inquiryDatas, long uDate, int status) {
        this.inquiryId = inquiryId;
        this.operationInquiry = operationInquiry;
        this.inquiryDatas = inquiryDatas;
        this.uDate = uDate;
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

    public List<OperationDataDAO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<OperationDataDAO> inquiryDatas) {
        this.inquiryDatas = inquiryDatas;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
