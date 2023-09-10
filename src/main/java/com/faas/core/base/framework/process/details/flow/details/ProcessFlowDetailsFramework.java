package com.faas.core.base.framework.process.details.flow.details;

import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessFlowDetailsFramework {


    @Autowired
    AppUtils appUtils;

    public List<ProcessTriggerWSDTO> getProcessTriggersService(long userId, String processId) {

        List<ProcessTriggerWSDTO> processTriggerWSDTOS = new ArrayList<>();
    /*    List<TriggerDBModel> triggerDBModels = triggerRepository.findByProcessId(processId);
        for (TriggerDBModel triggerDBModel : triggerDBModels) {
            triggerWSDTOS.add(new TriggerWSDTO(triggerDBModel));
        }

     */
        return processTriggerWSDTOS;
    }


}
