package com.faas.core.base.model.db.process.details.inquiry;

import com.faas.core.base.model.db.process.details.inquiry.dao.ProcessInquiryAssetDAO;
import com.faas.core.base.model.db.process.details.inquiry.dao.ProcessInquiryDataDAO;
import com.faas.core.base.model.db.process.details.inquiry.dao.ProcessInquiryUrlDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "process_inquiry_table")
public class ProcessInquiryDBModel {

    @Id
    private String id;
    private String processId;
    private List<ProcessInquiryUrlDAO>inquiryUrls;
    private List<ProcessInquiryDataDAO>inquiryDatas;
    private List<ProcessInquiryAssetDAO>inquiryAssets;
    private long uDate;
    private long cDate;
    private int status;

    public ProcessInquiryDBModel() {
    }

    public ProcessInquiryDBModel(String id, String processId, List<ProcessInquiryUrlDAO> inquiryUrls, List<ProcessInquiryDataDAO> inquiryDatas, List<ProcessInquiryAssetDAO> inquiryAssets, long uDate, long cDate, int status) {
        this.id = id;
        this.processId = processId;
        this.inquiryUrls = inquiryUrls;
        this.inquiryDatas = inquiryDatas;
        this.inquiryAssets = inquiryAssets;
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

    public List<ProcessInquiryUrlDAO> getInquiryUrls() {
        return inquiryUrls;
    }

    public void setInquiryUrls(List<ProcessInquiryUrlDAO> inquiryUrls) {
        this.inquiryUrls = inquiryUrls;
    }

    public List<ProcessInquiryDataDAO> getInquiryDatas() {
        return inquiryDatas;
    }

    public void setInquiryDatas(List<ProcessInquiryDataDAO> inquiryDatas) {
        this.inquiryDatas = inquiryDatas;
    }

    public List<ProcessInquiryAssetDAO> getInquiryAssets() {
        return inquiryAssets;
    }

    public void setInquiryAssets(List<ProcessInquiryAssetDAO> inquiryAssets) {
        this.inquiryAssets = inquiryAssets;
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
