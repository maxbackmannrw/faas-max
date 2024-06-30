package com.faas.core.base.model.ws.campaign.details.remote.dto;

import com.faas.core.base.model.db.campaign.details.remote.CampaignRemoteDBModel;
import com.faas.core.base.model.db.utils.UrlDBModel;

import java.util.List;

public class CampaignRemoteWSDTO {

    private CampaignRemoteDBModel campaignRemote;
    private List<UrlDBModel> remoteUrls;

    public CampaignRemoteWSDTO() {
    }

    public CampaignRemoteWSDTO(CampaignRemoteDBModel campaignRemote, List<UrlDBModel> remoteUrls) {
        this.campaignRemote = campaignRemote;
        this.remoteUrls = remoteUrls;
    }

    public CampaignRemoteDBModel getCampaignRemote() {
        return campaignRemote;
    }

    public void setCampaignRemote(CampaignRemoteDBModel campaignRemote) {
        this.campaignRemote = campaignRemote;
    }

    public List<UrlDBModel> getRemoteUrls() {
        return remoteUrls;
    }

    public void setRemoteUrls(List<UrlDBModel> remoteUrls) {
        this.remoteUrls = remoteUrls;
    }
}
