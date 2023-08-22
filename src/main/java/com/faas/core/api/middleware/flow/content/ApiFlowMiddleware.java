package com.faas.core.api.middleware.flow.content;

import com.faas.core.api.framework.flow.content.ApiFlowFramework;
import com.faas.core.api.model.ws.flow.content.ApiAgentFlowWSModel;
import com.faas.core.api.model.ws.flow.content.ApiFlowWSModel;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiFlowMiddleware {


    @Autowired
    ApiFlowFramework apiFlowFramework;


    public ApiAgentFlowWSModel apiGetAgentFlow(long agentId, int reqPage, int reqSize) {

        ApiAgentFlowWSModel response = new ApiAgentFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetAgentFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiFlowWSModel apiGetCampaignFlow(long agentId, String campaignId, String flowState, int reqPage, int reqSize) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetCampaignFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiGetFlows(long agentId,String flowState,int reqPage,int reqSize) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiGetFlow(long agentId, long flowId,String campaignId) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiStartFlow(long agentId,long flowId,long sessionId,String campaignId) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiStartFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiUpdateFlow(long agentId, long flowId,String flowState) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiUpdateFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiFlowWSModel apiRemoveFlow(long agentId, long flowId) {

        ApiFlowWSModel response = new ApiFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiRemoveFlow");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetFlowSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetFlowSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
