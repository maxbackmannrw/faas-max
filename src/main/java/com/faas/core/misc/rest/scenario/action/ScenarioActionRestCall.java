package com.faas.core.misc.rest.scenario.action;

import com.faas.core.data.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ScenarioActionRestCall {

    @Autowired
    AppUtils appUtils;


    public void startSipCallIntegration(OperationSipCallDBModel operationSipCallDBModel) {

    }


}
