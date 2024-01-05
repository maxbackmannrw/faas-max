package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;

public class OperationInquiryDAO {

    private String id;
    private String operationInquiry;
    private List<OperationDataDAO> operationInquiryDatas;
    private long uDate;
    private long cDate;
    private int status;

    public OperationInquiryDAO() {
    }

    public OperationInquiryDAO(String id, String operationInquiry, List<OperationDataDAO> operationInquiryDatas, long uDate, long cDate, int status) {
        this.id = id;
        this.operationInquiry = operationInquiry;
        this.operationInquiryDatas = operationInquiryDatas;
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

    public List<OperationDataDAO> getOperationInquiryDatas() {
        return operationInquiryDatas;
    }

    public void setOperationInquiryDatas(List<OperationDataDAO> operationInquiryDatas) {
        this.operationInquiryDatas = operationInquiryDatas;
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
