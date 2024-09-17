package com.faas.core.base.framework.dashboard.campaign;

import com.faas.core.base.model.ws.client.content.dto.ClientListWSDTO;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DashCampaignFramework {

    @Autowired
    AppUtils appUtils;


    public ClientListWSDTO getDashboardCampaignsService() {

        ClientListWSDTO clientListWSDTO = new ClientListWSDTO();

        return clientListWSDTO;
    }


}
