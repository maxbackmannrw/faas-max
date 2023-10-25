package com.faas.core.base.framework.utils.settings;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.ws.utils.settings.dto.UtilSettingsWSDTO;
import com.faas.core.base.repo.assets.content.AssetRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.operation.channel.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.flow.ProcessFlowRepository;
import com.faas.core.base.repo.process.details.inquiry.ProcessInquiryRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.ProcessTriggerRepository;
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
public class UtilsSettingsFramework {

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
    ProcessTriggerRepository processTriggerRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    AppUtils appUtils;


    public List<UtilSettingsWSDTO> getAllSystemSettingsService(long userId) {

        List<UtilSettingsWSDTO>systemSettingsWSDTOS  = new ArrayList<>();

        systemSettingsWSDTOS.add(getClientsSettings());
        systemSettingsWSDTOS.add(getSessionsSettings());
        systemSettingsWSDTOS.add(getOperationsSettings());
        systemSettingsWSDTOS.add(getOperationInquiriesSettings());
        systemSettingsWSDTOS.add(getOperationFlowsSettings());

        systemSettingsWSDTOS.add(getCampaignsSettings());
        systemSettingsWSDTOS.add(getProcessesSettings());
        systemSettingsWSDTOS.add(getScenariosSettings());

        systemSettingsWSDTOS.add(getUsersSettings());
        systemSettingsWSDTOS.add(getAgentsSettings());
        systemSettingsWSDTOS.add(getAssetsSettings());

        return systemSettingsWSDTOS;
    }



    public UtilSettingsWSDTO getClientsSettings(){

        UtilSettingsWSDTO clientSettings = new UtilSettingsWSDTO();
        clientSettings.setSettingsName(AppConstant.CLIENTS_SETTINGS);
        clientSettings.setSettingsValue(String.valueOf(clientRepository.count()));
        clientSettings.setSettingsState(true);
        return clientSettings;
    }

    public UtilSettingsWSDTO getSessionsSettings(){

        UtilSettingsWSDTO sessionsSettings = new UtilSettingsWSDTO();
        sessionsSettings.setSettingsName(AppConstant.SESSIONS_SETTINGS);
        sessionsSettings.setSettingsValue(String.valueOf(sessionRepository.count()));
        sessionsSettings.setSettingsState(true);
        return sessionsSettings;
    }

    public UtilSettingsWSDTO getOperationsSettings(){

        UtilSettingsWSDTO operationsSettings = new UtilSettingsWSDTO();
        operationsSettings.setSettingsName(AppConstant.OPERATIONS_SETTINGS);
        operationsSettings.setSettingsValue(String.valueOf(operationRepository.count()));
        operationsSettings.setSettingsState(true);
        return operationsSettings;
    }

    public UtilSettingsWSDTO getOperationInquiriesSettings(){

        UtilSettingsWSDTO operationInquiriesSettings = new UtilSettingsWSDTO();
        operationInquiriesSettings.setSettingsName(AppConstant.OPERATION_INQUIRIES_SETTINGS);
        operationInquiriesSettings.setSettingsValue(String.valueOf(operationInquiryRepository.count()));
        operationInquiriesSettings.setSettingsState(true);
        return operationInquiriesSettings;
    }

    public UtilSettingsWSDTO getOperationFlowsSettings(){

        UtilSettingsWSDTO operationFlowsSettings = new UtilSettingsWSDTO();
        operationFlowsSettings.setSettingsName(AppConstant.OPERATION_FLOWS_SETTINGS);
        operationFlowsSettings.setSettingsValue(String.valueOf(operationFlowRepository.count()));
        operationFlowsSettings.setSettingsState(true);
        return operationFlowsSettings;
    }


    public UtilSettingsWSDTO getCampaignsSettings(){

        UtilSettingsWSDTO campaignsSettings = new UtilSettingsWSDTO();
        campaignsSettings.setSettingsName(AppConstant.CAMPAIGNS_SETTINGS);
        campaignsSettings.setSettingsValue(String.valueOf(campaignRepository.count()));
        campaignsSettings.setSettingsState(true);
        return campaignsSettings;
    }

    public UtilSettingsWSDTO getProcessesSettings(){

        UtilSettingsWSDTO processesSettings = new UtilSettingsWSDTO();
        processesSettings.setSettingsName(AppConstant.PROCESSES_SETTINGS);
        processesSettings.setSettingsValue(String.valueOf(processRepository.count()));
        processesSettings.setSettingsState(true);
        return processesSettings;
    }

    public UtilSettingsWSDTO getScenariosSettings(){

        UtilSettingsWSDTO processScenariosSettings = new UtilSettingsWSDTO();
        processScenariosSettings.setSettingsName(AppConstant.SCENARIOS_SETTINGS);
        processScenariosSettings.setSettingsValue(String.valueOf(scenarioRepository.count()));
        processScenariosSettings.setSettingsState(true);
        return processScenariosSettings;
    }

    public UtilSettingsWSDTO getUsersSettings(){

        UtilSettingsWSDTO usersSettings = new UtilSettingsWSDTO();
        usersSettings.setSettingsName(AppConstant.USERS_SETTINGS);
        usersSettings.setSettingsValue(String.valueOf(userRepository.count()));
        usersSettings.setSettingsState(true);
        return usersSettings;
    }

    public UtilSettingsWSDTO getAgentsSettings(){

        UtilSettingsWSDTO usersSettings = new UtilSettingsWSDTO();
        usersSettings.setSettingsName(AppConstant.AGENTS_SETTINGS);
        usersSettings.setSettingsValue(String.valueOf(userRepository.countByUserType(AppConstant.AGENT_USER)));
        usersSettings.setSettingsState(true);
        return usersSettings;
    }

    public UtilSettingsWSDTO getAssetsSettings(){

        UtilSettingsWSDTO assetsSettings = new UtilSettingsWSDTO();
        assetsSettings.setSettingsName(AppConstant.ASSETS_SETTINGS);
        assetsSettings.setSettingsValue(String.valueOf(assetRepository.count()));
        assetsSettings.setSettingsState(true);
        return assetsSettings;
    }


    public boolean removeSystemSettingsService(long userId,String systemSettings) {

        if (systemSettings.equalsIgnoreCase(AppConstant.CLIENTS_SETTINGS)){
            removeAllClientsService();
            return true;
        }
        if (systemSettings.equalsIgnoreCase(AppConstant.SESSIONS_SETTINGS)){
            removeAllSessionsService();
            return true;
        }
        if (systemSettings.equalsIgnoreCase(AppConstant.OPERATIONS_SETTINGS)){
            removeAllOperationsService();
            return true;
        }
        if (systemSettings.equalsIgnoreCase(AppConstant.OPERATION_INQUIRIES_SETTINGS)){
            removeAllOperationInquiriesService();
            return true;
        }
        if (systemSettings.equalsIgnoreCase(AppConstant.OPERATION_FLOWS_SETTINGS)){
            removeAllOperationFlowsService();
            return true;
        }


        if (systemSettings.equalsIgnoreCase(AppConstant.CAMPAIGNS_SETTINGS)){
            removeAllCampaignsService();
            return true;
        }
        if (systemSettings.equalsIgnoreCase(AppConstant.PROCESSES_SETTINGS)){
            removeAllProcessesService();
            return true;
        }
        if (systemSettings.equalsIgnoreCase(AppConstant.SCENARIOS_SETTINGS)){
            removeAllScenariosService();
            return true;
        }

        if (systemSettings.equalsIgnoreCase(AppConstant.USERS_SETTINGS)){
            removeAllUsersService();
            return true;
        }
        if (systemSettings.equalsIgnoreCase(AppConstant.AGENTS_SETTINGS)){
            removeAllAgentsService();
            return true;
        }
        if (systemSettings.equalsIgnoreCase(AppConstant.ASSETS_SETTINGS)){
            removeAllAssetsService();
            return true;
        }
        return false;
    }


    public void removeAllClientsService(){

        clientRepository.deleteAll();
        clientAddressRepository.deleteAll();
        clientDataRepository.deleteAll();
        clientEmailRepository.deleteAll();
        clientNoteRepository.deleteAll();
        clientPhoneRepository.deleteAll();
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
        processTriggerRepository.deleteAll();
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
