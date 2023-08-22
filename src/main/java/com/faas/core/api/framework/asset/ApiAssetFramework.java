package com.faas.core.api.framework.asset;

import com.faas.core.api.model.ws.asset.dto.ApiAssetWSDTO;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiAssetFramework {


    @Autowired
    AppUtils appUtils;


    public List<ApiAssetWSDTO> apiGetAgentAssetsService(long agentId) {

        return null;
    }

    public ApiAssetWSDTO apiGetAgentAssetService(long agentId) {

        return null;
    }


    public List<ApiAssetWSDTO> apiGetCampaignAssetsService(long agentId) {

        return null;
    }

    public ApiAssetWSDTO apiGetCampaignAssetService(long agentId) {

        return null;
    }

}
