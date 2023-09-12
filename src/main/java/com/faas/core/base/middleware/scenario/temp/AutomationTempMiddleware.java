package com.faas.core.base.middleware.scenario.temp;

import com.faas.core.base.framework.scenario.temp.AutomationTempFramework;
import com.faas.core.base.model.ws.scenario.temp.automation.AutomationTempWSModel;
import com.faas.core.base.model.ws.scenario.temp.automation.dto.AutomationTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomationTempMiddleware {


    @Autowired
    AutomationTempFramework automationTempFramework;


    public AutomationTempWSModel getAutomationTemps(long userId) {

        AutomationTempWSModel response = new AutomationTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomationTempWSDTO> automationTempWSDTOS = automationTempFramework.getAutomationTempsService(userId);
        if (automationTempWSDTOS != null){
            response.setAutomationTemps(automationTempWSDTOS);
        }

        general.setOperation("getAutomationTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationTempWSModel getAutomationTemp(long userId, long tempId) {

        AutomationTempWSModel response = new AutomationTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTempWSDTO> automationTempWSDTOS = new ArrayList<>();

        AutomationTempWSDTO automationTempWSDTO = automationTempFramework.getAutomationTempService(tempId);
        if (automationTempWSDTO != null){
            automationTempWSDTOS.add(automationTempWSDTO);
        }

        response.setAutomationTemps(automationTempWSDTOS);
        general.setOperation("getAutomationTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationTempWSModel createAutomationTemp(long userId,String automationTemp,long typeId) {

        AutomationTempWSModel response = new AutomationTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTempWSDTO> automationTempWSDTOS = new ArrayList<>();

        AutomationTempWSDTO automationTempWSDTO = automationTempFramework.createAutomationTempService(userId,automationTemp,typeId);
        if (automationTempWSDTO != null){
            automationTempWSDTOS.add(automationTempWSDTO);
        }

        response.setAutomationTemps(automationTempWSDTOS);
        general.setOperation("createAutomationTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationTempWSModel updateAutomationTemp(long userId,long tempId,String automationTemp,long typeId) {

        AutomationTempWSModel response = new AutomationTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTempWSDTO> automationTempWSDTOS = new ArrayList<>();

        AutomationTempWSDTO automationTempWSDTO = automationTempFramework.updateAutomationTempService(userId,tempId,automationTemp,typeId);
        if (automationTempWSDTO != null){
            automationTempWSDTOS.add(automationTempWSDTO);
        }

        response.setAutomationTemps(automationTempWSDTOS);
        general.setOperation("updateAutomationTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public AutomationTempWSModel removeAutomationTemp(long userId,long tempId) {

        AutomationTempWSModel response = new AutomationTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTempWSDTO> automationTempWSDTOS = new ArrayList<>();

        AutomationTempWSDTO automationTempWSDTO = automationTempFramework.removeAutomationTempService(userId,tempId);
        if (automationTempWSDTO != null){
            automationTempWSDTOS.add(automationTempWSDTO);
        }

        response.setAutomationTemps(automationTempWSDTOS);
        general.setOperation("removeAutomationTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
