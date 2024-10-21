package com.faas.core.base.framework.utils.content;

import com.faas.core.base.model.ws.utils.content.dto.SystemContentWSDTO;
import com.faas.core.base.model.ws.utils.content.dto.SystemInitWSDTO;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.helpers.utils.UtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemContentFramework {

    @Autowired
    UtilsHelper utilsHelper;


    public SystemInitWSDTO initSystemContentService(String initType) {

        if (initType.equalsIgnoreCase(AppConstant.FIRST_TIME_INIT)) {
            return utilsHelper.initSystemContentHelper();
        }
        return null;
    }

    public List<SystemContentWSDTO> getSystemContentsService(long userId) {

        return utilsHelper.getSystemContentsHelper(userId);
    }

    public SystemContentWSDTO recoverSystemContentService(long userId, String contentType) {

        if (contentType.equalsIgnoreCase(AppConstant.CLIENT_CONTENTS)) {
            utilsHelper.recoverClientContentsHelper();
        }
        if (contentType.equalsIgnoreCase(AppConstant.AGENT_CONTENTS)) {
            utilsHelper.recoverAgentContentsHelper();
        }
        return null;
    }

    public SystemContentWSDTO removeSystemContentService(long userId, String contentType) {

        if (contentType.equalsIgnoreCase(AppConstant.CLIENT_CONTENTS)) {
            utilsHelper.removeAllClientsHelper();
            return new SystemContentWSDTO(AppConstant.CLIENT_CONTENTS, AppConstant.CLIENT_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.SESSION_CONTENTS)) {
            utilsHelper.removeAllSessionsHelper();
            return new SystemContentWSDTO(AppConstant.SESSION_CONTENTS, AppConstant.SESSION_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.OPERATION_CONTENTS)) {
            utilsHelper.removeAllOperationsHelper();
            return new SystemContentWSDTO(AppConstant.OPERATION_CONTENTS, AppConstant.OPERATION_CONTENTS, true);
        }

        if (contentType.equalsIgnoreCase(AppConstant.CAMPAIGN_CONTENTS)) {
            utilsHelper.removeAllCampaignsHelper();
            return new SystemContentWSDTO(AppConstant.CAMPAIGN_CONTENTS, AppConstant.CAMPAIGN_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.USER_CONTENTS)) {
            utilsHelper.removeAllUsersHelper();
            return new SystemContentWSDTO(AppConstant.USER_CONTENTS, AppConstant.USER_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.AGENT_CONTENTS)) {
            utilsHelper.removeAllAgentsHelper();
            return new SystemContentWSDTO(AppConstant.AGENT_CONTENTS, AppConstant.AGENT_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.ASSET_CONTENTS)) {
            utilsHelper.removeAllAssetsHelper();
            return new SystemContentWSDTO(AppConstant.ASSET_CONTENTS, AppConstant.ASSET_CONTENTS, true);
        }
        return null;
    }


}
