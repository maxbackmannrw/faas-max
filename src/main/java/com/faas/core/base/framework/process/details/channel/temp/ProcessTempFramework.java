package com.faas.core.base.framework.process.details.channel.temp;

import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.process.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProcessTempFramework {


    @Autowired
    ProcessHelper processHelper;

    @Autowired
    AppUtils appUtils;


    public ProcessTempWSDTO getProcessTempService(long userId, String processId) {
        return processHelper.createProcessTempWSDTO(processId);
    }


}
