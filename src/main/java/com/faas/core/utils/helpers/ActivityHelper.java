package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.content.dao.ActivityDAO;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

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


    public void createSessionActivity(SessionDBModel sessionDBModel,OperationDBModel operationDBModel) {

        ActivityDAO activityDAO = createActivityDAO(AppConstant.CREATE_SESSION_ACTIVITY,AppConstant.CREATE_SESSION_ACTIVITY_DESC,String.valueOf(sessionDBModel.getAgentId()),sessionDBModel.getAgentName(),String.valueOf(sessionDBModel.getId()),sessionDBModel.getClientName());
        operationDBModel.getOperationActivities().add(activityDAO);
        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationRepository.save(operationDBModel);
    }


    public void createOperationActivity(SessionDBModel sessionDBModel,OperationDBModel operationDBModel) {

        ActivityDAO activityDAO = createActivityDAO(AppConstant.CREATE_OPERATION_ACTIVITY,AppConstant.CREATE_OPERATION_ACTIVITY_DESC,String.valueOf(sessionDBModel.getAgentId()),sessionDBModel.getAgentName(),operationDBModel.getId(),sessionDBModel.getClientName());
        operationDBModel.getOperationActivities().add(activityDAO);
        operationDBModel.setuDate(appUtils.getCurrentTimeStamp());
        operationRepository.save(operationDBModel);
    }


    public ActivityDAO createActivityDAO(String activity,String activityDesc,String creatorId,String creator,String createdId,String created){

        ActivityDAO activityDAO = new ActivityDAO();
        activityDAO.setId(appUtils.generateUUID());
        activityDAO.setActivity(activity);
        activityDAO.setActivityDesc(activityDesc);
        activityDAO.setCreatorId(creatorId);
        activityDAO.setCreator(creator);
        activityDAO.setCreatedId(createdId);
        activityDAO.setCreated(created);
        activityDAO.setActivityDatas(new ArrayList<>());
        activityDAO.setcDate(appUtils.getCurrentTimeStamp());
        activityDAO.setStatus(1);

        return activityDAO;
    }







}
