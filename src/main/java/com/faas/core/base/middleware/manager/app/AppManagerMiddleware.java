package com.faas.core.base.middleware.manager.app;

import com.faas.core.base.framework.manager.app.AppManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerCampaignWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerContentWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerOperationWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerWSDTO;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.manager.operation.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AppManagerMiddleware {


    @Autowired
    AppManagerFramework appManagerFramework;


    public AppManagerWSModel getAppManager(long userId, int reqPage, int reqSize) {

        AppManagerWSModel response = new AppManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AppManagerWSDTO appManagerWSDTO = appManagerFramework.getAppManagerService(userId,reqPage,reqSize);
        if (appManagerWSDTO != null){
            response.setAppManager(appManagerWSDTO);
        }

        general.setOperation("getAppManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AppManagerContentWSModel getAppManagerContent(long userId,String category,int reqPage,int reqSize) {

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

        List<CampaignManagerWSDTO>campaignManagerWSDTOS = appManagerFramework.getAppManagerCampaignsService(userId,category);
        if (campaignManagerWSDTOS != null){
            response.setCampaignManagers(campaignManagerWSDTOS);
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
        List<CampaignManagerWSDTO>campaignManagerWSDTOS = new ArrayList<>();

        CampaignManagerWSDTO campaignManagerWSDTO = appManagerFramework.getAppManagerCampaignService(userId,campaignId);
        if (campaignManagerWSDTO != null){
            campaignManagerWSDTOS.add(campaignManagerWSDTO);
        }

        response.setCampaignManagers(campaignManagerWSDTOS);
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

        OperationManagerWSDTO operationManagerWSDTO = appManagerFramework.getAppManagerOperationsService(userId,category,reqPage,reqSize);
        if (operationManagerWSDTO != null){
            response.setOperationManager(operationManagerWSDTO);
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

        OperationManagerWSDTO operationManagerWSDTO = appManagerFramework.getAppManagerOperationsByStateService(userId,category,operationState,reqPage,reqSize);
        if (operationManagerWSDTO != null){
            response.setOperationManager(operationManagerWSDTO);
        }

        general.setOperation("getAppManagerOperationsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel getAppManagerOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = appManagerFramework.getAppManagerOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("getAppManagerOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel removeAppManagerOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = appManagerFramework.removeAppManagerOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("getAppManagerOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    

}
