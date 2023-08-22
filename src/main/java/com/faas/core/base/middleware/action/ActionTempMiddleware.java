package com.faas.core.base.middleware.action;

import com.faas.core.base.framework.action.ActionTempFramework;
import com.faas.core.base.model.db.action.ActionTempDBModel;
import com.faas.core.base.model.ws.action.ActionTempWSModel;
import com.faas.core.base.model.ws.action.dto.ActionTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.action.ActionTempRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ActionTempMiddleware {

    @Autowired
    ActionTempFramework actionTempFramework;

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AppUtils appUtils;


    public ActionTempWSModel getActionTemps(long userId) {

        ActionTempWSModel response = new ActionTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTempWSDTO> actionTempWSDTOS = new ArrayList<>();

        List<ActionTempDBModel> actionTempDBModels = actionTempRepository.findByStatus(1);
        for (ActionTempDBModel actionTempDBModel : actionTempDBModels) {
            actionTempWSDTOS.add(actionTempFramework.fillActionTempWSDTO(actionTempDBModel));
        }

        response.setActionTemps(actionTempWSDTOS);
        general.setOperation("getActionTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionTempWSModel getActionTemp(long userId, long tempId) {

        ActionTempWSModel response = new ActionTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTempWSDTO> actionTempWSDTOS = new ArrayList<>();

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(tempId);
        if (actionTempDBModel.isPresent()){
            actionTempWSDTOS.add(actionTempFramework.fillActionTempWSDTO(actionTempDBModel.get()));
        }

        response.setActionTemps(actionTempWSDTOS);
        general.setOperation("getActionTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionTempWSModel createActionTemp(long userId, String actionTemp) {

        ActionTempWSModel response = new ActionTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTempWSDTO> actionTempWSDTOS = new ArrayList<>();

        ActionTempDBModel actionTempDBModel = actionTempFramework.createActionTempService(actionTemp);
        if (actionTempDBModel != null){
            actionTempWSDTOS.add(actionTempFramework.fillActionTempWSDTO(actionTempDBModel));
        }

        response.setActionTemps(actionTempWSDTOS);
        general.setOperation("createActionTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionTempWSModel updateActionTemp(long userId, long tempId, String actionTemp) {

        ActionTempWSModel response = new ActionTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTempWSDTO> actionTempWSDTOS = new ArrayList<>();

        ActionTempDBModel actionTempDBModel = actionTempFramework.updateActionTempService(tempId,actionTemp);
        if (actionTempDBModel != null){
            actionTempWSDTOS.add(actionTempFramework.fillActionTempWSDTO(actionTempDBModel));
        }

        response.setActionTemps(actionTempWSDTOS);
        general.setOperation("updateActionTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionTempWSModel removeActionTemp(long userId, long tempId) {

        ActionTempWSModel response = new ActionTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionTempWSDTO> actionTempWSDTOS = new ArrayList<>();

        ActionTempDBModel actionTempDBModel = actionTempFramework.removeActionTempService(tempId);
        if (actionTempDBModel != null){
            actionTempWSDTOS.add(actionTempFramework.fillActionTempWSDTO(actionTempDBModel));
        }

        response.setActionTemps(actionTempWSDTOS);
        general.setOperation("removeActionTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
