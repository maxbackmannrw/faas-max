package com.faas.core.api.framework.operation.manager.activity;

import com.faas.core.api.model.ws.operation.manager.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.content.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationActivityFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AppUtils appUtils;


    public List<ApiOperationActivityWSDTO> apiGetOperationActivitiesService(long agentId, String operationId) {

        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = new ArrayList<>();

        return operationActivityWSDTOS;
    }

    public ApiOperationActivityWSDTO apiGetOperationActivityService(long agentId, String operationId, String activityId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);

        return null;
    }


}
