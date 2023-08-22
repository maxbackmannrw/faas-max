package com.faas.core.base.framework.dashboard.campaign;

import com.faas.core.base.model.ws.client.content.dto.ClientsByStateWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DashCampaignFramework {

    @Autowired
    AppUtils appUtils;


    public ClientsByStateWSDTO getDashboardCampaignsService() {

        ClientsByStateWSDTO clientsByStateWSDTO = new ClientsByStateWSDTO();

        return clientsByStateWSDTO;
    }




}
