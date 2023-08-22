package com.faas.core.base.middleware.process.details.asset;

import com.faas.core.base.framework.process.details.asset.ProcessAssetFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessAssetWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessAssetWSDTO;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessAssetMiddleware {

    @Autowired
    ProcessAssetFramework processAssetFramework;

    @Autowired
    AppUtils appUtils;


    public ProcessAssetWSModel getProcessAssets(long userId, String processId) {

        ProcessAssetWSModel response = new ProcessAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAssetWSDTO>processAssetWSDTOS = new ArrayList<>();



        response.setProcessAssets(processAssetWSDTOS);
        general.setOperation("getProcessActions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessAssetWSModel getProcessAsset(long userId, String processId) {

        ProcessAssetWSModel response = new ProcessAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAssetWSDTO>processAssetWSDTOS = new ArrayList<>();



        response.setProcessAssets(processAssetWSDTOS);
        general.setOperation("getProcessActions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessAssetWSModel createProcessAsset(long userId, String processId) {

        ProcessAssetWSModel response = new ProcessAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAssetWSDTO>processAssetWSDTOS = new ArrayList<>();



        response.setProcessAssets(processAssetWSDTOS);
        general.setOperation("getProcessActions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessAssetWSModel updateProcessAsset(long userId, String processId) {

        ProcessAssetWSModel response = new ProcessAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAssetWSDTO>processAssetWSDTOS = new ArrayList<>();



        response.setProcessAssets(processAssetWSDTOS);
        general.setOperation("getProcessActions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessAssetWSModel removeProcessAsset(long userId, String processId) {

        ProcessAssetWSModel response = new ProcessAssetWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessAssetWSDTO>processAssetWSDTOS = new ArrayList<>();



        response.setProcessAssets(processAssetWSDTOS);
        general.setOperation("getProcessActions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
