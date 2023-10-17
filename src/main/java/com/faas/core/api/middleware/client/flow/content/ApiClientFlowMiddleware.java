package com.faas.core.api.middleware.client.flow.content;

import com.faas.core.api.framework.client.flow.content.ApiClientFlowFramework;
import com.faas.core.api.model.ws.client.flow.content.ApiAgentFlowWSModel;
import com.faas.core.api.model.ws.client.flow.content.ApiFlowWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiClientFlowMiddleware {


    @Autowired
    ApiClientFlowFramework apiClientFlowFramework;


    public ApiAgentFlowWSModel apiGetAgentOperationFlows(long agentId, int reqPage, int reqSize) {

        ApiAgentFlowWSModel response = new ApiAgentFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetAgentOperationFlows");
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


    public ApiFlowWSModel apiStartOperationFlow(long agentId,long flowId,long sessionId,String campaignId) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiStartOperationFlow");
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



        general.setOperation("apiRemoveOperationFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
