package com.faas.core.base.middleware.automation.settings;

import com.faas.core.base.framework.automation.settings.AutomationSettingsFramework;
import com.faas.core.base.model.ws.automation.settings.AutomationTypeWSModel;
import com.faas.core.base.model.ws.automation.settings.dto.AutomationTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AutomationSettingsMiddleware {


    @Autowired
    AutomationSettingsFramework automationSettingsFramework;


    public AutomationTypeWSModel getAutomationTypes(long userId) {

        AutomationTypeWSModel response = new AutomationTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomationTypeWSDTO> automationTypeWSDTOS = automationSettingsFramework.getAutomationTypesService(userId);
        if (automationTypeWSDTOS != null){
            response.setAutomationTypes(automationTypeWSDTOS);
        }

        general.setOperation("getAutomationTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationTypeWSModel getAutomationType(long userId, long typeId) {

        AutomationTypeWSModel response = new AutomationTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTypeWSDTO>automationTypeWSDTOS = new ArrayList<>();

        AutomationTypeWSDTO automationTypeWSDTO = automationSettingsFramework.getAutomationTypeService(userId,typeId);
        if (automationTypeWSDTO != null){
            automationTypeWSDTOS.add(automationTypeWSDTO);
        }

        response.setAutomationTypes(automationTypeWSDTOS);
        general.setOperation("getAutomationType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationTypeWSModel createAutomationType(long userId,String automationType,String baseType) {

        AutomationTypeWSModel response = new AutomationTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTypeWSDTO>automationTypeWSDTOS = new ArrayList<>();

        AutomationTypeWSDTO automationTypeWSDTO = automationSettingsFramework.createAutomationTypeService(userId,automationType,baseType);
        if (automationTypeWSDTO != null){
            automationTypeWSDTOS.add(automationTypeWSDTO);
        }

        response.setAutomationTypes(automationTypeWSDTOS);
        general.setOperation("createAutomationType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationTypeWSModel updateAutomationType(long userId,long typeId,String automationType,String baseType) {

        AutomationTypeWSModel response = new AutomationTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTypeWSDTO>automationTypeWSDTOS = new ArrayList<>();

        AutomationTypeWSDTO automationTypeWSDTO = automationSettingsFramework.updateAutomationTypeService(userId,typeId,automationType,baseType);
        if (automationTypeWSDTO != null){
            automationTypeWSDTOS.add(automationTypeWSDTO);
        }

        response.setAutomationTypes(automationTypeWSDTOS);
        general.setOperation("updateAutomationType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public AutomationTypeWSModel removeAutomationType(long userId,long typeId) {

        AutomationTypeWSModel response = new AutomationTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTypeWSDTO>automationTypeWSDTOS = new ArrayList<>();

        AutomationTypeWSDTO automationTypeWSDTO = automationSettingsFramework.removeAutomationTypeService(userId,typeId);
        if (automationTypeWSDTO != null){
            automationTypeWSDTOS.add(automationTypeWSDTO);
        }

        response.setAutomationTypes(automationTypeWSDTOS);
        general.setOperation("removeAutomationType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
