package com.faas.core.data.ws.base.dashboard.campaign;

import com.faas.core.data.ws.base.dashboard.campaign.dto.DashboardCampaignWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
