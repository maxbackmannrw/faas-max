package com.faas.core.misc.helpers.operation;

import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.call.sip.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.call.wapp.dto.ApiOperationWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationAgentWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationManagerWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;
import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.operation.content.dao.OperationFlowDAO;
import com.faas.core.data.db.operation.content.dao.OperationInquiryDAO;
import com.faas.core.data.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.data.db.operation.details.channel.OperationWappCallDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.campaign.manager.operation.dto.CampaignOperationWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.data.db.user.details.UserDetailsDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.data.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.operation.details.channel.*;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.data.repo.user.details.UserDetailsRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.channel.ChannelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OperationHelper {

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignScenarioRepository campaignScenarioRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    AppUtils appUtils;
    @Autowired
    private OperationEmailRepository operationEmailRepository;
    @Autowired
    private OperationSmsRepository operationSmsRepository;
    @Autowired
    private OperationWappMessageRepository operationWappMessageRepository;
    @Autowired
    private OperationPushRepository operationPushRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsRepository userDetailsRepository;


    public OperationDBModel createOperationDBModel(UserDBModel userDBModel, CampaignDBModel campaignDBModel, ClientDBModel clientDBModel, ClientDetailsDBModel clientDetailsDBModel) {

        OperationDBModel operationDBModel = new OperationDBModel();
        operationDBModel.setClientId(clientDBModel.getId());
        operationDBModel.setClientName(clientDBModel.getClientName());
        operationDBModel.setNationalId(clientDBModel.getNationalId());
        operationDBModel.setPhoneNumber(clientDBModel.getPhoneNumber());
        operationDBModel.setEmailAddress(clientDBModel.getEmailAddress());
        operationDBModel.setClientCity(clientDBModel.getClientCity());
        operationDBModel.setClientCountry(clientDBModel.getClientCountry());
        operationDBModel.setClientType(clientDBModel.getClientType());
        if (clientDetailsDBModel.getClientPhones() != null) {
            operationDBModel.setClientPhones(clientDetailsDBModel.getClientPhones());
        }
        if (clientDetailsDBModel.getClientEmails() != null) {
            operationDBModel.setClientEmails(clientDetailsDBModel.getClientEmails());
        }
        if (clientDetailsDBModel.getClientAddresses() != null) {
            operationDBModel.setClientAddresses(clientDetailsDBModel.getClientAddresses());
        }
        if (clientDetailsDBModel.getClientNotes() != null) {
            operationDBModel.setClientNotes(clientDetailsDBModel.getClientNotes());
        }
        operationDBModel.setAgentId(userDBModel.getId());
        operationDBModel.setAgentName(userDBModel.getUserName());
        operationDBModel.setCampaignId(campaignDBModel.getId());
        operationDBModel.setCampaign(campaignDBModel.getCampaign());
        operationDBModel.setCampaignType(campaignDBModel.getCampaignType());
        operationDBModel.setCampaignCategory(campaignDBModel.getCampaignCategory());
        operationDBModel.setInquiryState(AppConstant.NONE);
        operationDBModel.setFlowState(AppConstant.NONE);
        if (campaignDBModel.getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)) {
            operationDBModel.setOperationInquiry(createOperationInquiryDAO(campaignDBModel));
            operationDBModel.setInquiryState(AppConstant.READY_STATE);
        }
        if (campaignDBModel.getCampaignCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)) {
            operationDBModel.setOperationFlow(createOperationFlowDAO(campaignDBModel));
            operationDBModel.setFlowState(AppConstant.READY_STATE);
        }
        operationDBModel.setOperationScenarios(new ArrayList<>());
        operationDBModel.setOperationScenarios(new ArrayList<>());
        operationDBModel.setOperationDatas(new ArrayList<>());
        operationDBModel.setOperationCategory(campaignDBModel.getCampaignCategory());
        operationDBModel.setOperationResult(AppConstant.NONE);
        operationDBModel.setOperationState(AppConstant.READY_STATE);
        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationDBModel.setcDate(appUtils.getCurrentTimeStamp());
        operationDBModel.setStatus(1);

        return operationRepository.save(operationDBModel);
    }

    public OperationInquiryDAO createOperationInquiryDAO(CampaignDBModel campaignDBModel) {

        OperationInquiryDAO operationInquiryDAO = new OperationInquiryDAO();
        operationInquiryDAO.setInquiryId(appUtils.generateUUID());
        operationInquiryDAO.setOperationInquiry(campaignDBModel.getCampaignInquiry().getCampaignInquiry());
        operationInquiryDAO.setInquiryDatas(new ArrayList<>());
        operationInquiryDAO.setuDate(appUtils.getCurrentTimeStamp());
        operationInquiryDAO.setStatus(1);

        return operationInquiryDAO;
    }

    public OperationFlowDAO createOperationFlowDAO(CampaignDBModel campaignDBModel) {

        OperationFlowDAO operationFlowDAO = new OperationFlowDAO();
        operationFlowDAO.setFlowId(appUtils.generateUUID());
        operationFlowDAO.setOperationFlow(campaignDBModel.getCampaignFlow().getCampaignFlow());
        operationFlowDAO.setFlowDatas(new ArrayList<>());
        operationFlowDAO.setuDate(appUtils.getCurrentTimeStamp());
        operationFlowDAO.setStatus(1);

        return operationFlowDAO;
    }


    public OperationWSDTO getOperationWSDTO(OperationDBModel operationDBModel) {

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperation(operationDBModel);

        return operationWSDTO;
    }

    public CampaignOperationWSDTO mapCampaignOperationWSDTO(Page<OperationDBModel> operationModelPage) {

        CampaignOperationWSDTO campaignOperationWSDTO = new CampaignOperationWSDTO();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationModelPage.getContent();
        for (OperationDBModel operationDBModel : operationDBModels) {
            operationWSDTOS.add(getOperationWSDTO(operationDBModel));
        }
        campaignOperationWSDTO.setOperations(operationWSDTOS);
        campaignOperationWSDTO.setPagination(mapOperationPaginationWSDTO(operationModelPage));

        return campaignOperationWSDTO;
    }

    public OperationDBModel removeOperationHelper(OperationDBModel operationDBModel) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(operationDBModel.getClientId());
        if (clientDBModel.isPresent()) {
            clientDBModel.get().setClientState(AppConstant.READY_CLIENT);
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel.get());
        }
        operationSipCallRepository.deleteAll(operationSipCallRepository.findByOperationId(operationDBModel.getId()));
        operationSmsRepository.deleteAll(operationSmsRepository.findByOperationId(operationDBModel.getId()));
        operationWappMessageRepository.deleteAll(operationWappMessageRepository.findByOperationId(operationDBModel.getId()));
        operationWappCallRepository.deleteAll(operationWappCallRepository.findByOperationId(operationDBModel.getId()));
        operationEmailRepository.deleteAll(operationEmailRepository.findByOperationId(operationDBModel.getId()));
        operationPushRepository.deleteAll(operationPushRepository.findByOperationId(operationDBModel.getId()));
        operationRepository.delete(operationDBModel);

        return operationDBModel;
    }

    public OperationListWSDTO getOperationListWSDTO(Page<OperationDBModel> operationModelPage) {

        OperationListWSDTO operationListWSDTO = new OperationListWSDTO();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationModelPage.getContent();
        for (OperationDBModel operationDBModel : operationDBModels) {
            operationWSDTOS.add(getOperationWSDTO(operationDBModel));
        }
        operationListWSDTO.setOperations(operationWSDTOS);
        operationListWSDTO.setPagination(mapOperationPaginationWSDTO(operationModelPage));

        return operationListWSDTO;
    }


    public ApiOperationWSDTO getApiOperationWSDTO(OperationDBModel operationDBModel) {

        ApiOperationWSDTO operationWSDTO = new ApiOperationWSDTO();
        operationWSDTO.setOperation(operationDBModel);
        return operationWSDTO;
    }


    public ApiValidateOperationWSDTO validateOperationHelper(UserDBModel agentDBModel, OperationDBModel operationDBModel) {

        ApiValidateOperationWSDTO operationValidateWSDTO = new ApiValidateOperationWSDTO();
        operationValidateWSDTO.setAgent(agentDBModel);
        operationValidateWSDTO.setOperation(operationDBModel);
        operationValidateWSDTO.setOperationCount(operationRepository.countByAgentIdAndOperationState(agentDBModel.getId(), AppConstant.ACTIVE_STATE));
        if (agentDBModel.getUserRole().equalsIgnoreCase(AppConstant.BASIC_AGENT)) {
            operationValidateWSDTO.setOperationLimit(AppConstant.BASIC_AGENT_OPERATION_LIMIT);
        }
        if (agentDBModel.getUserRole().equalsIgnoreCase(AppConstant.SUPER_AGENT)) {
            operationValidateWSDTO.setOperationLimit(AppConstant.SUPER_AGENT_OPERATION_LIMIT);
        }
        return operationValidateWSDTO;
    }

    public ApiOperationListWSDTO getApiOperationListWSDTO(Page<OperationDBModel> operationModelPage) {

        ApiOperationListWSDTO operationListWSDTO = new ApiOperationListWSDTO();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i = 0; operationModelPage.getContent().size() > i; i++) {
            ApiOperationWSDTO operationWSDTO = getApiOperationWSDTO(operationModelPage.getContent().get(i));
            if (operationWSDTO != null) {
                operationWSDTOS.add(operationWSDTO);
            }
        }
        operationListWSDTO.setOperations(operationWSDTOS);
        operationListWSDTO.setPagination(mapOperationPaginationWSDTO(operationModelPage));

        return operationListWSDTO;
    }

    public ApiOperationManagerWSDTO getApiOperationManagerWSDTO(OperationDBModel operationDBModel) {

        Optional<UserDBModel> agentDBModel = userRepository.findById(operationDBModel.getAgentId());
        List<UserDetailsDBModel> agentDetailsModels = userDetailsRepository.findByUserId(operationDBModel.getAgentId());
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(operationDBModel.getClientId());
        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(operationDBModel.getCampaignId());

        if (agentDBModel.isPresent() && !agentDetailsModels.isEmpty() && clientDBModel.isPresent() && campaignDBModel.isPresent()) {

            ApiOperationManagerWSDTO operationManagerWSDTO = new ApiOperationManagerWSDTO();
            operationManagerWSDTO.setOperation(operationDBModel);
            operationManagerWSDTO.setOperationAgent(getApiOperationAgentWSDTO(agentDBModel.get(),agentDetailsModels.get(0)));
            operationManagerWSDTO.setOperationClient(getApiOperationClientWSDTO(clientDBModel.get()));
            operationManagerWSDTO.setOperationCampaign(getApiOperationCampaignWSDTO(campaignDBModel.get()));

            return operationManagerWSDTO;
        }
        return null;
    }

    public ApiOperationAgentWSDTO getApiOperationAgentWSDTO(UserDBModel agentDBModel,UserDetailsDBModel agentDetailsDBModels) {

        ApiOperationAgentWSDTO operationAgentWSDTO = new ApiOperationAgentWSDTO();
        operationAgentWSDTO.setAgent(agentDBModel);
        operationAgentWSDTO.setAgentDetails(agentDetailsDBModels);
        operationAgentWSDTO.setOperationLimit(agentDetailsDBModels.getOperationLimit());
        operationAgentWSDTO.setActiveOperation(operationRepository.countByAgentIdAndOperationState(agentDBModel.getId(),AppConstant.ACTIVE_STATE));

        return operationAgentWSDTO;
    }

    public ApiOperationClientWSDTO getApiOperationClientWSDTO(ClientDBModel clientDBModel) {

        ApiOperationClientWSDTO operationClientWSDTO = new ApiOperationClientWSDTO();
        operationClientWSDTO.setClient(clientDBModel);
        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientDBModel.getId());
        if (!clientDetailsDBModels.isEmpty()) {
            operationClientWSDTO.setClientDetails(clientDetailsDBModels.get(0));
        }
        return operationClientWSDTO;
    }

    public ApiOperationCampaignWSDTO getApiOperationCampaignWSDTO(CampaignDBModel campaignDBModel) {

        ApiOperationCampaignWSDTO operationCampaignWSDTO = new ApiOperationCampaignWSDTO();
        operationCampaignWSDTO.setCampaign(campaignDBModel);
        List<CampaignScenarioDBModel> campaignScenarios = campaignScenarioRepository.findByCampaignId(campaignDBModel.getId());
        if (!campaignScenarios.isEmpty()) {
            operationCampaignWSDTO.setCampaignScenarios(campaignScenarios);
        }
        return operationCampaignWSDTO;
    }


    public ApiOperationCallChannelWSDTO getApiOperationCallChannelWSDTO(OperationDBModel operationDBModel, ClientDetailsDBModel clientDetails) {

        ApiOperationCallChannelWSDTO operationCallChannelWSDTO = new ApiOperationCallChannelWSDTO();
        operationCallChannelWSDTO.setOperationSipChannel(getApiOperationSipChannelWSDTO(operationDBModel, clientDetails));
        operationCallChannelWSDTO.setOperationWappCallChannel(getApiOperationWappCallChannelWSDTO(operationDBModel, clientDetails));

        return operationCallChannelWSDTO;
    }

    public ApiOperationSipChannelWSDTO getApiOperationSipChannelWSDTO(OperationDBModel operationDBModel, ClientDetailsDBModel clientDetails) {

        ApiOperationSipAccountWSDTO sipAccountWSDTO = channelHelper.getApiOperationSipAccountWSDTO(operationDBModel.getAgentId(), operationDBModel.getCampaignId());
        if (sipAccountWSDTO != null && clientDetails.getClientPhones() != null) {

            ApiOperationSipChannelWSDTO operationSipChannelWSDTO = new ApiOperationSipChannelWSDTO();
            operationSipChannelWSDTO.setSipAccount(sipAccountWSDTO);
            operationSipChannelWSDTO.setClientPhones(clientDetails.getClientPhones());
            List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByOperationId(operationDBModel.getId());
            OperationSipCallDBModel activeSipCall = channelHelper.getApiOperationActiveSipCallHelper(operationSipCallDBModels);
            if (activeSipCall != null) {
                operationSipChannelWSDTO.setActiveSipCall(activeSipCall);
            }
            operationSipChannelWSDTO.setRecentSipCalls(operationSipCallDBModels);

            return operationSipChannelWSDTO;
        }
        return null;
    }

    public ApiOperationWappCallChannelWSDTO getApiOperationWappCallChannelWSDTO(OperationDBModel operationDBModel, ClientDetailsDBModel clientDetails) {

        ApiOperationWappCallAccountWSDTO wappAccountWSDTO = channelHelper.getApiOperationWappCallAccountWSDTO(operationDBModel.getAgentId(), operationDBModel.getCampaignId());
        if (wappAccountWSDTO != null && clientDetails.getClientPhones() != null) {

            ApiOperationWappCallChannelWSDTO wappCallChannelWSDTO = new ApiOperationWappCallChannelWSDTO();
            wappCallChannelWSDTO.setWappAccount(wappAccountWSDTO);
            wappCallChannelWSDTO.setClientPhones(clientDetails.getClientPhones());
            List<OperationWappCallDBModel> operationWappCallDBModels = operationWappCallRepository.findByOperationId(operationDBModel.getId());
            OperationWappCallDBModel activeWappCall = channelHelper.getApiOperationActiveWappCallHelper(operationWappCallDBModels);
            if (activeWappCall != null) {
                wappCallChannelWSDTO.setActiveWappCall(activeWappCall);
            }
            wappCallChannelWSDTO.setRecentWappCalls(operationWappCallDBModels);

            return wappCallChannelWSDTO;
        }
        return null;
    }


    public ApiOperationMessageChannelWSDTO getApiOperationMessageChannelWSDTO(OperationDBModel operationDBModel, ClientDetailsDBModel clientDetails) {

        ApiOperationMessageChannelWSDTO operationMessageChannelWSDTO = new ApiOperationMessageChannelWSDTO();
        operationMessageChannelWSDTO.setOperationSmsChannel(getApiOperationSmsChannelWSDTO(operationDBModel, clientDetails));
        operationMessageChannelWSDTO.setOperationWappMessageChannel(getApiOperationWappMessageChannelWSDTO(operationDBModel, clientDetails));
        operationMessageChannelWSDTO.setOperationEmailChannel(getApiOperationEmailChannelWSDTO(operationDBModel, clientDetails));
        operationMessageChannelWSDTO.setOperationPushChannel(getApiOperationPushChannelWSDTO(operationDBModel, clientDetails));

        return operationMessageChannelWSDTO;
    }


    public ApiOperationSmsChannelWSDTO getApiOperationSmsChannelWSDTO(OperationDBModel operationDBModel, ClientDetailsDBModel clientDetails) {


        return null;
    }

    public ApiOperationWappMessageChannelWSDTO getApiOperationWappMessageChannelWSDTO(OperationDBModel operationDBModel, ClientDetailsDBModel clientDetails) {


        return null;
    }

    public ApiOperationEmailChannelWSDTO getApiOperationEmailChannelWSDTO(OperationDBModel operationDBModel, ClientDetailsDBModel clientDetails) {


        return null;
    }

    public ApiOperationPushChannelWSDTO getApiOperationPushChannelWSDTO(OperationDBModel operationDBModel, ClientDetailsDBModel clientDetails) {


        return null;
    }


    public PaginationWSDTO mapOperationPaginationWSDTO(Page<OperationDBModel> operationModelPage) {

        PaginationWSDTO operationPagination = new PaginationWSDTO();
        operationPagination.setPageSize(operationModelPage.getPageable().getPageSize());
        operationPagination.setPageNumber(operationModelPage.getPageable().getPageNumber());
        operationPagination.setTotalPage(operationModelPage.getTotalPages());
        operationPagination.setTotalElements(operationModelPage.getTotalElements());

        return operationPagination;
    }


}
