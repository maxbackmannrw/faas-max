package com.faas.core.base.framework.action;

import com.faas.core.base.model.db.action.ActionDBModel;
import com.faas.core.base.model.ws.action.dto.ActionWSDTO;
import com.faas.core.base.repo.action.ActionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ActionFramework {

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    AppUtils appUtils;


    public ActionWSDTO fillActionWSDTO(ActionDBModel actionDBModel) {

        ActionWSDTO actionWSDTO = new ActionWSDTO();
        actionWSDTO.setAction(actionDBModel);
        return actionWSDTO;
    }


    public ActionDBModel createActionService(String action) {

        ActionDBModel actionDBModel = new ActionDBModel();
        actionDBModel.setAction(action);
        actionDBModel.setuDate(appUtils.getCurrentTimeStamp());
        actionDBModel.setcDate(appUtils.getCurrentTimeStamp());
        actionDBModel.setStatus(1);

        return actionRepository.save(actionDBModel);
    }


    public ActionDBModel updateActionService(long actionId,String action) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent()){
            actionDBModel.get().setAction(action);
            actionDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            actionDBModel.get().setStatus(1);

            return actionRepository.save(actionDBModel.get());
        }
        return null;
    }


    public ActionDBModel removeActionService(long actionId) {

        Optional<ActionDBModel> actionDBModel = actionRepository.findById(actionId);
        if (actionDBModel.isPresent()){
            actionRepository.delete(actionDBModel.get());
            return actionDBModel.get();
        }
        return null;
    }

}
