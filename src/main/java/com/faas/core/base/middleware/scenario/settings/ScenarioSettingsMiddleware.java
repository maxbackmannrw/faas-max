package com.faas.core.base.middleware.scenario.settings;

import com.faas.core.base.framework.scenario.settings.ScenarioSettingsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.settings.ScenarioTypeWSModel;
import com.faas.core.base.model.ws.scenario.settings.dto.ScenarioTypeWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScenarioSettingsMiddleware {


    @Autowired
    ScenarioSettingsFramework scenarioSettingsFramework;


    public ScenarioTypeWSModel getScenarioTypes(long userId) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioTypeWSDTO> scenarioTypeWSDTOS = scenarioSettingsFramework.getScenarioTypesService(userId);
        if (scenarioTypeWSDTOS != null){
            response.setScenarioTypes(scenarioTypeWSDTOS);
        }

        general.setOperation("getScenarioTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel getScenarioTypesByBaseType(long userId,String baseType) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioTypeWSDTO> scenarioTypeWSDTOS = scenarioSettingsFramework.getScenarioTypesByBaseTypeService(userId,baseType);
        if (scenarioTypeWSDTOS != null){
            response.setScenarioTypes(scenarioTypeWSDTOS);
        }

        general.setOperation("getScenarioTypesByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel getScenarioType(long userId,long scenarioTypeId) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        ScenarioTypeWSDTO scenarioTypeWSDTO = scenarioSettingsFramework.getScenarioTypeService(userId,scenarioTypeId);
        if (scenarioTypeWSDTO != null){
            scenarioTypeWSDTOS.add(scenarioTypeWSDTO);
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("getScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel createScenarioType(long userId,String scenarioType,String baseType) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        ScenarioTypeWSDTO scenarioTypeWSDTO = scenarioSettingsFramework.createScenarioTypeService(userId,scenarioType,baseType);
        if (scenarioTypeWSDTO != null){
            scenarioTypeWSDTOS.add(scenarioTypeWSDTO);
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("createScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel updateScenarioType(long userId,long scenarioTypeId,String scenarioType,String baseType) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        ScenarioTypeWSDTO scenarioTypeWSDTO = scenarioSettingsFramework.updateScenarioTypeService(userId,scenarioTypeId,scenarioType,baseType);
        if (scenarioTypeWSDTO != null){
            scenarioTypeWSDTOS.add(scenarioTypeWSDTO);
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("updateScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel removeScenarioType(long userId,long scenarioTypeId) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        ScenarioTypeWSDTO scenarioTypeWSDTO = scenarioSettingsFramework.removeScenarioTypeService(userId,scenarioTypeId);
        if (scenarioTypeWSDTO != null){
            scenarioTypeWSDTOS.add(scenarioTypeWSDTO);
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("removeScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
