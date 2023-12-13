package com.faas.core.base.middleware.scenario.element.details;

import com.faas.core.base.framework.scenario.element.details.ScenarioElementDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.ScenarioDataWSModel;
import com.faas.core.base.model.ws.scenario.details.dto.ScenarioDataWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScenarioElementDetailsMiddleware {


    @Autowired
    ScenarioElementDetailsFramework scenarioElementDetailsFramework;


    public ScenarioDataWSModel getScenarioActionDatas(long userId, String scenarioId, String elementId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioDataWSDTO> scenarioDataWSDTOS = scenarioElementDetailsFramework.getScenarioActionDatasService(scenarioId,elementId);
        if (scenarioDataWSDTOS != null){
            response.setScenarioDatas(scenarioDataWSDTOS);
        }

        general.setOperation("getScenarioActionDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel getScenarioActionData(long userId,String scenarioId,String elementId,String dataId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioElementDetailsFramework.getScenarioActionDataService(scenarioId,elementId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("getScenarioActionData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel createScenarioActionData(long userId, String scenarioId,String elementId,long typeId,String value) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioElementDetailsFramework.createScenarioActionDataService(scenarioId,elementId,typeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("createScenarioActionData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel updateScenarioActionData(long userId, String scenarioId,String elementId,String dataId,long typeId,String value) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioElementDetailsFramework.updateScenarioActionDataService(scenarioId,elementId,dataId,typeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("updateScenarioActionData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel removeScenarioActionData(long userId, String scenarioId, String elementId, String dataId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioElementDetailsFramework.removeScenarioActionDataService(scenarioId,elementId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("removeScenarioActionData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioDataWSModel getScenarioAutomationDatas(long userId,String scenarioId,String elementId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioDataWSDTO> scenarioDataWSDTOS = scenarioElementDetailsFramework.getScenarioAutomationDatasService(scenarioId,elementId);
        if (scenarioDataWSDTOS != null){
            response.setScenarioDatas(scenarioDataWSDTOS);
        }

        general.setOperation("getScenarioAutomationDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel getScenarioAutomationData(long userId,String scenarioId,String elementId,String dataId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioElementDetailsFramework.getScenarioAutomationDataService(scenarioId,elementId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("getScenarioAutomationData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel createScenarioAutomationData(long userId,String scenarioId,String elementId,long typeId,String value) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioElementDetailsFramework.createScenarioAutomationDataService(scenarioId,elementId,typeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("createScenarioAutomationData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel updateScenarioAutomationData(long userId,String scenarioId,String elementId,String dataId,long typeId,String value) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioElementDetailsFramework.updateScenarioAutomationDataService(scenarioId,elementId,dataId,typeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("updateScenarioAutomationData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ScenarioDataWSModel removeScenarioAutomationData(long userId,String scenarioId,String elementId,String dataId) {

        ScenarioDataWSModel response = new ScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();

        ScenarioDataWSDTO scenarioDataWSDTO = scenarioElementDetailsFramework.removeScenarioAutomationDataService(scenarioId,elementId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("removeScenarioAutomationData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
