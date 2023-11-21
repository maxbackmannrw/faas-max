package com.faas.core.base.middleware.operation.manual.content;

import com.faas.core.base.framework.operation.manual.content.ManualManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.manual.content.ManualManagerWSModel;
import com.faas.core.base.model.ws.operation.manual.content.ManualOperationListWSModel;
import com.faas.core.base.model.ws.operation.manual.content.ManualOperationWSModel;
import com.faas.core.base.model.ws.operation.manual.content.dto.ManualManagerWSDTO;
import com.faas.core.base.model.ws.operation.manual.content.dto.ManualOperationListWSDTO;
import com.faas.core.base.model.ws.operation.manual.content.dto.ManualOperationWSDTO;
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


    public ManualOperationListWSModel getManualOperations(long userId, String sessionState, int reqPage, int reqSize) {

        ManualOperationListWSModel response = new ManualOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ManualOperationListWSDTO operationListWSDTO = manualManagerFramework.getManualOperationsService(userId,sessionState,reqPage,reqSize);
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

    public ManualOperationWSModel getManualOperation(long userId, long sessionId) {

        ManualOperationWSModel response = new ManualOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ManualOperationWSDTO> manualOperationWSDTOS = new ArrayList<>();

        ManualOperationWSDTO manualOperationWSDTO = manualManagerFramework.getManualOperationService(userId,sessionId);
        if (manualOperationWSDTO != null){
            manualOperationWSDTOS.add(manualOperationWSDTO);
        }

        response.setManualOperations(manualOperationWSDTOS);
        general.setOperation("getManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ManualOperationWSModel createManualOperation(long userId,long clientId,long agentId,String campaignId) {

        ManualOperationWSModel response = new ManualOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ManualOperationWSDTO> manualOperationWSDTOS = new ArrayList<>();

        ManualOperationWSDTO manualOperationWSDTO = manualManagerFramework.createManualOperationService(userId,clientId,agentId,campaignId);
        if (manualOperationWSDTO != null){
            manualOperationWSDTOS.add(manualOperationWSDTO);
        }

        response.setManualOperations(manualOperationWSDTOS);
        general.setOperation("createManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ManualOperationWSModel updateManualOperation(long userId, long sessionId) {

        ManualOperationWSModel response = new ManualOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ManualOperationWSDTO> manualOperationWSDTOS = new ArrayList<>();

        ManualOperationWSDTO manualOperationWSDTO = manualManagerFramework.updateManualOperationService(userId,sessionId);
        if (manualOperationWSDTO != null){
            manualOperationWSDTOS.add(manualOperationWSDTO);
        }

        response.setManualOperations(manualOperationWSDTOS);
        general.setOperation("updateManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ManualOperationWSModel removeManualOperation(long userId, long sessionId) {

        ManualOperationWSModel response = new ManualOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ManualOperationWSDTO> manualOperationWSDTOS = new ArrayList<>();

        ManualOperationWSDTO manualOperationWSDTO = manualManagerFramework.removeManualOperationService(userId,sessionId);
        if (manualOperationWSDTO != null){
            manualOperationWSDTOS.add(manualOperationWSDTO);
        }

        response.setManualOperations(manualOperationWSDTOS);
        general.setOperation("removeManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
