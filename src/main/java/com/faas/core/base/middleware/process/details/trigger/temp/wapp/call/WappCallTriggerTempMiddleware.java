package com.faas.core.base.middleware.process.details.trigger.temp.wapp.call;

import com.faas.core.base.framework.process.details.trigger.temp.wapp.call.WappCallTriggerTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.call.WappCallTriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.call.dto.WappCallTriggerTempWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class WappCallTriggerTempMiddleware {


    @Autowired
    WappCallTriggerTempFramework wappCallTriggerTempFramework;


    public WappCallTriggerTempWSModel getWappCallTriggerTemps(long userId, String processId) {

        WappCallTriggerTempWSModel response = new WappCallTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<WappCallTriggerTempWSDTO> wappCallTriggerTempWSDTOS = wappCallTriggerTempFramework.getWappCallTriggerTempsService(userId,processId);
        if (wappCallTriggerTempWSDTOS != null){
            response.setWappCallTriggerTemps(wappCallTriggerTempWSDTOS);
        }

        general.setOperation("getWappCallTriggerTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappCallTriggerTempWSModel getWappCallTriggerTemp(long userId, String tempId) {

        WappCallTriggerTempWSModel response = new WappCallTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappCallTriggerTempWSDTO> wappCallTriggerTempWSDTOS = new ArrayList<>();

        WappCallTriggerTempWSDTO wappCallTriggerTempWSDTO = wappCallTriggerTempFramework.getWappCallTriggerTempService(userId,tempId);
        if (wappCallTriggerTempWSDTO != null){
            wappCallTriggerTempWSDTOS.add(wappCallTriggerTempWSDTO);
        }

        response.setWappCallTriggerTemps(wappCallTriggerTempWSDTOS);
        general.setOperation("getWappCallTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappCallTriggerTempWSModel createWappCallTriggerTemp(long userId, String processId, String trigger, String accountId, long typeId) {

        WappCallTriggerTempWSModel response = new WappCallTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappCallTriggerTempWSDTO> wappCallTriggerTempWSDTOS = new ArrayList<>();

        WappCallTriggerTempWSDTO wappCallTriggerTempWSDTO = wappCallTriggerTempFramework.createWappCallTriggerTempService(userId,processId,trigger,accountId,typeId);
        if (wappCallTriggerTempWSDTO != null){
            wappCallTriggerTempWSDTOS.add(wappCallTriggerTempWSDTO);
        }

        response.setWappCallTriggerTemps(wappCallTriggerTempWSDTOS);
        general.setOperation("createWappCallTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappCallTriggerTempWSModel updateWappCallTriggerTemp(long userId, String tempId, String trigger, String accountId) {

        WappCallTriggerTempWSModel response = new WappCallTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappCallTriggerTempWSDTO> wappCallTriggerTempWSDTOS = new ArrayList<>();

        WappCallTriggerTempWSDTO wappCallTriggerTempWSDTO = wappCallTriggerTempFramework.updateWappCallTriggerTempService(userId,tempId,trigger,accountId);
        if (wappCallTriggerTempWSDTO != null){
            wappCallTriggerTempWSDTOS.add(wappCallTriggerTempWSDTO);
        }

        response.setWappCallTriggerTemps(wappCallTriggerTempWSDTOS);
        general.setOperation("updateWappCallTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappCallTriggerTempWSModel removeWappCallTriggerTemp(long userId, String tempId) {

        WappCallTriggerTempWSModel response = new WappCallTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappCallTriggerTempWSDTO> wappCallTriggerTempWSDTOS = new ArrayList<>();

        WappCallTriggerTempWSDTO wappCallTriggerTempWSDTO = wappCallTriggerTempFramework.removeWappCallTriggerTempService(userId,tempId);
        if (wappCallTriggerTempWSDTO != null){
            wappCallTriggerTempWSDTOS.add(wappCallTriggerTempWSDTO);
        }

        response.setWappCallTriggerTemps(wappCallTriggerTempWSDTOS);
        general.setOperation("removeWappCallTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
