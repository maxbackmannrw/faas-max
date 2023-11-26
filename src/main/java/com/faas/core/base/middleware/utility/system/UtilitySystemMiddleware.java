package com.faas.core.base.middleware.utility.system;

import com.faas.core.base.framework.utility.system.UtilitySystemFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utility.system.SystemInfoWSModel;
import com.faas.core.base.model.ws.utility.system.SystemInitWSModel;
import com.faas.core.base.model.ws.utility.system.dto.SystemInfoWSDTO;
import com.faas.core.base.model.ws.utility.system.dto.SystemInitWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UtilitySystemMiddleware {


    @Autowired
    UtilitySystemFramework utilitySystemFramework;


    public SystemInfoWSModel getSystemInfos(long userId) {

        SystemInfoWSModel response = new SystemInfoWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SystemInfoWSDTO> systemInfoWSDTOS = utilitySystemFramework.getSystemInfosService(userId);
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


    public SystemInitWSModel initializeSystem(String initType) {

        SystemInitWSModel response = new SystemInitWSModel();
        GeneralWSModel general = new GeneralWSModel();

        SystemInitWSDTO systemInitWSDTO = utilitySystemFramework.initializeSystemService(initType);
        if (systemInitWSDTO != null){
            response.setSystemInit(systemInitWSDTO);
        }

        general.setOperation("initializeSystem");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SystemInfoWSModel repairSystemInfo(long userId, String systemInfo) {

        SystemInfoWSModel response = new SystemInfoWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SystemInfoWSDTO> systemInfoWSDTOS = new ArrayList<>();

        SystemInfoWSDTO systemInfoWSDTO = utilitySystemFramework.repairSystemInfoService(userId,systemInfo);
        if (systemInfoWSDTO != null){
            systemInfoWSDTOS.add(systemInfoWSDTO);
        }

        response.setSystemInfos(systemInfoWSDTOS);
        general.setOperation("repairSystemInfo");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SystemInfoWSModel removeSystemInfo(long userId, String systemInfo) {

        SystemInfoWSModel response = new SystemInfoWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SystemInfoWSDTO> systemInfoWSDTOS = new ArrayList<>();

        SystemInfoWSDTO systemInfoWSDTO = utilitySystemFramework.removeSystemInfoService(userId,systemInfo);
        if (systemInfoWSDTO != null){
            systemInfoWSDTOS.add(systemInfoWSDTO);
        }

        response.setSystemInfos(systemInfoWSDTOS);
        general.setOperation("removeSystemInfo");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
