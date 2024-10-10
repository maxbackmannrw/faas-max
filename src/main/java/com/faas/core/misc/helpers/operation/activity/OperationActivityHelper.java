package com.faas.core.misc.helpers.operation.activity;

import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationActivityHelper {


    @Autowired
    OperationRepository operationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUtils appUtils;

    public void createOperationActivity(OperationDBModel operationDBModel) {

    }





}
