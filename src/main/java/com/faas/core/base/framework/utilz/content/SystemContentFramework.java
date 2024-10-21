package com.faas.core.base.framework.utilz.content;

import com.faas.core.base.model.ws.utilz.content.dto.SystemContentWSDTO;
import com.faas.core.base.model.ws.utilz.content.dto.SystemInitWSDTO;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.helpers.utilz.UtilzHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemContentFramework {

    @Autowired
    UtilzHelper utilzHelper;


    public SystemInitWSDTO initSystemContentService(String initType) {

        if (initType.equalsIgnoreCase(AppConstant.FIRST_TIME_INIT)) {
            return utilzHelper.initSystemContentHelper();
        }
        return null;
    }

    public List<SystemContentWSDTO> getSystemContentsService(long userId) {

        return utilzHelper.getSystemContentsHelper(userId);
    }

    public SystemContentWSDTO recoverSystemContentService(long userId, String contentType) {

        if (contentType.equalsIgnoreCase(AppConstant.CLIENT_CONTENTS)) {
            utilzHelper.recoverClientContentsHelper();
        }
        if (contentType.equalsIgnoreCase(AppConstant.AGENT_CONTENTS)) {
            utilzHelper.recoverAgentContentsHelper();
        }
        return null;
    }

    public SystemContentWSDTO removeSystemContentService(long userId, String contentType) {

        if (contentType.equalsIgnoreCase(AppConstant.CLIENT_CONTENTS)) {
            utilzHelper.removeAllClientsHelper();
            return new SystemContentWSDTO(AppConstant.CLIENT_CONTENTS, AppConstant.CLIENT_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.SESSION_CONTENTS)) {
            utilzHelper.removeAllSessionsHelper();
            return new SystemContentWSDTO(AppConstant.SESSION_CONTENTS, AppConstant.SESSION_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.OPERATION_CONTENTS)) {
            utilzHelper.removeAllOperationsHelper();
            return new SystemContentWSDTO(AppConstant.OPERATION_CONTENTS, AppConstant.OPERATION_CONTENTS, true);
        }

        if (contentType.equalsIgnoreCase(AppConstant.CAMPAIGN_CONTENTS)) {
            utilzHelper.removeAllCampaignsHelper();
            return new SystemContentWSDTO(AppConstant.CAMPAIGN_CONTENTS, AppConstant.CAMPAIGN_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.USER_CONTENTS)) {
            utilzHelper.removeAllUsersHelper();
            return new SystemContentWSDTO(AppConstant.USER_CONTENTS, AppConstant.USER_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.AGENT_CONTENTS)) {
            utilzHelper.removeAllAgentsHelper();
            return new SystemContentWSDTO(AppConstant.AGENT_CONTENTS, AppConstant.AGENT_CONTENTS, true);
        }
        if (contentType.equalsIgnoreCase(AppConstant.ASSET_CONTENTS)) {
            utilzHelper.removeAllAssetsHelper();
            return new SystemContentWSDTO(AppConstant.ASSET_CONTENTS, AppConstant.ASSET_CONTENTS, true);
        }
        return null;
    }


}
