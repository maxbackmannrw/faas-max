package com.faas.core.base.endpoint.controller.client.inquiry.content;

import com.faas.core.base.middleware.client.inquiry.content.ClientInquiryMiddleware;
import com.faas.core.base.model.ws.client.inquiry.InquiryCampaignWSModel;
import com.faas.core.base.model.ws.client.inquiry.ClientInquiryWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/inquiry/")
public class ClientInquiryController {


    @Autowired
    ClientInquiryMiddleware clientInquiryMiddleware;


    @RequestMapping(value = BaseRoute.GET_INQUIRY_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryCampaigns(@RequestParam long userId,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        InquiryCampaignWSModel response = clientInquiryMiddleware.getInquiryCampaigns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryCampaign(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam int reqPage,
                                                @RequestParam int reqSize) {

        InquiryCampaignWSModel response = clientInquiryMiddleware.getInquiryCampaign(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllInquiries(@RequestParam long userId,
                                                   @RequestParam int reqPage,
                                                   @RequestParam int reqSize) {

        ClientInquiryWSModel response = clientInquiryMiddleware.getAllInquiries(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRIES_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiriesByState(@RequestParam long userId,
                                                 @RequestParam String inquiryState,
                                                 @RequestParam int reqPage,
                                                 @RequestParam int reqSize) {

        ClientInquiryWSModel response = clientInquiryMiddleware.getInquiriesByState(userId,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiry(@RequestParam long userId,
                                        @RequestParam long inquiryId,
                                        @RequestParam long clientId) {

        ClientInquiryWSModel response = clientInquiryMiddleware.getInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> createInquiry(@RequestParam long userId,
                                           @RequestParam long clientId,
                                           @RequestParam long agentId,
                                           @RequestParam String campaignId) {

        ClientInquiryWSModel response = clientInquiryMiddleware.createInquiry(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateInquiry(@RequestParam long userId,
                                           @RequestParam long inquiryId,
                                           @RequestParam long clientId) {

        ClientInquiryWSModel response = clientInquiryMiddleware.updateInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeInquiry(@RequestParam long userId,
                                           @RequestParam long inquiryId,
                                           @RequestParam long clientId) {

        ClientInquiryWSModel response = clientInquiryMiddleware.removeInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
