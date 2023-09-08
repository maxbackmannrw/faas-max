package com.faas.core.base.framework.process.details.flow.details;

import com.faas.core.base.model.db.process.details.trigger.TriggerDBModel;
import com.faas.core.base.model.ws.process.details.trigger.dto.TriggerWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessFlowDetailsFramework {


    @Autowired
    AppUtils appUtils;

    public List<TriggerWSDTO> getProcessTriggersService(long userId, String processId) {

        List<TriggerWSDTO> triggerWSDTOS = new ArrayList<>();
    /*    List<TriggerDBModel> triggerDBModels = triggerRepository.findByProcessId(processId);
        for (TriggerDBModel triggerDBModel : triggerDBModels) {
            triggerWSDTOS.add(new TriggerWSDTO(triggerDBModel));
        }

     */
        return triggerWSDTOS;
    }


}
