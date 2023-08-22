package com.faas.core.base.middleware.utils.settings;

import com.faas.core.base.framework.utils.settings.UtilsSettingsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.settings.UtilSettingsWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UtilsSettingsMiddleware {

    @Autowired
    UtilsSettingsFramework utilsSettingsFramework;


    public UtilSettingsWSModel removeAllClients(long userId) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        utilsSettingsFramework.removeAllClientsService();

        general.setOperation("removeAllClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UtilSettingsWSModel removeAllSessions(long userId) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        utilsSettingsFramework.removeAllSessionsService();

        general.setOperation("removeAllSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public UtilSettingsWSModel removeAllFlows(long userId) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        utilsSettingsFramework.removeAllFlowsService();

        general.setOperation("removeAllFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UtilSettingsWSModel removeAllInquiries(long userId) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        utilsSettingsFramework.removeAllInquiriesService();

        general.setOperation("removeAllInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UtilSettingsWSModel removeSelectedTables(long userId,String selected) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        utilsSettingsFramework.removeSelectedTablesService(selected);

        general.setOperation("removeSelectedTables");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UtilSettingsWSModel cleanSystemTables(long userId) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        utilsSettingsFramework.cleanSystemTablesService();

        general.setOperation("cleanSystemTables");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
