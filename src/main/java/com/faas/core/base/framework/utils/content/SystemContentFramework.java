package com.faas.core.base.framework.utils.content;

import com.faas.core.base.model.ws.utils.content.dto.SystemInitWSDTO;
import com.faas.core.base.model.ws.utils.content.dto.SystemContentWSDTO;
import com.faas.core.base.repo.asset.content.AssetRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.campaign.details.temp.EmailTempRepository;
import com.faas.core.base.repo.campaign.details.temp.PushTempRepository;
import com.faas.core.base.repo.campaign.details.temp.SmsTempRepository;
import com.faas.core.base.repo.campaign.details.temp.WappMessageTempRepository;
import com.faas.core.base.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.base.repo.campaign.details.trigger.*;
import com.faas.core.base.repo.remoteapp.RemoteAppRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.base.repo.user.details.UserDetailsRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.utils.UtilsHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemContentFramework {

    @Autowired
    UtilsHelpers utilsHelpers;

    @Autowired
    ClientRepository clientRepository;

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
    OperationSmsRepository OperationSmsRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsTempRepository smsTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    CampaignScenarioRepository campaignScenarioRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

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


    public SystemInitWSDTO initSystemContentService(String initType) {

        if (initType.equalsIgnoreCase(AppConstant.FIRST_TIME_INIT)){
            return utilsHelpers.initSystemContentHelper();
        }
        return null;
    }

    public List<SystemContentWSDTO> getSystemContentsService(long userId) {

        return utilsHelpers.getSystemContentsHelper(userId);
    }

    public SystemContentWSDTO recoverSystemContentService(long userId, String contentType) {

        if (contentType.equalsIgnoreCase(AppConstant.CLIENT_CONTENTS)){
            utilsHelpers.recoverClientContentsHelper();
        }
        if (contentType.equalsIgnoreCase(AppConstant.AGENT_CONTENTS)){
            utilsHelpers.recoverAgentContentsHelper();
        }
        return null;
    }

    public SystemContentWSDTO removeSystemContentService(long userId, String contentType) {

        if (contentType.equalsIgnoreCase(AppConstant.CLIENT_CONTENTS)){
            utilsHelpers.removeAllClientsHelper();
            return new SystemContentWSDTO(AppConstant.CLIENT_CONTENTS,AppConstant.CLIENT_CONTENTS,true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.SESSION_CONTENTS)){
            utilsHelpers.removeAllSessionsHelper();
            return new SystemContentWSDTO(AppConstant.SESSION_CONTENTS,AppConstant.SESSION_CONTENTS,true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.OPERATION_CONTENTS)){
            utilsHelpers.removeAllOperationsHelper();
            return new SystemContentWSDTO(AppConstant.OPERATION_CONTENTS,AppConstant.OPERATION_CONTENTS,true);
        }

        if (contentType.equalsIgnoreCase(AppConstant.CAMPAIGN_CONTENTS)){
            utilsHelpers.removeAllCampaignsHelper();
            return new SystemContentWSDTO(AppConstant.CAMPAIGN_CONTENTS,AppConstant.CAMPAIGN_CONTENTS,true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.PROCESS_CONTENTS)){
            utilsHelpers.removeAllProcessesHelper();
            return new SystemContentWSDTO(AppConstant.PROCESS_CONTENTS,AppConstant.PROCESS_CONTENTS,true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.SCENARIO_CONTENTS)){
            utilsHelpers.removeAllScenariosHelper();
            return new SystemContentWSDTO(AppConstant.SCENARIO_CONTENTS,AppConstant.SCENARIO_CONTENTS,true);
        }

        if (contentType.equalsIgnoreCase(AppConstant.USER_CONTENTS)){
            utilsHelpers.removeAllUsersHelper();
            return new SystemContentWSDTO(AppConstant.USER_CONTENTS,AppConstant.USER_CONTENTS,true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.AGENT_CONTENTS)){
            utilsHelpers.removeAllAgentsHelper();
            return new SystemContentWSDTO(AppConstant.AGENT_CONTENTS,AppConstant.AGENT_CONTENTS,true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.ASSET_CONTENTS)){
            utilsHelpers.removeAllAssetsHelper();
            return new SystemContentWSDTO(AppConstant.ASSET_CONTENTS,AppConstant.ASSET_CONTENTS,true);
        }
        return null;
    }



}
