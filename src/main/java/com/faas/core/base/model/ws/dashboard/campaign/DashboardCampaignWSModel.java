package com.faas.core.base.model.ws.dashboard.campaign;

import com.faas.core.base.model.ws.dashboard.campaign.dto.DashboardCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class DashboardCampaignWSModel {

    private GeneralWSModel general;
    private List<DashboardCampaignWSDTO> dashboardCampaigns;

    public DashboardCampaignWSModel() {
    }

    public DashboardCampaignWSModel(GeneralWSModel general, List<DashboardCampaignWSDTO> dashboardCampaigns) {
        this.general = general;
        this.dashboardCampaigns = dashboardCampaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<DashboardCampaignWSDTO> getDashboardCampaigns() {
        return dashboardCampaigns;
    }

    public void setDashboardCampaigns(List<DashboardCampaignWSDTO> dashboardCampaigns) {
        this.dashboardCampaigns = dashboardCampaigns;
    }
}
