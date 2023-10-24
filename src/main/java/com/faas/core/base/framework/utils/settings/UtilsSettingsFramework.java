package com.faas.core.base.framework.utils.settings;

import com.faas.core.base.model.ws.utils.settings.dto.UtilSettingsWSDTO;
import com.faas.core.base.repo.assets.content.AssetRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UtilsSettingsFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    OperationFlowRepository operationFlowRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    AssetRepository assetRepository;


    public List<UtilSettingsWSDTO> getAllSystemSettingsService(long userId) {

        List<UtilSettingsWSDTO>systemSettingsWSDTOS  = new ArrayList<>();
        systemSettingsWSDTOS.add(getClientsSettings());
        systemSettingsWSDTOS.add(getSessionsSettings());
        systemSettingsWSDTOS.add(getOperationsSettings());
        systemSettingsWSDTOS.add(getOperationInquiriesSettings());
        systemSettingsWSDTOS.add(getOperationFlowsSettings());

        systemSettingsWSDTOS.add(getCampaignsSettings());
        systemSettingsWSDTOS.add(getProcessesSettings());
        systemSettingsWSDTOS.add(getProcessScenariosSettings());

        systemSettingsWSDTOS.add(getUsersSettings());
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

    public UtilSettingsWSDTO getProcessScenariosSettings(){

        UtilSettingsWSDTO processScenariosSettings = new UtilSettingsWSDTO();
        processScenariosSettings.setSettingsName(AppConstant.PROCESS_SCENARIOS_SETTINGS);
        processScenariosSettings.setSettingsValue(String.valueOf(processScenarioRepository.count()));
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

    public UtilSettingsWSDTO getAssetsSettings(){

        UtilSettingsWSDTO assetsSettings = new UtilSettingsWSDTO();
        assetsSettings.setSettingsName(AppConstant.ASSETS_SETTINGS);
        assetsSettings.setSettingsValue(String.valueOf(assetRepository.count()));
        assetsSettings.setSettingsState(true);
        return assetsSettings;
    }



    public List<UtilSettingsWSDTO> removeSystemSettingsService(long userId,String systemSettings) {

        if (systemSettings.equalsIgnoreCase(AppConstant.CLIENTS_SETTINGS)){

        }

        if (systemSettings.equalsIgnoreCase(AppConstant.SESSIONS_SETTINGS)){

        }

        if (systemSettings.equalsIgnoreCase(AppConstant.OPERATIONS_SETTINGS)){

        }

        if (systemSettings.equalsIgnoreCase(AppConstant.OPERATION_INQUIRIES_SETTINGS)){

        }

        if (systemSettings.equalsIgnoreCase(AppConstant.OPERATION_FLOWS_SETTINGS)){

        }

        return null;
    }




    public boolean removeAllClientSettings(){
        return true;
    }

    public boolean removeAllSessionSettings(){
        return true;
    }

    public boolean removeAllOperationSettings(){
        return true;
    }

    public boolean removeAllOperationInquirySettings(){
        return true;
    }

    public boolean removeAllOperationFlowSettings(){
        return true;
    }



}
