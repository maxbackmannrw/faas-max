package com.faas.core.base.endpoint.controller.campaign.details.client.inquiry;

import com.faas.core.base.middleware.campaign.details.client.inquiry.CampaignInquiryClientMiddleware;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquiryWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquiryClientRequest;
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
public class CampaignInquiryClientController {


    @Autowired
    CampaignInquiryClientMiddleware campaignInquiryClientMiddleware;


    @RequestMapping(value = BaseRoute.SEARCH_CAMPAIGN_INQUIRY_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> searchCampaignInquiryClients(@RequestParam long userId,
                                                          @RequestParam String campaignId,
                                                          @RequestParam String clientCity,
                                                          @RequestParam String clientCountry,
                                                          @RequestParam int reqPage,
                                                          @RequestParam int reqSize) {

        CampaignInquiryWSModel response = campaignInquiryClientMiddleware.searchCampaignInquiryClients(userId,campaignId,clientCity,clientCountry,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRY_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquiryClients(@RequestParam long userId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam int reqPage,
                                                       @RequestParam int reqSize) {

        CampaignInquiryWSModel response = campaignInquiryClientMiddleware.getCampaignInquiryClients(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRY_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquiryClient(@RequestParam long userId,
                                                      @RequestParam long inquiryId,
                                                      @RequestParam long clientId) {

        ClientInquiryWSModel response = campaignInquiryClientMiddleware.getCampaignInquiryClient(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_INQUIRY_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignInquiryClient(@RequestBody CampaignInquiryClientRequest campaignInquiryClientRequest) {

        ClientInquiryWSModel response = campaignInquiryClientMiddleware.createCampaignInquiryClient(campaignInquiryClientRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_INQUIRY_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignInquiryClient(@RequestParam long userId,
                                                         @RequestParam long inquiryId,
                                                         @RequestParam long clientId,
                                                         @RequestParam String inquiryState) {

        ClientInquiryWSModel response = campaignInquiryClientMiddleware.updateCampaignInquiryClient(userId,inquiryId,clientId,inquiryState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_INQUIRY_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignInquiryClient(@RequestParam long userId,
                                                         @RequestParam long inquiryId,
                                                         @RequestParam long clientId) {

        ClientInquiryWSModel response = campaignInquiryClientMiddleware.removeCampaignInquiryClient(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
