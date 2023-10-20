package com.faas.core.api.framework.flow.content;

import com.faas.core.api.model.ws.flow.content.dto.ApiAgentFlowWSDTO;
import com.faas.core.api.model.ws.flow.content.dto.ApiFlowWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiFlowFramework {


    @Autowired
    AppUtils appUtils;


    public ApiAgentFlowWSDTO apiGetAgentFlowsService(long agentId, int reqPage, int reqSize){

        return null;
    }


    public ApiFlowWSDTO apiGetCampaignFlowsService(long agentId, String campaignId,String flowState, int reqPage, int reqSize){
        return null;
    }


    public ApiFlowWSDTO apiGetFlowsService(long agentId, String flowState, int reqPage, int reqSize){
        return null;
    }


    public ApiInquiryWSDTO apiGetFlowService(long agentId,long flowId,String campaignId){

       return null;
    }


    public ApiInquiryWSDTO apiUpdateFlowService(long agentId,long flowId,String inquiryState){

        return null;
    }

    public ApiInquiryWSDTO apiRemoveFlowService(long agentId,long flowId){
        return null;
    }


    public List<ApiSummaryWSDTO> apiGetFlowSummaryService(long agentId){

        return null;
    }


}
