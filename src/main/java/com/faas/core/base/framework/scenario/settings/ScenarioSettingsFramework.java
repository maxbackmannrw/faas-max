package com.faas.core.base.framework.scenario.settings;

import com.faas.core.data.db.scenario.settings.ScenarioTypeDBModel;
import com.faas.core.data.ws.base.scenario.settings.dto.ScenarioTypeWSDTO;
import com.faas.core.data.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ScenarioSettingsFramework {


    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ScenarioTypeWSDTO> getScenarioTypesService(long userId) {

        List<ScenarioTypeWSDTO> scenarioTypeWSDTOS = new ArrayList<>();
        List<ScenarioTypeDBModel> scenarioTypeDBModels = scenarioTypeRepository.findByStatus(1);
        for (ScenarioTypeDBModel scenarioTypeDBModel : scenarioTypeDBModels) {
            scenarioTypeWSDTOS.add(new ScenarioTypeWSDTO(scenarioTypeDBModel));
        }
        return scenarioTypeWSDTOS;
    }

    public List<ScenarioTypeWSDTO> getScenarioTypesByBaseTypeService(long userId, String baseType) {

        List<ScenarioTypeWSDTO> scenarioTypeWSDTOS = new ArrayList<>();
        List<ScenarioTypeDBModel> scenarioTypeDBModels = scenarioTypeRepository.findByBaseType(baseType);
        for (ScenarioTypeDBModel scenarioTypeDBModel : scenarioTypeDBModels) {
            scenarioTypeWSDTOS.add(new ScenarioTypeWSDTO(scenarioTypeDBModel));
        }
        return scenarioTypeWSDTOS;
    }

    public ScenarioTypeWSDTO getScenarioTypeService(long userId, long scenarioTypeId) {

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(scenarioTypeId);
        if (scenarioTypeDBModel.isPresent()) {
            return new ScenarioTypeWSDTO(scenarioTypeDBModel.get());
        }
        return null;
    }

    public ScenarioTypeWSDTO createScenarioTypeService(long userId, String scenarioType, String baseType) {

        ScenarioTypeDBModel scenarioTypeDBModel = new ScenarioTypeDBModel();
        scenarioTypeDBModel.setScenarioType(scenarioType);
        scenarioTypeDBModel.setBaseType(baseType);
        scenarioTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        scenarioTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        scenarioTypeDBModel.setStatus(1);

        return new ScenarioTypeWSDTO(scenarioTypeRepository.save(scenarioTypeDBModel));
    }

    public ScenarioTypeWSDTO updateScenarioTypeService(long userId, long scenarioTypeId, String scenarioType, String baseType) {

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(scenarioTypeId);
        if (scenarioTypeDBModel.isPresent()) {

            scenarioTypeDBModel.get().setScenarioType(scenarioType);
            scenarioTypeDBModel.get().setBaseType(baseType);
            scenarioTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            scenarioTypeDBModel.get().setStatus(1);

            return new ScenarioTypeWSDTO(scenarioTypeRepository.save(scenarioTypeDBModel.get()));
        }
        return null;
    }

    public ScenarioTypeWSDTO removeScenarioTypeService(long userId, long scenarioTypeId) {

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(scenarioTypeId);
        if (scenarioTypeDBModel.isPresent()) {
            scenarioTypeRepository.delete(scenarioTypeDBModel.get());
        }
        return null;
    }


}
