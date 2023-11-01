package com.faas.core.base.endpoint.controller.operation.inquiry;

import com.faas.core.base.middleware.operation.inquiry.InquiryOperationMiddleware;
import com.faas.core.base.model.ws.operation.inquiry.InquiryOperationListWSModel;
import com.faas.core.base.model.ws.operation.inquiry.InquiryOperationWSModel;
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
public class InquiryOperationController {


    @Autowired
    InquiryOperationMiddleware inquiryOperationMiddleware;


    @RequestMapping(value = BaseRoute.GET_INQUIRY_OPERATIONS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryOperations(@RequestParam long userId,
                                                  @RequestParam String sessionState,
                                                  @RequestParam int reqPage,
                                                  @RequestParam int reqSize) {

        InquiryOperationListWSModel response = inquiryOperationMiddleware.getInquiryOperations(userId,sessionState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryOperation(@RequestParam long userId,
                                                 @RequestParam long sessionId) {

        InquiryOperationWSModel response = inquiryOperationMiddleware.getInquiryOperation(userId,sessionId);

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

        InquiryOperationWSModel response = inquiryOperationMiddleware.createInquiryOperation(userId,clientId,agentId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_INQUIRY_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> updateInquiryOperation(@RequestParam long userId,
                                                    @RequestParam long sessionId) {

        InquiryOperationWSModel response = inquiryOperationMiddleware.updateInquiryOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_INQUIRY_OPERATION, method = RequestMethod.POST)
    public ResponseEntity<?> removeInquiryOperation(@RequestParam long userId,
                                                    @RequestParam long sessionId) {

        InquiryOperationWSModel response = inquiryOperationMiddleware.removeInquiryOperation(userId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
