package com.faas.core.base.framework.scenario.content;

import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.settings.ScenarioTypeDBModel;
import com.faas.core.base.model.ws.scenario.content.dto.ScenarioWSDTO;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.base.repo.utils.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ScenarioFramework {


    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ScenarioWSDTO> getScenariosService(long userId) {

        List<ScenarioWSDTO> scenarioWSDTOS = new ArrayList<>();
        List<ScenarioDBModel> scenarioDBModels = scenarioRepository.findByStatus(1);
        for (ScenarioDBModel scenarioDBModel : scenarioDBModels) {
            scenarioWSDTOS.add(new ScenarioWSDTO(scenarioDBModel));
        }
        return scenarioWSDTOS;
    }

    public List<ScenarioWSDTO> getScenariosByBaseTypeService(long userId,String baseType) {

        List<ScenarioWSDTO> scenarioWSDTOS = new ArrayList<>();
        List<ScenarioDBModel> scenarioDBModels = scenarioRepository.findByBaseType(baseType);
        for (ScenarioDBModel scenarioDBModel : scenarioDBModels) {
            scenarioWSDTOS.add(new ScenarioWSDTO(scenarioDBModel));
        }
        return scenarioWSDTOS;
    }

    public ScenarioWSDTO getScenarioService(long userId,String scenarioId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent()) {
            return new ScenarioWSDTO(scenarioDBModel.get());
        }
        return null;
    }

    public ScenarioWSDTO createScenarioService(long userId,String scenario,String scenarioDesc,long typeId) {

        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
        if (scenarioTypeDBModel.isPresent()) {

            ScenarioDBModel scenarioDBModel = new ScenarioDBModel();
            scenarioDBModel.setScenario(scenario);
            scenarioDBModel.setScenarioDesc(scenarioDesc);
            scenarioDBModel.setTypeId(typeId);
            scenarioDBModel.setScenarioType(scenarioTypeDBModel.get().getScenarioType());
            scenarioDBModel.setBaseType(scenarioTypeDBModel.get().getBaseType());
            scenarioDBModel.setScenarioDatas(new ArrayList<>());
            scenarioDBModel.setuDate(appUtils.getCurrentTimeStamp());
            scenarioDBModel.setcDate(appUtils.getCurrentTimeStamp());
            scenarioDBModel.setStatus(1);

            return new ScenarioWSDTO(scenarioRepository.save(scenarioDBModel));
        }
        return null;
    }

    public ScenarioWSDTO updateScenarioService(long userId,String scenarioId,String scenarioDesc,String scenario,long typeId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<ScenarioTypeDBModel> scenarioTypeDBModel = scenarioTypeRepository.findById(typeId);
        if (scenarioDBModel.isPresent() && scenarioTypeDBModel.isPresent()) {

            scenarioDBModel.get().setScenario(scenario);
            scenarioDBModel.get().setScenarioDesc(scenarioDesc);
            scenarioDBModel.get().setTypeId(typeId);
            scenarioDBModel.get().setScenarioType(scenarioTypeDBModel.get().getScenarioType());
            scenarioDBModel.get().setBaseType(scenarioTypeDBModel.get().getBaseType());
            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            scenarioDBModel.get().setStatus(1);

            return new ScenarioWSDTO(scenarioRepository.save(scenarioDBModel.get()));
        }
        return null;
    }

    public ScenarioWSDTO removeScenarioService(String scenarioId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent()) {
            scenarioRepository.delete(scenarioDBModel.get());
            return new ScenarioWSDTO(scenarioDBModel.get());
        }
        return null;
    }


}
