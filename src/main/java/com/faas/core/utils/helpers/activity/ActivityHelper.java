package com.faas.core.utils.helpers.activity;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.content.dao.OperationActivityDAO;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ActivityHelper {


    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUtils appUtils;

    public void createOperationActivity(SessionDBModel sessionDBModel,OperationDBModel operationDBModel) {

        OperationActivityDAO operationActivityDAO = createActivityDAO(AppConstant.CREATE_OPERATION_ACTIVITY,AppConstant.CREATE_OPERATION_ACTIVITY_DESC,String.valueOf(sessionDBModel.getAgentId()),sessionDBModel.getAgentName(),operationDBModel.getId(),sessionDBModel.getClientName());
        operationDBModel.getOperationActivities().add(operationActivityDAO);
        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationRepository.save(operationDBModel);
    }


    public OperationActivityDAO createActivityDAO(String activity, String activityDesc, String creatorId, String creator, String createdId, String created){

        OperationActivityDAO operationActivityDAO = new OperationActivityDAO();
        operationActivityDAO.setId(appUtils.generateUUID());
        operationActivityDAO.setActivity(activity);
        operationActivityDAO.setActivityDesc(activityDesc);
        operationActivityDAO.setCreatorId(creatorId);
        operationActivityDAO.setCreator(creator);
        operationActivityDAO.setCreatedId(createdId);
        operationActivityDAO.setCreated(created);
        operationActivityDAO.setActivityDatas(new ArrayList<>());
        operationActivityDAO.setcDate(appUtils.getCurrentTimeStamp());
        operationActivityDAO.setStatus(1);

        return operationActivityDAO;
    }


}
