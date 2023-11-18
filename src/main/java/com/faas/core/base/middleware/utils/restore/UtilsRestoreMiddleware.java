package com.faas.core.base.middleware.utils.restore;

import com.faas.core.base.framework.utils.restore.UtilsRestoreFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.restore.UtilSettingsWSModel;
import com.faas.core.base.model.ws.utils.restore.dto.UtilSettingsWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UtilsRestoreMiddleware {


    @Autowired
    UtilsRestoreFramework utilsRestoreFramework;


    public UtilSettingsWSModel getAllSystemSettings(long userId) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<UtilSettingsWSDTO> systemSettingsWSDTOS = utilsRestoreFramework.getAllSystemSettingsService(userId);
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


    public UtilSettingsWSModel repairSystemSettings(long userId,String systemSettings) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UtilSettingsWSDTO> utilSettingsWSDTOS = new ArrayList<>();

        utilSettingsWSDTOS.add(new UtilSettingsWSDTO(systemSettings,"", utilsRestoreFramework.repairSystemSettingsService(userId,systemSettings)));

        response.setUtilSettings(utilSettingsWSDTOS);
        general.setOperation("repairSystemSettings");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public UtilSettingsWSModel removeSystemSettings(long userId,String systemSettings) {

        UtilSettingsWSModel response = new UtilSettingsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UtilSettingsWSDTO> utilSettingsWSDTOS = new ArrayList<>();

        utilSettingsWSDTOS.add(new UtilSettingsWSDTO(systemSettings,"", utilsRestoreFramework.removeSystemSettingsService(userId,systemSettings)));

        response.setUtilSettings(utilSettingsWSDTOS);
        general.setOperation("removeSystemSettings");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
