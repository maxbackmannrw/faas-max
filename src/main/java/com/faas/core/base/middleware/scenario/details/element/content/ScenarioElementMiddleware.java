package com.faas.core.base.middleware.scenario.details.element.content;

import com.faas.core.base.framework.scenario.details.element.content.ScenarioElementFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.element.content.ScenarioElementWSModel;
import com.faas.core.base.model.ws.scenario.details.element.content.dto.ScenarioElementWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ScenarioElementMiddleware {


    @Autowired
    ScenarioElementFramework scenarioElementFramework;


    public ScenarioElementWSModel getScenarioElements(long userId, String scenarioId) {

        ScenarioElementWSModel response = new ScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ScenarioElementWSDTO> scenarioElementWSDTOS = scenarioElementFramework.getScenarioElementsService(scenarioId);
        if (scenarioElementWSDTOS != null){
            response.setScenarioElements(scenarioElementWSDTOS);
        }

        general.setOperation("getScenarioElements");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioElementWSModel getScenarioElement(long userId,String scenarioId,String elementId) {

        ScenarioElementWSModel response = new ScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();

        ScenarioElementWSDTO scenarioElementWSDTO = scenarioElementFramework.getScenarioElementService(scenarioId,elementId);
        if (scenarioElementWSDTO != null){
            scenarioElementWSDTOS.add(scenarioElementWSDTO);
        }

        response.setScenarioElements(scenarioElementWSDTOS);
        general.setOperation("getScenarioElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioElementWSModel createScenarioElement(long userId,String scenarioId,String element,String elementType,long tempId,int elementOrder) {

        ScenarioElementWSModel response = new ScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();

        ScenarioElementWSDTO scenarioElementWSDTO = scenarioElementFramework.createScenarioElementService(scenarioId,element,elementType,tempId,elementOrder);
        if (scenarioElementWSDTO != null){
            scenarioElementWSDTOS.add(scenarioElementWSDTO);
        }

        response.setScenarioElements(scenarioElementWSDTOS);
        general.setOperation("createScenarioElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioElementWSModel updateScenarioElement(long userId,String scenarioId,String elementId,String element,String elementType,long tempId,int elementOrder) {

        ScenarioElementWSModel response = new ScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();

        ScenarioElementWSDTO scenarioElementWSDTO = scenarioElementFramework.updateScenarioElementService(scenarioId,elementId,element,elementType,tempId,elementOrder);
        if (scenarioElementWSDTO != null){
            scenarioElementWSDTOS.add(scenarioElementWSDTO);
        }

        response.setScenarioElements(scenarioElementWSDTOS);
        general.setOperation("updateScenarioElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioElementWSModel removeScenarioElement(long userId,String scenarioId,String elementId) {

        ScenarioElementWSModel response = new ScenarioElementWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioElementWSDTO>scenarioElementWSDTOS = new ArrayList<>();

        ScenarioElementWSDTO scenarioElementWSDTO = scenarioElementFramework.removeScenarioElementService(scenarioId,elementId);
        if (scenarioElementWSDTO != null){
            scenarioElementWSDTOS.add(scenarioElementWSDTO);
        }

        response.setScenarioElements(scenarioElementWSDTOS);
        general.setOperation("removeScenarioElement");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
