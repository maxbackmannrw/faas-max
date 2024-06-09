package com.faas.core.base.middleware.manager.main;

import com.faas.core.base.framework.manager.main.MainManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.main.MainManagerCampaignWSModel;
import com.faas.core.base.model.ws.manager.main.MainManagerContentWSModel;
import com.faas.core.base.model.ws.manager.main.MainManagerOperationWSModel;
import com.faas.core.base.model.ws.manager.main.MainManagerWSModel;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerWSDTO;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.operation.manager.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class MainManagerMiddleware {


    @Autowired
    MainManagerFramework mainManagerFramework;


    public MainManagerWSModel getMainManager(long userId, int reqPage, int reqSize) {

        MainManagerWSModel response = new MainManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        MainManagerWSDTO mainManagerWSDTO = mainManagerFramework.getMainManagerService(userId,reqPage,reqSize);
        if (mainManagerWSDTO != null){
            response.setMainManager(mainManagerWSDTO);
        }

        general.setOperation("getAppManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public MainManagerContentWSModel getMainManagerContent(long userId, String category, int reqPage, int reqSize) {

        MainManagerContentWSModel response = new MainManagerContentWSModel();
        GeneralWSModel general = new GeneralWSModel();

        MainManagerContentWSDTO mainManagerContentWSDTO = mainManagerFramework.getMainManagerContentService(userId,category,reqPage,reqSize);
        if (mainManagerContentWSDTO != null){
            response.setMainManagerContent(mainManagerContentWSDTO);
        }

        general.setOperation("getAppManagerContent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public MainManagerCampaignWSModel getMainManagerCampaigns(long userId, String category) {

        MainManagerCampaignWSModel response = new MainManagerCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignManagerWSDTO>campaignManagerWSDTOS = mainManagerFramework.getMainManagerCampaignsService(userId,category);
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

    public MainManagerCampaignWSModel getMainManagerCampaign(long userId, String campaignId) {

        MainManagerCampaignWSModel response = new MainManagerCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignManagerWSDTO>campaignManagerWSDTOS = new ArrayList<>();

        CampaignManagerWSDTO campaignManagerWSDTO = mainManagerFramework.getMainManagerCampaignService(userId,campaignId);
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


    public MainManagerOperationWSModel getMainManagerOperations(long userId, String category, int reqPage, int reqSize) {

        MainManagerOperationWSModel response = new MainManagerOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationManagerWSDTO operationManagerWSDTO = mainManagerFramework.getMainManagerOperationsService(userId,category,reqPage,reqSize);
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

    public MainManagerOperationWSModel getMainManagerOperationsByState(long userId, String category, String operationState, int reqPage, int reqSize) {

        MainManagerOperationWSModel response = new MainManagerOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationManagerWSDTO operationManagerWSDTO = mainManagerFramework.getMainManagerOperationsByStateService(userId,category,operationState,reqPage,reqSize);
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

    public OperationWSModel getMainManagerOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = mainManagerFramework.getMainManagerOperationService(userId,sessionId);
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


    public OperationWSModel removeMainManagerOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = mainManagerFramework.removeMainManagerOperationService(userId,sessionId);
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
