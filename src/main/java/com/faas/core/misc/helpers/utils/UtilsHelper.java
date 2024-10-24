package com.faas.core.misc.helpers.utils;

import com.faas.core.data.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.client.details.dao.ClientAddressDAO;
import com.faas.core.data.db.client.details.dao.ClientEmailDAO;
import com.faas.core.data.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.db.user.details.UserDetailsDBModel;
import com.faas.core.data.db.user.settings.UserRoleDBModel;
import com.faas.core.base.model.ws.utils.content.dto.SystemContentWSDTO;
import com.faas.core.base.model.ws.utils.content.dto.SystemInitWSDTO;
import com.faas.core.data.repo.asset.content.AssetRepository;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.operation.details.channel.*;
import com.faas.core.data.repo.remoteapp.RemoteAppRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.data.repo.user.details.UserDetailsRepository;
import com.faas.core.data.repo.user.settings.UserRoleRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.client.ClientHelper;
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
    RemoteAppRepository remoteAppRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationEmailRepository operationEmailRepository;

    @Autowired
    OperationPushRepository operationPushRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    com.faas.core.data.repo.operation.details.channel.OperationSmsRepository OperationSmsRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    AppUtils appUtils;


    public SystemInitWSDTO initSystemContentHelper() {

        deleteUserRolesHelper();
        createUserRolesHelper();
        deleteUsersHelper();
        createUsersHelper();
        return new SystemInitWSDTO(AppConstant.FIRST_TIME_INIT, AppConstant.FIRST_TIME_INIT, true);
    }

    public void deleteUserRolesHelper() {

        userRoleRepository.deleteAll(userRoleRepository.findAll());
    }

    public void createUserRolesHelper() {

        userRoleRepository.save(createUserRoleDBModel(AppConstant.SUPER_MANAGER, AppConstant.MANAGER_USER));
        userRoleRepository.save(createUserRoleDBModel(AppConstant.BASIC_MANAGER, AppConstant.MANAGER_USER));
        userRoleRepository.save(createUserRoleDBModel(AppConstant.BASIC_AGENT, AppConstant.AGENT_USER));
        userRoleRepository.save(createUserRoleDBModel(AppConstant.SUPER_AGENT, AppConstant.AGENT_USER));
        userRoleRepository.save(createUserRoleDBModel(AppConstant.AUTO_AGENT, AppConstant.AGENT_USER));
    }

    public UserRoleDBModel createUserRoleDBModel(String userRole, String userType) {

        UserRoleDBModel userRoleDBModel = new UserRoleDBModel();
        userRoleDBModel.setUserRole(userRole);
        userRoleDBModel.setUserType(userType);
        userRoleDBModel.setuDate(appUtils.getCurrentTimeStamp());
        userRoleDBModel.setcDate(appUtils.getCurrentTimeStamp());
        userRoleDBModel.setStatus(1);

        return userRoleDBModel;
    }


    public void deleteUsersHelper() {

        userRepository.deleteAll(userRepository.findAll());
        userDetailsRepository.deleteAll(userDetailsRepository.findAll());
    }

    public void createUsersHelper() {
        UserDBModel managerUser = createUserDBModel(AppConstant.DEFAULT_MANAGER_NAME, AppConstant.DEFAULT_MANAGER_EMAIL, AppConstant.DEFAULT_MANAGER_PASSWORD, AppConstant.SUPER_MANAGER);
        if (managerUser != null) {
            userDetailsRepository.save(createUserDetailsDBModel(userRepository.save(managerUser)));
        }
        UserDBModel agentUser = createUserDBModel(AppConstant.DEFAULT_AGENT_NAME, AppConstant.DEFAULT_AGENT_EMAIL, AppConstant.DEFAULT_AGENT_PASSWORD, AppConstant.SUPER_AGENT);
        if (agentUser != null) {
            userDetailsRepository.save(createUserDetailsDBModel(userRepository.save(agentUser)));
        }
    }

    public UserDBModel createUserDBModel(String userName, String userEmail, String password, String userRole) {

        List<UserRoleDBModel> userRoleDBModels = userRoleRepository.findByUserRole(userRole);
        if (!userRoleDBModels.isEmpty()) {

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

            return userDBModel;
        }
        return null;
    }

    public UserDetailsDBModel createUserDetailsDBModel(UserDBModel userDBModel) {

        UserDetailsDBModel userDetailsDBModel = new UserDetailsDBModel();
        userDetailsDBModel.setUserId(userDBModel.getId());
        userDetailsDBModel.setUserDatas(new ArrayList<>());
        if (userDBModel.getUserRole().equalsIgnoreCase(AppConstant.BASIC_AGENT)) {
            userDetailsDBModel.setOperationLimit(AppConstant.BASIC_AGENT_OPERATION_LIMIT);
        }
        if (userDBModel.getUserRole().equalsIgnoreCase(AppConstant.SUPER_AGENT)) {
            userDetailsDBModel.setOperationLimit(AppConstant.SUPER_AGENT_OPERATION_LIMIT);
        }
        if (userDBModel.getUserRole().equalsIgnoreCase(AppConstant.BASIC_MANAGER)) {
            userDetailsDBModel.setOperationLimit(AppConstant.BASIC_MANAGER_OPERATION_LIMIT);
        }
        if (userDBModel.getUserRole().equalsIgnoreCase(AppConstant.SUPER_MANAGER)) {
            userDetailsDBModel.setOperationLimit(AppConstant.SUPER_MANAGER_OPERATION_LIMIT);
        }
        userDetailsDBModel.setuDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setcDate(appUtils.getCurrentTimeStamp());
        userDetailsDBModel.setStatus(1);

        return userDetailsDBModel;
    }


    public List<SystemContentWSDTO> getSystemContentsHelper(long userId) {

        List<SystemContentWSDTO> systemContents = new ArrayList<>();
        systemContents.add(getSystemClientsHelper());
        systemContents.add(getSystemOperationsHelper());
        systemContents.add(getSystemCampaignsHelper());
        systemContents.add(getSystemUsersHelper());
        systemContents.add(getSystemAgentsHelper());
        systemContents.add(getSystemAssetsHelper());

        return systemContents;
    }

    public SystemContentWSDTO getSystemClientsHelper() {

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.CLIENT_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(clientRepository.count()));
        systemContentWSDTO.setContentState(true);

        return systemContentWSDTO;
    }


    public SystemContentWSDTO getSystemOperationsHelper() {

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.OPERATION_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(operationRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getSystemCampaignsHelper() {

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.CAMPAIGN_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(campaignRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }


    public SystemContentWSDTO getSystemUsersHelper() {

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.USER_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(userRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getSystemAgentsHelper() {

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.AGENT_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(userRepository.countByUserType(AppConstant.AGENT_USER)));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }

    public SystemContentWSDTO getSystemAssetsHelper() {

        SystemContentWSDTO systemContentWSDTO = new SystemContentWSDTO();
        systemContentWSDTO.setContentName(AppConstant.ASSET_CONTENTS);
        systemContentWSDTO.setContentValue(String.valueOf(assetRepository.count()));
        systemContentWSDTO.setContentState(true);
        return systemContentWSDTO;
    }


    public void recoverClientContentsHelper() {

        clientRepository.findAll().forEach(clientDBModel -> {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientDBModel.getId());
            if (!clientDetailsDBModels.isEmpty()) {

                ClientDetailsDBModel clientDetailsDBModel = clientDetailsDBModels.get(0);
                if (clientDetailsDBModel.getClientAddresses() == null) {
                    clientDetailsDBModel.setClientAddresses(new ArrayList<>());
                }
                clientDetailsDBModel.setClientAddresses(updateClientAddressesHelper(clientDBModel, clientDetailsDBModel.getClientAddresses()));

                if (clientDetailsDBModel.getClientPhones() == null) {
                    clientDetailsDBModel.setClientPhones(new ArrayList<>());
                }
                clientDetailsDBModel.setClientPhones(updateClientPhonesHelper(clientDBModel, clientDetailsDBModel.getClientPhones()));

                if (clientDetailsDBModel.getClientEmails() == null) {
                    clientDetailsDBModel.setClientEmails(new ArrayList<>());
                }
                clientDetailsDBModel.setClientEmails(updateClientEmailsHelper(clientDBModel, clientDetailsDBModel.getClientEmails()));
                clientDetailsDBModel.setuDate(appUtils.getCurrentTimeStamp());

                clientDetailsRepository.save(clientDetailsDBModel);
            }
        });
    }

    public List<ClientAddressDAO> updateClientAddressesHelper(ClientDBModel clientDBModel, List<ClientAddressDAO> clientAddressDAOS) {

        List<ClientAddressDAO> checkedAddressDAOS = new ArrayList<>();
        for (ClientAddressDAO clientAddressDAO : clientAddressDAOS) {
            if (clientAddressDAO.getAddressType() != null && clientAddressDAO.getAddressType().equalsIgnoreCase(AppConstant.SUB_TYPE)) {
                checkedAddressDAOS.add(clientAddressDAO);
            }
        }
        if (clientDBModel.getClientCity() != null && !"".equalsIgnoreCase(clientDBModel.getClientCity()) && clientDBModel.getClientCountry() != null && !"".equalsIgnoreCase(clientDBModel.getClientCountry())) {
            checkedAddressDAOS.add(clientHelper.createClientAddressDAO(AppConstant.NONE, clientDBModel.getClientCity(), AppConstant.NONE, AppConstant.NONE, clientDBModel.getClientCountry(), AppConstant.MAIN_TYPE));
        }
        return checkedAddressDAOS;
    }

    public List<ClientPhoneDAO> updateClientPhonesHelper(ClientDBModel clientDBModel, List<ClientPhoneDAO> clientPhoneDAOS) {

        List<ClientPhoneDAO> checkedPhoneDAOS = new ArrayList<>();
        for (ClientPhoneDAO clientPhoneDAO : clientPhoneDAOS) {

        }
        if (clientDBModel.getPhoneNumber() != null && !"".equalsIgnoreCase(clientDBModel.getPhoneNumber())) {
            checkedPhoneDAOS.add(clientHelper.createClientPhoneDAO(clientDBModel.getPhoneNumber(), AppConstant.NONE, AppConstant.MAIN_TYPE));
        }
        return checkedPhoneDAOS;
    }

    public List<ClientEmailDAO> updateClientEmailsHelper(ClientDBModel clientDBModel, List<ClientEmailDAO> clientEmailDAOS) {

        List<ClientEmailDAO> checkedEmailDAOS = new ArrayList<>();
        for (ClientEmailDAO clientEmailDAO : clientEmailDAOS) {
            if (clientEmailDAO.getEmailType() != null && clientEmailDAO.getEmailType().equalsIgnoreCase(AppConstant.SUB_TYPE)) {
                checkedEmailDAOS.add(clientEmailDAO);
            }
        }
        if (clientDBModel.getEmailAddress() != null && !"".equalsIgnoreCase(clientDBModel.getEmailAddress())) {
            checkedEmailDAOS.add(clientHelper.createClientEmailDAO(clientDBModel.getEmailAddress(), AppConstant.MAIN_TYPE));
        }
        return checkedEmailDAOS;
    }


    public void recoverAgentContentsHelper() {

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


    public void removeAllClientsHelper() {

        clientRepository.deleteAll();
        remoteAppRepository.deleteAll();
        operationRepository.deleteAll();
        operationEmailRepository.deleteAll();
        operationPushRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        OperationSmsRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
    }

    public void removeAllSessionsHelper() {

        operationRepository.deleteAll();
        operationEmailRepository.deleteAll();
        operationPushRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        OperationSmsRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
        resetAllClientsHelper();
    }

    public void removeAllOperationsHelper() {

        operationRepository.deleteAll();
        operationEmailRepository.deleteAll();
        operationPushRepository.deleteAll();
        operationSipCallRepository.deleteAll();
        OperationSmsRepository.deleteAll();
        operationWappCallRepository.deleteAll();
        operationWappMessageRepository.deleteAll();
        resetAllClientsHelper();
    }


    public void resetAllClientsHelper() {

        Iterable<ClientDBModel> clientDBModels = clientRepository.findAll();
        for (ClientDBModel clientDBModel : clientDBModels) {
            clientDBModel.setClientState(AppConstant.READY_CLIENT);
            clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientRepository.save(clientDBModel);
        }
    }


    public void removeAllCampaignsHelper() {
        campaignRepository.deleteAll();
        campaignAgentRepository.deleteAll();
    }


    public void removeAllUsersHelper() {

        userRepository.deleteAll();
        userDetailsRepository.deleteAll();
        campaignAgentRepository.deleteAll();
    }

    public void removeAllAgentsHelper() {

        List<UserDBModel> userDBModels = userRepository.findByUserType(AppConstant.AGENT_USER);
        for (UserDBModel userDBModel : userDBModels) {
            userDetailsRepository.deleteAll(userDetailsRepository.findByUserId(userDBModel.getId()));
            campaignAgentRepository.deleteAll();
            userRepository.delete(userDBModel);
        }
    }

    public void removeAllAssetsHelper() {
        assetRepository.deleteAll();
    }


}
