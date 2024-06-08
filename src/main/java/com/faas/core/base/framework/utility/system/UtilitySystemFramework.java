package com.faas.core.base.framework.utility.system;

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
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.utility.UtilityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilitySystemFramework {

    @Autowired
    UtilityHelper utilityHelper;

    @Autowired
    ClientRepository clientRepository;

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


    public InitSystemUtilityWSDTO initSystemUtilityService(String initType) {

        if (initType.equalsIgnoreCase(AppConstant.FIRST_TIME_INIT)){
            return utilityHelper.firstTimeInitSystemUtilityHelper();
        }
        return null;
    }

    public List<SystemUtilityWSDTO> getSystemUtilitiesService(long userId) {

        return utilityHelper.getSystemUtilitiesHelper(userId);
    }

    public SystemUtilityWSDTO repairSystemUtilityService(long userId, String repairType) {

        if (repairType.equalsIgnoreCase(AppConstant.CLIENT_UTILS)){
            utilityHelper.repairClientsHelper();
        }
        if (repairType.equalsIgnoreCase(AppConstant.AGENT_UTILS)){
            utilityHelper.repairAgentsHelper();
        }
        return null;
    }


    public SystemUtilityWSDTO removeSystemUtilityService(long userId, String removeType) {

        if (removeType.equalsIgnoreCase(AppConstant.CLIENT_UTILS)){
            utilityHelper.removeAllClientsHelper();
            return new SystemUtilityWSDTO(AppConstant.CLIENT_UTILS,AppConstant.CLIENT_UTILS,true);
        }
        if (removeType.equalsIgnoreCase(AppConstant.SESSION_UTILS)){
            utilityHelper.removeAllSessionsHelper();
            return new SystemUtilityWSDTO(AppConstant.SESSION_UTILS,AppConstant.SESSION_UTILS,true);
        }
        if (removeType.equalsIgnoreCase(AppConstant.OPERATION_UTILS)){
            utilityHelper.removeAllOperationsHelper();
            return new SystemUtilityWSDTO(AppConstant.OPERATION_UTILS,AppConstant.OPERATION_UTILS,true);
        }

        if (removeType.equalsIgnoreCase(AppConstant.CAMPAIGN_UTILS)){
            utilityHelper.removeAllCampaignsHelper();
            return new SystemUtilityWSDTO(AppConstant.CAMPAIGN_UTILS,AppConstant.CAMPAIGN_UTILS,true);
        }
        if (removeType.equalsIgnoreCase(AppConstant.PROCESS_UTILS)){
            utilityHelper.removeAllProcessesHelper();
            return new SystemUtilityWSDTO(AppConstant.PROCESS_UTILS,AppConstant.PROCESS_UTILS,true);
        }
        if (removeType.equalsIgnoreCase(AppConstant.SCENARIO_UTILS)){
            utilityHelper.removeAllScenariosHelper();
            return new SystemUtilityWSDTO(AppConstant.SCENARIO_UTILS,AppConstant.SCENARIO_UTILS,true);
        }

        if (removeType.equalsIgnoreCase(AppConstant.USER_UTILS)){
            utilityHelper.removeAllUsersHelper();
            return new SystemUtilityWSDTO(AppConstant.USER_UTILS,AppConstant.USER_UTILS,true);
        }
        if (removeType.equalsIgnoreCase(AppConstant.AGENT_UTILS)){
            utilityHelper.removeAllAgentsHelper();
            return new SystemUtilityWSDTO(AppConstant.AGENT_UTILS,AppConstant.AGENT_UTILS,true);
        }
        if (removeType.equalsIgnoreCase(AppConstant.ASSET_UTILS)){
            utilityHelper.removeAllAssetsHelper();
            return new SystemUtilityWSDTO(AppConstant.ASSET_UTILS,AppConstant.ASSET_UTILS,true);
        }
        return null;
    }



}
