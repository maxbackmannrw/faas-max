package com.faas.core.base.middleware.process.details.trigger.temp;

import com.faas.core.base.framework.process.details.trigger.temp.WappTriggerTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.WappCallTriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.WappMessageTriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.WappCallTriggerTempWSDTO;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.WappMessageTriggerTempWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class WappTriggerTempMiddleware {


    @Autowired
    WappTriggerTempFramework wappTriggerTempFramework;


    public WappCallTriggerTempWSModel getWappCallTriggerTemps(long userId, String processId) {

        WappCallTriggerTempWSModel response = new WappCallTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<WappCallTriggerTempWSDTO> wappCallTriggerTempWSDTOS = wappTriggerTempFramework.getWappCallTriggerTempsService(userId,processId);
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

        WappCallTriggerTempWSDTO wappCallTriggerTempWSDTO = wappTriggerTempFramework.getWappCallTriggerTempService(userId,tempId);
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

        WappCallTriggerTempWSDTO wappCallTriggerTempWSDTO = wappTriggerTempFramework.createWappCallTriggerTempService(userId,processId,trigger,accountId,typeId);
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

        WappCallTriggerTempWSDTO wappCallTriggerTempWSDTO = wappTriggerTempFramework.updateWappCallTriggerTempService(userId,tempId,trigger,accountId);
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

        WappCallTriggerTempWSDTO wappCallTriggerTempWSDTO = wappTriggerTempFramework.removeWappCallTriggerTempService(userId,tempId);
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


    public WappMessageTriggerTempWSModel getWappMessageTriggerTemps(long userId, String processId) {

        WappMessageTriggerTempWSModel response = new WappMessageTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<WappMessageTriggerTempWSDTO> wappMessageTriggerTempWSDTOS = wappTriggerTempFramework.getWappMessageTriggerTempsService(userId,processId);
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

        WappMessageTriggerTempWSDTO wappMessageTriggerTempWSDTO = wappTriggerTempFramework.getWappMessageTriggerTempService(userId,tempId);
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

        WappMessageTriggerTempWSDTO wappMessageTriggerTempWSDTO = wappTriggerTempFramework.createWappMessageTriggerTempService(userId,processId,trigger,accountId,wappTitle,wappBody,typeId);
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

        WappMessageTriggerTempWSDTO wappMessageTriggerTempWSDTO = wappTriggerTempFramework.updateWappMessageTriggerTempService(userId,tempId,trigger,accountId,wappTitle,wappBody);
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

        WappMessageTriggerTempWSDTO wappMessageTriggerTempWSDTO = wappTriggerTempFramework.removeWappMessageTriggerTempService(userId,tempId);
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
