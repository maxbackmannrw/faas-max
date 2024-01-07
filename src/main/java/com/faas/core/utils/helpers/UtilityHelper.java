package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.model.db.user.settings.UserRoleDBModel;
import com.faas.core.base.model.ws.utility.system.dto.InitSystemUtilityWSDTO;
import com.faas.core.base.model.ws.utility.system.dto.SystemUtilityWSDTO;
import com.faas.core.base.repo.asset.content.AssetRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.ProcessEmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessSmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessWappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.remote.app.RemoteAppRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.base.repo.user.settings.UserRoleRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UtilityHelper {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

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
    ProcessEmailTempRepository processEmailTempRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    ProcessSmsMessageTempRepository processSmsMessageTempRepository;

    @Autowired
    ProcessWappMessageTempRepository processWappMessageTempRepository;

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
    UserRoleRepository userRoleRepository;

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


    public InitSystemUtilityWSDTO firstTimeInitSystemUtilityHelper(){

        checkUserRolesAndReset();
        initializeUserRolesHelper();
        checkUsersAndReset();
        initializeUsersHelper();
        return new InitSystemUtilityWSDTO(AppConstant.FIRST_TIME_INIT,AppConstant.FIRST_TIME_INIT,true);
    }

    public void checkUserRolesAndReset(){

        if (userRoleRepository.count()>0){
            userRoleRepository.deleteAll(userRoleRepository.findAll());
        }
    }

    public void initializeUserRolesHelper(){
        userRoleRepository.save(createUserRolesHelper(AppConstant.SUPER_MANAGER,AppConstant.MANAGER_USER));
        userRoleRepository.save(createUserRolesHelper(AppConstant.BASIC_MANAGER,AppConstant.MANAGER_USER));
        userRoleRepository.save(createUserRolesHelper(AppConstant.BASIC_AGENT,AppConstant.AGENT_USER));
        userRoleRepository.save(createUserRolesHelper(AppConstant.SUPER_AGENT,AppConstant.AGENT_USER));
        userRoleRepository.save(createUserRolesHelper(AppConstant.AUTO_AGENT,AppConstant.AGENT_USER));
    }

    public UserRoleDBModel createUserRolesHelper(String userRole,String userType){

        UserRoleDBModel userRoleDBModel = new UserRoleDBModel();
        userRoleDBModel.setUserRole(userRole);
        userRoleDBModel.setUserType(userType);
        userRoleDBModel.setuDate(appUtils.getCurrentTimeStamp());
        userRoleDBModel.setcDate(appUtils.getCurrentTimeStamp());
        userRoleDBModel.setStatus(1);

        return userRoleDBModel;
    }

    public void checkUsersAndReset(){

        List<UserDBModel> managerUsers = userRepository.findByUserType(AppConstant.MANAGER_USER);
        if (!managerUsers.isEmpty()){
            userRepository.deleteAll(managerUsers);
            for (UserDBModel managerUser : managerUsers) {
                userDetailsRepository.deleteAll(userDetailsRepository.findByUserId(managerUser.getId()));
            }
        }
    }

    public void initializeUsersHelper(){

        createUserHelper(AppConstant.DEFAULT_MANAGER_NAME, AppConstant.DEFAULT_MANAGER_EMAIL, AppConstant.DEFAULT_MANAGER_PASSWORD,AppConstant.SUPER_MANAGER );
    }

    public void createUserHelper(String userName,String userEmail,String password,String userRole){

        List<UserRoleDBModel> userRoleDBModels = userRoleRepository.findByUserRole(userRole);
        if (!userRoleDBModels.isEmpty()){

            UserDBModel userDBModel = new UserDBModel();

            userDBModel.setUserName(userName);
            userDBModel.setUserEmail(userEmail.toLowerCase());
            userDBModel.setPassword(appUtils.base64Encoder(password));
            userDBModel.setRoleId(userRoleDBModels.get(0).getId());
            userDBModel.setUserRole(userRoleDBModels.get(0).getUserRole());
            userDBModel.setUserType(userRoleDBModels.get(0).getUserType());
            userDBModel.setValidUser(true);
            userDBModel.setuDate(appUtils.getCurrentTimeStamp());
            userDBModel.setcDate(appUtils.getCurrentTimeStamp());
            userDBModel.setStatus(1);

            createUserDetailsHelper(userRepository.save(userDBModel));
        }
    }

    public void createUserDetailsHelper(UserDBModel userDBModel){

        UserDetailsDBModel userDetailsDBModel = new UserDetailsDBModel();
        userDetailsDBModel.setUserId(userDBModel.getId());
        userDetailsDBModel.setUserDatas(new ArrayList<>());
        userDetailsDBModel.setuDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setcDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setStatus(1);

        userDetailsRepository.save(userDetailsDBModel);
    }




    public SystemUtilityWSDTO fillSystemUtilityWSDTO(String utilityName, String utilityValue, boolean utilityState){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(utilityName);
        systemUtilityWSDTO.setUtilityValue(utilityValue);
        systemUtilityWSDTO.setUtilityState(utilityState);

        return systemUtilityWSDTO;
    }

    public List<SystemUtilityWSDTO> getSystemUtilitiesHelper(long userId){

        List<SystemUtilityWSDTO> systemUtilityWSDTOS = new ArrayList<>();
        systemUtilityWSDTOS.add(getClientUtils());
        systemUtilityWSDTOS.add(getSessionUtils());
        systemUtilityWSDTOS.add(getOperationUtils());

        systemUtilityWSDTOS.add(getCampaignUtils());
        systemUtilityWSDTOS.add(getProcessUtils());
        systemUtilityWSDTOS.add(getScenarioUtils());

        systemUtilityWSDTOS.add(getUserUtils());
        systemUtilityWSDTOS.add(getAgentUtils());
        systemUtilityWSDTOS.add(getAssetUtils());

        return systemUtilityWSDTOS;
    }


    public SystemUtilityWSDTO getClientUtils(){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(AppConstant.CLIENT_UTILS);
        systemUtilityWSDTO.setUtilityValue(String.valueOf(clientRepository.count()));
        systemUtilityWSDTO.setUtilityState(true);
        return systemUtilityWSDTO;
    }

    public SystemUtilityWSDTO getSessionUtils(){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(AppConstant.SESSION_UTILS);
        systemUtilityWSDTO.setUtilityValue(String.valueOf(sessionRepository.count()));
        systemUtilityWSDTO.setUtilityState(true);
        return systemUtilityWSDTO;
    }

    public SystemUtilityWSDTO getOperationUtils(){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(AppConstant.OPERATION_UTILS);
        systemUtilityWSDTO.setUtilityValue(String.valueOf(operationRepository.count()));
        systemUtilityWSDTO.setUtilityState(true);
        return systemUtilityWSDTO;
    }

    public SystemUtilityWSDTO getCampaignUtils(){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(AppConstant.CAMPAIGN_UTILS);
        systemUtilityWSDTO.setUtilityValue(String.valueOf(campaignRepository.count()));
        systemUtilityWSDTO.setUtilityState(true);
        return systemUtilityWSDTO;
    }

    public SystemUtilityWSDTO getProcessUtils(){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(AppConstant.PROCESS_UTILS);
        systemUtilityWSDTO.setUtilityValue(String.valueOf(processRepository.count()));
        systemUtilityWSDTO.setUtilityState(true);
        return systemUtilityWSDTO;
    }

    public SystemUtilityWSDTO getScenarioUtils(){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(AppConstant.SCENARIO_UTILS);
        systemUtilityWSDTO.setUtilityValue(String.valueOf(scenarioRepository.count()));
        systemUtilityWSDTO.setUtilityState(true);
        return systemUtilityWSDTO;
    }

    public SystemUtilityWSDTO getUserUtils(){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(AppConstant.USER_UTILS);
        systemUtilityWSDTO.setUtilityValue(String.valueOf(userRepository.count()));
        systemUtilityWSDTO.setUtilityState(true);
        return systemUtilityWSDTO;
    }

    public SystemUtilityWSDTO getAgentUtils(){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(AppConstant.AGENT_UTILS);
        systemUtilityWSDTO.setUtilityValue(String.valueOf(userRepository.countByUserType(AppConstant.AGENT_USER)));
        systemUtilityWSDTO.setUtilityState(true);
        return systemUtilityWSDTO;
    }

    public SystemUtilityWSDTO getAssetUtils(){

        SystemUtilityWSDTO systemUtilityWSDTO = new SystemUtilityWSDTO();
        systemUtilityWSDTO.setUtilityName(AppConstant.ASSET_UTILS);
        systemUtilityWSDTO.setUtilityValue(String.valueOf(assetRepository.count()));
        systemUtilityWSDTO.setUtilityState(true);
        return systemUtilityWSDTO;
    }





    public void removeAllClientsHelper(){

        clientRepository.deleteAll();
        remoteAppRepository.deleteAll();
        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        operationEmailMessageRepository.deleteAll();
        operationPushMessageRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        operationSmsMessageRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
    }

    public void removeAllSessionsHelper(){

        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        operationEmailMessageRepository.deleteAll();
        operationPushMessageRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        operationSmsMessageRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
        resetAllClientsHelper();
    }

    public void removeAllOperationsHelper(){

        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        operationEmailMessageRepository.deleteAll();
        operationPushMessageRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        operationSmsMessageRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
        resetAllClientsHelper();
    }


    public void resetAllClientsHelper(){

        Iterable<ClientDBModel> clientDBModels = clientRepository.findAll();
        for (ClientDBModel clientDBModel : clientDBModels) {
            clientDBModel.setClientState(AppConstant.READY_CLIENT);
            clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel);
        }
    }


    public void removeAllCampaignsHelper(){
        campaignRepository.deleteAll();
        campaignAgentRepository.deleteAll();
    }

    public void removeAllProcessesHelper(){

        processRepository.deleteAll();
        processEmailChannelRepository.deleteAll();
        processPushChannelRepository.deleteAll();
        processSipChannelRepository.deleteAll();
        processSmsChannelRepository.deleteAll();
        processWappChannelRepository.deleteAll();
        processEmailTempRepository.deleteAll();
        processPushTempRepository.deleteAll();
        processSmsMessageTempRepository.deleteAll();
        processWappMessageTempRepository.deleteAll();
        processScenarioRepository.deleteAll();
        removeAllTriggersHelper();
    }

    public void removeAllTriggersHelper(){

        aiTriggerRepository.deleteAll();
        emailTriggerRepository.deleteAll();
        sipCallTriggerRepository.deleteAll();
        smsMessageTriggerRepository.deleteAll();
        wappCallTriggerRepository.deleteAll();
        wappMessageTriggerRepository.deleteAll();
    }

    public void removeAllScenariosHelper(){
        scenarioRepository.deleteAll();
    }


    public void removeAllUsersHelper(){

        userRepository.deleteAll();
        userDetailsRepository.deleteAll();
        campaignAgentRepository.deleteAll();
    }

    public void removeAllAgentsHelper(){

        List<UserDBModel> userDBModels = userRepository.findByUserType(AppConstant.AGENT_USER);
        for (UserDBModel userDBModel : userDBModels) {
            userDetailsRepository.deleteAll(userDetailsRepository.findByUserId(userDBModel.getId()));
            campaignAgentRepository.deleteAll();
            userRepository.delete(userDBModel);
        }
    }

    public void removeAllAssetsHelper(){
        assetRepository.deleteAll();
    }



}
