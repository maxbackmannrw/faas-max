package com.faas.core.base.middleware.process.details.channel.temp;

import com.faas.core.base.framework.process.details.channel.temp.ProcessTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.temp.*;
import com.faas.core.base.model.ws.process.details.channel.temp.dto.*;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessTempMiddleware {


    @Autowired
    ProcessTempFramework processTempFramework;


    public ProcessTempWSModel getProcessTemp(long userId, String processId) {

        ProcessTempWSModel response = new ProcessTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessTempWSDTO processTempWSDTO = processTempFramework.getProcessTempService(userId,processId);
        if (processTempWSDTO != null){
            response.setProcessTemp(processTempWSDTO);
        }

        general.setOperation("getProcessTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
