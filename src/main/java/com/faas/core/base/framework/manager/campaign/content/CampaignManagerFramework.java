package com.faas.core.base.framework.manager.campaign.content;

import com.faas.core.base.model.ws.manager.operation.details.automatic.dto.AutomaticManagerWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignManagerFramework {


    @Autowired
    AppUtils appUtils;


    public AutomaticManagerWSDTO getAutomaticManagerService(long userId, int reqPage, int reqSize) {

        AutomaticManagerWSDTO automaticManagerWSDTO = new AutomaticManagerWSDTO();
        return automaticManagerWSDTO;
    }



}
