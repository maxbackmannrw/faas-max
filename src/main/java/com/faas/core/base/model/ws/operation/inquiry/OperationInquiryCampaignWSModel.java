package com.faas.core.base.model.ws.operation.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquiryCampaignWSDTO;

import java.util.List;

public class OperationInquiryCampaignWSModel {

    private GeneralWSModel general;
    private List<OperationInquiryCampaignWSDTO>inquiryCampaigns;

    public OperationInquiryCampaignWSModel() {
    }

    public OperationInquiryCampaignWSModel(GeneralWSModel general, List<OperationInquiryCampaignWSDTO> inquiryCampaigns) {
        this.general = general;
        this.inquiryCampaigns = inquiryCampaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationInquiryCampaignWSDTO> getInquiryCampaigns() {
        return inquiryCampaigns;
    }

    public void setInquiryCampaigns(List<OperationInquiryCampaignWSDTO> inquiryCampaigns) {
        this.inquiryCampaigns = inquiryCampaigns;
    }
}
