package com.faas.core.base.middleware.utils.settings;

import com.faas.core.base.framework.utils.settings.UtilsSettingsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.settings.UtilSettingsWSModel;
import com.faas.core.base.model.ws.utils.settings.dto.UtilSettingsWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UtilsSettingsMiddleware {


    @Autowired
    UtilsSettingsFramework utilsSettingsFramework;


    public UtilSettingsWSModel getAllSystemSettings(long userId) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<UtilSettingsWSDTO> systemSettingsWSDTOS = utilsSettingsFramework.getAllSystemSettingsService(userId);
        if (systemSettingsWSDTOS != null){
            response.setUtilSettings(systemSettingsWSDTOS);
        }

        general.setOperation("getAllSystemSettings");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public UtilSettingsWSModel removeSystemSettings(long userId,String systemSettings) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<UtilSettingsWSDTO> systemSettingsWSDTOS = utilsSettingsFramework.removeSystemSettingsService(userId,systemSettings);
        if (systemSettingsWSDTOS != null){
            response.setUtilSettings(systemSettingsWSDTOS);
        }

        general.setOperation("removeSystemSettings");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
