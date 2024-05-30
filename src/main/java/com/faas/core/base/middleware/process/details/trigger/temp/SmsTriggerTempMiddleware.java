package com.faas.core.base.middleware.process.details.trigger.temp;

import com.faas.core.base.framework.process.details.trigger.temp.SmsTriggerTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.SmsTriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.SmsTriggerTempWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SmsTriggerTempMiddleware {


    @Autowired
    SmsTriggerTempFramework smsTriggerTempFramework;


    public SmsTriggerTempWSModel getSmsTriggerTemps(long userId, String processId) {

        SmsTriggerTempWSModel response = new SmsTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SmsTriggerTempWSDTO> smsTriggerTempWSDTOS = smsTriggerTempFramework.getSmsTriggerTempsService(userId,processId);
        if (smsTriggerTempWSDTOS != null){
            response.setSmsTriggerTemps(smsTriggerTempWSDTOS);
        }

        general.setOperation("getSmsTriggerTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsTriggerTempWSModel getSmsTriggerTemp(long userId, String tempId) {

        SmsTriggerTempWSModel response = new SmsTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsTriggerTempWSDTO> smsTriggerTempWSDTOS = new ArrayList<>();

        SmsTriggerTempWSDTO smsTriggerTempWSDTO = smsTriggerTempFramework.getSmsTriggerTempService(userId,tempId);
        if (smsTriggerTempWSDTO != null){
            smsTriggerTempWSDTOS.add(smsTriggerTempWSDTO);
        }

        response.setSmsTriggerTemps(smsTriggerTempWSDTOS);
        general.setOperation("getSmsTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsTriggerTempWSModel createSmsTriggerTemp(long userId, String processId, String trigger, String accountId, String smsTitle, String smsBody, String senderId, long typeId) {

        SmsTriggerTempWSModel response = new SmsTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsTriggerTempWSDTO> smsTriggerTempWSDTOS = new ArrayList<>();

        SmsTriggerTempWSDTO smsTriggerTempWSDTO = smsTriggerTempFramework.createSmsTriggerTempService(userId,processId,trigger,accountId,smsTitle,smsBody,senderId,typeId);
        if (smsTriggerTempWSDTO != null){
            smsTriggerTempWSDTOS.add(smsTriggerTempWSDTO);
        }

        response.setSmsTriggerTemps(smsTriggerTempWSDTOS);
        general.setOperation("createSmsTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsTriggerTempWSModel updateSmsTriggerTemp(long userId, String tempId, String trigger, String accountId, String smsTitle, String smsBody, String senderId) {

        SmsTriggerTempWSModel response = new SmsTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsTriggerTempWSDTO> smsTriggerTempWSDTOS = new ArrayList<>();

        SmsTriggerTempWSDTO smsTriggerTempWSDTO = smsTriggerTempFramework.updateSmsTriggerTempService(userId,tempId,trigger,accountId,smsTitle,smsBody,senderId);
        if (smsTriggerTempWSDTO != null){
            smsTriggerTempWSDTOS.add(smsTriggerTempWSDTO);
        }

        response.setSmsTriggerTemps(smsTriggerTempWSDTOS);
        general.setOperation("updateSmsTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SmsTriggerTempWSModel removeSmsTriggerTemp(long userId, String tempId) {

        SmsTriggerTempWSModel response = new SmsTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SmsTriggerTempWSDTO> smsTriggerTempWSDTOS = new ArrayList<>();

        SmsTriggerTempWSDTO smsTriggerTempWSDTO = smsTriggerTempFramework.removeSmsTriggerTempService(userId,tempId);
        if (smsTriggerTempWSDTO != null){
            smsTriggerTempWSDTOS.add(smsTriggerTempWSDTO);
        }

        response.setSmsTriggerTemps(smsTriggerTempWSDTOS);
        general.setOperation("removeSmsTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
