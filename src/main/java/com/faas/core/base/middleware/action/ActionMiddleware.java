package com.faas.core.base.middleware.action;

import com.faas.core.base.framework.action.ActionFramework;
import com.faas.core.base.model.db.action.ActionDBModel;
import com.faas.core.base.model.ws.action.ActionWSModel;
import com.faas.core.base.model.ws.action.dto.ActionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.action.ActionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ActionMiddleware {

    @Autowired
    ActionFramework actionFramework;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    AppUtils appUtils;


    public ActionWSModel getActions(long userId) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();

        List<ActionDBModel> actionDBModels = actionRepository.findByStatus(1);
        for (ActionDBModel actionDBModel : actionDBModels) {
            actionWSDTOS.add(actionFramework.fillActionWSDTO(actionDBModel));
        }

        response.setActions(actionWSDTOS);
        general.setOperation("getActions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionWSModel getAction(long userId, long actionId) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent()){
            actionWSDTOS.add(actionFramework.fillActionWSDTO(actionDBModel.get()));
        }

        response.setActions(actionWSDTOS);
        general.setOperation("getAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionWSModel createAction(long userId, String action) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();

        ActionDBModel actionDBModel = actionFramework.createActionService(action);
        if (actionDBModel != null){
            actionWSDTOS.add(actionFramework.fillActionWSDTO(actionDBModel));
        }

        response.setActions(actionWSDTOS);
        general.setOperation("createAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionWSModel updateAction(long userId,long actionId,String action) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();

        ActionDBModel actionDBModel = actionFramework.updateActionService(actionId,action);
        if (actionDBModel != null){
            actionWSDTOS.add(actionFramework.fillActionWSDTO(actionDBModel));
        }

        response.setActions(actionWSDTOS);
        general.setOperation("updateAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ActionWSModel removeAction(long userId, long actionId) {

        ActionWSModel response = new ActionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ActionWSDTO> actionWSDTOS = new ArrayList<>();

        ActionDBModel actionDBModel = actionFramework.removeActionService(actionId);
        if (actionDBModel != null){
            actionWSDTOS.add(actionFramework.fillActionWSDTO(actionDBModel));
        }

        response.setActions(actionWSDTOS);
        general.setOperation("removeAction");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
