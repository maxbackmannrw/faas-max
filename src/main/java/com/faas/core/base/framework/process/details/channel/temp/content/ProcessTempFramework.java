package com.faas.core.base.framework.process.details.channel.temp.content;

import com.faas.core.base.model.ws.process.details.channel.temp.dto.ProcessTempWSDTO;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.process.ProcessHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProcessTempFramework {


    @Autowired
    ProcessHelpers processHelpers;

    @Autowired
    AppUtils appUtils;


    public ProcessTempWSDTO getProcessTempService(long userId, String processId) {
        return processHelpers.createProcessTempWSDTO(processId);
    }


}
