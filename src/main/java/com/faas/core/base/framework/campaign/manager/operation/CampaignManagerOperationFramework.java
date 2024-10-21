package com.faas.core.base.framework.campaign.manager.operation;

import com.faas.core.base.model.ws.campaign.manager.client.CampaignClientRequest;
import com.faas.core.base.model.ws.campaign.manager.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.manager.operation.CampaignOperationRequest;
import com.faas.core.base.model.ws.campaign.manager.operation.dto.CampaignOperationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.client.ClientHelper;
import com.faas.core.misc.helpers.operation.content.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignManagerOperationFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ClientHelper clientHelper;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignOperationWSDTO searchCampaignOperationsService(long userId, String campaignId, String city, String country, int reqPage, int reqSize) {

        return null;
    }

    public CampaignOperationWSDTO getCampaignOperationsService(long userId, String campaignId, String operationState, int reqPage, int reqSize) {

        Page<OperationDBModel> operationDBModelPage = operationRepository.findAllByCampaignIdAndOperationState(campaignId, operationState, PageRequest.of(reqPage, reqSize));
        if (operationDBModelPage != null) {
            return operationHelper.mapCampaignOperationWSDTO(operationDBModelPage);
        }
        return null;
    }

    public OperationWSDTO getCampaignOperationService(long userId, String operationId) {

        return null;
    }

    public List<OperationWSDTO> createCampaignOperationsService(CampaignOperationRequest operationRequest) {

        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        Optional<UserDBModel> agentDBModel = userRepository.findById(operationRequest.getAgentId());
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(operationRequest.getCampaignId());
        if (agentDBModel.isPresent() && campaignDBModel.isPresent() && operationRequest.getClientIds() != null && !operationRequest.getClientIds().isEmpty()) {
            for (int i = 0; i < operationRequest.getClientIds().size(); i++) {
                List<ClientDBModel> clientDBModels = clientRepository.findByIdAndClientState(operationRequest.getClientIds().get(i), AppConstant.READY_CLIENT);
                List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationRequest.getClientIds().get(i));
                if (!clientDBModels.isEmpty() && !clientDetailsDBModels.isEmpty()) {
                    OperationWSDTO operationWSDTO = createCampaignOperation(agentDBModel.get(), campaignDBModel.get(), clientDBModels.get(0), clientDetailsDBModels.get(0));
                    if (operationWSDTO != null) {
                        operationWSDTOS.add(operationWSDTO);
                    }
                }
            }
        }
        return operationWSDTOS;
    }

    public OperationWSDTO createCampaignOperationService(long userId, long clientId, String campaignId, long agentId) {

        return null;
    }

    public OperationWSDTO createCampaignOperation(UserDBModel userDBModel, CampaignDBModel campaignDBModel, ClientDBModel clientDBModel, ClientDetailsDBModel clientDetailsDBModel) {

        clientDBModel.setClientState(AppConstant.BUSY_CLIENT);
        clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientDBModel = clientRepository.save(clientDBModel);

        OperationDBModel operationDBModel = operationHelper.createOperationDBModel(userDBModel, campaignDBModel, clientDBModel, clientDetailsDBModel);
        if (operationDBModel != null) {
            return operationHelper.getOperationWSDTO(operationDBModel);
        }
        return null;
    }

    public OperationWSDTO updateCampaignOperationService(long userId, String operationId, String operationState) {

        return null;
    }

    public OperationWSDTO removeCampaignOperationService(long userId, String operationId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        if (operationDBModel.isPresent()) {
            return operationHelper.getOperationWSDTO(operationHelper.removeOperationHelper(operationDBModel.get()));
        }
        return null;
    }


    public CampaignClientWSDTO searchCampaignClientsService(String city, String clientState, int reqPage, int reqSize) {

        if (city.equalsIgnoreCase(AppConstant.NONE)) {
            return clientHelper.mapCampaignClientWSDTO(clientRepository.findAllByClientState(clientState, PageRequest.of(reqPage, reqSize)));
        } else {
            return clientHelper.mapCampaignClientWSDTO(clientRepository.findAllByClientCityAndClientState(city, clientState, PageRequest.of(reqPage, reqSize)));
        }
    }

    public List<ClientWSDTO> getSelectedCampaignClients(CampaignClientRequest clientRequest) {

        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();
        if (clientRequest.getClientRequests() != null) {
            for (int i = 0; i < clientRequest.getClientRequests().size(); i++) {
                List<ClientDBModel> clientDBModels = clientRepository.findByIdAndClientState(clientRequest.getClientRequests().get(i).getClientId(), AppConstant.READY_CLIENT);
                if (!clientDBModels.isEmpty()) {
                    clientWSDTOS.add(new ClientWSDTO(clientDBModels.get(0)));
                }
            }
        }
        return clientWSDTOS;
    }

    public ClientWSDTO getCampaignClientService(long userId, long clientId, String campaignId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()) {
            return new ClientWSDTO(clientDBModel.get());
        }
        return null;
    }


}