package com.faas.core.misc.rest.scenario.automation;

import com.faas.core.data.db.operation.details.channel.OperationSipCallDBModel;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ScenarioAutomationRestCall {

    @Autowired
    AppUtils appUtils;


    public void startSipCallIntegration(OperationSipCallDBModel operationSipCallDBModel) {

    }


}
