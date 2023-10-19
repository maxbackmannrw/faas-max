package com.faas.core.api.middleware.flow.content;

import com.faas.core.api.framework.flow.content.ApiOperationFlowFramework;
import com.faas.core.api.model.ws.flow.content.ApiAgentOperationFlowWSModel;
import com.faas.core.api.model.ws.flow.content.ApiFlowWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationFlowMiddleware {


    @Autowired
    ApiOperationFlowFramework apiOperationFlowFramework;


    public ApiAgentOperationFlowWSModel apiGetAgentOperationFlows(long agentId, int reqPage, int reqSize) {

        ApiAgentOperationFlowWSModel response = new ApiAgentOperationFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetAgentClientFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiGetCampaignOperationFlows(long agentId, String campaignId, String flowState, int reqPage, int reqSize) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetCampaignOperationFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiGetOperationFlows(long agentId,String flowState,int reqPage,int reqSize) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetOperationFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiGetOperationFlow(long agentId, long flowId,String campaignId) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetOperationFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiUpdateOperationFlow(long agentId, long flowId,String flowState) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiUpdateOperationFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiRemoveOperationFlow(long agentId, long flowId) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiRemoveClientFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetOperationFlowSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationFlowSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
