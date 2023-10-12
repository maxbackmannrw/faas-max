package com.faas.core.api.framework.flow.content;

import com.faas.core.api.model.ws.flow.content.dto.ApiAgentFlowWSDTO;
import com.faas.core.api.model.ws.flow.content.dto.ApiFlowWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiClientFlowFramework {


    @Autowired
    AppUtils appUtils;


    public ApiAgentFlowWSDTO apiGetAgentOperationFlowsService(long agentId, int reqPage, int reqSize){

        return null;
    }


    public ApiFlowWSDTO apiGetCampaignOperationFlowsService(long agentId, String campaignId,String flowState, int reqPage, int reqSize){
        return null;
    }


    public ApiFlowWSDTO apiGetOperationFlowsService(long agentId, String flowState, int reqPage, int reqSize){
        return null;
    }


    public ApiInquiryWSDTO apiGetOperationFlowService(long agentId,long flowId,String campaignId){

       return null;
    }


    public ApiInquiryWSDTO apiStartOperationFlowService(long agentId,long flowId,long sessionId,String campaignId){

        return null;
    }


    public ApiInquiryWSDTO apiUpdateOperationFlowService(long agentId,long flowId,String inquiryState){

        return null;
    }


    public ApiInquiryWSDTO apiRemoveOperationFlowService(long agentId,long flowId){
        return null;
    }





}
