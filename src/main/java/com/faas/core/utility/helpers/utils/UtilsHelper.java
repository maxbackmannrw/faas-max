package com.faas.core.utility.helpers.utils;

import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.dao.ClientAddressDAO;
import com.faas.core.base.model.db.client.details.dao.ClientEmailDAO;
import com.faas.core.base.model.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import com.faas.core.base.model.db.user.settings.UserRoleDBModel;
import com.faas.core.base.model.ws.utils.content.dto.SystemInitWSDTO;
import com.faas.core.base.model.ws.utils.content.dto.SystemContentWSDTO;
import com.faas.core.base.repo.utils.asset.content.AssetRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.process.details.trigger.*;
import com.faas.core.base.repo.remote.client.ClientRemoteRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.base.repo.user.settings.UserRoleRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.client.ClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UtilsHelper {

    @Autowired
    ClientHelper clientHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    ClientRemoteRepository clientRemoteRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationEmailRepository operationEmailRepository;

    @Autowired
    OperationPushRepository operationPushRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationSmsRepository operationSmsRepository;

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
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

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
    AITriggerRepository AITriggerRepository;

    @Autowired
    EmailTriggerRepository emailTriggerRepository;

    @Autowired
    SipTriggerRepository sipTriggerRepository;

    @Autowired
    SmsTriggerRepository smsTriggerRepository;

    @Autowired
    WappCallTriggerRepository wappCallTriggerRepository;

    @Autowired
    WappMessageTriggerRepository wappMessageTriggerRepository;

    @Autowired
    AppUtils appUtils;


    public SystemInitWSDTO initSystemContentServiceHelper(){

        checkUserRolesAndReset();
        initializeUserRolesHelper();
        checkUsersAndReset();
        initUsersHelper();
        return new SystemInitWSDTO(AppConstant.FIRST_TIME_INIT,AppConstant.FIRST_TIME_INIT,true);
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

    public void initUsersHelper(){
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
        userDetailsDBModel.setOperationLimit(0);
        userDetailsDBModel.setuDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setcDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setStatus(1);

        userDetailsRepository.save(userDetailsDBModel);
    }


    public List<SystemContentWSDTO> getSystemContentsServiceHelper(long userId){

        List<SystemContentWSDTO> systemContentWSDTOS = new ArrayList<>();
        systemContentWSDTOS.add(getClientContentsHelper());
        systemContentWSDTOS.add(getSessionContentsHelper());
        systemContentWSDTOS.add(getOperationContentsHelper());

        systemContentWSDTOS.add(getCampaignContentsHelper());
        systemContentWSDTOS.add(getProcessContentsHelper());
        systemContentWSDTOS.add(getScenarioContentsHelper());

        systemContentWSDTOS.add(getUserContentsHelper());
        systemContentWSDTOS.add(getAgentContentsHelper());
        systemContentWSDTOS.add(getAssetContentsHelper());

        return systemContentWSDTOS;
    }


    public SystemContentWSDTO getClientContentsHelper(){

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.CLIENT_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(clientRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getSessionContentsHelper(){

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.SESSION_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(sessionRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getOperationContentsHelper(){

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.OPERATION_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(operationRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getCampaignContentsHelper(){

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.CAMPAIGN_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(campaignRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getProcessContentsHelper(){

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.PROCESS_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(processRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getScenarioContentsHelper(){

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.SCENARIO_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(scenarioRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getUserContentsHelper(){

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.USER_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(userRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getAgentContentsHelper(){

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.AGENT_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(userRepository.countByUserType(AppConstant.AGENT_USER)));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getAssetContentsHelper(){

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.ASSET_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(assetRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }


    public void recoverClientContentsHelper(){

        clientRepository.findAll().forEach(clientDBModel -> {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientDBModel.getId());
            if (!clientDetailsDBModels.isEmpty()){

                ClientDetailsDBModel clientDetailsDBModel = clientDetailsDBModels.get(0);
                if (clientDetailsDBModel.getClientAddresses() == null){
                    clientDetailsDBModel.setClientAddresses(new ArrayList<>());
                }
                clientDetailsDBModel.setClientAddresses(checkAndUpdateClientAddressesHelper(clientDBModel,clientDetailsDBModel.getClientAddresses()));

                if (clientDetailsDBModel.getClientPhones() == null){
                    clientDetailsDBModel.setClientPhones(new ArrayList<>());
                }
                clientDetailsDBModel.setClientPhones(checkAndUpdateClientPhonesHelper(clientDBModel,clientDetailsDBModel.getClientPhones()));

                if (clientDetailsDBModel.getClientEmails() == null){
                    clientDetailsDBModel.setClientEmails(new ArrayList<>());
                }
                clientDetailsDBModel.setClientEmails(checkAndUpdateClientEmailsHelper(clientDBModel,clientDetailsDBModel.getClientEmails()));
                clientDetailsDBModel.setuDate(appUtils.getCurrentTimeStamp());

                clientDetailsRepository.save(clientDetailsDBModel);
            }
        });
    }

    public List<ClientAddressDAO> checkAndUpdateClientAddressesHelper(ClientDBModel clientDBModel, List<ClientAddressDAO> clientAddressDAOS) {

        List<ClientAddressDAO> checkedAddressDAOS = new ArrayList<>();
        for (ClientAddressDAO clientAddressDAO : clientAddressDAOS) {
            if (clientAddressDAO.getAddressType() != null &&clientAddressDAO.getAddressType().equalsIgnoreCase(AppConstant.SUB_TYPE)) {
                checkedAddressDAOS.add(clientAddressDAO);
            }
        }
        if (clientDBModel.getClientCity() != null && !"".equalsIgnoreCase(clientDBModel.getClientCity()) && clientDBModel.getClientCountry() != null && !"".equalsIgnoreCase(clientDBModel.getClientCountry())){
            checkedAddressDAOS.add(clientHelper.createClientAddressDAO(AppConstant.NONE,clientDBModel.getClientCity(),AppConstant.NONE,AppConstant.NONE,clientDBModel.getClientCountry(),AppConstant.MAIN_TYPE));
        }
        return checkedAddressDAOS;
    }


    public List<ClientPhoneDAO> checkAndUpdateClientPhonesHelper(ClientDBModel clientDBModel, List<ClientPhoneDAO> clientPhoneDAOS) {

        List<ClientPhoneDAO> checkedPhoneDAOS = new ArrayList<>();
        for (ClientPhoneDAO clientPhoneDAO : clientPhoneDAOS) {
            if (clientPhoneDAO.getPhoneType() != null && clientPhoneDAO.getPhoneType().equalsIgnoreCase(AppConstant.SUB_TYPE)) {
                checkedPhoneDAOS.add(clientPhoneDAO);
            }
        }
        if (clientDBModel.getPhoneNumber() != null && !"".equalsIgnoreCase(clientDBModel.getPhoneNumber())){
            checkedPhoneDAOS.add(clientHelper.createClientPhoneDAO(clientDBModel.getPhoneNumber(),AppConstant.NONE,AppConstant.MAIN_TYPE));
        }
        return checkedPhoneDAOS;
    }

    public List<ClientEmailDAO> checkAndUpdateClientEmailsHelper(ClientDBModel clientDBModel, List<ClientEmailDAO> clientEmailDAOS) {

        List<ClientEmailDAO> checkedEmailDAOS = new ArrayList<>();
        for (ClientEmailDAO clientEmailDAO : clientEmailDAOS) {
            if (clientEmailDAO.getEmailType() != null && clientEmailDAO.getEmailType().equalsIgnoreCase(AppConstant.SUB_TYPE)) {
                checkedEmailDAOS.add(clientEmailDAO);
            }
        }
        if (clientDBModel.getEmailAddress() != null && !"".equalsIgnoreCase(clientDBModel.getEmailAddress())){
            checkedEmailDAOS.add(clientHelper.createClientEmailDAO(clientDBModel.getEmailAddress(),AppConstant.MAIN_TYPE));
        }
        return checkedEmailDAOS;
    }


    public void recoverAgentContentsHelper(){

        List<UserDBModel> userDBModels = userRepository.findByUserType(AppConstant.AGENT_USER);
        for (UserDBModel userDBModel : userDBModels) {
            List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByAgentId(userDBModel.getId());
            for (CampaignAgentDBModel campaignAgentDBModel : campaignAgentDBModels) {
                if (!campaignRepository.existsById(campaignAgentDBModel.getCampaignId())) {
                    campaignAgentRepository.delete(campaignAgentDBModel);
                }
            }
        }
        List<UserDetailsDBModel> userDetailsDBModels = userDetailsRepository.findAll();
        for (UserDetailsDBModel userDetailsDBModel : userDetailsDBModels) {
            if (!userRepository.existsById(userDetailsDBModel.getUserId())) {
                userDetailsRepository.delete(userDetailsDBModel);
            }
        }

    }


    public void removeAllClientContentsHelper(){

        clientRepository.deleteAll();
        clientRemoteRepository.deleteAll();
        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        operationEmailRepository.deleteAll();
        operationPushRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        operationSmsRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
    }

    public void removeAllSessionContentsHelper(){

        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        operationEmailRepository.deleteAll();
        operationPushRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        operationSmsRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
        resetAllClientsHelper();
    }

    public void removeAllOperationContentsHelper(){

        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        operationEmailRepository.deleteAll();
        operationPushRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        operationSmsRepository.deleteAll();
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


    public void removeAllCampaignContentsHelper(){
        campaignRepository.deleteAll();
        campaignAgentRepository.deleteAll();
    }

    public void removeAllProcessContentsHelper(){

        processRepository.deleteAll();
        processEmailChannelRepository.deleteAll();
        processPushChannelRepository.deleteAll();
        processSipChannelRepository.deleteAll();
        processSmsChannelRepository.deleteAll();
        processWappChannelRepository.deleteAll();
        emailTempRepository.deleteAll();
        pushTempRepository.deleteAll();
        smsTempRepository.deleteAll();
        wappMessageTempRepository.deleteAll();
        processScenarioRepository.deleteAll();
        removeAllTriggersHelper();
    }

    public void removeAllTriggersHelper(){

        AITriggerRepository.deleteAll();
        emailTriggerRepository.deleteAll();
        sipTriggerRepository.deleteAll();
        smsTriggerRepository.deleteAll();
        wappCallTriggerRepository.deleteAll();
        wappMessageTriggerRepository.deleteAll();
    }

    public void removeAllScenarioContentsHelper(){
        scenarioRepository.deleteAll();
    }


    public void removeAllUserContentsHelper(){

        userRepository.deleteAll();
        userDetailsRepository.deleteAll();
        campaignAgentRepository.deleteAll();
    }

    public void removeAllAgentContentsHelper(){

        List<UserDBModel> userDBModels = userRepository.findByUserType(AppConstant.AGENT_USER);
        for (UserDBModel userDBModel : userDBModels) {
            userDetailsRepository.deleteAll(userDetailsRepository.findByUserId(userDBModel.getId()));
            campaignAgentRepository.deleteAll();
            userRepository.delete(userDBModel);
        }
    }

    public void removeAllAssetContentsHelper(){
        assetRepository.deleteAll();
    }



}
