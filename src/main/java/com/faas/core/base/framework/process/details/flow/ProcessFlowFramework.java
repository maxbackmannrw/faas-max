package com.faas.core.base.framework.process.details.flow;

import com.faas.core.base.model.ws.process.details.trigger.dto.ProcessTriggerWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessFlowFramework {


    @Autowired
    AppUtils appUtils;


    public List<ProcessTriggerWSDTO> getProcessFlowService(long userId, String processId) {

        return null;
    }



}
