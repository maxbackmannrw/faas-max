package com.faas.core.base.framework.manager.operation.details;

import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class OperationManagerDetailsFramework {

    @Autowired
    ManagerHelper managerHelper;

    @Autowired
    AppUtils appUtils;


    public List<CampaignManagerWSDTO> getAutomaticOperationDetailsService(long userId) {

        return null;
    }



}
