package com.faas.core.base.middleware.manager.app;

import com.faas.core.base.framework.manager.app.AppManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerCampaignWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerContentWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerOperationWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerCampaignWSDTO;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerOperationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AppManagerMiddleware {


    @Autowired
    AppManagerFramework appManagerFramework;


    public AppManagerContentWSModel getAppManagerContent(long userId, String category, int reqPage, int reqSize) {

        AppManagerContentWSModel response = new AppManagerContentWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AppManagerContentWSDTO appManagerContentWSDTO = appManagerFramework.getAppManagerContentService(userId,category,reqPage,reqSize);
        if (appManagerContentWSDTO != null){
            response.setAppManagerContent(appManagerContentWSDTO);
        }

        general.setOperation("getAppManagerContent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AppManagerCampaignWSModel getAppManagerCampaigns(long userId, String category) {

        AppManagerCampaignWSModel response = new AppManagerCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AppManagerCampaignWSDTO appManagerCampaignWSDTO = appManagerFramework.getAppManagerCampaignsService(userId,category);
        if (appManagerCampaignWSDTO != null){
            response.setAppManagerCampaign(appManagerCampaignWSDTO);
        }

        general.setOperation("getAppManagerCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AppManagerCampaignWSModel getAppManagerCampaign(long userId,String campaignId) {

        AppManagerCampaignWSModel response = new AppManagerCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AppManagerCampaignWSDTO appManagerCampaignWSDTO = appManagerFramework.getAppManagerCampaignService(userId,campaignId);
        if (appManagerCampaignWSDTO != null){
            response.setAppManagerCampaign(appManagerCampaignWSDTO);
        }

        general.setOperation("getAppManagerCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AppManagerOperationWSModel getAppManagerOperations(long userId,String category,int reqPage,int reqSize) {

        AppManagerOperationWSModel response = new AppManagerOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AppManagerOperationWSDTO appManagerOperationWSDTO = appManagerFramework.getAppManagerOperationsService(userId,category,reqPage,reqSize);
        if (appManagerOperationWSDTO != null){
            response.setAppManagerOperation(appManagerOperationWSDTO);
        }

        general.setOperation("getAppManagerOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AppManagerOperationWSModel getAppManagerOperationsByState(long userId,String category,String operationState,int reqPage,int reqSize) {

        AppManagerOperationWSModel response = new AppManagerOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AppManagerOperationWSDTO appManagerOperationWSDTO = appManagerFramework.getAppManagerOperationsByStateService(userId,category,operationState,reqPage,reqSize);
        if (appManagerOperationWSDTO != null){
            response.setAppManagerOperation(appManagerOperationWSDTO);
        }

        general.setOperation("getAppManagerOperationsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AppManagerOperationWSModel getAppManagerOperation(long userId,long sessionId) {

        AppManagerOperationWSModel response = new AppManagerOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AppManagerOperationWSDTO appManagerOperationWSDTO = appManagerFramework.getAppManagerOperationService(userId,sessionId);
        if (appManagerOperationWSDTO != null){
            response.setAppManagerOperation(appManagerOperationWSDTO);
        }

        general.setOperation("getAppManagerOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
