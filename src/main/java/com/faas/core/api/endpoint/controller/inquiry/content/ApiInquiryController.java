
package com.faas.core.api.endpoint.controller.inquiry.content;

import com.faas.core.api.middleware.inquiry.content.ApiInquiryMiddleware;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.inquiry.content.ApiAgentInquiryWSModel;
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
public class ApiInquiryController {


    @Autowired
    ApiInquiryMiddleware apiInquiryMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentInquiry(@RequestParam long agentId,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        ApiAgentInquiryWSModel response = apiInquiryMiddleware.apiGetAgentInquiry(agentId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetCampaignInquiry(@RequestParam long agentId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String inquiryState,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        ApiInquiryWSModel response = apiInquiryMiddleware.apiGetCampaignInquiry(agentId,campaignId,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetInquiries(@RequestParam long agentId,
                                             @RequestParam String inquiryState,
                                             @RequestParam int reqPage,
                                             @RequestParam int reqSize) {

        ApiInquiryWSModel response = apiInquiryMiddleware.apiGetInquiries(agentId,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetInquiry(@RequestParam long agentId,
                                           @RequestParam long inquiryId,
                                           @RequestParam String campaignId) {

        ApiInquiryWSModel response = apiInquiryMiddleware.apiGetInquiry(agentId,inquiryId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_START_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiStartInquiry(@RequestParam long agentId,
                                             @RequestParam long inquiryId,
                                             @RequestParam long sessionId,
                                             @RequestParam String campaignId) {

        ApiInquiryWSModel response = apiInquiryMiddleware.apiStartInquiry(agentId,inquiryId,sessionId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateInquiry(@RequestParam long agentId,
                                              @RequestParam long inquiryId,
                                              @RequestParam String inquiryState) {

        ApiInquiryWSModel response = apiInquiryMiddleware.apiUpdateInquiry(agentId,inquiryId,inquiryState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveInquiry(@RequestParam long agentId,
                                              @RequestParam long inquiryId) {

        ApiInquiryWSModel response = apiInquiryMiddleware.apiRemoveInquiry(agentId,inquiryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_INQUIRY_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetInquirySummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiInquiryMiddleware.apiGetInquirySummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
