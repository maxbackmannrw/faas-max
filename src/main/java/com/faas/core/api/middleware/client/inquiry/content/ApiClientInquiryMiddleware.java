package com.faas.core.api.middleware.client.inquiry.content;

import com.faas.core.api.framework.client.inquiry.content.ApiClientInquiryFramework;
import com.faas.core.api.model.ws.client.inquiry.content.ApiAgentInquiryWSModel;
import com.faas.core.api.model.ws.client.inquiry.content.ApiInquiryWSModel;
import com.faas.core.api.model.ws.client.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.api.model.ws.client.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiClientInquiryMiddleware {


    @Autowired
    ApiClientInquiryFramework apiClientInquiryFramework;


    public ApiAgentInquiryWSModel apiGetAgentOperationInquiries(long agentId,int reqPage,int reqSize) {

        ApiAgentInquiryWSModel response = new ApiAgentInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentInquiryWSDTO agentInquiryWSDTO = apiClientInquiryFramework.apiGetAgentOperationInquiriesService(agentId,reqPage,reqSize);
        if (agentInquiryWSDTO != null){
            response.setAgentInquiry(agentInquiryWSDTO);
        }

        general.setOperation("apiGetAgentOperationInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiGetCampaignOperationInquiries(long agentId, String campaignId,String inquiryState, int reqPage, int reqSize) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiInquiryWSDTO inquiryWSDTO = apiClientInquiryFramework.apiGetCampaignOperationInquiriesService(agentId,campaignId,inquiryState,reqPage,reqSize);
        if (inquiryWSDTO != null){
            response.setInquiry(inquiryWSDTO);
        }

        general.setOperation("apiGetCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiGetOperationInquiries(long agentId,String inquiryState,int reqPage,int reqSize) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiInquiryWSDTO inquiryWSDTO = apiClientInquiryFramework.apiGetOperationInquiriesService(agentId,inquiryState,reqPage,reqSize);
        if (inquiryWSDTO != null){
            response.setInquiry(inquiryWSDTO);
        }

        general.setOperation("apiGetOperationInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiInquiryWSModel apiGetOperationInquiry(long agentId, long inquiryId,String campaignId) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiInquiryWSDTO inquiryWSDTO = apiClientInquiryFramework.apiGetOperationInquiryService(agentId,inquiryId,campaignId);
        if (inquiryWSDTO != null){
            response.setInquiry(inquiryWSDTO);
        }

        general.setOperation("apiGetInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiStartOperationInquiry(long agentId,long inquiryId,long sessionId,String campaignId) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiInquiryWSDTO inquiryWSDTO = apiClientInquiryFramework.apiStartOperationInquiryService(agentId,inquiryId,sessionId,campaignId);
        if (inquiryWSDTO != null){
            response.setInquiry(inquiryWSDTO);
        }

        general.setOperation("apiStartOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiUpdateOperationInquiry(long agentId, long inquiryId,String inquiryState) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiInquiryWSDTO inquiryWSDTO = apiClientInquiryFramework.apiUpdateOperationInquiryService(agentId,inquiryId,inquiryState);
        if (inquiryWSDTO != null){
            response.setInquiry(inquiryWSDTO);
        }

        general.setOperation("apiUpdateInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiRemoveOperationInquiry(long agentId, long inquiryId) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiInquiryWSDTO inquiryWSDTO = apiClientInquiryFramework.apiRemoveOperationInquiryService(agentId,inquiryId);
        if (inquiryWSDTO != null){
            response.setInquiry(inquiryWSDTO);
        }

        general.setOperation("apiRemoveOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
