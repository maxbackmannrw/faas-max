package com.faas.core.base.framework.scenario.element.details;

import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.scenario.details.dto.ScenarioDataWSDTO;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
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
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ScenarioDataWSDTO> getScenarioActionDatasService(String scenarioId, String elementId) {

        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
              if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                  for (int j=0;j<scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().size();j++){
                      scenarioDataWSDTOS.add(new ScenarioDataWSDTO(scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j)));
                  }
              }
            }
        }
        return scenarioDataWSDTOS;
    }


    public ScenarioDataWSDTO getScenarioActionDataService(String scenarioId,String elementId,String dataId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                    for (int j=0;j<scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().size();j++){
                       if (scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).getDataId().equalsIgnoreCase(dataId)){
                           return new ScenarioDataWSDTO(scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j));
                       }
                    }
                }
            }
        }
        return null;
    }


    public ScenarioDataWSDTO createScenarioActionDataService(String scenarioId,String elementId,long typeId,String value) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){

                    ScenarioDataDAO scenarioDataDAO = new ScenarioDataDAO();
                    scenarioDataDAO.setDataId(appUtils.generateUUID());
                    scenarioDataDAO.setDataType(dataTypeDBModel.get().getDataType());
                    scenarioDataDAO.setValue(value);
                    scenarioDataDAO.setcDate(appUtils.getCurrentTimeStamp());
                    scenarioDataDAO.setStatus(1);

                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().add(scenarioDataDAO);
                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModel.get().getScenarioElements().get(i).setuDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioRepository.save(scenarioDBModel.get());

                    return new ScenarioDataWSDTO(scenarioDataDAO);
                }
            }
        }
        return null;
    }


    public ScenarioDataWSDTO updateScenarioActionDataService(String scenarioId,String elementId, String dataId,long typeId,String value) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                    for (int j=0;j<scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().size();j++){
                        if (scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).getDataId().equalsIgnoreCase(dataId)){

                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).setDataType(dataTypeDBModel.get().getDataType());
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).setValue(value);
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).setStatus(1);
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().setuDate(appUtils.getCurrentTimeStamp());

                            scenarioDBModel.get().getScenarioElements().get(i).setuDate(appUtils.getCurrentTimeStamp());
                            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioRepository.save(scenarioDBModel.get());

                            return new ScenarioDataWSDTO(scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j));
                        }
                    }
                }
            }
        }
        return null;
    }


    public ScenarioDataWSDTO removeScenarioActionDataService(String scenarioId,String elementId,String dataId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                    for (int j=0;j<scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().size();j++){
                        if (scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).getDataId().equalsIgnoreCase(dataId)){

                            ScenarioDataDAO scenarioDataDAO = scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j);
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().remove(scenarioDataDAO);
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioDBModel.get().getScenarioElements().get(i).setuDate(appUtils.getCurrentTimeStamp());
                            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioRepository.save(scenarioDBModel.get());

                            return new ScenarioDataWSDTO(scenarioDataDAO);
                        }
                    }
                }
            }
        }
        return null;
    }




    public List<ScenarioDataWSDTO> getScenarioAutomationDatasService(String scenarioId,String elementId) {

        List<ScenarioDataWSDTO>scenarioDataWSDTOS = new ArrayList<>();
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                    for (int j=0;j<scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().size();j++){
                        scenarioDataWSDTOS.add(new ScenarioDataWSDTO(scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j)));
                    }
                }
            }
        }
        return scenarioDataWSDTOS;
    }


    public ScenarioDataWSDTO getScenarioAutomationDataService(String scenarioId,String elementId,String dataId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                    for (int j=0;j<scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().getAutomationDatas().size();j++){
                        if (scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().getAutomationDatas().get(j).getDataId().equalsIgnoreCase(dataId)){
                            return new ScenarioDataWSDTO(scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().getAutomationDatas().get(j));
                        }
                    }
                }
            }
        }
        return null;
    }


    public ScenarioDataWSDTO createScenarioAutomationDataService(String scenarioId,String elementId,long typeId,String value) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){

                    ScenarioDataDAO scenarioDataDAO = new ScenarioDataDAO();
                    scenarioDataDAO.setDataId(appUtils.generateUUID());
                    scenarioDataDAO.setDataType(dataTypeDBModel.get().getDataType());
                    scenarioDataDAO.setValue(value);
                    scenarioDataDAO.setcDate(appUtils.getCurrentTimeStamp());
                    scenarioDataDAO.setStatus(1);

                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().getAutomationDatas().add(scenarioDataDAO);
                    scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModel.get().getScenarioElements().get(i).setuDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    scenarioRepository.save(scenarioDBModel.get());

                    return new ScenarioDataWSDTO(scenarioDataDAO);
                }
            }
        }
        return null;
    }


    public ScenarioDataWSDTO updateScenarioAutomationDataService(String scenarioId,String elementId,String dataId,long typeId,String value) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                    for (int j=0;j<scenarioDBModel.get().getScenarioElements().get(i).getScenarioAutomation().getAutomationDatas().size();j++){
                        if (scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).getDataId().equalsIgnoreCase(dataId)){

                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).setDataType(dataTypeDBModel.get().getDataType());
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).setValue(value);
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).setStatus(1);
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().setuDate(appUtils.getCurrentTimeStamp());

                            scenarioDBModel.get().getScenarioElements().get(i).setuDate(appUtils.getCurrentTimeStamp());
                            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioRepository.save(scenarioDBModel.get());

                            return new ScenarioDataWSDTO(scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j));
                        }
                    }
                }
            }
        }
        return null;
    }


    public ScenarioDataWSDTO removeScenarioAutomationDataService(String scenarioId,String elementId,String dataId) {

        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (scenarioDBModel.isPresent() && scenarioDBModel.get().getScenarioElements() != null){
            for (int i=0;i<scenarioDBModel.get().getScenarioElements().size();i++){
                if (scenarioDBModel.get().getScenarioElements().get(i).getId().equalsIgnoreCase(elementId)){
                    for (int j=0;j<scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().size();j++){
                        if (scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j).getDataId().equalsIgnoreCase(dataId)){

                            ScenarioDataDAO scenarioDataDAO = scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().get(j);
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().getActionDatas().remove(scenarioDataDAO);
                            scenarioDBModel.get().getScenarioElements().get(i).getScenarioAction().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioDBModel.get().getScenarioElements().get(i).setuDate(appUtils.getCurrentTimeStamp());
                            scenarioDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                            scenarioRepository.save(scenarioDBModel.get());

                            return new ScenarioDataWSDTO(scenarioDataDAO);
                        }
                    }
                }
            }
        }
        return null;
    }




}
