package com.faas.core.base.middleware.campaign.manager.operation;

import com.faas.core.base.framework.campaign.manager.operation.CampaignManagerOperationFramework;
import com.faas.core.base.model.ws.campaign.manager.client.CampaignClientRequest;
import com.faas.core.base.model.ws.campaign.manager.client.CampaignClientWSModel;
import com.faas.core.base.model.ws.campaign.manager.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.campaign.manager.operation.CampaignOperationRequest;
import com.faas.core.base.model.ws.campaign.manager.operation.CampaignOperationWSModel;
import com.faas.core.base.model.ws.campaign.manager.operation.dto.CampaignOperationWSDTO;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignManagerOperationMiddleware {


    @Autowired
    CampaignManagerOperationFramework campaignManagerOperationFramework;


    public CampaignOperationWSModel searchCampaignOperations(long userId, String campaignId, String city, String country, int reqPage, int reqSize) {

        CampaignOperationWSModel response = new CampaignOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignOperationWSDTO campaignOperationWSDTO = campaignManagerOperationFramework.searchCampaignOperationsService(userId, campaignId, city, country, reqPage, reqSize);
        if (campaignOperationWSDTO != null) {
            response.setCampaignOperation(campaignOperationWSDTO);
        }

        general.setOperation("searchCampaignOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignOperationWSModel getCampaignOperations(long userId, String campaignId, String operationState, int reqPage, int reqSize) {

        CampaignOperationWSModel response = new CampaignOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignOperationWSDTO campaignOperationWSDTO = campaignManagerOperationFramework.getCampaignOperationsService(userId, campaignId, operationState, reqPage, reqSize);
        if (campaignOperationWSDTO != null) {
            response.setCampaignOperation(campaignOperationWSDTO);
        }

        general.setOperation("getCampaignOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel getCampaignOperation(long userId, String operationId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = campaignManagerOperationFramework.getCampaignOperationService(userId, operationId);
        if (operationWSDTO != null) {
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

    public OperationWSModel createCampaignOperations(CampaignOperationRequest operationRequest) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationWSDTO> operationWSDTOS = campaignManagerOperationFramework.createCampaignOperationsService(operationRequest);
        if (operationWSDTOS != null) {
            response.setOperations(operationWSDTOS);
        }

        general.setOperation("createCampaignOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel createCampaignOperation(long userId, long clientId, String campaignId, long agentId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = campaignManagerOperationFramework.createCampaignOperationService(userId, clientId, campaignId, agentId);
        if (operationWSDTO != null) {
            response.setOperations(operationWSDTOS);
        }

        general.setOperation("createCampaignOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel updateCampaignOperation(long userId, String operationId, String operationState) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = campaignManagerOperationFramework.updateCampaignOperationService(userId, operationId, operationState);
        if (operationWSDTO != null) {
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

    public OperationWSModel removeCampaignOperation(long userId, String operationId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = campaignManagerOperationFramework.removeCampaignOperationService(userId, operationId);
        if (operationWSDTO != null) {
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


    public CampaignClientWSModel searchCampaignClients(long userId, String city, String clientState, int reqPage, int reqSize) {

        CampaignClientWSModel response = new CampaignClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignClientWSDTO campaignClientWSDTO = campaignManagerOperationFramework.searchCampaignClientsService(city, clientState, reqPage, reqSize);
        if (campaignClientWSDTO != null) {
            response.setCampaignClient(campaignClientWSDTO);
        }

        general.setOperation("searchCampaignClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientWSModel getSelectedCampaignClients(CampaignClientRequest clientRequest) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientWSDTO> clientWSDTOS = campaignManagerOperationFramework.getSelectedCampaignClients(clientRequest);
        if (clientWSDTOS != null) {
            response.setClients(clientWSDTOS);
        }

        general.setOperation("getSelectedCampaignClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientWSModel getCampaignClient(long userId, long clientId, String campaignId) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();

        ClientWSDTO clientWSDTO = campaignManagerOperationFramework.getCampaignClientService(userId, clientId, campaignId);
        if (clientWSDTO != null) {
            clientWSDTOS.add(clientWSDTO);
        }

        response.setClients(clientWSDTOS);
        general.setOperation("getCampaignClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
