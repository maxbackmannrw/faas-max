package com.faas.core.base.endpoint.controller.campaign.details.client.inquiry;

import com.faas.core.base.middleware.campaign.details.client.inquiry.CampaignInquirySessionMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquirySessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquirySessionRequest;
import com.faas.core.base.model.ws.manager.inquiry.operation.OperationInquirySessionWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/client/inquiry/")
public class CampaignInquirySessionController {


    @Autowired
    CampaignInquirySessionMiddleware campaignInquirySessionMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_INQUIRY_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignInquirySessions(@RequestParam long userId,
                                                           @RequestParam String campaignId,
                                                           @RequestParam String city,
                                                           @RequestParam String country,
                                                           @RequestParam int reqPage,
                                                           @RequestParam int reqSize) {

        CampaignInquirySessionWSModel response = campaignInquirySessionMiddleware.searchCampaignInquirySessions(userId,campaignId,city,country,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRY_SESSIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquirySessions(@RequestParam long userId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam int reqPage,
                                                        @RequestParam int reqSize) {

        CampaignInquirySessionWSModel response = campaignInquirySessionMiddleware.getCampaignInquirySessions(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRY_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquirySession(@RequestParam long userId,
                                                       @RequestParam long sessionId) {

        OperationInquirySessionWSModel response = campaignInquirySessionMiddleware.getCampaignInquirySession(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_INQUIRY_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignInquirySession(@RequestBody CampaignInquirySessionRequest inquirySessionRequest) {

        OperationInquirySessionWSModel response = campaignInquirySessionMiddleware.createCampaignInquirySession(inquirySessionRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_INQUIRY_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignInquirySession(@RequestParam long userId,
                                                          @RequestParam long sessionId,
                                                          @RequestParam long agentId,
                                                          @RequestParam String campaignId,
                                                          @RequestParam String inquiryState) {

        OperationInquirySessionWSModel response = campaignInquirySessionMiddleware.updateCampaignInquirySession(userId,sessionId,agentId,campaignId,inquiryState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_INQUIRY_SESSION, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignInquirySession(@RequestParam long userId,
                                                          @RequestParam long sessionId) {

        OperationInquirySessionWSModel response = campaignInquirySessionMiddleware.removeCampaignInquirySession(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
