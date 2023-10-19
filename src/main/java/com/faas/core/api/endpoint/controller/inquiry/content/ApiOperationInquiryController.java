
package com.faas.core.api.endpoint.controller.inquiry.content;

import com.faas.core.api.middleware.inquiry.content.ApiOperationInquiryMiddleware;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiAgentOperationInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiOperationInquiryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiInquiryWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/inquiry/")
public class ApiOperationInquiryController {


    @Autowired
    ApiOperationInquiryMiddleware apiOperationInquiryMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_OPERATION_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentOperationInquiries(@RequestParam long agentId,
                                                           @RequestParam int reqPage,
                                                           @RequestParam int reqSize) {

        ApiAgentOperationInquiryWSModel response = apiOperationInquiryMiddleware.apiGetAgentOperationInquiries(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_OPERATION_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignOperationInquiries(@RequestParam long agentId,
                                                              @RequestParam String campaignId,
                                                              @RequestParam String inquiryState,
                                                              @RequestParam int reqPage,
                                                              @RequestParam int reqSize) {

        ApiOperationInquiryWSModel response = apiOperationInquiryMiddleware.apiGetCampaignOperationInquiries(agentId,campaignId,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationInquiries(@RequestParam long agentId,
                                                      @RequestParam String inquiryState,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        ApiOperationInquiryWSModel response = apiOperationInquiryMiddleware.apiGetOperationInquiries(agentId,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationInquiry(@RequestParam long agentId,
                                                    @RequestParam long inquiryId,
                                                    @RequestParam String campaignId) {

        ApiInquiryWSModel response = apiOperationInquiryMiddleware.apiGetOperationInquiry(agentId,inquiryId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_START_OPERATION_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartOperationInquiry(@RequestParam long agentId,
                                                      @RequestParam long inquiryId,
                                                      @RequestParam long sessionId,
                                                      @RequestParam String campaignId) {

        ApiInquiryWSModel response = apiOperationInquiryMiddleware.apiStartOperationInquiry(agentId,inquiryId,sessionId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationInquiry(@RequestParam long agentId,
                                                       @RequestParam long inquiryId,
                                                       @RequestParam String inquiryState) {

        ApiInquiryWSModel response = apiOperationInquiryMiddleware.apiUpdateOperationInquiry(agentId,inquiryId,inquiryState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationInquiry(@RequestParam long agentId,
                                                       @RequestParam long inquiryId) {

        ApiInquiryWSModel response = apiOperationInquiryMiddleware.apiRemoveOperationInquiry(agentId,inquiryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_INQUIRY_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationInquirySummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiOperationInquiryMiddleware.apiGetOperationInquirySummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
