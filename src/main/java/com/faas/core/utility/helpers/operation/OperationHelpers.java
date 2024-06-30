package com.faas.core.utility.helpers.operation;

import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationCampaignWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.content.dao.OperationFlowDAO;
import com.faas.core.base.model.db.operation.content.dao.OperationInquiryDAO;
import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.campaign.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.campaign.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.campaign.details.channel.temp.SmsTempRepository;
import com.faas.core.base.repo.campaign.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.channel.ChannelHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OperationHelpers {

    @Autowired
    ChannelHelpers channelHelpers;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignScenarioRepository campaignScenarioRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    OperationWappCallRepository wappCallRepository;

    @Autowired
    OperationSmsRepository OperationSmsRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationEmailRepository operationEmailRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    OperationPushRepository operationPushRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    AppUtils appUtils;



    public OperationDBModel createOperationDBModel() {

        return null;
    }

    public OperationInquiryDAO createOperationInquiryDAO() {


        return null;
    }

    public OperationFlowDAO createOperationFlowDAO() {


        return null;
    }


    public OperationWSDTO getOperationWSDTO(OperationDBModel operationDBModel){

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperation(operationDBModel);

        return operationWSDTO;
    }

    public OperationListWSDTO getOperationListWSDTO(){

        OperationListWSDTO operationListWSDTO = new OperationListWSDTO();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        return operationListWSDTO;
    }



    public void removeOperationHelper(){

    }


    public ApiOperationWSDTO getApiOperationWSDTO(OperationDBModel operationDBModel) {

        return null;
    }


    public List<ApiSummaryWSDTO> apiGetOperationSummaryHelper(long agentId) {

        List<ApiSummaryWSDTO> operationSummary = new ArrayList<>();
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.READY_STATE))));
        operationSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));

        return operationSummary;
    }


    public ApiOperationWSDTO startManualOperationHelper(){

        return null;
    }






    public ApiOperationValidateWSDTO operationValidateHelper(UserDBModel agentDBModel,OperationDBModel operationDBModel){

        ApiOperationValidateWSDTO operationValidateWSDTO = new ApiOperationValidateWSDTO();
        operationValidateWSDTO.setAgent(agentDBModel);
        operationValidateWSDTO.setOperation(operationDBModel);
        operationValidateWSDTO.setOperationCount(operationRepository.countByAgentIdAndOperationState(agentDBModel.getId(),AppConstant.ACTIVE_STATE));

        if (agentDBModel.getUserRole().equalsIgnoreCase(AppConstant.BASIC_AGENT)){
            operationValidateWSDTO.setOperationLimit(AppConstant.BASIC_AGENT_OPERATION_LIMIT);
        }
        if (agentDBModel.getUserRole().equalsIgnoreCase(AppConstant.SUPER_AGENT)){
            operationValidateWSDTO.setOperationLimit(AppConstant.SUPER_AGENT_OPERATION_LIMIT);
        }
        return operationValidateWSDTO;
    }



    public ApiOperationListWSDTO getApiOperationListWSDTO(Page<OperationDBModel> operationModelPage){

        ApiOperationListWSDTO operationListWSDTO = new ApiOperationListWSDTO();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        for (int i=0;operationModelPage.getContent().size()>i;i++){
            ApiOperationWSDTO operationWSDTO = getApiOperationWSDTO(operationModelPage.getContent().get(i));
            if (operationWSDTO != null){
                operationWSDTOS.add(operationWSDTO);
            }
        }
        operationListWSDTO.setOperations(operationWSDTOS);
        operationListWSDTO.setPagination(mapOperationPagination(operationModelPage));

        return operationListWSDTO;
    }


    public ApiOperationDetailsWSDTO getApiOperationDetailsWSDTO(OperationDBModel operationDBModel) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(operationDBModel.getClientId());
        List<ClientDetailsDBModel> clientDetails = clientDetailsRepository.findByClientId(operationDBModel.getClientId());

        if (clientDBModel.isPresent() && !clientDetails.isEmpty()) {

            ApiOperationDetailsWSDTO operationDetailsWSDTO = new ApiOperationDetailsWSDTO();
            operationDetailsWSDTO.setOperation(operationDBModel);
            operationDetailsWSDTO.setOperationClient(getApiOperationClientWSDTO(clientDBModel.get()));
            operationDetailsWSDTO.setOperationCampaign(getApiOperationCampaignWSDTO(operationDBModel.getCampaignId(),operationDBModel.getCampaignId()));
            operationDetailsWSDTO.setOperationCallChannel(getApiOperationCallChannelWSDTO(operationDBModel,clientDetails.get(0)));
            operationDetailsWSDTO.setOperationMessageChannel(getApiOperationMessageChannelWSDTO(operationDBModel,clientDetails.get(0)));

            return operationDetailsWSDTO;
        }
        return null;
    }

    public ApiOperationClientWSDTO getApiOperationClientWSDTO(ClientDBModel clientDBModel) {

        ApiOperationClientWSDTO operationClientWSDTO = new ApiOperationClientWSDTO();
        operationClientWSDTO.setClient(clientDBModel);
        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientDBModel.getId());
        if (!clientDetailsDBModels.isEmpty()){
            operationClientWSDTO.setClientDetails(clientDetailsDBModels.get(0));
        }
        return operationClientWSDTO;
    }

    public ApiOperationCampaignWSDTO getApiOperationCampaignWSDTO(String campaignId,String processId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        Optional<CampaignDBModel> processDBModel = campaignRepository.findById(processId);
        if (campaignDBModel.isPresent() && processDBModel.isPresent()){

            ApiOperationCampaignWSDTO operationCampaignWSDTO = new ApiOperationCampaignWSDTO();
            operationCampaignWSDTO.setOperationCampaign(campaignDBModel.get());
            operationCampaignWSDTO.setProcessScenarios(campaignScenarioRepository.findByCampaignId(processId));

            return operationCampaignWSDTO;
        }
        return null;
    }


    public ApiOperationCallChannelWSDTO getApiOperationCallChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationCallChannelWSDTO operationCallChannelWSDTO = new ApiOperationCallChannelWSDTO();
        operationCallChannelWSDTO.setOperationSipChannel(getApiOperationSipChannelWSDTO(operationDBModel,clientDetails));
        operationCallChannelWSDTO.setOperationWappCallChannel(getApiOperationWappCallChannelWSDTO(operationDBModel,clientDetails));

        return operationCallChannelWSDTO;
    }

    public ApiOperationSipChannelWSDTO getApiOperationSipChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationSipAccountWSDTO sipAccountWSDTO = channelHelpers.getApiOperationSipAccountWSDTO(operationDBModel.getAgentId(),operationDBModel.getCampaignId());
        if (sipAccountWSDTO != null && clientDetails.getClientPhones() != null){

            ApiOperationSipChannelWSDTO operationSipChannelWSDTO = new ApiOperationSipChannelWSDTO();
            operationSipChannelWSDTO.setSipAccount(sipAccountWSDTO);
            operationSipChannelWSDTO.setClientPhones(clientDetails.getClientPhones());
            List<OperationSipCallDBModel> operationSipCallDBModels = operationSipCallRepository.findByOperationId(operationDBModel.getId());
            OperationSipCallDBModel activeSipCall = channelHelpers.getApiOperationActiveSipCallHelper(operationSipCallDBModels);
            if (activeSipCall != null){
                operationSipChannelWSDTO.setActiveSipCall(activeSipCall);
            }
            operationSipChannelWSDTO.setRecentSipCalls(operationSipCallDBModels);

            return operationSipChannelWSDTO;
        }
        return null;
    }

    public ApiOperationWappCallChannelWSDTO getApiOperationWappCallChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationWappCallAccountWSDTO wappAccountWSDTO = channelHelpers.getApiOperationWappCallAccountWSDTO(operationDBModel.getAgentId(),operationDBModel.getCampaignId());
        if (wappAccountWSDTO != null && clientDetails.getClientPhones() != null){

            ApiOperationWappCallChannelWSDTO wappCallChannelWSDTO = new ApiOperationWappCallChannelWSDTO();
            wappCallChannelWSDTO.setWappAccount(wappAccountWSDTO);
            wappCallChannelWSDTO.setClientPhones(clientDetails.getClientPhones());
            List<OperationWappCallDBModel> operationWappCallDBModels = wappCallRepository.findByOperationId(operationDBModel.getId());
            OperationWappCallDBModel activeWappCall = channelHelpers.getApiOperationActiveWappCallHelper(operationWappCallDBModels);
            if (activeWappCall != null){
                wappCallChannelWSDTO.setActiveWappCall(activeWappCall);
            }
            wappCallChannelWSDTO.setRecentWappCalls(operationWappCallDBModels);

            return wappCallChannelWSDTO;
        }
        return null;
    }



    public ApiOperationMessageChannelWSDTO getApiOperationMessageChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {

        ApiOperationMessageChannelWSDTO operationMessageChannelWSDTO = new ApiOperationMessageChannelWSDTO();
        operationMessageChannelWSDTO.setOperationSmsChannel(getApiOperationSmsChannelWSDTO(operationDBModel,clientDetails));
        operationMessageChannelWSDTO.setOperationWappMessageChannel(getApiOperationWappMessageChannelWSDTO(operationDBModel,clientDetails));
        operationMessageChannelWSDTO.setOperationEmailChannel(getApiOperationEmailChannelWSDTO(operationDBModel,clientDetails));
        operationMessageChannelWSDTO.setOperationPushChannel(getApiOperationPushChannelWSDTO(operationDBModel,clientDetails));

        return operationMessageChannelWSDTO;
    }


    public ApiOperationSmsChannelWSDTO getApiOperationSmsChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {


        return null;
    }

    public ApiOperationWappMessageChannelWSDTO getApiOperationWappMessageChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {


        return null;
    }

    public ApiOperationEmailChannelWSDTO getApiOperationEmailChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {


        return null;
    }

    public ApiOperationPushChannelWSDTO getApiOperationPushChannelWSDTO(OperationDBModel operationDBModel,ClientDetailsDBModel clientDetails) {


        return null;
    }


    public PaginationWSDTO mapOperationPagination(Page<OperationDBModel> operationModelPage){

        PaginationWSDTO operationPagination = new PaginationWSDTO();
        operationPagination.setPageSize(operationModelPage.getPageable().getPageSize());
        operationPagination.setPageNumber(operationModelPage.getPageable().getPageNumber());
        operationPagination.setTotalPage(operationModelPage.getTotalPages());
        operationPagination.setTotalElements(operationModelPage.getTotalElements());

        return operationPagination;
    }




}
