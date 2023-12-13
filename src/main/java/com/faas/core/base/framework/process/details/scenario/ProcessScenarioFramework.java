package com.faas.core.base.framework.process.details.scenario;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.scenario.ProcessScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.ScenarioDBModel;
import com.faas.core.base.model.db.scenario.content.dao.ScenarioDataDAO;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioDataWSDTO;
import com.faas.core.base.model.ws.process.details.scenario.dto.ProcessScenarioWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
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


    public ProcessScenarioWSDTO createProcessScenarioService(String processId,String scenarioId,int order) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<ScenarioDBModel> scenarioDBModel = scenarioRepository.findById(scenarioId);
        if (!processScenarioRepository.existsByProcessIdAndScenarioId(processId,scenarioId) && processDBModel.isPresent() && scenarioDBModel.isPresent()) {

            ProcessScenarioDBModel processScenarioDBModel = new ProcessScenarioDBModel();
            processScenarioDBModel.setProcessId(processId);
            processScenarioDBModel.setScenarioId(scenarioId);
            processScenarioDBModel.setScenario(scenarioDBModel.get().getScenario());
            processScenarioDBModel.setScenarioType(scenarioDBModel.get().getScenarioType());
            if (scenarioDBModel.get().getScenarioDatas() != null){
                processScenarioDBModel.setScenarioDatas(scenarioDBModel.get().getScenarioDatas());
            }else {
                processScenarioDBModel.setScenarioDatas(new ArrayList<>());
            }
            if (scenarioDBModel.get().getScenarioElements() != null){
                processScenarioDBModel.setScenarioElements(scenarioDBModel.get().getScenarioElements());
            }else {
                processScenarioDBModel.setScenarioElements(new ArrayList<>());
            }
            processScenarioDBModel.setScenarioDatas(new ArrayList<>());
            processScenarioDBModel.setOrder(order);
            processScenarioDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processScenarioDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processScenarioDBModel.setStatus(1);

            return fillProcessScenarioWSDTO(processScenarioRepository.save(processScenarioDBModel));
        }
        return null;
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

            ScenarioDataDAO scenarioDataDAO = new ScenarioDataDAO();
            scenarioDataDAO.setDataId(appUtils.generateUUID());
            scenarioDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            scenarioDataDAO.setValue(value);
            scenarioDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            scenarioDataDAO.setStatus(1);

            if (scenarioDBModels.get(0).getScenarioDatas() != null) {
                scenarioDBModels.get(0).getScenarioDatas().add(scenarioDataDAO);
            } else {
                List<ScenarioDataDAO> scenarioDataDAOS = new ArrayList<>();
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

                    ScenarioDataDAO scenarioDataDAO = scenarioDBModels.get(0).getScenarioDatas().get(i);
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
