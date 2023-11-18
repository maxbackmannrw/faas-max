package com.faas.core.base.middleware.utils.system;

import com.faas.core.base.framework.utils.system.UtilsSystemFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.system.SystemInfoWSModel;
import com.faas.core.base.model.ws.utils.system.dto.SystemInfoWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UtilsSystemMiddleware {


    @Autowired
    UtilsSystemFramework utilsSystemFramework;


    public SystemInfoWSModel getSystemInfos(long userId) {

        SystemInfoWSModel response = new SystemInfoWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SystemInfoWSDTO> systemInfoWSDTOS = utilsSystemFramework.getSystemInfosService(userId);
        if (systemInfoWSDTOS != null){
            response.setSystemInfos(systemInfoWSDTOS);
        }

        general.setOperation("getSystemInfos");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SystemInfoWSModel repairSystemInfo(long userId, String systemSettings) {

        SystemInfoWSModel response = new SystemInfoWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SystemInfoWSDTO> systemInfoWSDTOS = new ArrayList<>();

        utilsSystemFramework.repairSystemSettingsService(userId,systemSettings);

        response.setSystemInfos(systemInfoWSDTOS);
        general.setOperation("repairSystemInfo");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public SystemInfoWSModel removeSystemInfo(long userId, String systemSettings) {

        SystemInfoWSModel response = new SystemInfoWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SystemInfoWSDTO> systemInfoWSDTOS = new ArrayList<>();

        utilsSystemFramework.removeSystemSettingsService(userId,systemSettings);


        general.setOperation("removeSystemInfo");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
