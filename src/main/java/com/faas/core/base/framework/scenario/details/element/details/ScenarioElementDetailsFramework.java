package com.faas.core.base.framework.scenario.details.element.details;

import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.ElementVariableDAO;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioVariableDAO;
import com.faas.core.base.model.db.scenario.settings.VariableTypeDBModel;
import com.faas.core.base.model.ws.scenario.details.element.details.dto.ElementVariableWSDTO;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.scenario.settings.VariableTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ScenarioElementDetailsFramework {


    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    VariableTypeRepository variableTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ElementVariableWSDTO> getElementVariablesService(String scenarioId, String elementId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);

        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                if (scenarioDBModel.get().getElements().get(i).getId().equalsIgnoreCase(elementId) && scenarioDBModel.get().getElements().get(i).getVariables() != null){
                    List<ElementVariableWSDTO>elementVariableWSDTOS = new ArrayList<>();
                    for (int j=0;j<scenarioDBModel.get().getElements().get(i).getVariables().size();j++){
                        elementVariableWSDTOS.add(new ElementVariableWSDTO(scenarioDBModel.get().getElements().get(i).getVariables().get(j)));
                    }
                    return elementVariableWSDTOS;
                }
            }
        }
        return null;
    }


    public ElementVariableWSDTO getElementVariableService(String scenarioId,String elementId,String variableId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);

        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                if (scenarioDBModel.get().getElements().get(i).getId().equalsIgnoreCase(elementId) && scenarioDBModel.get().getElements().get(i).getVariables() != null){
                    for (int j=0;j<scenarioDBModel.get().getElements().get(i).getVariables().size();j++){
                        if (scenarioDBModel.get().getElements().get(i).getVariables().get(j).getVariableId().equalsIgnoreCase(variableId)){
                            return new ElementVariableWSDTO(scenarioDBModel.get().getElements().get(i).getVariables().get(j));
                        }
                    }
                }
            }
        }
        return null;
    }


    public ElementVariableWSDTO createElementVariableService(String scenarioId,String elementId,long typeId,String value) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);

        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null && variableTypeDBModel.isPresent()){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                if (scenarioDBModel.get().getElements().get(i).getId().equalsIgnoreCase(elementId)){

                    ElementVariableDAO elementVariableDAO = new ElementVariableDAO();
                    elementVariableDAO.setVariableId(appUtils.generateUUID());
                    elementVariableDAO.setVariableType(variableTypeDBModel.get().getVariableType());
                    elementVariableDAO.setValue(value);
                    elementVariableDAO.setcDate(appUtils.getCurrentTimeStamp());
                    elementVariableDAO.setStatus(1);

                    scenarioDBModel.get().getElements().get(i).getVariables().add(elementVariableDAO);
                    scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioRepository.save(scenarioDBModel.get());

                    return new ElementVariableWSDTO(elementVariableDAO);
                }
            }
        }
        return null;
    }


    public ElementVariableWSDTO updateElementVariableService(String scenarioId,String elementId,String variableId,long typeId,String value) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<VariableTypeDBModel> variableTypeDBModel = variableTypeRepository.findById(typeId);

        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null  && variableTypeDBModel.isPresent()){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                if (scenarioDBModel.get().getElements().get(i).getId().equalsIgnoreCase(elementId) && scenarioDBModel.get().getElements().get(i).getVariables() != null){
                    for (int j=0;j<scenarioDBModel.get().getElements().get(i).getVariables().size();j++){
                        if (scenarioDBModel.get().getElements().get(i).getVariables().get(j).getVariableId().equalsIgnoreCase(variableId)){

                            scenarioDBModel.get().getElements().get(i).getVariables().get(j).setVariableType(variableTypeDBModel.get().getVariableType());
                            scenarioDBModel.get().getElements().get(i).getVariables().get(j).setValue(value);
                            scenarioDBModel.get().getElements().get(i).getVariables().get(j).setcDate(appUtils.getCurrentTimeStamp());
                            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioRepository.save(scenarioDBModel.get());

                            return new ElementVariableWSDTO(scenarioDBModel.get().getElements().get(i).getVariables().get(j));
                        }
                    }
                }
            }
        }
        return null;
    }


    public ElementVariableWSDTO removeElementVariableService(String scenarioId,String elementId,String variableId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);

        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                if (scenarioDBModel.get().getElements().get(i).getId().equalsIgnoreCase(elementId) && scenarioDBModel.get().getElements().get(i).getVariables() != null){
                    for (int j=0;j<scenarioDBModel.get().getElements().get(i).getVariables().size();j++){
                        if (scenarioDBModel.get().getElements().get(i).getVariables().get(j).getVariableId().equalsIgnoreCase(variableId)){

                            ElementVariableDAO elementVariableDAO = scenarioDBModel.get().getElements().get(i).getVariables().get(j);
                            scenarioDBModel.get().getElements().get(i).getVariables().remove(elementVariableDAO);
                            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioRepository.save(scenarioDBModel.get());

                            return new ElementVariableWSDTO(elementVariableDAO);
                        }
                    }
                }
            }
        }
        return null;
    }




}
