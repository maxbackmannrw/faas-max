package com.faas.core.base.framework.utilz.content;

import com.faas.core.data.ws.base.utilz.content.dto.SystemContentWSDTO;
import com.faas.core.data.ws.base.utilz.content.dto.SystemInitWSDTO;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.helpers.utils.UtilsHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemContentFramework {

    @Autowired
    UtilsHelpers utilsHelpers;


    public SystemInitWSDTO initSystemContentService(String initType) {

        if (initType.equalsIgnoreCase(AppConstant.FIRST_TIME_INIT)) {
            return utilsHelpers.initSystemContentHelper();
        }
        return null;
    }

    public List<SystemContentWSDTO> getSystemContentsService(long userId) {

        return utilsHelpers.getSystemContentsHelper(userId);
    }

    public SystemContentWSDTO recoverSystemContentService(long userId, String contentType) {

        if (contentType.equalsIgnoreCase(AppConstant.CLIENT_CONTENTS)) {
            utilsHelpers.recoverClientContentsHelper();
        }
        if (contentType.equalsIgnoreCase(AppConstant.AGENT_CONTENTS)) {
            utilsHelpers.recoverAgentContentsHelper();
        }
        return null;
    }

    public SystemContentWSDTO removeSystemContentService(long userId, String contentType) {

        if (contentType.equalsIgnoreCase(AppConstant.CLIENT_CONTENTS)) {
            utilsHelpers.removeAllClientsHelper();
            return new SystemContentWSDTO(AppConstant.CLIENT_CONTENTS, AppConstant.CLIENT_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.SESSION_CONTENTS)) {
            utilsHelpers.removeAllSessionsHelper();
            return new SystemContentWSDTO(AppConstant.SESSION_CONTENTS, AppConstant.SESSION_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.OPERATION_CONTENTS)) {
            utilsHelpers.removeAllOperationsHelper();
            return new SystemContentWSDTO(AppConstant.OPERATION_CONTENTS, AppConstant.OPERATION_CONTENTS, true);
        }

        if (contentType.equalsIgnoreCase(AppConstant.CAMPAIGN_CONTENTS)) {
            utilsHelpers.removeAllCampaignsHelper();
            return new SystemContentWSDTO(AppConstant.CAMPAIGN_CONTENTS, AppConstant.CAMPAIGN_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.PROCESS_CONTENTS)) {
            utilsHelpers.removeAllProcessesHelper();
            return new SystemContentWSDTO(AppConstant.PROCESS_CONTENTS, AppConstant.PROCESS_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.SCENARIO_CONTENTS)) {
            utilsHelpers.removeAllScenariosHelper();
            return new SystemContentWSDTO(AppConstant.SCENARIO_CONTENTS, AppConstant.SCENARIO_CONTENTS, true);
        }

        if (contentType.equalsIgnoreCase(AppConstant.USER_CONTENTS)) {
            utilsHelpers.removeAllUsersHelper();
            return new SystemContentWSDTO(AppConstant.USER_CONTENTS, AppConstant.USER_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.AGENT_CONTENTS)) {
            utilsHelpers.removeAllAgentsHelper();
            return new SystemContentWSDTO(AppConstant.AGENT_CONTENTS, AppConstant.AGENT_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.ASSET_CONTENTS)) {
            utilsHelpers.removeAllAssetsHelper();
            return new SystemContentWSDTO(AppConstant.ASSET_CONTENTS, AppConstant.ASSET_CONTENTS, true);
        }
        return null;
    }


}
