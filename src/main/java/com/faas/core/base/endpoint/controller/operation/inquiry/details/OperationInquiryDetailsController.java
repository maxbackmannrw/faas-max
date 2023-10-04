package com.faas.core.base.endpoint.controller.operation.inquiry.details;

import com.faas.core.base.middleware.operation.inquiry.details.OperationInquiryDetailsMiddleware;
import com.faas.core.base.model.ws.operation.inquiry.OperationInquiryCampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/inquiry/details/")
public class OperationInquiryDetailsController {


    @Autowired
    OperationInquiryDetailsMiddleware operationInquiryDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_OPERATION_INQUIRY_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getOperationInquiryCampaigns(@RequestParam long userId,
                                                          @RequestParam int reqPage,
                                                          @RequestParam int reqSize) {

        OperationInquiryCampaignWSModel response = operationInquiryDetailsMiddleware.getOperationInquiryCampaigns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
