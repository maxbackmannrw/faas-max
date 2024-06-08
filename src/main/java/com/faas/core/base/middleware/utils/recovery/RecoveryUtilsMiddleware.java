package com.faas.core.base.middleware.utils.recovery;

import com.faas.core.base.framework.utils.recovery.RecoveryUtilsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.backup.SystemUtilityWSModel;
import com.faas.core.base.model.ws.utils.backup.InitSystemUtilityWSModel;
import com.faas.core.base.model.ws.utils.backup.dto.SystemUtilityWSDTO;
import com.faas.core.base.model.ws.utils.backup.dto.InitSystemUtilityWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecoveryUtilsMiddleware {


    @Autowired
    RecoveryUtilsFramework recoveryUtilsFramework;


    public InitSystemUtilityWSModel initSystemUtility(String initType) {

        InitSystemUtilityWSModel response = new InitSystemUtilityWSModel();
        GeneralWSModel general = new GeneralWSModel();

        InitSystemUtilityWSDTO initSystemUtilityWSDTO = recoveryUtilsFramework.initSystemUtilityService(initType);
        if (initSystemUtilityWSDTO != null){
            response.setInitSystemUtility(initSystemUtilityWSDTO);
        }

        general.setOperation("initSystemUtility");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SystemUtilityWSModel getSystemUtilities(long userId) {

        SystemUtilityWSModel response = new SystemUtilityWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SystemUtilityWSDTO> systemUtilityWSDTOS = recoveryUtilsFramework.getSystemUtilitiesService(userId);
        if (systemUtilityWSDTOS != null){
            response.setSystemUtilities(systemUtilityWSDTOS);
        }

        general.setOperation("getSystemUtilities");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public SystemUtilityWSModel repairSystemUtility(long userId, String repairType) {

        SystemUtilityWSModel response = new SystemUtilityWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SystemUtilityWSDTO> systemUtilityWSDTOS = new ArrayList<>();

        SystemUtilityWSDTO systemUtilityWSDTO = recoveryUtilsFramework.repairSystemUtilityService(userId,repairType);
        if (systemUtilityWSDTO != null){
            systemUtilityWSDTOS.add(systemUtilityWSDTO);
        }

        response.setSystemUtilities(systemUtilityWSDTOS);
        general.setOperation("repairSystemUtility");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SystemUtilityWSModel removeSystemUtility(long userId, String removeType) {

        SystemUtilityWSModel response = new SystemUtilityWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SystemUtilityWSDTO> systemUtilityWSDTOS = new ArrayList<>();

        SystemUtilityWSDTO systemUtilityWSDTO = recoveryUtilsFramework.removeSystemUtilityService(userId,removeType);
        if (systemUtilityWSDTO != null){
            systemUtilityWSDTOS.add(systemUtilityWSDTO);
        }

        response.setSystemUtilities(systemUtilityWSDTOS);
        general.setOperation("removeSystemUtility");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
