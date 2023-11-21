package com.faas.core.base.middleware.operation.automatic.content;

import com.faas.core.base.framework.operation.automatic.content.AutomaticManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.automatic.content.AutomaticManagerWSModel;
import com.faas.core.base.model.ws.operation.automatic.content.dto.AutomaticManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationCampaignWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomaticManagerMiddleware {


    @Autowired
    AutomaticManagerFramework automaticManagerFramework;


    public AutomaticManagerWSModel getAutomaticManager(long userId, int reqPage, int reqSize) {

        AutomaticManagerWSModel response = new AutomaticManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AutomaticManagerWSDTO automaticManagerWSDTO = automaticManagerFramework.getAutomaticManagerService(userId,reqPage,reqSize);
        if (automaticManagerWSDTO != null){
            response.setAutomaticManager(automaticManagerWSDTO);
        }

        general.setOperation("getAutomaticManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationListWSModel getAutomaticOperations(long userId, String sessionState, int reqPage, int reqSize) {

        OperationListWSModel response = new OperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationListWSDTO operationListWSDTO = automaticManagerFramework.getAutomaticOperationsService(userId,sessionState,reqPage,reqSize);
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

    public OperationWSModel getAutomaticOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = automaticManagerFramework.getAutomaticOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("getAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel createAutomaticOperation(long userId,long clientId,long agentId,String campaignId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = automaticManagerFramework.createAutomaticOperationService(userId,clientId,agentId,campaignId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("createAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel updateAutomaticOperation(long userId,long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = automaticManagerFramework.updateAutomaticOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("updateAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel removeAutomaticOperation(long userId,long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = automaticManagerFramework.removeAutomaticOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("removeAutomaticOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationCampaignWSModel getAutomaticCampaigns(long userId) {

        OperationCampaignWSModel response = new OperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationCampaignWSDTO> operationCampaignWSDTOS = automaticManagerFramework.getAutomaticCampaignsService(userId);
        if (operationCampaignWSDTOS != null){
            response.setCampaigns(operationCampaignWSDTOS);
        }

        general.setOperation("getAutomaticCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationCampaignWSModel getAutomaticCampaign(long userId, String campaignId) {

        OperationCampaignWSModel response = new OperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationCampaignWSDTO>operationCampaignWSDTOS = new ArrayList<>();

        OperationCampaignWSDTO operationCampaignWSDTO = automaticManagerFramework.getAutomaticCampaignService(userId,campaignId);
        if (operationCampaignWSDTO != null){
            operationCampaignWSDTOS.add(operationCampaignWSDTO);
        }

        response.setCampaigns(operationCampaignWSDTOS);
        general.setOperation("getAutomaticCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
