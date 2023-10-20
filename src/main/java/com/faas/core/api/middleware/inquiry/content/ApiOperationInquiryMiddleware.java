package com.faas.core.api.middleware.inquiry.content;

import com.faas.core.api.framework.inquiry.content.ApiOperationInquiryFramework;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiAgentOperationInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiOperationInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiAgentOperationInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiOperationInquiryWSDTO;
import com.faas.core.api.model.ws.inquiry.content.dto.ApiInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationInquiryMiddleware {


    @Autowired
    ApiOperationInquiryFramework apiOperationInquiryFramework;


    public ApiAgentOperationInquiryWSModel apiGetAgentOperationInquiries(long agentId, int reqPage, int reqSize) {

        ApiAgentOperationInquiryWSModel response = new ApiAgentOperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentOperationInquiryWSDTO agentOperationInquiryWSDTO = apiOperationInquiryFramework.apiGetAgentOperationInquiriesService(agentId,reqPage,reqSize);
        if (agentOperationInquiryWSDTO != null){
            response.setAgentOperationInquiry(agentOperationInquiryWSDTO);
        }

        general.setOperation("apiGetAgentOperationInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationInquiryWSModel apiGetCampaignOperationInquiries(long agentId, String campaignId, String inquiryState, int reqPage, int reqSize) {

        ApiOperationInquiryWSModel response = new ApiOperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationInquiryWSDTO operationInquiryWSDTO = apiOperationInquiryFramework.apiGetCampaignOperationInquiriesService(agentId,campaignId,inquiryState,reqPage,reqSize);
        if (operationInquiryWSDTO != null){
            response.setOperationInquiry(operationInquiryWSDTO);
        }

        general.setOperation("apiGetCampaignOperationInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationInquiryWSModel apiGetOperationInquiries(long agentId, String inquiryState, int reqPage, int reqSize) {

        ApiOperationInquiryWSModel response = new ApiOperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationInquiryWSDTO operationInquiryWSDTO = apiOperationInquiryFramework.apiGetOperationInquiriesService(agentId,inquiryState,reqPage,reqSize);
        if (operationInquiryWSDTO != null){
            response.setOperationInquiry(operationInquiryWSDTO);
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
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();

        ApiInquiryWSDTO inquiryWSDTO = apiOperationInquiryFramework.apiGetOperationInquiryService(agentId,inquiryId,campaignId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("apiGetOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiStartOperationInquiry(long agentId,long inquiryId,long sessionId,String campaignId) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();

        ApiInquiryWSDTO inquiryWSDTO = apiOperationInquiryFramework.apiStartOperationInquiryService(agentId,inquiryId,sessionId,campaignId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
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
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();

        ApiInquiryWSDTO inquiryWSDTO = apiOperationInquiryFramework.apiUpdateOperationInquiryService(agentId,inquiryId,inquiryState);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("apiUpdateOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiInquiryWSModel apiRemoveOperationInquiry(long agentId, long inquiryId) {

        ApiInquiryWSModel response = new ApiInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiInquiryWSDTO> inquiryWSDTOS = new ArrayList<>();

        ApiInquiryWSDTO inquiryWSDTO = apiOperationInquiryFramework.apiRemoveOperationInquiryService(agentId,inquiryId);
        if (inquiryWSDTO != null){
            inquiryWSDTOS.add(inquiryWSDTO);
        }

        response.setInquiries(inquiryWSDTOS);
        general.setOperation("apiRemoveOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetOperationInquirySummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> operationInquirySummary  = apiOperationInquiryFramework.apiGetOperationInquirySummaryService(agentId);
        if (operationInquirySummary != null){
            response.setSummaries(operationInquirySummary);
        }

        general.setOperation("apiGetOperationInquirySummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
