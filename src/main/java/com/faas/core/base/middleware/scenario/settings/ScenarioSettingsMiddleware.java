package com.faas.core.base.middleware.scenario.settings;

import com.faas.core.base.framework.scenario.settings.ScenarioSettingsFramework;
import com.faas.core.base.model.db.scenario.settings.ScenarioTypeDBModel;
import com.faas.core.base.model.ws.scenario.settings.AutomationTypeWSModel;
import com.faas.core.base.model.ws.scenario.settings.dto.AutomationTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.settings.ScenarioTypeWSModel;
import com.faas.core.base.model.ws.scenario.settings.VariableTypeWSModel;
import com.faas.core.base.model.ws.scenario.settings.dto.ScenarioTypeWSDTO;
import com.faas.core.base.model.ws.scenario.settings.dto.VariableTypeWSDTO;
import com.faas.core.base.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ScenarioSettingsMiddleware {

    @Autowired
    ScenarioSettingsFramework scenarioSettingsFramework;

    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;


    @Autowired
    AppUtils appUtils;


    public ScenarioTypeWSModel getAllScenarioTypes(long userId) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        List<ScenarioTypeDBModel> scenarioTypeDBModels = scenarioTypeRepository.findByStatus(1);
        for (ScenarioTypeDBModel scenarioTypeDBModel : scenarioTypeDBModels) {
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel));
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("getAllScenarioTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel getScenarioType(long userId, long typeId) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
        if (scenarioTypeDBModel.isPresent()){
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel.get()));
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

        ScenarioTypeDBModel scenarioTypeDBModel = scenarioSettingsFramework.createScenarioTypeService(scenarioType,baseType);
        if (scenarioTypeDBModel != null){
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel));
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("createScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel updateScenarioType(long userId,long typeId,String scenarioType,String baseType) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        ScenarioTypeDBModel scenarioTypeDBModel = scenarioSettingsFramework.updateScenarioTypeService(typeId,scenarioType,baseType);
        if (scenarioTypeDBModel != null){
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel));
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("updateScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ScenarioTypeWSModel removeScenarioType(long userId,long typeId) {

        ScenarioTypeWSModel response = new ScenarioTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ScenarioTypeWSDTO>scenarioTypeWSDTOS = new ArrayList<>();

        ScenarioTypeDBModel scenarioTypeDBModel = scenarioSettingsFramework.removeScenarioTypeService(typeId);
        if (scenarioTypeDBModel != null){
            scenarioTypeWSDTOS.add(scenarioSettingsFramework.fillScenarioTypeWSDTO(scenarioTypeDBModel));
        }

        response.setScenarioTypes(scenarioTypeWSDTOS);
        general.setOperation("removeScenarioType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public AutomationTypeWSModel getAutomationTypes(long userId) {

        AutomationTypeWSModel response = new AutomationTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AutomationTypeWSDTO> automationTypeWSDTOS = scenarioSettingsFramework.getAutomationTypesService(userId);
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

        AutomationTypeWSDTO automationTypeWSDTO = scenarioSettingsFramework.getAutomationTypeService(userId,typeId);
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


    public AutomationTypeWSModel createAutomationType(long userId,String automationType) {

        AutomationTypeWSModel response = new AutomationTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTypeWSDTO>automationTypeWSDTOS = new ArrayList<>();

        AutomationTypeWSDTO automationTypeWSDTO = scenarioSettingsFramework.createAutomationTypeService(userId,automationType);
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


    public AutomationTypeWSModel updateAutomationType(long userId,long typeId,String automationType) {

        AutomationTypeWSModel response = new AutomationTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AutomationTypeWSDTO>automationTypeWSDTOS = new ArrayList<>();

        AutomationTypeWSDTO automationTypeWSDTO = scenarioSettingsFramework.updateAutomationTypeService(userId,typeId,automationType);
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

        AutomationTypeWSDTO automationTypeWSDTO = scenarioSettingsFramework.removeAutomationTypeService(userId,typeId);
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



    public VariableTypeWSModel getAllVariableTypes(long userId) {

        VariableTypeWSModel response = new VariableTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<VariableTypeWSDTO> variableTypeWSDTOS = scenarioSettingsFramework.getAllVariableTypesService(userId);
        if (variableTypeWSDTOS != null){
            response.setVariableTypes(variableTypeWSDTOS);
        }

        response.setVariableTypes(variableTypeWSDTOS);
        general.setOperation("getAllVariableTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public VariableTypeWSModel getVariableTypesByCategory(long userId,String category) {

        VariableTypeWSModel response = new VariableTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<VariableTypeWSDTO> variableTypeWSDTOS = scenarioSettingsFramework.getVariableTypesByCategoryService(userId,category);
        if (variableTypeWSDTOS != null){
            response.setVariableTypes(variableTypeWSDTOS);
        }

        general.setOperation("getVariableTypesByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public VariableTypeWSModel getVariableType(long userId,long typeId) {

        VariableTypeWSModel response = new VariableTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<VariableTypeWSDTO>variableTypeWSDTOS = new ArrayList<>();

        VariableTypeWSDTO variableTypeWSDTO = scenarioSettingsFramework.getVariableTypeService(userId,typeId);
        if (variableTypeWSDTO != null){
            variableTypeWSDTOS.add(variableTypeWSDTO);
        }

        response.setVariableTypes(variableTypeWSDTOS);
        general.setOperation("getVariableType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public VariableTypeWSModel createVariableType(long userId,String variableType,String category) {

        VariableTypeWSModel response = new VariableTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<VariableTypeWSDTO>variableTypeWSDTOS = new ArrayList<>();

        VariableTypeWSDTO variableTypeWSDTO = scenarioSettingsFramework.createVariableTypeService(userId,variableType,category);
        if (variableTypeWSDTO != null){
            variableTypeWSDTOS.add(variableTypeWSDTO);
        }

        response.setVariableTypes(variableTypeWSDTOS);
        general.setOperation("createVariableType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public VariableTypeWSModel updateVariableType(long userId,long typeId,String variableType,String category) {

        VariableTypeWSModel response = new VariableTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<VariableTypeWSDTO>variableTypeWSDTOS = new ArrayList<>();

        VariableTypeWSDTO variableTypeWSDTO = scenarioSettingsFramework.updateVariableTypeService(userId,typeId,variableType,category);
        if (variableTypeWSDTO != null){
            variableTypeWSDTOS.add(variableTypeWSDTO);
        }

        response.setVariableTypes(variableTypeWSDTOS);
        general.setOperation("updateVariableType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public VariableTypeWSModel removeVariableType(long userId,long typeId) {

        VariableTypeWSModel response = new VariableTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<VariableTypeWSDTO>variableTypeWSDTOS = new ArrayList<>();

        VariableTypeWSDTO variableTypeWSDTO = scenarioSettingsFramework.removeVariableTypeService(userId,typeId);
        if (variableTypeWSDTO != null){
            variableTypeWSDTOS.add(variableTypeWSDTO);
        }

        response.setVariableTypes(variableTypeWSDTOS);
        general.setOperation("removeVariableType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
