package com.faas.core.base.framework.campaign.details.asset;

import com.faas.core.base.model.db.campaign.content.dao.CampaignAssetDAO;
import com.faas.core.base.model.ws.campaign.details.assets.dto.CampaignAssetWSDTO;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CampaignAssetFramework {


    @Autowired
    AppUtils appUtils;

    public CampaignAssetWSDTO fillProcessAssetWSDTO(CampaignAssetDAO campaignAssetDAO) {

        CampaignAssetWSDTO campaignAssetWSDTO = new CampaignAssetWSDTO();
        campaignAssetWSDTO.setCampaignAsset(campaignAssetDAO);
        return campaignAssetWSDTO;
    }


}
