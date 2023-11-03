package com.faas.core.base.middleware.manager.automatic.operation;

import com.faas.core.base.framework.manager.automatic.operation.AutomaticOperationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.automatic.operation.AutomaticOperationListWSModel;
import com.faas.core.base.model.ws.manager.automatic.operation.AutomaticOperationWSModel;
import com.faas.core.base.model.ws.manager.automatic.operation.dto.AutomaticOperationListWSDTO;
import com.faas.core.base.model.ws.manager.automatic.operation.dto.AutomaticOperationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomaticOperationMiddleware {


    @Autowired
    AutomaticOperationFramework automaticOperationFramework;


    public AutomaticOperationListWSModel getAutomaticOperations(long userId, String sessionState, int reqPage, int reqSize) {

        AutomaticOperationListWSModel response = new AutomaticOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AutomaticOperationListWSDTO operationListWSDTO = automaticOperationFramework.getAutomaticOperationsService(userId,sessionState,reqPage,reqSize);
        if (operationListWSDTO != null){
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("getAutomaticOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomaticOperationWSModel getAutomaticOperation(long userId, long sessionId) {

        AutomaticOperationWSModel response = new AutomaticOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticOperationWSDTO> automaticOperationWSDTOS = new ArrayList<>();

        AutomaticOperationWSDTO automaticOperationWSDTO = automaticOperationFramework.getAutomaticOperationService(userId,sessionId);
        if (automaticOperationWSDTO != null){
            automaticOperationWSDTOS.add(automaticOperationWSDTO);
        }

        response.setAutomaticOperations(automaticOperationWSDTOS);
        general.setOperation("getAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomaticOperationWSModel createAutomaticOperation(long userId,long clientId,long agentId,String campaignId) {

        AutomaticOperationWSModel response = new AutomaticOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticOperationWSDTO> automaticOperationWSDTOS = new ArrayList<>();

        AutomaticOperationWSDTO automaticOperationWSDTO = automaticOperationFramework.createAutomaticOperationService(userId,clientId,agentId,campaignId);
        if (automaticOperationWSDTO != null){
            automaticOperationWSDTOS.add(automaticOperationWSDTO);
        }

        response.setAutomaticOperations(automaticOperationWSDTOS);
        general.setOperation("createAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomaticOperationWSModel updateAutomaticOperation(long userId,long sessionId) {

        AutomaticOperationWSModel response = new AutomaticOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticOperationWSDTO> automaticOperationWSDTOS = new ArrayList<>();

        AutomaticOperationWSDTO automaticOperationWSDTO = automaticOperationFramework.updateAutomaticOperationService(userId,sessionId);
        if (automaticOperationWSDTO != null){
            automaticOperationWSDTOS.add(automaticOperationWSDTO);
        }

        response.setAutomaticOperations(automaticOperationWSDTOS);
        general.setOperation("updateAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomaticOperationWSModel removeAutomaticOperation(long userId,long sessionId) {

        AutomaticOperationWSModel response = new AutomaticOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticOperationWSDTO> automaticOperationWSDTOS = new ArrayList<>();

        AutomaticOperationWSDTO automaticOperationWSDTO = automaticOperationFramework.removeAutomaticOperationService(userId,sessionId);
        if (automaticOperationWSDTO != null){
            automaticOperationWSDTOS.add(automaticOperationWSDTO);
        }

        response.setAutomaticOperations(automaticOperationWSDTOS);
        general.setOperation("removeAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
