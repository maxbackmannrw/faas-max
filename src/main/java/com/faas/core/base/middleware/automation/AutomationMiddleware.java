package com.faas.core.base.middleware.automation;

import com.faas.core.base.framework.automation.AutomationFramework;
import com.faas.core.base.model.ws.automation.AutomationWSModel;
import com.faas.core.base.model.ws.automation.dto.AutomationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomationMiddleware {


    @Autowired
    AutomationFramework automationFramework;


    public AutomationWSModel getAutomations(long userId) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomationWSDTO> automationWSDTOS = automationFramework.getAutomationsService(userId);
        if (automationWSDTOS != null){
            response.setAutomations(automationWSDTOS);
        }

        general.setOperation("getAutomations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomationWSModel getAutomation(long userId, long automationId) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();

        AutomationWSDTO automationWSDTO = automationFramework.getAutomationService(automationId);
        if (automationWSDTO != null){
            automationWSDTOS.add(automationWSDTO);
        }

        response.setAutomations(automationWSDTOS);
        general.setOperation("getAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomationWSModel createAutomation(long userId, String automation,long typeId) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();

        AutomationWSDTO automationWSDTO = automationFramework.createAutomationService(userId,automation,typeId);
        if (automationWSDTO != null){
            automationWSDTOS.add(automationWSDTO);
        }

        response.setAutomations(automationWSDTOS);
        general.setOperation("createAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomationWSModel updateAutomation(long userId,long automationId,String automation,long typeId) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();

        AutomationWSDTO automationWSDTO = automationFramework.updateAutomationService(userId,automationId,automation,typeId);
        if (automationWSDTO != null){
            automationWSDTOS.add(automationWSDTO);
        }

        response.setAutomations(automationWSDTOS);
        general.setOperation("updateAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AutomationWSModel removeAutomation(long userId, long automationId) {

        AutomationWSModel response = new AutomationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationWSDTO> automationWSDTOS = new ArrayList<>();

        AutomationWSDTO automationWSDTO = automationFramework.removeAutomationService(userId,automationId);
        if (automationWSDTO != null){
            automationWSDTOS.add(automationWSDTO);
        }

        response.setAutomations(automationWSDTOS);
        general.setOperation("removeAutomation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
