package com.faas.core.base.endpoint.controller.campaign.details.content.inquiry;

import com.faas.core.base.middleware.campaign.details.client.inquiry.CampaignInquiryMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquiryWSModel;
import com.faas.core.base.model.ws.client.inquiry.ClientInquiryRequest;
import com.faas.core.base.model.ws.client.inquiry.ClientInquiryWSModel;
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
public class CampaignInquiryController {


    @Autowired
    CampaignInquiryMiddleware campaignInquiryMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignInquiries(@RequestParam long userId,
                                                     @RequestParam String campaignId,
                                                     @RequestParam String clientCity,
                                                     @RequestParam String clientCountry,
                                                     @RequestParam int reqPage,
                                                     @RequestParam int reqSize) {

        CampaignInquiryWSModel response = campaignInquiryMiddleware.searchCampaignInquiries(userId,campaignId,clientCity,clientCountry,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquiries(@RequestParam long userId,
                                                  @RequestParam String campaignId,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        CampaignInquiryWSModel response = campaignInquiryMiddleware.getCampaignInquiries(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquiry(@RequestParam long userId,
                                                @RequestParam long inquiryId,
                                                @RequestParam long clientId) {

        ClientInquiryWSModel response = campaignInquiryMiddleware.getCampaignInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignInquiry(@RequestBody ClientInquiryRequest clientInquiryRequest) {

        ClientInquiryWSModel response = campaignInquiryMiddleware.createCampaignInquiry(clientInquiryRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignInquiry(@RequestParam long userId,
                                                   @RequestParam long inquiryId,
                                                   @RequestParam long clientId,
                                                   @RequestParam String inquiryState) {

        ClientInquiryWSModel response = campaignInquiryMiddleware.updateCampaignInquiry(userId,inquiryId,clientId,inquiryState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignInquiry(@RequestParam long userId,
                                                   @RequestParam long inquiryId,
                                                   @RequestParam long clientId) {

        ClientInquiryWSModel response = campaignInquiryMiddleware.removeCampaignInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
