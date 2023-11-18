package com.faas.core.base.framework.scenario.content;

import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.settings.ScenarioTypeDBModel;
import com.faas.core.base.model.ws.scenario.content.dto.ScenarioWSDTO;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.base.repo.utils.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ScenarioFramework {


    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ScenarioWSDTO fillScenarioWSDTO(ScenarioDBModel scenarioDBModel) {

        ScenarioWSDTO scenarioWSDTO = new ScenarioWSDTO();
        scenarioWSDTO.setScenario(scenarioDBModel);
        return scenarioWSDTO;
    }


    public List<ScenarioWSDTO> getScenarios() {

        List<ScenarioWSDTO> scenarioWSDTOS = new ArrayList<>();
        List<ScenarioDBModel> scenarioDBModels = scenarioRepository.findByStatus(1);
        for (ScenarioDBModel scenarioDBModel : scenarioDBModels) {
            scenarioWSDTOS.add(fillScenarioWSDTO(scenarioDBModel));
        }
        return scenarioWSDTOS;
    }


    public ScenarioWSDTO getScenarioService(String scenarioId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent()) {
            return fillScenarioWSDTO(scenarioDBModel.get());
        }
        return null;
    }


    public ScenarioWSDTO createScenarioService(String scenario,long typeId) {

        ScenarioDBModel scenarioDBModel = new ScenarioDBModel();
        scenarioDBModel.setScenario(scenario);
        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
        if (scenarioTypeDBModel.isPresent()) {
            scenarioDBModel.setTypeId(typeId);
            scenarioDBModel.setScenarioType(scenarioTypeDBModel.get().getScenarioType());
        }
        scenarioDBModel.setVariables(new ArrayList<>());
        scenarioDBModel.setElements(new ArrayList<>());
        scenarioDBModel.setuDate(appUtils.getCurrentTimeStamp());
        scenarioDBModel.setcDate(appUtils.getCurrentTimeStamp());
        scenarioDBModel.setStatus(1);

        return fillScenarioWSDTO(scenarioRepository.save(scenarioDBModel));
    }


    public ScenarioWSDTO updateScenarioService(String scenarioId,String scenario,long typeId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent()) {
            scenarioDBModel.get().setScenario(scenario);
            Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
            if (scenarioTypeDBModel.isPresent()) {
                scenarioDBModel.get().setTypeId(typeId);
                scenarioDBModel.get().setScenarioType(scenarioTypeDBModel.get().getScenarioType());
            }
            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            scenarioDBModel.get().setStatus(1);

            return fillScenarioWSDTO(scenarioRepository.save(scenarioDBModel.get()));
        }
        return null;
    }


    public ScenarioWSDTO removeScenarioService(String scenarioId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent()) {
            scenarioRepository.delete(scenarioDBModel.get());
            return fillScenarioWSDTO(scenarioDBModel.get());
        }
        return null;
    }


}
