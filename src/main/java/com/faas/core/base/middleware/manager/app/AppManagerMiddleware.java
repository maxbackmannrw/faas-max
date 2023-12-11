package com.faas.core.base.middleware.manager.app;

import com.faas.core.base.framework.manager.app.AppManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AppManagerMiddleware {


    @Autowired
    AppManagerFramework appManagerFramework;


    public AppManagerWSModel getAppManager(long userId,int reqPage,int reqSize) {

        AppManagerWSModel response = new AppManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AppManagerWSDTO appManagerWSDTO = appManagerFramework.getAppManagerService(userId,reqPage,reqSize);
        if (appManagerWSDTO != null){
            response.setAppManager(appManagerWSDTO);
        }

        general.setOperation("getAppManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
