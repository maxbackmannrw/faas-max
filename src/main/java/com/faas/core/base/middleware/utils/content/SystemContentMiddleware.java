package com.faas.core.base.middleware.utils.content;

import com.faas.core.base.framework.utils.content.SystemContentFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.content.SystemContentWSModel;
import com.faas.core.base.model.ws.utils.content.SystemInitWSModel;
import com.faas.core.base.model.ws.utils.content.dto.SystemContentWSDTO;
import com.faas.core.base.model.ws.utils.content.dto.SystemInitWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SystemContentMiddleware {


    @Autowired
    SystemContentFramework systemContentFramework;


    public SystemInitWSModel initSystemContent(String initType) {

        SystemInitWSModel response = new SystemInitWSModel();
        GeneralWSModel general = new GeneralWSModel();

        SystemInitWSDTO systemInitWSDTO = systemContentFramework.initSystemContentService(initType);
        if (systemInitWSDTO != null){
            response.setSystemInit(systemInitWSDTO);
        }

        general.setOperation("initSystemContent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SystemContentWSModel getSystemContents(long userId) {

        SystemContentWSModel response = new SystemContentWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<SystemContentWSDTO> systemContentWSDTOS = systemContentFramework.getSystemContentsService(userId);
        if (systemContentWSDTOS != null){
            response.setSystemContents(systemContentWSDTOS);
        }

        general.setOperation("getSystemContents");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SystemContentWSModel recoverSystemContent(long userId, String contentType) {

        SystemContentWSModel response = new SystemContentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SystemContentWSDTO> systemContentWSDTOS = new ArrayList<>();

        SystemContentWSDTO systemContentWSDTO = systemContentFramework.recoverSystemContentService(userId,contentType);
        if (systemContentWSDTO != null){
            systemContentWSDTOS.add(systemContentWSDTO);
        }

        response.setSystemContents(systemContentWSDTOS);
        general.setOperation("recoverSystemContent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public SystemContentWSModel removeSystemContent(long userId, String contentType) {

        SystemContentWSModel response = new SystemContentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<SystemContentWSDTO> systemContentWSDTOS = new ArrayList<>();

        SystemContentWSDTO systemContentWSDTO = systemContentFramework.removeSystemContentService(userId,contentType);
        if (systemContentWSDTO != null){
            systemContentWSDTOS.add(systemContentWSDTO);
        }

        response.setSystemContents(systemContentWSDTOS);
        general.setOperation("removeSystemContent");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
