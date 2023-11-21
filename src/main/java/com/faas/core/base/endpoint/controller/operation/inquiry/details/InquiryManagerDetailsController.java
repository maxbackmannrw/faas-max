package com.faas.core.base.endpoint.controller.operation.inquiry.details;

import com.faas.core.base.middleware.operation.inquiry.details.InquiryManagerDetailsMiddleware;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/manager/inquiry/details/")
public class InquiryManagerDetailsController {


    @Autowired
    InquiryManagerDetailsMiddleware inquiryManagerDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_INQUIRY_OPERATION_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryOperationDetails(@RequestParam long userId) {

        OperationCampaignWSModel response = inquiryManagerDetailsMiddleware.getInquiryOperationDetails(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_CAMPAIGN_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryCampaignDetails(@RequestParam long userId) {

        OperationCampaignWSModel response = inquiryManagerDetailsMiddleware.getInquiryCampaignDetails(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
