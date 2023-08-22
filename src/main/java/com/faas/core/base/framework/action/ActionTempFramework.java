package com.faas.core.base.framework.action;

import com.faas.core.base.model.db.action.ActionTempDBModel;
import com.faas.core.base.model.ws.action.dto.ActionTempWSDTO;
import com.faas.core.base.repo.action.ActionTempRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ActionTempFramework {

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AppUtils appUtils;


    public ActionTempWSDTO fillActionTempWSDTO(ActionTempDBModel actionTempDBModel) {

        ActionTempWSDTO actionTempWSDTO = new ActionTempWSDTO();
        actionTempWSDTO.setActionTemp(actionTempDBModel);
        return actionTempWSDTO;
    }


    public ActionTempDBModel createActionTempService(String actionTemp) {

        ActionTempDBModel actionTempDBModel = new ActionTempDBModel();

        actionTempDBModel.setActionTemp(actionTemp);
        actionTempDBModel.setuDate(appUtils.getCurrentTimeStamp());
        actionTempDBModel.setcDate(appUtils.getCurrentTimeStamp());
        actionTempDBModel.setStatus(1);

        return actionTempRepository.save(actionTempDBModel);
    }


    public ActionTempDBModel updateActionTempService(long tempId, String actionTemp) {

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(tempId);
        if (actionTempDBModel.isPresent()){

            actionTempDBModel.get().setActionTemp(actionTemp);
            actionTempDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            actionTempDBModel.get().setStatus(1);

            return actionTempRepository.save(actionTempDBModel.get());
        }
        return null;
    }


    public ActionTempDBModel removeActionTempService(long tempId) {

        Optional<ActionTempDBModel> actionTempDBModel = actionTempRepository.findById(tempId);
        if (actionTempDBModel.isPresent()){
            actionTempRepository.delete(actionTempDBModel.get());
            return actionTempDBModel.get();
        }
        return null;
    }

}
