package com.faas.core.base.middleware.scenario.details.content;

import com.faas.core.base.framework.scenario.details.content.ScenarioDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.content.ScenarioVariableWSModel;
import com.faas.core.base.model.ws.scenario.details.element.content.ScenarioElementWSModel;
import com.faas.core.base.model.ws.scenario.details.content.dto.ScenarioVariableWSDTO;
import com.faas.core.base.model.ws.scenario.details.element.content.dto.ScenarioElementWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScenarioDetailsMiddleware {


    @Autowired
    ScenarioDetailsFramework scenarioDetailsFramework;




    public ScenarioVariableWSModel getScenarioVariables(long userId, String scenarioId) {

        ScenarioVariableWSModel response = new ScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioVariableWSDTO> scenarioVariableWSDTOS = scenarioDetailsFramework.getScenarioVariablesService(scenarioId);
        if (scenarioVariableWSDTOS != null){
            response.setScenarioVariables(scenarioVariableWSDTOS);
        }

        general.setOperation("getScenarioVariables");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioVariableWSModel getScenarioVariable(long userId, String scenarioId, String variableId) {

        ScenarioVariableWSModel response = new ScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();

        ScenarioVariableWSDTO scenarioVariableWSDTO = scenarioDetailsFramework.getScenarioVariableService(scenarioId,variableId);
        if (scenarioVariableWSDTO != null){
            scenarioVariableWSDTOS.add(scenarioVariableWSDTO);
        }

        response.setScenarioVariables(scenarioVariableWSDTOS);
        general.setOperation("getScenarioVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioVariableWSModel createScenarioVariable(long userId, String scenarioId, long typeId, String value) {

        ScenarioVariableWSModel response = new ScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();

        ScenarioVariableWSDTO scenarioVariableWSDTO = scenarioDetailsFramework.createScenarioVariableService(scenarioId,typeId,value);
        if (scenarioVariableWSDTO != null){
            scenarioVariableWSDTOS.add(scenarioVariableWSDTO);
        }

        response.setScenarioVariables(scenarioVariableWSDTOS);
        general.setOperation("createScenarioVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioVariableWSModel updateScenarioVariable(long userId, String scenarioId, String variableId, long typeId, String value) {

        ScenarioVariableWSModel response = new ScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();

        ScenarioVariableWSDTO scenarioVariableWSDTO = scenarioDetailsFramework.updateScenarioVariableService(scenarioId,variableId,typeId,value);
        if (scenarioVariableWSDTO != null){
            scenarioVariableWSDTOS.add(scenarioVariableWSDTO);
        }

        response.setScenarioVariables(scenarioVariableWSDTOS);
        general.setOperation("updateScenarioVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ScenarioVariableWSModel removeScenarioVariable(long userId, String scenarioId, String variableId) {

        ScenarioVariableWSModel response = new ScenarioVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();

        ScenarioVariableWSDTO scenarioVariableWSDTO = scenarioDetailsFramework.removeScenarioVariableService(scenarioId,variableId);
        if (scenarioVariableWSDTO != null){
            scenarioVariableWSDTOS.add(scenarioVariableWSDTO);
        }

        response.setScenarioVariables(scenarioVariableWSDTOS);
        general.setOperation("removeScenarioVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
