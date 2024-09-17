package com.faas.core.base.model.ws.campaign.details.remote.dto;

import com.faas.core.data.db.campaign.details.remote.CampaignRemoteDBModel;
import com.faas.core.data.db.remote.details.RemoteUrlDBModel;

import java.util.List;

public class CampaignRemoteWSDTO {

    private CampaignRemoteDBModel campaignRemote;
    private List<RemoteUrlDBModel> remoteUrls;

    public CampaignRemoteWSDTO() {
    }

    public CampaignRemoteWSDTO(CampaignRemoteDBModel campaignRemote, List<RemoteUrlDBModel> remoteUrls) {
        this.campaignRemote = campaignRemote;
        this.remoteUrls = remoteUrls;
    }

    public CampaignRemoteDBModel getCampaignRemote() {
        return campaignRemote;
    }

    public void setCampaignRemote(CampaignRemoteDBModel campaignRemote) {
        this.campaignRemote = campaignRemote;
    }

    public List<RemoteUrlDBModel> getRemoteUrls() {
        return remoteUrls;
    }

    public void setRemoteUrls(List<RemoteUrlDBModel> remoteUrls) {
        this.remoteUrls = remoteUrls;
    }
}
