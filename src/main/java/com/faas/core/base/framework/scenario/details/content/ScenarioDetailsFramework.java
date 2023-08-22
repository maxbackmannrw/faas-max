package com.faas.core.base.framework.scenario.details.content;

import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioVariableDAO;
import com.faas.core.base.model.db.scenario.settings.VariableTypeDBModel;
import com.faas.core.base.model.ws.scenario.details.content.dto.ScenarioVariableWSDTO;
import com.faas.core.base.repo.action.ActionTempRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.scenario.settings.VariableTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ScenarioDetailsFramework {


    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    VariableTypeRepository variableTypeRepository;

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AppUtils appUtils;



    public ScenarioVariableWSDTO fillScenarioVariableWSDTO(ScenarioVariableDAO scenarioVariableDAO) {

        ScenarioVariableWSDTO scenarioVariableWSDTO = new ScenarioVariableWSDTO();
        scenarioVariableWSDTO.setScenarioVariable(scenarioVariableDAO);
        return scenarioVariableWSDTO;
    }


    public List<ScenarioVariableWSDTO> getScenarioVariablesService(String scenarioId) {

        List<ScenarioVariableWSDTO> scenarioVariableWSDTOS = new ArrayList<>();
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getVariables() != null){
            for (int i=0;i<scenarioDBModel.get().getVariables().size();i++){
                scenarioVariableWSDTOS.add(fillScenarioVariableWSDTO(scenarioDBModel.get().getVariables().get(i)));
            }
        }
        return scenarioVariableWSDTOS;
    }


    public ScenarioVariableWSDTO getScenarioVariableService(String scenarioId, String variableId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getVariables() != null){
            for (int i=0;i<scenarioDBModel.get().getVariables().size();i++){
                if (scenarioDBModel.get().getVariables().get(i).getVariableId().equalsIgnoreCase(variableId)){
                    return fillScenarioVariableWSDTO(scenarioDBModel.get().getVariables().get(i));
                }
            }
        }
        return null;
    }


    public ScenarioVariableWSDTO createScenarioVariableService(String scenarioId, long typeId, String value) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);
        if (scenarioDBModel.isPresent() && variableTypeDBModel.isPresent()){

            ScenarioVariableDAO scenarioVariableDAO = new ScenarioVariableDAO();
            scenarioVariableDAO.setVariableId(appUtils.generateUUID());
            scenarioVariableDAO.setVariableType(variableTypeDBModel.get().getVariableType());
            scenarioVariableDAO.setValue(value);
            scenarioVariableDAO.setcDate(appUtils.getCurrentTimeStamp());
            scenarioVariableDAO.setStatus(1);

            if (scenarioDBModel.get().getVariables() == null){
                List<ScenarioVariableDAO> scenarioVariableDAOS = new ArrayList<>();
                scenarioVariableDAOS.add(scenarioVariableDAO);
                scenarioDBModel.get().setVariables(scenarioVariableDAOS);
            }else {
                scenarioDBModel.get().getVariables().add(scenarioVariableDAO);
            }
            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            scenarioRepository.save(scenarioDBModel.get());

            return fillScenarioVariableWSDTO(scenarioVariableDAO);
        }
        return null;
    }


    public ScenarioVariableWSDTO updateScenarioVariableService(String scenarioId, String variableId, long typeId, String value) {

        return null;
    }


    public ScenarioVariableWSDTO removeScenarioVariableService(String scenarioId, String variableId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getVariables() != null){
            for (int i=0;i<scenarioDBModel.get().getVariables().size();i++){
                if (scenarioDBModel.get().getVariables().get(i).getVariableId().equalsIgnoreCase(variableId)){

                    ScenarioVariableDAO scenarioVariableDAO = scenarioDBModel.get().getVariables().get(i);
                    scenarioDBModel.get().getVariables().remove(scenarioVariableDAO);
                    scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioRepository.save(scenarioDBModel.get());

                    return fillScenarioVariableWSDTO(scenarioVariableDAO);
                }
            }
        }
        return null;
    }



}
