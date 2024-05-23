package com.faas.core.base.middleware.process.details.trigger.ai;

import com.faas.core.base.framework.process.details.trigger.ai.ProcessAiTriggerFramework;
import com.faas.core.base.framework.process.details.trigger.wapp.ProcessWappMessageTriggerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.ai.ProcessAITriggerWSModel;
import com.faas.core.base.model.ws.process.details.trigger.ai.dto.ProcessAITriggerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessAiTriggerMiddleware {


    @Autowired
    ProcessAiTriggerFramework processAiTriggerFramework;


    public ProcessAITriggerWSModel getProcessAITriggers(long userId, String processId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = processAiTriggerFramework.getProcessAITriggersService(userId,processId);
        if (processAITriggerWSDTOS != null){
            response.setProcessAITriggers(processAITriggerWSDTOS);
        }

        general.setOperation("getProcessAITriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessAITriggerWSModel getProcessAITrigger(long userId, String triggerId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();

        ProcessAITriggerWSDTO processAITriggerWSDTO = processAiTriggerFramework.getProcessAITriggerService(userId,triggerId);
        if (processAITriggerWSDTO != null){
            processAITriggerWSDTOS.add(processAITriggerWSDTO);
        }

        response.setProcessAITriggers(processAITriggerWSDTOS);
        general.setOperation("getProcessAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessAITriggerWSModel createProcessAITrigger(long userId, String processId, String trigger, String triggerDesc, String accountId, long typeId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();

        ProcessAITriggerWSDTO processAITriggerWSDTO = processAiTriggerFramework.createProcessAITriggerService(userId,processId,trigger,triggerDesc,accountId,typeId);
        if (processAITriggerWSDTO != null){
            processAITriggerWSDTOS.add(processAITriggerWSDTO);
        }

        response.setProcessAITriggers(processAITriggerWSDTOS);
        general.setOperation("createProcessAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessAITriggerWSModel updateProcessAITrigger(long userId, String triggerId, String trigger, String triggerDesc, String accountId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();

        ProcessAITriggerWSDTO processAITriggerWSDTO = processAiTriggerFramework.updateProcessAITriggerService(userId,triggerId,trigger,triggerDesc,accountId);
        if (processAITriggerWSDTO != null){
            processAITriggerWSDTOS.add(processAITriggerWSDTO);
        }

        response.setProcessAITriggers(processAITriggerWSDTOS);
        general.setOperation("updateProcessAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessAITriggerWSModel removeProcessAITrigger(long userId, String triggerId) {

        ProcessAITriggerWSModel response = new ProcessAITriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAITriggerWSDTO> processAITriggerWSDTOS = new ArrayList<>();

        ProcessAITriggerWSDTO processAITriggerWSDTO = processAiTriggerFramework.removeProcessAITriggerService(userId,triggerId);
        if (processAITriggerWSDTO != null){
            processAITriggerWSDTOS.add(processAITriggerWSDTO);
        }

        response.setProcessAITriggers(processAITriggerWSDTOS);
        general.setOperation("removeProcessAITrigger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
