package com.faas.core.api.middleware.asset;

import com.faas.core.api.framework.asset.ApiAssetFramework;
import com.faas.core.data.ws.api.asset.ApiAssetWSModel;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiAssetMiddleware {

    @Autowired
    ApiAssetFramework apiAssetFramework;

    @Autowired
    AppUtils appUtils;


    public ApiAssetWSModel apiGetAgentAssets(long agentId) {

        ApiAssetWSModel response = new ApiAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetAgentAssets");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiAssetWSModel apiGetAgentAsset(long agentId) {

        ApiAssetWSModel response = new ApiAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();

        general.setOperation("apiGetAgentAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiAssetWSModel apiGetCampaignAssets(long agentId) {

        ApiAssetWSModel response = new ApiAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();

        general.setOperation("apiGetCampaignAssets");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiAssetWSModel apiGetCampaignAsset(long agentId) {

        ApiAssetWSModel response = new ApiAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();

        general.setOperation("apiGetCampaignAsset");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
