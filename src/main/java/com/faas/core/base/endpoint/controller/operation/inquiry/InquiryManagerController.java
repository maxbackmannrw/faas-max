package com.faas.core.base.endpoint.controller.operation.inquiry;

import com.faas.core.base.middleware.operation.inquiry.InquiryManagerMiddleware;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.inquiry.InquiryManagerWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/manager/inquiry/")
public class InquiryManagerController {


    @Autowired
    InquiryManagerMiddleware inquiryManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_INQUIRY_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryManager(@RequestParam long userId,
                                               @RequestParam int reqPage,
                                               @RequestParam int reqSize) {

        InquiryManagerWSModel response = inquiryManagerMiddleware.getInquiryManager(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryOperations(@RequestParam long userId,
                                                  @RequestParam String sessionState,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        OperationListWSModel response = inquiryManagerMiddleware.getInquiryOperations(userId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryOperation(@RequestParam long userId,
                                                 @RequestParam long sessionId) {

        OperationWSModel response = inquiryManagerMiddleware.getInquiryOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_INQUIRY_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> createInquiryOperation(@RequestParam long userId,
                                                    @RequestParam long clientId,
                                                    @RequestParam long agentId,
                                                    @RequestParam String campaignId) {

        OperationWSModel response = inquiryManagerMiddleware.createInquiryOperation(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_INQUIRY_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateInquiryOperation(@RequestParam long userId,
                                                    @RequestParam long sessionId) {

        OperationWSModel response = inquiryManagerMiddleware.updateInquiryOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_INQUIRY_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeInquiryOperation(@RequestParam long userId,
                                                    @RequestParam long sessionId) {

        OperationWSModel response = inquiryManagerMiddleware.removeInquiryOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryCampaigns(@RequestParam long userId) {

        OperationCampaignWSModel response = inquiryManagerMiddleware.getInquiryCampaigns(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_INQUIRY_CAMPAIGN, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryCampaign(@RequestParam long userId,
                                                @RequestParam String campaignId) {

        OperationCampaignWSModel response = inquiryManagerMiddleware.getInquiryCampaign(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
