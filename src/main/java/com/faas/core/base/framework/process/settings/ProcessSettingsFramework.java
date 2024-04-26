package com.faas.core.base.framework.process.settings;

import com.faas.core.base.model.db.process.settings.ProcessTypeDBModel;
import com.faas.core.base.model.db.process.settings.TriggerTypeDBModel;
import com.faas.core.base.model.db.scenario.settings.ScenarioTypeDBModel;
import com.faas.core.base.model.ws.process.settings.dto.ProcessTypeWSDTO;
import com.faas.core.base.model.ws.process.settings.dto.TriggerTypeWSDTO;
import com.faas.core.base.model.ws.scenario.settings.dto.ScenarioTypeWSDTO;
import com.faas.core.base.repo.process.settings.ProcessTypeRepository;
import com.faas.core.base.repo.process.settings.TriggerTypeRepository;
import com.faas.core.base.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProcessSettingsFramework {

    @Autowired
    ProcessTypeRepository processTypeRepository;

    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    TriggerTypeRepository triggerTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessTypeWSDTO fillProcessTypeWSDTO(ProcessTypeDBModel processTypeDBModel) {

        ProcessTypeWSDTO processTypeWSDTO = new ProcessTypeWSDTO();
        processTypeWSDTO.setProcessType(processTypeDBModel);
        return processTypeWSDTO;
    }


    public ProcessTypeDBModel createProcessTypeService(String processType) {

        ProcessTypeDBModel processTypeDBModel = new ProcessTypeDBModel();
        processTypeDBModel.setProcessType(processType);
        processTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        processTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        processTypeDBModel.setStatus(1);

        return processTypeRepository.save(processTypeDBModel);
    }


    public ProcessTypeDBModel updateProcessTypeService(long typeId, String processType) {

        Optional<ProcessTypeDBModel> processTypeDBModel = processTypeRepository.findById(typeId);
        if (processTypeDBModel.isPresent()) {
            processTypeDBModel.get().setProcessType(processType);
            processTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processTypeDBModel.get().setStatus(1);

            return processTypeRepository.save(processTypeDBModel.get());
        }
        return null;
    }


    public ProcessTypeDBModel removeProcessTypeService(long typeId) {

        Optional<ProcessTypeDBModel> processTypeDBModel = processTypeRepository.findById(typeId);
        if (processTypeDBModel.isPresent()) {
            processTypeRepository.delete(processTypeDBModel.get());
            return processTypeDBModel.get();
        }
        return null;
    }



    public List<TriggerTypeWSDTO> getAllTriggerTypesService(long userId) {

        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();
        List<TriggerTypeDBModel> triggerTypeDBModels = triggerTypeRepository.findByStatus(1);
        for (TriggerTypeDBModel triggerTypeDBModel : triggerTypeDBModels) {
            triggerTypeWSDTOS.add(new TriggerTypeWSDTO(triggerTypeDBModel));
        }
        return triggerTypeWSDTOS;
    }



    public List<TriggerTypeWSDTO> getTriggerTypesByBaseService(long userId,String baseType) {

        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();
        List<TriggerTypeDBModel> triggerTypeDBModels = triggerTypeRepository.findByBaseType(baseType);
        for (TriggerTypeDBModel triggerTypeDBModel : triggerTypeDBModels) {
            triggerTypeWSDTOS.add(new TriggerTypeWSDTO(triggerTypeDBModel));
        }
        return triggerTypeWSDTOS;
    }



    public TriggerTypeWSDTO getTriggerTypeService(long userId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()) {
            return new TriggerTypeWSDTO(triggerTypeDBModel.get());
        }
        return null;
    }


    public TriggerTypeWSDTO createTriggerTypeService(long userId,String triggerType,String baseType) {

        TriggerTypeDBModel triggerTypeDBModel = new TriggerTypeDBModel();
        triggerTypeDBModel.setTriggerType(triggerType);
        triggerTypeDBModel.setBaseType(baseType);
        triggerTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        triggerTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        triggerTypeDBModel.setStatus(1);

        return new TriggerTypeWSDTO(triggerTypeRepository.save(triggerTypeDBModel));
    }


    public TriggerTypeWSDTO updateTriggerTypeService(long userId,long typeId,String triggerType,String baseType) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){

            triggerTypeDBModel.get().setTriggerType(triggerType);
            triggerTypeDBModel.get().setBaseType(baseType);
            triggerTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new TriggerTypeWSDTO(triggerTypeRepository.save(triggerTypeDBModel.get()));
        }
        return null;
    }


    public TriggerTypeWSDTO removeTriggerTypeService(long userId,long typeId) {

        Optional<TriggerTypeDBModel> triggerTypeDBModel = triggerTypeRepository.findById(typeId);
        if (triggerTypeDBModel.isPresent()){
            triggerTypeRepository.delete(triggerTypeDBModel.get());
            return new TriggerTypeWSDTO(triggerTypeDBModel.get());
        }
        return null;
    }


}
