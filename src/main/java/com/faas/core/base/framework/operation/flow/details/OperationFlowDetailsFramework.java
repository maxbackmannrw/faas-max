package com.faas.core.base.framework.operation.flow.details;

import com.faas.core.base.model.ws.operation.flow.dto.OperationFlowCampaignWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OperationFlowDetailsFramework {

    @Autowired
    AppUtils appUtils;


    public List<OperationFlowCampaignWSDTO> getFlowCampaignsService(long userId, int reqPage, int reqSize) {

        List<OperationFlowCampaignWSDTO> operationFlowCampaignWSDTOS = new ArrayList<>();

        return operationFlowCampaignWSDTOS;
    }




}
