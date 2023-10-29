package com.faas.core.base.middleware.operation.details.automatic;

import com.faas.core.base.framework.operation.details.automatic.AutomaticOperationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.automatic.AutomaticOperationWSModel;
import com.faas.core.base.model.ws.operation.details.automatic.dto.AutomaticOperationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomaticOperationMiddleware {


    @Autowired
    AutomaticOperationFramework automaticOperationFramework;


    public AutomaticOperationWSModel getAutomaticOperations(long userId, String flowState, int reqPage, int reqSize) {

        AutomaticOperationWSModel response = new AutomaticOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAutomaticOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomaticOperationWSModel getAutomaticOperation(long userId, long flowId, long clientId) {

        AutomaticOperationWSModel response = new AutomaticOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticOperationWSDTO> automaticOperationWSDTOS = new ArrayList<>();


        response.setOperationFlows(automaticOperationWSDTOS);
        general.setOperation("getAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomaticOperationWSModel createAutomaticOperation(long userId, long clientId, long agentId, String campaignId) {

        AutomaticOperationWSModel response = new AutomaticOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticOperationWSDTO> automaticOperationWSDTOS = new ArrayList<>();



        response.setOperationFlows(automaticOperationWSDTOS);
        general.setOperation("createAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomaticOperationWSModel updateAutomaticOperation(long userId, long flowId, long clientId) {

        AutomaticOperationWSModel response = new AutomaticOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticOperationWSDTO> automaticOperationWSDTOS = new ArrayList<>();



        response.setOperationFlows(automaticOperationWSDTOS);
        general.setOperation("updateAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomaticOperationWSModel removeAutomaticOperation(long userId, long flowId, long clientId) {

        AutomaticOperationWSModel response = new AutomaticOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomaticOperationWSDTO> automaticOperationWSDTOS = new ArrayList<>();



        response.setOperationFlows(automaticOperationWSDTOS);
        general.setOperation("removeAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
