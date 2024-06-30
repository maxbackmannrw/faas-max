package com.faas.core.base.middleware.campaign.details.operation;

import com.faas.core.base.framework.campaign.details.operation.CampaignOperationFramework;
import com.faas.core.base.model.ws.campaign.details.operation.CampaignOperationRequest;
import com.faas.core.base.model.ws.campaign.details.operation.CampaignOperationWSModel;
import com.faas.core.base.model.ws.campaign.details.operation.dto.CampaignOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignOperationMiddleware {

    @Autowired
    CampaignOperationFramework campaignOperationFramework;


    public CampaignOperationWSModel searchCampaignOperations(long userId, String campaignId,String city,String country,int reqPage,int reqSize) {

        CampaignOperationWSModel response = new CampaignOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignOperationWSDTO campaignOperationWSDTO = campaignOperationFramework.searchCampaignOperationsService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignOperationWSDTO != null){
            response.setCampaignOperation(campaignOperationWSDTO);
        }

        general.setOperation("searchCampaignOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignOperationWSModel getCampaignOperations(long userId, String campaignId, int reqPage, int reqSize) {

        CampaignOperationWSModel response = new CampaignOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignOperationWSDTO campaignOperationWSDTO = campaignOperationFramework.getCampaignOperationsService(userId,campaignId,reqPage,reqSize);
        if (campaignOperationWSDTO != null){
            response.setCampaignOperation(campaignOperationWSDTO);
        }

        general.setOperation("getCampaignOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel getCampaignOperation(long userId,long sessionId,String campaignId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = campaignOperationFramework.getCampaignOperationService(userId,sessionId,campaignId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("getCampaignOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel createCampaignOperation(CampaignOperationRequest operationRequest) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationWSDTO> operationWSDTOS = campaignOperationFramework.createCampaignOperationService(operationRequest);
        if (operationWSDTOS != null){
            response.setOperations(operationWSDTOS);
        }

        general.setOperation("createCampaignOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel updateCampaignOperation(long userId,long sessionId,long agentId,String operationState) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = campaignOperationFramework.updateCampaignOperationService(userId,sessionId,agentId,operationState);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("updateCampaignOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel removeCampaignOperation(long userId,long sessionId,String campaignId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO>operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = campaignOperationFramework.removeCampaignOperationService(userId,sessionId,campaignId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("removeCampaignOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
