package com.faas.core.api.middleware.inquiry.content;

import com.faas.core.api.framework.inquiry.content.ApiInquiryFramework;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiAgentInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiOperationInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiOperationInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiInquiryMiddleware {


    @Autowired
    ApiInquiryFramework apiInquiryFramework;


    public ApiAgentInquiryWSModel apiGetAgentInquiries(long agentId, int reqPage, int reqSize) {

        ApiAgentInquiryWSModel response = new ApiAgentInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentInquiryWSDTO agentInquiryWSDTO = apiInquiryFramework.apiGetAgentInquiriesService(agentId,reqPage,reqSize);
        if (agentInquiryWSDTO != null){
            response.setAgentInquiry(agentInquiryWSDTO);
        }

        general.setOperation("apiGetAgentInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationInquiryWSModel apiGetCampaignInquiries(long agentId, String campaignId, String inquiryState, int reqPage, int reqSize) {

        ApiOperationInquiryWSModel response = new ApiOperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationInquiryWSDTO operationInquiryWSDTO = apiInquiryFramework.apiGetCampaignInquiriesService(agentId,campaignId,inquiryState,reqPage,reqSize);
        if (operationInquiryWSDTO != null){
            response.setOperationInquiry(operationInquiryWSDTO);
        }

        general.setOperation("apiGetCampaignInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationInquiryWSModel apiGetInquiries(long agentId, String inquiryState, int reqPage, int reqSize) {

        ApiOperationInquiryWSModel response = new ApiOperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationInquiryWSDTO operationInquiryWSDTO = apiInquiryFramework.apiGetInquiriesService(agentId,inquiryState,reqPage,reqSize);
        if (operationInquiryWSDTO != null){
            response.setOperationInquiry(operationInquiryWSDTO);
        }

        general.setOperation("apiGetInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiInquiryWSModel apiGetInquiry(long agentId, long inquiryId,String campaignId) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();

        ApiInquiryWSDTO inquiryWSDTO = apiInquiryFramework.apiGetInquiryService(agentId,inquiryId,campaignId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("apiGetInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiStartInquiry(long agentId,long inquiryId,long sessionId,String campaignId) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();

        ApiInquiryWSDTO inquiryWSDTO = apiInquiryFramework.apiStartInquiryService(agentId,inquiryId,sessionId,campaignId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("apiStartInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiUpdateInquiry(long agentId, long inquiryId,String inquiryState) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();



        response.setInquiries(inquiryWSDTOS);
        general.setOperation("apiUpdateInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiRemoveInquiry(long agentId, long inquiryId) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();



        response.setInquiries(inquiryWSDTOS);
        general.setOperation("apiRemoveInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetInquirySummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetInquirySummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
