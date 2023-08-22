package com.faas.core.base.middleware.scenario.details.element.details;

import com.faas.core.base.framework.scenario.details.element.details.ScenarioElementDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.content.dto.ScenarioVariableWSDTO;
import com.faas.core.base.model.ws.scenario.details.element.details.ElementVariableWSModel;
import com.faas.core.base.model.ws.scenario.details.element.details.dto.ElementVariableWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScenarioElementDetailsMiddleware {


    @Autowired
    ScenarioElementDetailsFramework scenarioElementDetailsFramework;


    public ElementVariableWSModel getElementVariables(long userId, String scenarioId, String elementId) {

        ElementVariableWSModel response = new ElementVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ElementVariableWSDTO> elementVariables = scenarioElementDetailsFramework.getElementVariablesService(scenarioId,elementId);
        if (elementVariables != null){
            response.setElementVariables(elementVariables);
        }

        general.setOperation("getElementVariables");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ElementVariableWSModel getElementVariable(long userId, String scenarioId, String elementId, String variableId) {

        ElementVariableWSModel response = new ElementVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ElementVariableWSDTO>elementVariables = new ArrayList<>();

        ElementVariableWSDTO elementVariable = scenarioElementDetailsFramework.getElementVariableService(scenarioId,elementId,variableId);
        if (elementVariable != null){
            elementVariables.add(elementVariable);
        }

        response.setElementVariables(elementVariables);
        general.setOperation("getElementVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ElementVariableWSModel createElementVariable(long userId, String scenarioId, String elementId, long typeId, String value) {

        ElementVariableWSModel response = new ElementVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ElementVariableWSDTO>elementVariables = new ArrayList<>();

        ElementVariableWSDTO elementVariable = scenarioElementDetailsFramework.createElementVariableService(scenarioId,elementId,typeId,value);
        if (elementVariable != null){
            elementVariables.add(elementVariable);
        }

        response.setElementVariables(elementVariables);
        general.setOperation("createElementVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ElementVariableWSModel updateElementVariable(long userId, String scenarioId, String elementId, String variableId, long typeId, String value) {

        ElementVariableWSModel response = new ElementVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ElementVariableWSDTO>elementVariables = new ArrayList<>();

        ElementVariableWSDTO elementVariable = scenarioElementDetailsFramework.updateElementVariableService(scenarioId,elementId,variableId,typeId,value);
        if (elementVariable != null){
            elementVariables.add(elementVariable);
        }

        response.setElementVariables(elementVariables);
        general.setOperation("updateElementVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ElementVariableWSModel removeElementVariable(long userId, String scenarioId, String elementId, String variableId) {

        ElementVariableWSModel response = new ElementVariableWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ElementVariableWSDTO>elementVariables = new ArrayList<>();

        ElementVariableWSDTO elementVariable = scenarioElementDetailsFramework.removeElementVariableService(scenarioId,elementId,variableId);
        if (elementVariable != null){
            elementVariables.add(elementVariable);
        }

        response.setElementVariables(elementVariables);
        general.setOperation("removeElementVariable");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
