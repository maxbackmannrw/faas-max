package com.faas.core.api.model.ws.dashboard;

import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiDashboardCampaignWSModel {

    private GeneralWSModel general;
    private List<ApiDashboardCampaignWSDTO> dashboardCampaigns;

    public ApiDashboardCampaignWSModel() {
    }

    public ApiDashboardCampaignWSModel(GeneralWSModel general, List<ApiDashboardCampaignWSDTO> dashboardCampaigns) {
        this.general = general;
        this.dashboardCampaigns = dashboardCampaigns;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiDashboardCampaignWSDTO> getDashboardCampaigns() {
        return dashboardCampaigns;
    }

    public void setDashboardCampaigns(List<ApiDashboardCampaignWSDTO> dashboardCampaigns) {
        this.dashboardCampaigns = dashboardCampaigns;
    }
}
