package com.faas.core.base.framework.operation.inquiry;

import com.faas.core.base.model.ws.operation.content.dto.OperationCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class InquiryCampaignFramework {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<OperationCampaignWSDTO> getInquiryCampaignDetailsService(long userId) {

        return null;
    }

}
