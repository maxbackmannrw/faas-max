package com.faas.core.base.framework.scenario.details.element.content;

import com.faas.core.base.model.db.scenario.temp.ActionTempDBModel;
import com.faas.core.base.model.db.scenario.temp.AutomationTempDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.ActionDAO;
import com.faas.core.base.model.db.scenario.content.dao.AutomationDAO;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioElement;
import com.faas.core.base.model.ws.scenario.details.element.content.dto.ScenarioElementWSDTO;
import com.faas.core.base.repo.scenario.temp.ActionTempRepository;
import com.faas.core.base.repo.scenario.temp.AutomationTempRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ScenarioElementFramework {

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    AutomationTempRepository automationTempRepository;

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AppUtils appUtils;


    public List<ScenarioElementWSDTO> getScenarioElementsService(String scenarioId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            List<ScenarioElementWSDTO> scenarioElementWSDTOS = new ArrayList<>();
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                scenarioElementWSDTOS.add(new ScenarioElementWSDTO(scenarioDBModel.get().getElements().get(i)));
            }
            return scenarioElementWSDTOS;
        }
        return null;
    }


    public ScenarioElementWSDTO getScenarioElementService(String scenarioId,String elementId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                if (scenarioDBModel.get().getElements().get(i).getId().equalsIgnoreCase(elementId)){
                    return new ScenarioElementWSDTO(scenarioDBModel.get().getElements().get(i));
                }
            }
        }
        return null;
    }


    public ScenarioElementWSDTO createScenarioElementService(String scenarioId,String element,String elementType,long tempId,int elementOrder) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() ){
            ScenarioElement scenarioElement = null;
            if (elementType.equalsIgnoreCase(AppConstant.ACTION_ELEMENT)){
                scenarioElement = createScenarioAction(element,elementType,tempId,elementOrder);
            }
            if (elementType.equalsIgnoreCase(AppConstant.AUTOMATION_ELEMENT)){
                scenarioElement = createScenarioAutomation(element,elementType,tempId,elementOrder);
            }
            if (scenarioElement != null){

                scenarioDBModel.get().getElements().add(scenarioElement);
                scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                scenarioRepository.save(scenarioDBModel.get());

                return new ScenarioElementWSDTO(scenarioElement);
            }
        }
        return null;
    }


    public ScenarioElement createScenarioAction(String element,String elementType,long tempId,int elementOrder){

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(tempId);
        if (actionTempDBModel.isPresent()){

            ScenarioElement scenarioElement = new ScenarioElement();
            scenarioElement.setId(appUtils.generateUUID());
            scenarioElement.setElement(element);
            scenarioElement.setElementType(elementType);
            scenarioElement.setAction(createActionDAO(actionTempDBModel.get()));
            scenarioElement.setVariables(new ArrayList<>());
            scenarioElement.setElementOrder(elementOrder);
            scenarioElement.setuDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setcDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setStatus(1);

            return scenarioElement;
        }
        return null;
    }


    public ActionDAO createActionDAO(ActionTempDBModel actionTempDBModel){

        ActionDAO actionDAO = new ActionDAO();

        actionDAO.setTempId(actionTempDBModel.getId());
        actionDAO.setActionTemp(actionTempDBModel.getActionTemp());
        actionDAO.setcDate(appUtils.getCurrentTimeStamp());
        actionDAO.setStatus(1);

        return actionDAO;
    }


    public ScenarioElement createScenarioAutomation(String element,String elementType,long tempId,int elementOrder){

        Optional<AutomationTempDBModel> automationTempDBModel = automationTempRepository.findById(tempId);
        if (automationTempDBModel.isPresent()){

            ScenarioElement scenarioElement = new ScenarioElement();
            scenarioElement.setId(appUtils.generateUUID());
            scenarioElement.setElement(element);
            scenarioElement.setElementType(elementType);
            scenarioElement.setAutomation(createAutomationDAO(automationTempDBModel.get()));
            scenarioElement.setVariables(new ArrayList<>());
            scenarioElement.setElementOrder(elementOrder);
            scenarioElement.setuDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setcDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setStatus(1);

            return scenarioElement;
        }
        return null;
    }

    public AutomationDAO createAutomationDAO(AutomationTempDBModel automationTempDBModel){

        AutomationDAO automationDAO = new AutomationDAO();
        automationDAO.setTempId(automationTempDBModel.getId());
        automationDAO.setAutomationTemp(automationTempDBModel.getAutomationTemp());
        automationDAO.setTypeId(automationTempDBModel.getTypeId());
        automationDAO.setAutomationType(automationTempDBModel.getAutomationType());
        automationDAO.setcDate(appUtils.getCurrentTimeStamp());
        automationDAO.setStatus(1);

        return automationDAO;
    }




    public ScenarioElementWSDTO updateScenarioElementService(String scenarioId,String elementId,String element,String elementType,long tempId,int elementOrder) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                if (scenarioDBModel.get().getElements().get(i).getId().equalsIgnoreCase(elementId)){
                    if (scenarioDBModel.get().getElements().get(i).getElementType().equalsIgnoreCase(AppConstant.ACTION_ELEMENT)){
                        ScenarioElement scenarioElement = updateScenarioAction(elementId,element,elementType,tempId,elementOrder);
                        if (scenarioElement != null){

                            scenarioDBModel.get().getElements().set(i,scenarioElement);
                            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioRepository.save(scenarioDBModel.get());

                            return new ScenarioElementWSDTO(scenarioElement);
                        }
                    }
                    if (scenarioDBModel.get().getElements().get(i).getElementType().equalsIgnoreCase(AppConstant.AUTOMATION_ELEMENT)){
                        ScenarioElement scenarioElement = updateScenarioAutomation(elementId,element,elementType,tempId,elementOrder);
                        if (scenarioElement != null){

                            scenarioDBModel.get().getElements().set(i,scenarioElement);
                            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioRepository.save(scenarioDBModel.get());

                            return new ScenarioElementWSDTO(scenarioElement);
                        }
                    }
                }
            }
        }
        return null;
    }



    public ScenarioElement updateScenarioAction(String elementId,String element,String elementType,long tempId,int elementOrder){

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(tempId);
        if (actionTempDBModel.isPresent()){

            ScenarioElement scenarioElement = new ScenarioElement();
            scenarioElement.setId(elementId);
            scenarioElement.setElement(element);
            scenarioElement.setElementType(elementType);
            scenarioElement.setAction(createActionDAO(actionTempDBModel.get()));
            scenarioElement.setVariables(new ArrayList<>());
            scenarioElement.setElementOrder(elementOrder);
            scenarioElement.setuDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setcDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setStatus(1);

            return scenarioElement;
        }
        return null;
    }

    public ScenarioElement updateScenarioAutomation(String elementId,String element,String elementType,long tempId,int elementOrder){

        Optional<AutomationTempDBModel> automationTempDBModel = automationTempRepository.findById(tempId);
        if (automationTempDBModel.isPresent()){

            ScenarioElement scenarioElement = new ScenarioElement();
            scenarioElement.setId(elementId);
            scenarioElement.setElement(element);
            scenarioElement.setElementType(elementType);
            scenarioElement.setAutomation(createAutomationDAO(automationTempDBModel.get()));
            scenarioElement.setVariables(new ArrayList<>());
            scenarioElement.setElementOrder(elementOrder);
            scenarioElement.setuDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setcDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setStatus(1);

            return scenarioElement;
        }
        return null;
    }


    public ScenarioElementWSDTO removeScenarioElementService(String scenarioId,String elementId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getElements() != null){
            for (int i=0;i<scenarioDBModel.get().getElements().size();i++){
                if (scenarioDBModel.get().getElements().get(i).getId().equalsIgnoreCase(elementId)){
                    ScenarioElement scenarioElement = scenarioDBModel.get().getElements().get(i);
                    scenarioDBModel.get().getElements().remove(scenarioElement);
                    scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioRepository.save(scenarioDBModel.get());

                    return new ScenarioElementWSDTO(scenarioElement);
                }
            }
        }
        return null;
    }



}
