package com.faas.core.base.model.ws.campaign.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.content.dto.CampaignDataWSDTO;

import java.util.List;

public class CampaignDataWSModel {

    private GeneralWSModel general;
    private List<CampaignDataWSDTO>campaignDatas;

    public CampaignDataWSModel() {
    }

    public CampaignDataWSModel(GeneralWSModel general, List<CampaignDataWSDTO> campaignDatas) {
        this.general = general;
        this.campaignDatas = campaignDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CampaignDataWSDTO> getCampaignDatas() {
        return campaignDatas;
    }

    public void setCampaignDatas(List<CampaignDataWSDTO> campaignDatas) {
        this.campaignDatas = campaignDatas;
    }
}
