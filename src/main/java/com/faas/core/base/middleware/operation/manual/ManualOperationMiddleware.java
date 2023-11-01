package com.faas.core.base.middleware.operation.manual;

import com.faas.core.base.framework.operation.manual.ManualOperationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.inquiry.InquiryOperationWSModel;
import com.faas.core.base.model.ws.operation.inquiry.dto.InquiryOperationWSDTO;
import com.faas.core.base.model.ws.operation.manual.ManualOperationListWSModel;
import com.faas.core.base.model.ws.operation.manual.ManualOperationWSModel;
import com.faas.core.base.model.ws.operation.manual.dto.ManualOperationListWSDTO;
import com.faas.core.base.model.ws.operation.manual.dto.ManualOperationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ManualOperationMiddleware {


    @Autowired
    ManualOperationFramework manualOperationFramework;


    public ManualOperationListWSModel getManualOperations(long userId, String sessionState, int reqPage, int reqSize) {

        ManualOperationListWSModel response = new ManualOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ManualOperationListWSDTO operationListWSDTO = manualOperationFramework.getManualOperationsService(userId,sessionState,reqPage,reqSize);
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

        ManualOperationWSDTO manualOperationWSDTO = manualOperationFramework.getManualOperationService(userId,sessionId);
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

        ManualOperationWSDTO manualOperationWSDTO = manualOperationFramework.createManualOperationService(userId,clientId,agentId,campaignId);
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

        ManualOperationWSDTO manualOperationWSDTO = manualOperationFramework.updateManualOperationService(userId,sessionId);
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

        ManualOperationWSDTO manualOperationWSDTO = manualOperationFramework.removeManualOperationService(userId,sessionId);
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
