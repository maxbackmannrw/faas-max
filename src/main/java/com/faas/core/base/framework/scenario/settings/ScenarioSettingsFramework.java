package com.faas.core.base.framework.scenario.settings;

import com.faas.core.base.model.db.scenario.settings.AutomationTypeDBModel;
import com.faas.core.base.model.db.scenario.settings.ScenarioTypeDBModel;
import com.faas.core.base.model.db.scenario.settings.VariableTypeDBModel;
import com.faas.core.base.model.ws.scenario.settings.dto.AutomationTypeWSDTO;
import com.faas.core.base.model.ws.scenario.settings.dto.ScenarioTypeWSDTO;
import com.faas.core.base.model.ws.scenario.settings.dto.VariableTypeWSDTO;
import com.faas.core.base.repo.scenario.settings.AutomationTypeRepository;
import com.faas.core.base.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.base.repo.scenario.settings.VariableTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ScenarioSettingsFramework {

    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    AutomationTypeRepository automationTypeRepository;

    @Autowired
    VariableTypeRepository variableTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ScenarioTypeWSDTO fillScenarioTypeWSDTO(ScenarioTypeDBModel scenarioTypeDBModel) {

        ScenarioTypeWSDTO scenarioTypeWSDTO = new ScenarioTypeWSDTO();
        scenarioTypeWSDTO.setScenarioType(scenarioTypeDBModel);
        return scenarioTypeWSDTO;
    }


    public ScenarioTypeDBModel createScenarioTypeService(String scenarioType, String baseType) {

        ScenarioTypeDBModel scenarioTypeDBModel = new ScenarioTypeDBModel();
        scenarioTypeDBModel.setScenarioType(scenarioType);
        scenarioTypeDBModel.setBaseType(baseType);
        scenarioTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        scenarioTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        scenarioTypeDBModel.setStatus(1);

        return scenarioTypeRepository.save(scenarioTypeDBModel);
    }


    public ScenarioTypeDBModel updateScenarioTypeService(long typeId, String scenarioType, String baseType) {

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
        if (scenarioTypeDBModel.isPresent()) {
            scenarioTypeDBModel.get().setScenarioType(scenarioType);
            scenarioTypeDBModel.get().setBaseType(baseType);
            scenarioTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            scenarioTypeDBModel.get().setStatus(1);

            return scenarioTypeRepository.save(scenarioTypeDBModel.get());
        }
        return null;
    }


    public ScenarioTypeDBModel removeScenarioTypeService(long typeId) {

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
        if (scenarioTypeDBModel.isPresent()) {
            scenarioTypeRepository.delete(scenarioTypeDBModel.get());
            return scenarioTypeDBModel.get();
        }
        return null;
    }



    public List<AutomationTypeWSDTO> getAutomationTypesService(long userId) {

        List<AutomationTypeWSDTO>automationTypeWSDTOS = new ArrayList<>();
        List<AutomationTypeDBModel> automationTypeDBModels = automationTypeRepository.findByStatus(1);
        for (AutomationTypeDBModel automationTypeDBModel : automationTypeDBModels) {
            automationTypeWSDTOS.add(new AutomationTypeWSDTO(automationTypeDBModel));
        }
        return automationTypeWSDTOS;
    }


    public AutomationTypeWSDTO getAutomationTypeService(long userId,long typeId) {

        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent()){
            return new AutomationTypeWSDTO(automationTypeDBModel.get());
        }
        return null;
    }


    public AutomationTypeWSDTO createAutomationTypeService(long userId,String automationType,String baseType) {

        AutomationTypeDBModel automationTypeDBModel = new AutomationTypeDBModel();

        automationTypeDBModel.setAutomationType(automationType);
        automationTypeDBModel.setBaseType(baseType);
        automationTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        automationTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        automationTypeDBModel.setStatus(1);

        return new AutomationTypeWSDTO(automationTypeRepository.save(automationTypeDBModel));
    }


    public AutomationTypeWSDTO updateAutomationTypeService(long userId,long typeId,String automationType,String baseType) {

        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent()){

            automationTypeDBModel.get().setAutomationType(automationType);
            automationTypeDBModel.get().setBaseType(baseType);
            automationTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            automationTypeDBModel.get().setStatus(1);

            return new AutomationTypeWSDTO(automationTypeRepository.save(automationTypeDBModel.get()));
        }
        return null;
    }


    public AutomationTypeWSDTO removeAutomationTypeService(long userId,long typeId) {

        Optional<AutomationTypeDBModel> automationTypeDBModel = automationTypeRepository.findById(typeId);
        if (automationTypeDBModel.isPresent()){
            automationTypeRepository.delete(automationTypeDBModel.get());
            return new AutomationTypeWSDTO(automationTypeDBModel.get());
        }
        return null;
    }


    public List<VariableTypeWSDTO> getAllVariableTypesService(long userId) {

        List<VariableTypeWSDTO> variableTypeWSDTOS = new ArrayList<>();
        List<VariableTypeDBModel> variableTypeDBModels = variableTypeRepository.findByStatus(1);
        for (VariableTypeDBModel variableTypeDBModel : variableTypeDBModels) {
            variableTypeWSDTOS.add(new VariableTypeWSDTO(variableTypeDBModel));
        }
        return variableTypeWSDTOS;
    }


    public List<VariableTypeWSDTO> getVariableTypesByCategoryService(long userId, String category) {

        List<VariableTypeWSDTO> variableTypeWSDTOS = new ArrayList<>();
        List<VariableTypeDBModel> variableTypeDBModels = variableTypeRepository.findByCategory(category);
        for (VariableTypeDBModel variableTypeDBModel : variableTypeDBModels) {
            variableTypeWSDTOS.add(new VariableTypeWSDTO(variableTypeDBModel));
        }
        return variableTypeWSDTOS;
    }


    public VariableTypeWSDTO getVariableTypeService(long userId, long typeId) {

        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (variableTypeDBModel.isPresent()) {
           return new VariableTypeWSDTO(variableTypeDBModel.get());
        }
        return null;
    }


    public VariableTypeWSDTO createVariableTypeService(long userId, String variableType, String category) {

        VariableTypeDBModel variableTypeDBModel = new VariableTypeDBModel();
        variableTypeDBModel.setVariableType(variableType);
        variableTypeDBModel.setCategory(category);
        variableTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        variableTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        variableTypeDBModel.setStatus(1);

        return new VariableTypeWSDTO(variableTypeRepository.save(variableTypeDBModel));
    }


    public VariableTypeWSDTO updateVariableTypeService(long userId, long typeId, String variableType, String category) {

        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (variableTypeDBModel.isPresent()) {
            variableTypeDBModel.get().setVariableType(variableType);
            variableTypeDBModel.get().setCategory(category);
            variableTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            variableTypeDBModel.get().setStatus(1);

            return new VariableTypeWSDTO(variableTypeRepository.save(variableTypeDBModel.get()));
        }
        return null;
    }


    public VariableTypeWSDTO removeVariableTypeService(long userId, long typeId) {

        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (variableTypeDBModel.isPresent()) {
            variableTypeRepository.delete(variableTypeDBModel.get());
            return new VariableTypeWSDTO(variableTypeDBModel.get());
        }
        return null;
    }




}
