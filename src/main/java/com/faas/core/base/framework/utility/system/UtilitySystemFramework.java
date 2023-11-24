package com.faas.core.base.framework.utility.system;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.utility.system.dto.SystemInfoWSDTO;
import com.faas.core.base.repo.asset.content.AssetRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.remote.RemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.details.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.flow.ProcessFlowRepository;
import com.faas.core.base.repo.process.details.inquiry.ProcessInquiryRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UtilitySystemFramework {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationScenarioRepository operationScenarioRepository;

    @Autowired
    OperationEmailMessageRepository operationEmailMessageRepository;

    @Autowired
    OperationPushMessageRepository operationPushMessageRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    OperationFlowRepository operationFlowRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    ProcessFlowRepository processFlowRepository;

    @Autowired
    ProcessInquiryRepository processInquiryRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    AiTriggerRepository aiTriggerRepository;

    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    SipCallTriggerRepository sipCallTriggerRepository;

    @Autowired
    SmsMessageTriggerRepository smsMessageTriggerRepository;

    @Autowired
    WappCallTriggerRepository wappCallTriggerRepository;

    @Autowired
    WappMessageTriggerRepository wappMessageTriggerRepository;

    @Autowired
    AppUtils appUtils;

    public SystemInfoWSDTO fillSystemInfoWSDTO(String infoName,String infoValue,boolean infoState){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(infoName);
        systemInfoWSDTO.setInfoValue(infoValue);
        systemInfoWSDTO.setInfoState(infoState);

        return systemInfoWSDTO;
    }


    public List<SystemInfoWSDTO> getSystemInfosService(long userId) {

        List<SystemInfoWSDTO>systemInfoWSDTOS  = new ArrayList<>();

        systemInfoWSDTOS.add(getClientsInfos());
        systemInfoWSDTOS.add(getSessionsInfos());
        systemInfoWSDTOS.add(getOperationsInfos());
        systemInfoWSDTOS.add(getOperationInquiriesInfos());
        systemInfoWSDTOS.add(getOperationFlowsInfos());

        systemInfoWSDTOS.add(getCampaignsInfos());
        systemInfoWSDTOS.add(getProcessesInfos());
        systemInfoWSDTOS.add(getScenariosInfos());

        systemInfoWSDTOS.add(getUsersInfos());
        systemInfoWSDTOS.add(getAgentsInfos());
        systemInfoWSDTOS.add(getAssetsInfos());

        return systemInfoWSDTOS;
    }



    public SystemInfoWSDTO getClientsInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.CLIENTS_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(clientRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }

    public SystemInfoWSDTO getSessionsInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.SESSIONS_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(sessionRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }

    public SystemInfoWSDTO getOperationsInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.OPERATIONS_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(operationRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }

    public SystemInfoWSDTO getOperationInquiriesInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.OPERATION_INQUIRIES_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(operationInquiryRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }

    public SystemInfoWSDTO getOperationFlowsInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.OPERATION_FLOWS_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(operationFlowRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }


    public SystemInfoWSDTO getCampaignsInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.CAMPAIGNS_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(campaignRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }

    public SystemInfoWSDTO getProcessesInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.PROCESSES_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(processRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }

    public SystemInfoWSDTO getScenariosInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.SCENARIOS_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(scenarioRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }

    public SystemInfoWSDTO getUsersInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.USERS_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(userRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }

    public SystemInfoWSDTO getAgentsInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.AGENTS_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(userRepository.countByUserType(AppConstant.AGENT_USER)));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }

    public SystemInfoWSDTO getAssetsInfos(){

        SystemInfoWSDTO systemInfoWSDTO = new SystemInfoWSDTO();
        systemInfoWSDTO.setInfoName(AppConstant.ASSETS_INFOS);
        systemInfoWSDTO.setInfoValue(String.valueOf(assetRepository.count()));
        systemInfoWSDTO.setInfoState(true);
        return systemInfoWSDTO;
    }


    public SystemInfoWSDTO repairSystemInfoService(long userId,String systemInfo) {

        if (systemInfo.equalsIgnoreCase(AppConstant.CLIENTS_INFOS)){
            repairAllClientsService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(clientRepository.count()),true);
        }
        return null;
    }

    public void repairAllClientsService(){

    }



    public SystemInfoWSDTO removeSystemInfoService(long userId,String systemInfo) {

        if (systemInfo.equalsIgnoreCase(AppConstant.CLIENTS_INFOS)){
            removeAllClientsService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(clientRepository.count()),true);
        }
        if (systemInfo.equalsIgnoreCase(AppConstant.SESSIONS_INFOS)){
            removeAllSessionsService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(sessionRepository.count()),true);
        }
        if (systemInfo.equalsIgnoreCase(AppConstant.OPERATIONS_INFOS)){
            removeAllOperationsService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(operationRepository.count()),true);
        }
        if (systemInfo.equalsIgnoreCase(AppConstant.OPERATION_INQUIRIES_INFOS)){
            removeAllOperationInquiriesService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(operationInquiryRepository.count()),true);
        }
        if (systemInfo.equalsIgnoreCase(AppConstant.OPERATION_FLOWS_INFOS)){
            removeAllOperationFlowsService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(operationFlowRepository.count()),true);
        }


        if (systemInfo.equalsIgnoreCase(AppConstant.CAMPAIGNS_INFOS)){
            removeAllCampaignsService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(campaignRepository.count()),true);
        }
        if (systemInfo.equalsIgnoreCase(AppConstant.PROCESSES_INFOS)){
            removeAllProcessesService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(processRepository.count()),true);
        }
        if (systemInfo.equalsIgnoreCase(AppConstant.SCENARIOS_INFOS)){
            removeAllScenariosService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(scenarioRepository.count()),true);
        }

        if (systemInfo.equalsIgnoreCase(AppConstant.USERS_INFOS)){
            removeAllUsersService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(userRepository.count()),true);
        }
        if (systemInfo.equalsIgnoreCase(AppConstant.AGENTS_INFOS)){
            removeAllAgentsService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(userRepository.countByUserType(AppConstant.AGENT_USER)),true);
        }
        if (systemInfo.equalsIgnoreCase(AppConstant.ASSETS_INFOS)){
            removeAllAssetsService();
            return fillSystemInfoWSDTO(systemInfo, String.valueOf(assetRepository.count()),true);
        }
        return null;
    }




    public void removeAllClientsService(){

        clientRepository.deleteAll();
        clientAddressRepository.deleteAll();
        clientDataRepository.deleteAll();
        clientEmailRepository.deleteAll();
        clientNoteRepository.deleteAll();
        clientPhoneRepository.deleteAll();
        remoteRepository.deleteAll();
        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        operationScenarioRepository.deleteAll();
        operationEmailMessageRepository.deleteAll();
        operationPushMessageRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        operationSmsMessageRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
        operationFlowRepository.deleteAll();
        operationInquiryRepository.deleteAll();
    }

    public void removeAllSessionsService(){

        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        operationScenarioRepository.deleteAll();
        operationEmailMessageRepository.deleteAll();
        operationPushMessageRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        operationSmsMessageRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
        operationFlowRepository.deleteAll();
        operationInquiryRepository.deleteAll();
        resetAllClientsService();
    }


    public void removeAllOperationsService(){

        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        operationScenarioRepository.deleteAll();
        operationEmailMessageRepository.deleteAll();
        operationPushMessageRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        operationSmsMessageRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
        operationFlowRepository.deleteAll();
        operationInquiryRepository.deleteAll();
        resetAllClientsService();
    }


    public void removeAllOperationInquiriesService(){

    }

    public void removeAllOperationFlowsService(){

    }

    public void resetAllClientsService(){

        Iterable<ClientDBModel> clientDBModels = clientRepository.findAll();
        for (ClientDBModel clientDBModel : clientDBModels) {
            clientDBModel.setClientState(AppConstant.READY_CLIENT);
            clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel);
        }
    }


    public void removeAllCampaignsService(){

        campaignRepository.deleteAll();
        campaignAgentRepository.deleteAll();
    }

    public void removeAllProcessesService(){

        processRepository.deleteAll();
        processEmailChannelRepository.deleteAll();
        processPushChannelRepository.deleteAll();
        processSipChannelRepository.deleteAll();
        processSmsChannelRepository.deleteAll();
        processWappChannelRepository.deleteAll();
        emailTempRepository.deleteAll();
        pushTempRepository.deleteAll();
        smsMessageTempRepository.deleteAll();
        wappMessageTempRepository.deleteAll();
        processFlowRepository.deleteAll();
        processInquiryRepository.deleteAll();
        processScenarioRepository.deleteAll();
        removeAllTriggers();
    }

    public void removeAllTriggers(){

        aiTriggerRepository.deleteAll();
        emailTriggerRepository.deleteAll();
        sipCallTriggerRepository.deleteAll();
        smsMessageTriggerRepository.deleteAll();
        wappCallTriggerRepository.deleteAll();
        wappMessageTriggerRepository.deleteAll();
    }

    public void removeAllScenariosService(){

        scenarioRepository.deleteAll();
    }


    public void removeAllUsersService(){

        userRepository.deleteAll();
        userDetailsRepository.deleteAll();
        campaignAgentRepository.deleteAll();
    }

    public void removeAllAgentsService(){

        List<UserDBModel> userDBModels = userRepository.findByUserType(AppConstant.AGENT_USER);
        for (UserDBModel userDBModel : userDBModels) {
            userDetailsRepository.deleteAll(userDetailsRepository.findByUserId(userDBModel.getId()));
            campaignAgentRepository.deleteAll();
            userRepository.delete(userDBModel);
        }
    }

    public void removeAllAssetsService(){

        assetRepository.deleteAll();
    }


}
