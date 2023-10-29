package com.faas.core.base.endpoint.controller.operation.details.inquiry.content;

import com.faas.core.base.middleware.operation.details.inquiry.content.OperationInquiryMiddleware;
import com.faas.core.base.model.ws.operation.inquiry.OperationInquiryCampaignWSModel;
import com.faas.core.base.model.ws.operation.inquiry.OperationInquiryWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/inquiry/")
public class OperationInquiryController {


    @Autowired
    OperationInquiryMiddleware operationInquiryMiddleware;


    @RequestMapping(value = BaseRoute.GET_OPERATION_INQUIRY_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationInquiryCampaigns(@RequestParam long userId,
                                                          @RequestParam int reqPage,
                                                          @RequestParam int reqSize) {

        OperationInquiryCampaignWSModel response = operationInquiryMiddleware.getOperationInquiryCampaigns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_OPERATION_INQUIRY_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationInquiryCampaign(@RequestParam long userId,
                                                         @RequestParam String campaignId,
                                                         @RequestParam int reqPage,
                                                         @RequestParam int reqSize) {

        OperationInquiryCampaignWSModel response = operationInquiryMiddleware.getOperationInquiryCampaign(userId,campaignId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_ALL_OPERATION_INQUIRIES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllOperationInquiries(@RequestParam long userId,
                                                      @RequestParam int reqPage,
                                                      @RequestParam int reqSize) {

        OperationInquiryWSModel response = operationInquiryMiddleware.getAllOperationInquiries(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_OPERATION_INQUIRIES_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationInquiriesByState(@RequestParam long userId,
                                                          @RequestParam String inquiryState,
                                                          @RequestParam int reqPage,
                                                          @RequestParam int reqSize) {

        OperationInquiryWSModel response = operationInquiryMiddleware.getOperationInquiriesByState(userId,inquiryState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_OPERATION_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationInquiry(@RequestParam long userId,
                                                 @RequestParam long inquiryId,
                                                 @RequestParam long clientId) {

        OperationInquiryWSModel response = operationInquiryMiddleware.getOperationInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_OPERATION_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> createOperationInquiry(@RequestParam long userId,
                                                    @RequestParam long clientId,
                                                    @RequestParam long agentId,
                                                    @RequestParam String campaignId) {

        OperationInquiryWSModel response = operationInquiryMiddleware.createOperationInquiry(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_OPERATION_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateOperationInquiry(@RequestParam long userId,
                                                    @RequestParam long inquiryId,
                                                    @RequestParam long clientId) {

        OperationInquiryWSModel response = operationInquiryMiddleware.updateOperationInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_OPERATION_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeOperationInquiry(@RequestParam long userId,
                                                    @RequestParam long inquiryId,
                                                    @RequestParam long clientId) {

        OperationInquiryWSModel response = operationInquiryMiddleware.removeOperationInquiry(userId,inquiryId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
