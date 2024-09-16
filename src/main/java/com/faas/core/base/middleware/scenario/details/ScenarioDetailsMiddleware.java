package com.faas.core.base.middleware.scenario.details;

import com.faas.core.base.framework.scenario.details.ScenarioDetailsFramework;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.scenario.details.ScenarioDataWSModel;
import com.faas.core.data.ws.base.scenario.details.dto.ScenarioDataWSDTO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScenarioDetailsMiddleware {


    @Autowired
    ScenarioDetailsFramework scenarioDetailsFramework;


    public ScenarioDataWSModel getScenarioDatas(long userId, String scenarioId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioDataWSDTO> scenarioDataWSDTOS = scenarioDetailsFramework.getScenarioDatasService(scenarioId);
        if (scenarioDataWSDTOS != null) {
            response.setScenarioDatas(scenarioDataWSDTOS);
        }

        general.setOperation("getScenarioDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel getScenarioData(long userId, String scenarioId, String dataId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioDetailsFramework.getScenarioDataService(scenarioId, dataId);
        if (scenarioDataWSDTO != null) {
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("getScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel createScenarioData(long userId, String scenarioId, long typeId, String value) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioDetailsFramework.createScenarioDataService(scenarioId, typeId, value);
        if (scenarioDataWSDTO != null) {
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("createScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel updateScenarioData(long userId, String scenarioId, String dataId, long typeId, String value) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioDetailsFramework.updateScenarioDataService(scenarioId, dataId, typeId, value);
        if (scenarioDataWSDTO != null) {
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("updateScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel removeScenarioData(long userId, String scenarioId, String dataId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioDetailsFramework.removeScenarioDataService(scenarioId, dataId);
        if (scenarioDataWSDTO != null) {
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("removeScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
