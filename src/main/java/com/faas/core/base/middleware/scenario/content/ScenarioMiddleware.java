package com.faas.core.base.middleware.scenario.content;

import com.faas.core.base.framework.scenario.content.ScenarioFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.content.ScenarioWSModel;
import com.faas.core.base.model.ws.scenario.content.dto.ScenarioWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScenarioMiddleware {


    @Autowired
    ScenarioFramework scenarioFramework;


    public ScenarioWSModel getScenarios(long userId) {

        ScenarioWSModel response = new ScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioWSDTO> scenarioWSDTOS = scenarioFramework.getScenarios();
        if (scenarioWSDTOS != null){
            response.setScenarios(scenarioWSDTOS);
        }

        general.setOperation("getScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioWSModel getScenariosByBaseType(long userId, String baseType) {

        ScenarioWSModel response = new ScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioWSDTO> scenarioWSDTOS = scenarioFramework.getScenariosByBaseTypeService(baseType);
        if (scenarioWSDTOS != null){
            response.setScenarios(scenarioWSDTOS);
        }

        general.setOperation("getScenariosByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioWSModel getScenario(long userId, String scenarioId) {

        ScenarioWSModel response = new ScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioWSDTO> scenarioWSDTOS = new ArrayList<>();

        ScenarioWSDTO scenarioWSDTO = scenarioFramework.getScenarioService(scenarioId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setScenarios(scenarioWSDTOS);
        general.setOperation("getScenarioTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioWSModel createScenario(long userId, String scenario,long typeId) {

        ScenarioWSModel response = new ScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioWSDTO> scenarioWSDTOS = new ArrayList<>();

        ScenarioWSDTO scenarioWSDTO = scenarioFramework.createScenarioService(scenario,typeId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setScenarios(scenarioWSDTOS);
        general.setOperation("createScenarioTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioWSModel updateScenario(long userId,String scenarioId,String scenario,long typeId) {

        ScenarioWSModel response = new ScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioWSDTO> scenarioWSDTOS = new ArrayList<>();

        ScenarioWSDTO scenarioWSDTO = scenarioFramework.updateScenarioService(scenarioId,scenario,typeId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setScenarios(scenarioWSDTOS);
        general.setOperation("updateScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioWSModel removeScenario(long userId, String scenarioId) {

        ScenarioWSModel response = new ScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioWSDTO> scenarioWSDTOS = new ArrayList<>();

        ScenarioWSDTO scenarioWSDTO = scenarioFramework.removeScenarioService(scenarioId);
        if (scenarioWSDTO != null){
            scenarioWSDTOS.add(scenarioWSDTO);
        }

        response.setScenarios(scenarioWSDTOS);
        general.setOperation("removeScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
