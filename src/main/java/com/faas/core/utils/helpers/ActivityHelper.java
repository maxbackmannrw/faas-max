package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.content.dao.OperationActivityDAO;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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


    public void createOperationActivity(long sessionId,String operationId,String activity,String activityType,
                                        String creatorId, String creatorType, String createdId, String createdType) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndSessionId(operationId,sessionId);
        if (!operationDBModels.isEmpty()){
            OperationActivityDAO operationActivityDAO = createOperationActivityDAO(sessionId,operationId,activity,activityType,creatorId,creatorType,createdId,createdType);
            if (operationActivityDAO != null){
                operationDBModels.get(0).getActivities().add(operationActivityDAO);
                operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                operationRepository.save(operationDBModels.get(0));
            }
        }
    }


    public OperationActivityDAO createOperationActivityDAO(long sessionId, String operationId, String activity, String activityType,
                                                           String creatorId, String creatorType, String createdId, String createdType){

        OperationActivityDAO operationActivityDAO = new OperationActivityDAO();

        operationActivityDAO.setId(appUtils.generateUUID());
        operationActivityDAO.setSessionId(sessionId);
        operationActivityDAO.setOperationId(operationId);
        operationActivityDAO.setActivity(activity);
        operationActivityDAO.setActivityDesc(createOperationActivityDesc(activity));
        operationActivityDAO.setActivityType(activityType);
        operationActivityDAO = mapOperationActivityCreatorData(creatorId,creatorType, operationActivityDAO);
        operationActivityDAO = mapOperationActivityCreatedData(createdId,createdType, operationActivityDAO);
        operationActivityDAO.setActivityDatas(new ArrayList<>());
        operationActivityDAO.setcDate(appUtils.getCurrentTimeStamp());
        operationActivityDAO.setStatus(1);

        return operationActivityDAO;
    }


    public OperationActivityDAO mapOperationActivityCreatorData(String creatorId, String creatorType, OperationActivityDAO operationActivityDAO){

        if (creatorType.equalsIgnoreCase(AppConstant.USER_TYPE)){
            Optional<UserDBModel> userDBModel = userRepository.findById(Long.parseLong(creatorId));
            if (userDBModel.isPresent()){
                operationActivityDAO.setCreatorId(creatorId);
                operationActivityDAO.setCreatorName(userDBModel.get().getUserName());
                operationActivityDAO.setCreatorType(creatorType);

                return operationActivityDAO;
            }
        }
        return operationActivityDAO;
    }


    public OperationActivityDAO mapOperationActivityCreatedData(String createdId, String createdType, OperationActivityDAO operationActivityDAO){

        if (createdType.equalsIgnoreCase(AppConstant.SESSION_TYPE)){

            operationActivityDAO.setCreatedId(createdId);
            operationActivityDAO.setCreatedName(AppConstant.SESSION_TYPE);
            operationActivityDAO.setCreatedType(createdType);

            return operationActivityDAO;
        }
        if (createdType.equalsIgnoreCase(AppConstant.OPERATION_TYPE)){

            operationActivityDAO.setCreatedId(createdId);
            operationActivityDAO.setCreatedName(AppConstant.OPERATION_TYPE);
            operationActivityDAO.setCreatedType(createdType);

            return operationActivityDAO;
        }
        return operationActivityDAO;
    }



    public String createOperationActivityDesc(String activity){

        if (activity.equalsIgnoreCase(AppConstant.CREATE_SESSION_ACTIVITY)){
            return AppConstant.CREATE_SESSION_ACTIVITY_DESC;
        }
        if (activity.equalsIgnoreCase(AppConstant.CREATE_OPERATION_ACTIVITY)){
            return AppConstant.CREATE_OPERATION_ACTIVITY_DESC;
        }
        if (activity.equalsIgnoreCase(AppConstant.LAUNCH_OPERATION_ACTIVITY)){
            return AppConstant.LAUNCH_OPERATION_ACTIVITY_DESC;
        }
        if (activity.equalsIgnoreCase(AppConstant.FINISH_OPERATION_ACTIVITY)){
            return AppConstant.FINISH_OPERATION_ACTIVITY_DESC;
        }
        return "";
    }


}
