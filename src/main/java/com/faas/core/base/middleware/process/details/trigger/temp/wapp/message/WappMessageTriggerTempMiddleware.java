package com.faas.core.base.middleware.process.details.trigger.temp.wapp.message;

import com.faas.core.base.framework.process.details.trigger.temp.wapp.message.WappMessageTriggerTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.message.WappMessageTriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.wapp.message.dto.WappMessageTriggerTempWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class WappMessageTriggerTempMiddleware {


    @Autowired
    WappMessageTriggerTempFramework wappMessageTriggerTempFramework;


    public WappMessageTriggerTempWSModel getWappMessageTriggerTemps(long userId, String processId) {

        WappMessageTriggerTempWSModel response = new WappMessageTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<WappMessageTriggerTempWSDTO> wappMessageTriggerTempWSDTOS = wappMessageTriggerTempFramework.getWappMessageTriggerTempsService(userId,processId);
        if (wappMessageTriggerTempWSDTOS != null){
            response.setWappMessageTriggerTemps(wappMessageTriggerTempWSDTOS);
        }

        general.setOperation("getWappMessageTriggerTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappMessageTriggerTempWSModel getWappMessageTriggerTemp(long userId, String tempId) {

        WappMessageTriggerTempWSModel response = new WappMessageTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTriggerTempWSDTO> wappMessageTriggerTempWSDTOS = new ArrayList<>();

        WappMessageTriggerTempWSDTO wappMessageTriggerTempWSDTO = wappMessageTriggerTempFramework.getWappMessageTriggerTempService(userId,tempId);
        if (wappMessageTriggerTempWSDTO != null){
            wappMessageTriggerTempWSDTOS.add(wappMessageTriggerTempWSDTO);
        }

        response.setWappMessageTriggerTemps(wappMessageTriggerTempWSDTOS);
        general.setOperation("getWappMessageTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappMessageTriggerTempWSModel createWappMessageTriggerTemp(long userId, String processId, String trigger, String accountId, String wappTitle, String wappBody, long typeId) {

        WappMessageTriggerTempWSModel response = new WappMessageTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTriggerTempWSDTO> wappMessageTriggerTempWSDTOS = new ArrayList<>();

        WappMessageTriggerTempWSDTO wappMessageTriggerTempWSDTO = wappMessageTriggerTempFramework.createWappMessageTriggerTempService(userId,processId,trigger,accountId,wappTitle,wappBody,typeId);
        if (wappMessageTriggerTempWSDTO != null){
            wappMessageTriggerTempWSDTOS.add(wappMessageTriggerTempWSDTO);
        }

        response.setWappMessageTriggerTemps(wappMessageTriggerTempWSDTOS);
        general.setOperation("createWappMessageTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappMessageTriggerTempWSModel updateWappMessageTriggerTemp(long userId, String tempId, String trigger, String accountId, String wappTitle, String wappBody) {

        WappMessageTriggerTempWSModel response = new WappMessageTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTriggerTempWSDTO> wappMessageTriggerTempWSDTOS = new ArrayList<>();

        WappMessageTriggerTempWSDTO wappMessageTriggerTempWSDTO = wappMessageTriggerTempFramework.updateWappMessageTriggerTempService(userId,tempId,trigger,accountId,wappTitle,wappBody);
        if (wappMessageTriggerTempWSDTO != null){
            wappMessageTriggerTempWSDTOS.add(wappMessageTriggerTempWSDTO);
        }

        response.setWappMessageTriggerTemps(wappMessageTriggerTempWSDTOS);
        general.setOperation("updateWappMessageTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public WappMessageTriggerTempWSModel removeWappMessageTriggerTemp(long userId, String tempId) {

        WappMessageTriggerTempWSModel response = new WappMessageTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<WappMessageTriggerTempWSDTO> wappMessageTriggerTempWSDTOS = new ArrayList<>();

        WappMessageTriggerTempWSDTO wappMessageTriggerTempWSDTO = wappMessageTriggerTempFramework.removeWappMessageTriggerTempService(userId,tempId);
        if (wappMessageTriggerTempWSDTO != null){
            wappMessageTriggerTempWSDTOS.add(wappMessageTriggerTempWSDTO);
        }

        response.setWappMessageTriggerTemps(wappMessageTriggerTempWSDTOS);
        general.setOperation("removeWappMessageTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
