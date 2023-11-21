package com.faas.core.base.middleware.operation.manual.content;

import com.faas.core.base.framework.operation.manual.content.ManualManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationCampaignWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.model.ws.operation.manual.content.ManualManagerWSModel;
import com.faas.core.base.model.ws.operation.manual.content.dto.ManualManagerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ManualManagerMiddleware {


    @Autowired
    ManualManagerFramework manualManagerFramework;


    public ManualManagerWSModel getManualManager(long userId, int reqPage, int reqSize) {

        ManualManagerWSModel response = new ManualManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ManualManagerWSDTO manualManagerWSDTO = manualManagerFramework.getManualManagerService(userId,reqPage,reqSize);
        if (manualManagerWSDTO != null){
            response.setManualManager(manualManagerWSDTO);
        }

        general.setOperation("getManualManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationListWSModel getManualOperations(long userId, String sessionState, int reqPage, int reqSize) {

        OperationListWSModel response = new OperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationListWSDTO operationListWSDTO = manualManagerFramework.getManualOperationsService(userId,sessionState,reqPage,reqSize);
        if (operationListWSDTO != null){
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("getManualOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel getManualOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = manualManagerFramework.getManualOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("getManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel createManualOperation(long userId,long clientId,long agentId,String campaignId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = manualManagerFramework.createManualOperationService(userId,clientId,agentId,campaignId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("createManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel updateManualOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = manualManagerFramework.updateManualOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("updateManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel removeManualOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = manualManagerFramework.removeManualOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("removeManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationCampaignWSModel getManualCampaigns(long userId) {

        OperationCampaignWSModel response = new OperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationCampaignWSDTO> operationCampaignWSDTOS = manualManagerFramework.getManualCampaignsService(userId);
        if (operationCampaignWSDTOS != null){
            response.setCampaigns(operationCampaignWSDTOS);
        }

        general.setOperation("getManualCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationCampaignWSModel getManualCampaign(long userId,String campaignId) {

        OperationCampaignWSModel response = new OperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationCampaignWSDTO> operationCampaignWSDTOS = new ArrayList<>();

        OperationCampaignWSDTO operationCampaignWSDTO = manualManagerFramework.getManualCampaignService(userId,campaignId);
        if (operationCampaignWSDTO != null){
            operationCampaignWSDTOS.add(operationCampaignWSDTO);
        }

        response.setCampaigns(operationCampaignWSDTOS);
        general.setOperation("getManualCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
