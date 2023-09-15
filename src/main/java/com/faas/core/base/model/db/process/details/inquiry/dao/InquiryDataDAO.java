package com.faas.core.base.model.db.process.details.inquiry.dao;

public class InquiryDataDAO {

    private String dataId;
    private String dataType;
    private String value;
    private long cDate;
    private int status;

    public InquiryDataDAO() {
    }

    public InquiryDataDAO(String dataId, String dataType, String value, long cDate, int status) {
        this.dataId = dataId;
        this.dataType = dataType;
        this.value = value;
        this.cDate = cDate;
        this.status = status;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
