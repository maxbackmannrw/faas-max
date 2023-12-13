package com.faas.core.base.framework.scenario.element.content;

import com.faas.core.base.model.db.action.ActionDBModel;
import com.faas.core.base.model.db.automation.AutomationDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioActionDAO;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioAutomationDAO;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioElement;
import com.faas.core.base.model.ws.scenario.element.dto.ScenarioElementWSDTO;
import com.faas.core.base.repo.action.ActionRepository;
import com.faas.core.base.repo.automation.AutomationRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
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
    AutomationRepository automationRepository;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    AppUtils appUtils;


    public List<ScenarioElementWSDTO> getScenarioElementsService(String scenarioId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            List<ScenarioElementWSDTO> scenarioElementWSDTOS = new ArrayList<>();
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                scenarioElementWSDTOS.add(new ScenarioElementWSDTO(scenarioDBModel.get().getScenarioElements().get(i)));
            }
            return scenarioElementWSDTOS;
        }
        return null;
    }

    public ScenarioElementWSDTO getScenarioElementService(String scenarioId, String elementId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                    return new ScenarioElementWSDTO(scenarioDBModel.get().getScenarioElements().get(i));
                }
            }
        }
        return null;
    }

    public ScenarioElementWSDTO createScenarioActionService(String scenarioId,String element,String elementType,long actionId,int order) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (scenarioDBModel.isPresent() && actionDBModel.isPresent()){

            ScenarioElement scenarioElement = new ScenarioElement();
            scenarioElement.setId(appUtils.generateUUID());
            scenarioElement.setElement(element);
            scenarioElement.setElementType(elementType);

            ScenarioActionDAO scenarioActionDAO = new ScenarioActionDAO();
            scenarioActionDAO.setActionId(actionId);
            scenarioActionDAO.setAction(actionDBModel.get().getAction());
            scenarioActionDAO.setActionDatas(new ArrayList<>());
            scenarioActionDAO.setuDate(appUtils.getCurrentTimeStamp());
            scenarioActionDAO.setcDate(appUtils.getCurrentTimeStamp());
            scenarioActionDAO.setStatus(1);

            scenarioElement.setScenarioAction(scenarioActionDAO);
            scenarioElement.setOrder(order);
            scenarioElement.setuDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setcDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setStatus(1);

            scenarioDBModel.get().getScenarioElements().add(scenarioElement);
            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            scenarioRepository.save(scenarioDBModel.get());

            return new ScenarioElementWSDTO(scenarioElement);
        }
        return null;
    }

    public ScenarioElementWSDTO createScenarioAutomationService(String scenarioId,String element,String elementType,long automationId,int order) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (scenarioDBModel.isPresent() && automationDBModel.isPresent()){

            ScenarioElement scenarioElement = new ScenarioElement();
            scenarioElement.setId(appUtils.generateUUID());
            scenarioElement.setElement(element);
            scenarioElement.setElementType(elementType);

            ScenarioAutomationDAO scenarioAutomationDAO = new ScenarioAutomationDAO();
            scenarioAutomationDAO.setAutomationId(automationId);
            scenarioAutomationDAO.setAutomation(automationDBModel.get().getAutomation());
            scenarioAutomationDAO.setAutomationType(automationDBModel.get().getAutomationType());
            scenarioAutomationDAO.setAutomationDatas(new ArrayList<>());
            scenarioAutomationDAO.setuDate(appUtils.getCurrentTimeStamp());
            scenarioAutomationDAO.setcDate(appUtils.getCurrentTimeStamp());
            scenarioAutomationDAO.setStatus(1);

            scenarioElement.setScenarioAutomation(scenarioAutomationDAO);
            scenarioElement.setOrder(order);
            scenarioElement.setuDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setcDate(appUtils.getCurrentTimeStamp());
            scenarioElement.setStatus(1);

            scenarioDBModel.get().getScenarioElements().add(scenarioElement);
            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            scenarioRepository.save(scenarioDBModel.get());

            return new ScenarioElementWSDTO(scenarioElement);
        }
        return null;
    }

    public ScenarioElementWSDTO updateScenarioActionService(String scenarioId,String elementId,String element,String elementType,long actionId,int order) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (scenarioDBModel.isPresent() && actionDBModel.isPresent()){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){

                    scenarioDBModel.get().getScenarioElements().get(i).setElement(element);
                    scenarioDBModel.get().getScenarioElements().get(i).setElementType(elementType);

                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().setActionId(actionId);
                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().setAction(actionDBModel.get().getAction());
                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().setStatus(1);

                    scenarioDBModel.get().getScenarioElements().get(i).setOrder(order);
                    scenarioDBModel.get().getScenarioElements().get(i).setuDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModel.get().getScenarioElements().get(i).setStatus(1);
                    scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioRepository.save(scenarioDBModel.get());

                    return new ScenarioElementWSDTO(scenarioDBModel.get().getScenarioElements().get(i));
                }
            }
        }
        return null;
    }

    public ScenarioElementWSDTO updateScenarioAutomationService(String scenarioId,String elementId,String element,String elementType,long automationId,int order) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<AutomationDBModel> automationDBModel = automationRepository.findById(automationId);
        if (scenarioDBModel.isPresent() && automationDBModel.isPresent()){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){

                    scenarioDBModel.get().getScenarioElements().get(i).setElement(element);
                    scenarioDBModel.get().getScenarioElements().get(i).setElementType(elementType);

                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().setAutomationId(automationId);
                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().setAutomation(automationDBModel.get().getAutomation());
                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().setAutomationType(automationDBModel.get().getAutomationType());
                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().setStatus(1);

                    scenarioDBModel.get().getScenarioElements().get(i).setOrder(order);
                    scenarioDBModel.get().getScenarioElements().get(i).setuDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModel.get().getScenarioElements().get(i).setStatus(1);
                    scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioRepository.save(scenarioDBModel.get());

                    return new ScenarioElementWSDTO(scenarioDBModel.get().getScenarioElements().get(i));
                }
            }
        }
        return null;
    }

    public ScenarioElementWSDTO removeScenarioElementService(String scenarioId, String elementId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                    ScenarioElement scenarioElement = scenarioDBModel.get().getScenarioElements().get(i);
                    scenarioDBModel.get().getScenarioElements().remove(scenarioElement);
                    scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioRepository.save(scenarioDBModel.get());

                    return new ScenarioElementWSDTO(scenarioElement);
                }
            }
        }
        return null;
    }



}
