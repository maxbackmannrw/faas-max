package com.faas.core.api.framework.operation.details.activity;

import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationActivityFramework {


    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationActivityWSDTO> apiGetOperationActivitiesService(long agentId,String operationId) {

        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty() && operationDBModels.get(0).getOperationActivities() != null){
            for (int i=0;i<operationDBModels.get(0).getOperationActivities().size();i++){
                operationActivityWSDTOS.add(new ApiOperationActivityWSDTO(operationDBModels.get(0).getOperationActivities().get(i)));
            }
        }
        return operationActivityWSDTOS;
    }

    public ApiOperationActivityWSDTO apiGetOperationActivityService(long agentId,String operationId,String activityId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty() && operationDBModels.get(0).getOperationActivities() != null){
            for (int i=0;i<operationDBModels.get(0).getOperationActivities().size();i++){
                if (operationDBModels.get(0).getOperationActivities().get(i).getId().equalsIgnoreCase(activityId)){
                    return new ApiOperationActivityWSDTO(operationDBModels.get(0).getOperationActivities().get(i));
                }
            }
        }
        return null;
    }


}
