package com.faas.core.base.framework.process.details.scenario;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.process.details.scenario.dao.*;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.*;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioDataWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessScenarioFramework {


    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessScenarioWSDTO fillProcessScenarioWSDTO(ProcessScenarioDBModel processScenarioDBModel) {

        ProcessScenarioWSDTO processScenarioWSDTO = new ProcessScenarioWSDTO();
        processScenarioWSDTO.setProcessScenario(processScenarioDBModel);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(processScenarioDBModel.getScenarioId());
        scenarioDBModel.ifPresent(processScenarioWSDTO::setProcessScenarioDetails);
        return processScenarioWSDTO;
    }


    public List<ProcessScenarioWSDTO> getProcessScenariosService(String processId) {

        List<ProcessScenarioWSDTO> processScenarioWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessId(processId);
        for (ProcessScenarioDBModel processScenarioDBModel : processScenarioDBModels) {
            processScenarioWSDTOS.add(fillProcessScenarioWSDTO(processScenarioDBModel));
        }
        return processScenarioWSDTOS;
    }


    public ProcessScenarioWSDTO getProcessScenarioService(String processId, String scenarioId) {

        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (!processScenarioDBModels.isEmpty()) {
            return fillProcessScenarioWSDTO(processScenarioDBModels.get(0));
        }
        return null;
    }


    public ProcessScenarioWSDTO createProcessScenarioService(String processId,String scenarioId,int scenarioOrder) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (!processScenarioRepository.existsByProcessIdAndScenarioId(processId,scenarioId) && processDBModel.isPresent() && scenarioDBModel.isPresent()) {

            ProcessScenarioDBModel processScenarioDBModel = new ProcessScenarioDBModel();
            processScenarioDBModel.setProcessId(processId);
            processScenarioDBModel.setScenarioId(scenarioId);
            processScenarioDBModel.setScenario(scenarioDBModel.get().getScenario());
            processScenarioDBModel.setScenarioTypeId(scenarioDBModel.get().getTypeId());
            processScenarioDBModel.setScenarioType(scenarioDBModel.get().getScenarioType());
            processScenarioDBModel.setBaseType(scenarioDBModel.get().getBaseType());
            if (scenarioDBModel.get().getVariables() != null){
                processScenarioDBModel.setScenarioVariables(getProcessScenarioVariables(scenarioDBModel.get().getVariables()));
            }else {
                processScenarioDBModel.setScenarioVariables(new ArrayList<>());
            }
            if (scenarioDBModel.get().getElements() != null){
                processScenarioDBModel.setScenarioElements(getProcessScenarioElements(scenarioDBModel.get().getElements()));
            }else {
                processScenarioDBModel.setScenarioElements(new ArrayList<>());
            }
            processScenarioDBModel.setScenarioDatas(new ArrayList<>());
            processScenarioDBModel.setScenarioOrder(scenarioOrder);
            processScenarioDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processScenarioDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processScenarioDBModel.setStatus(1);

            return fillProcessScenarioWSDTO(processScenarioRepository.save(processScenarioDBModel));
        }
        return null;
    }

    public List<ProcessScenarioVariableDAO> getProcessScenarioVariables(List<ScenarioVariableDAO> scenarioVariables) {

        List<ProcessScenarioVariableDAO>processScenarioVariables = new ArrayList<>();
        for (ScenarioVariableDAO scenarioVariable : scenarioVariables) {

            ProcessScenarioVariableDAO processScenarioVariable = new ProcessScenarioVariableDAO();
            processScenarioVariable.setVariableId(appUtils.generateUUID());
            processScenarioVariable.setVariableType(scenarioVariable.getVariableType());
            processScenarioVariable.setValue(scenarioVariable.getValue());
            processScenarioVariable.setcDate(appUtils.getCurrentTimeStamp());
            processScenarioVariable.setStatus(1);

            processScenarioVariables.add(processScenarioVariable);
        }
        return processScenarioVariables;
    }


    public List<ProcessScenarioElement> getProcessScenarioElements(List<ScenarioElement> scenarioElements) {

        List<ProcessScenarioElement>processScenarioElements = new ArrayList<>();
        for (ScenarioElement scenarioElement : scenarioElements) {

            ProcessScenarioElement processScenarioElement = new ProcessScenarioElement();

            processScenarioElement.setId(appUtils.generateUUID());
            processScenarioElement.setElement(scenarioElement.getElement());
            processScenarioElement.setElementType(scenarioElement.getElementType());
            if (scenarioElement.getAction() != null){
                processScenarioElement.setAction(getScenarioAction(scenarioElement.getAction()));
            }
            if (scenarioElement.getAutomation() != null){
                processScenarioElement.setAutomation(getScenarioAutomation(scenarioElement.getAutomation()));
            }
            if (scenarioElement.getVariables() != null){
                processScenarioElement.setVariables(getScenarioElementVariables(scenarioElement.getVariables()));
            }else {
                processScenarioElement.setVariables(new ArrayList<>());
            }
            processScenarioElement.setElementOrder(scenarioElement.getElementOrder());
            processScenarioElement.setuDate(appUtils.getCurrentTimeStamp());
            processScenarioElement.setcDate(appUtils.getCurrentTimeStamp());
            processScenarioElement.setStatus(1);

            processScenarioElements.add(processScenarioElement);

        }
        return processScenarioElements;
    }


    public ScenarioActionDAO getScenarioAction(ActionDAO actionDAO){

        ScenarioActionDAO scenarioActionDAO = new ScenarioActionDAO();

        scenarioActionDAO.setTempId(actionDAO.getTempId());
        scenarioActionDAO.setActionTemp(actionDAO.getActionTemp());
        scenarioActionDAO.setcDate(appUtils.getCurrentTimeStamp());
        scenarioActionDAO.setStatus(actionDAO.getStatus());

        return scenarioActionDAO;
    }

    public ScenarioAutomationDAO getScenarioAutomation(AutomationDAO automationDAO){

        ScenarioAutomationDAO scenarioAutomationDAO = new ScenarioAutomationDAO();

        scenarioAutomationDAO.setTempId(automationDAO.getTempId());
        scenarioAutomationDAO.setAutomationTemp(automationDAO.getAutomationTemp());
        scenarioAutomationDAO.setAutomationTypeId(automationDAO.getTypeId());
        scenarioAutomationDAO.setAutomationType(automationDAO.getAutomationType());
        scenarioAutomationDAO.setBaseType(automationDAO.getBaseType());
        scenarioAutomationDAO.setcDate(appUtils.getCurrentTimeStamp());
        scenarioAutomationDAO.setStatus(automationDAO.getStatus());

        return scenarioAutomationDAO;
    }

    public List<ScenarioElementVariableDAO> getScenarioElementVariables(List<ElementVariableDAO>elementVariables){

        List<ScenarioElementVariableDAO>scenarioElementVariables = new ArrayList<>();
        for (ElementVariableDAO elementVariable : elementVariables) {

            ScenarioElementVariableDAO scenarioElementVariable = new ScenarioElementVariableDAO();

            scenarioElementVariable.setVariableId(appUtils.generateUUID());
            scenarioElementVariable.setVariableType(elementVariable.getVariableType());
            scenarioElementVariable.setValue(elementVariable.getValue());
            scenarioElementVariable.setcDate(appUtils.getCurrentTimeStamp());
            scenarioElementVariable.setStatus(elementVariable.getStatus());

            scenarioElementVariables.add(scenarioElementVariable);
        }
        return scenarioElementVariables;
    }


    public ProcessScenarioWSDTO removeProcessScenarioService(String processId, String scenarioId) {

        List<ProcessScenarioDBModel> processScenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (!processScenarioDBModels.isEmpty()) {
            processScenarioRepository.deleteAll(processScenarioDBModels);
            return fillProcessScenarioWSDTO(processScenarioDBModels.get(0));
        }
        return null;
    }


    public List<ProcessScenarioDataWSDTO> getProcessScenarioDatasService(String processId, String scenarioId) {

        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();
        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (!scenarioDBModels.isEmpty() && scenarioDBModels.get(0).getScenarioDatas() != null) {
            for (int i = 0; i < scenarioDBModels.get(0).getScenarioDatas().size(); i++) {
                scenarioDataWSDTOS.add(new ProcessScenarioDataWSDTO(scenarioDBModels.get(0).getScenarioDatas().get(i)));
            }
        }
        return scenarioDataWSDTOS;
    }


    public ProcessScenarioDataWSDTO getProcessScenarioDataService(String processId, String scenarioId, String dataId) {

        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (!scenarioDBModels.isEmpty() && scenarioDBModels.get(0).getScenarioDatas() != null) {
            for (int i = 0; i < scenarioDBModels.get(0).getScenarioDatas().size(); i++) {
                if (scenarioDBModels.get(0).getScenarioDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {
                    return new ProcessScenarioDataWSDTO(scenarioDBModels.get(0).getScenarioDatas().get(i));
                }
            }
        }
        return null;
    }


    public ProcessScenarioDataWSDTO createProcessScenarioDataService(String processId, String scenarioId, long typeId, String value) {

        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!scenarioDBModels.isEmpty() && dataTypeDBModel.isPresent()) {

            ProcessScenarioDataDAO scenarioDataDAO = new ProcessScenarioDataDAO();
            scenarioDataDAO.setDataId(appUtils.generateUUID());
            scenarioDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            scenarioDataDAO.setValue(value);
            scenarioDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            scenarioDataDAO.setStatus(1);

            if (scenarioDBModels.get(0).getScenarioDatas() != null) {
                scenarioDBModels.get(0).getScenarioDatas().add(scenarioDataDAO);
            } else {
                List<ProcessScenarioDataDAO> scenarioDataDAOS = new ArrayList<>();
                scenarioDataDAOS.add(scenarioDataDAO);
                scenarioDBModels.get(0).setScenarioDatas(scenarioDataDAOS);
            }
            scenarioDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            processScenarioRepository.save(scenarioDBModels.get(0));

            return new ProcessScenarioDataWSDTO(scenarioDataDAO);
        }
        return null;
    }

    public ProcessScenarioDataWSDTO updateProcessScenarioDataService(String processId, String scenarioId, String dataId, long typeId, String value) {

        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!scenarioDBModels.isEmpty() && scenarioDBModels.get(0).getScenarioDatas() != null && dataTypeDBModel.isPresent()) {
            for (int i = 0; i < scenarioDBModels.get(0).getScenarioDatas().size(); i++) {
                if (scenarioDBModels.get(0).getScenarioDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    scenarioDBModels.get(0).getScenarioDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    scenarioDBModels.get(0).getScenarioDatas().get(i).setValue(value);
                    scenarioDBModels.get(0).getScenarioDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    scenarioDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processScenarioRepository.save(scenarioDBModels.get(0));

                    return new ProcessScenarioDataWSDTO(scenarioDBModels.get(0).getScenarioDatas().get(i));
                }
            }
        }
        return null;
    }


    public ProcessScenarioDataWSDTO removeProcessScenarioDataService(String processId, String scenarioId, String dataId) {

        List<ProcessScenarioDBModel> scenarioDBModels = processScenarioRepository.findByProcessIdAndScenarioId(processId,scenarioId);
        if (!scenarioDBModels.isEmpty() && scenarioDBModels.get(0).getScenarioDatas() != null) {
            for (int i = 0; i < scenarioDBModels.get(0).getScenarioDatas().size(); i++) {
                if (scenarioDBModels.get(0).getScenarioDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    ProcessScenarioDataDAO scenarioDataDAO = scenarioDBModels.get(0).getScenarioDatas().get(i);
                    scenarioDBModels.get(0).getScenarioDatas().remove(scenarioDataDAO);
                    scenarioDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processScenarioRepository.save(scenarioDBModels.get(0));

                    return new ProcessScenarioDataWSDTO(scenarioDataDAO);
                }
            }
        }
        return null;
    }


}
