package com.faas.core.base.middleware.process.details.trigger.temp;

import com.faas.core.base.framework.process.details.trigger.temp.SipTriggerTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.SipTriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.SipTriggerTempWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SipTriggerTempMiddleware {


    @Autowired
    SipTriggerTempFramework sipTriggerTempFramework;


    public SipTriggerTempWSModel getSipTriggerTemps(long userId, String processId) {

        SipTriggerTempWSModel response = new SipTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SipTriggerTempWSDTO> sipTriggerTempWSDTOS = sipTriggerTempFramework.getSipTriggerTempsService(userId,processId);
        if (sipTriggerTempWSDTOS != null){
            response.setSipTriggerTemps(sipTriggerTempWSDTOS);
        }

        general.setOperation("getSipTriggerTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipTriggerTempWSModel getSipTriggerTemp(long userId, String tempId) {

        SipTriggerTempWSModel response = new SipTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipTriggerTempWSDTO> sipTriggerTempWSDTOS = new ArrayList<>();

        SipTriggerTempWSDTO sipTriggerTempWSDTO = sipTriggerTempFramework.getSipTriggerTempService(userId,tempId);
        if (sipTriggerTempWSDTO != null){
            sipTriggerTempWSDTOS.add(sipTriggerTempWSDTO);
        }

        response.setSipTriggerTemps(sipTriggerTempWSDTOS);
        general.setOperation("getSipTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipTriggerTempWSModel createSipTriggerTemp(long userId, String processId, String trigger, String accountId, String callerId, long typeId) {

        SipTriggerTempWSModel response = new SipTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipTriggerTempWSDTO> sipTriggerTempWSDTOS = new ArrayList<>();

        SipTriggerTempWSDTO sipTriggerTempWSDTO = sipTriggerTempFramework.createSipTriggerTempService(userId,processId,trigger,accountId,callerId,typeId);
        if (sipTriggerTempWSDTO != null){
            sipTriggerTempWSDTOS.add(sipTriggerTempWSDTO);
        }

        response.setSipTriggerTemps(sipTriggerTempWSDTOS);
        general.setOperation("createSipTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipTriggerTempWSModel updateSipTriggerTemp(long userId, String tempId, String trigger, String accountId, String callerId) {

        SipTriggerTempWSModel response = new SipTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipTriggerTempWSDTO> sipTriggerTempWSDTOS = new ArrayList<>();

        SipTriggerTempWSDTO sipTriggerTempWSDTO = sipTriggerTempFramework.updateSipTriggerTempService(userId,tempId,trigger,accountId,callerId);
        if (sipTriggerTempWSDTO != null){
            sipTriggerTempWSDTOS.add(sipTriggerTempWSDTO);
        }

        response.setSipTriggerTemps(sipTriggerTempWSDTOS);
        general.setOperation("updateSipTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SipTriggerTempWSModel removeSipTriggerTemp(long userId, String tempId) {

        SipTriggerTempWSModel response = new SipTriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SipTriggerTempWSDTO> sipTriggerTempWSDTOS = new ArrayList<>();

        SipTriggerTempWSDTO sipTriggerTempWSDTO = sipTriggerTempFramework.removeSipTriggerTempService(userId,tempId);
        if (sipTriggerTempWSDTO != null){
            sipTriggerTempWSDTOS.add(sipTriggerTempWSDTO);
        }

        response.setSipTriggerTemps(sipTriggerTempWSDTOS);
        general.setOperation("removeSipTriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
