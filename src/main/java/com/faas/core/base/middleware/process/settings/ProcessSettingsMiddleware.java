package com.faas.core.base.middleware.process.settings;

import com.faas.core.base.framework.process.settings.ProcessSettingsFramework;
import com.faas.core.base.model.db.process.settings.ProcessTypeDBModel;
import com.faas.core.base.model.ws.process.settings.TriggerTypeWSModel;
import com.faas.core.base.model.ws.process.settings.dto.TriggerTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.settings.ProcessTypeWSModel;
import com.faas.core.base.model.ws.process.settings.dto.ProcessTypeWSDTO;
import com.faas.core.base.repo.process.settings.ProcessTypeRepository;
import com.faas.core.base.repo.scenario.settings.ScenarioTypeRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProcessSettingsMiddleware {

    @Autowired
    ProcessSettingsFramework processSettingsFramework;

    @Autowired
    ProcessTypeRepository processTypeRepository;

    @Autowired
    ScenarioTypeRepository scenarioTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessTypeWSModel getAllProcessTypes(long userId) {

        ProcessTypeWSModel response = new ProcessTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTypeWSDTO> processTypeWSDTOS = new ArrayList<>();

        List<ProcessTypeDBModel> processTypeDBModels = processTypeRepository.findByStatus(1);
        for (ProcessTypeDBModel processTypeDBModel : processTypeDBModels) {
            processTypeWSDTOS.add(processSettingsFramework.fillProcessTypeWSDTO(processTypeDBModel));
        }

        response.setProcessTypes(processTypeWSDTOS);
        general.setOperation("getAllProcessTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ProcessTypeWSModel getProcessType(long userId, long typeId) {

        ProcessTypeWSModel response = new ProcessTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTypeWSDTO> processTypeWSDTOS = new ArrayList<>();

        Optional<ProcessTypeDBModel> processTypeDBModel = processTypeRepository.findById(typeId);
        if (processTypeDBModel.isPresent()) {
            processTypeWSDTOS.add(processSettingsFramework.fillProcessTypeWSDTO(processTypeDBModel.get()));
        }

        response.setProcessTypes(processTypeWSDTOS);
        general.setOperation("getProcessType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessTypeWSModel createProcessType(long userId, String processType) {

        ProcessTypeWSModel response = new ProcessTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTypeWSDTO> processTypeWSDTOS = new ArrayList<>();

        ProcessTypeDBModel processTypeDBModel = processSettingsFramework.createProcessTypeService(processType);
        if (processTypeDBModel != null) {
            processTypeWSDTOS.add(processSettingsFramework.fillProcessTypeWSDTO(processTypeDBModel));
        }

        response.setProcessTypes(processTypeWSDTOS);
        general.setOperation("createProcessType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessTypeWSModel updateProcessType(long userId, long typeId, String processType) {

        ProcessTypeWSModel response = new ProcessTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTypeWSDTO> processTypeWSDTOS = new ArrayList<>();

        ProcessTypeDBModel processTypeDBModel = processSettingsFramework.updateProcessTypeService(typeId,processType);
        if (processTypeDBModel != null) {
            processTypeWSDTOS.add(processSettingsFramework.fillProcessTypeWSDTO(processTypeDBModel));
        }

        response.setProcessTypes(processTypeWSDTOS);
        general.setOperation("updateProcessType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessTypeWSModel removeProcessType(long userId, long typeId) {

        ProcessTypeWSModel response = new ProcessTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessTypeWSDTO> processTypeWSDTOS = new ArrayList<>();

        ProcessTypeDBModel processTypeDBModel = processSettingsFramework.removeProcessTypeService(typeId);
        if (processTypeDBModel != null) {
            processTypeWSDTOS.add(processSettingsFramework.fillProcessTypeWSDTO(processTypeDBModel));
        }

        response.setProcessTypes(processTypeWSDTOS);
        general.setOperation("removeProcessType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public TriggerTypeWSModel getAllTriggerTypes(long userId) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<TriggerTypeWSDTO> triggerTypeWSDTOS = processSettingsFramework.getAllTriggerTypesService(userId);
        if (triggerTypeWSDTOS != null){
            response.setTriggerTypes(triggerTypeWSDTOS);
        }

        general.setOperation("getAllTriggerTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerTypeWSModel getTriggerTypesByBase(long userId,String baseType) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<TriggerTypeWSDTO> triggerTypeWSDTOS = processSettingsFramework.getTriggerTypesByBaseService(userId,baseType);
        if (triggerTypeWSDTOS != null){
            response.setTriggerTypes(triggerTypeWSDTOS);
        }

        general.setOperation("getAllTriggerTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerTypeWSModel getTriggerType(long userId, long typeId) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();

        TriggerTypeWSDTO triggerTypeWSDTO = processSettingsFramework.getTriggerTypeService(userId,typeId);
        if (triggerTypeWSDTO != null){
            triggerTypeWSDTOS.add(triggerTypeWSDTO);
        }

        response.setTriggerTypes(triggerTypeWSDTOS);
        general.setOperation("getTriggerType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerTypeWSModel createTriggerType(long userId, String triggerType,String baseType) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();

        TriggerTypeWSDTO triggerTypeWSDTO = processSettingsFramework.createTriggerTypeService(userId,triggerType,baseType);
        if (triggerTypeWSDTO != null){
            triggerTypeWSDTOS.add(triggerTypeWSDTO);
        }

        response.setTriggerTypes(triggerTypeWSDTOS);
        general.setOperation("createTriggerType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerTypeWSModel updateTriggerType(long userId, long typeId,String triggerType,String baseType) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();

        TriggerTypeWSDTO triggerTypeWSDTO = processSettingsFramework.updateTriggerTypeService(userId,typeId,triggerType,baseType);
        if (triggerTypeWSDTO != null){
            triggerTypeWSDTOS.add(triggerTypeWSDTO);
        }

        response.setTriggerTypes(triggerTypeWSDTOS);
        general.setOperation("updateTriggerType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public TriggerTypeWSModel removeTriggerType(long userId,long typeId) {

        TriggerTypeWSModel response = new TriggerTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<TriggerTypeWSDTO> triggerTypeWSDTOS = new ArrayList<>();

        TriggerTypeWSDTO triggerTypeWSDTO = processSettingsFramework.removeTriggerTypeService(userId,typeId);
        if (triggerTypeWSDTO != null){
            triggerTypeWSDTOS.add(triggerTypeWSDTO);
        }

        response.setTriggerTypes(triggerTypeWSDTOS);
        general.setOperation("removeTriggerType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
