package com.faas.core.api.endpoint.controller.operation.inquiry;

import com.faas.core.api.middleware.operation.inquiry.ApiOperationInquiryMiddleware;
import com.faas.core.api.model.ws.operation.device.ApiOperationDeviceWSModel;
import com.faas.core.api.model.ws.operation.inquiry.ApiOperationInquiryWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/inquiry/")
public class ApiOperationInquiryController {


    @Autowired
    ApiOperationInquiryMiddleware apiOperationInquiryMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationInquiry(@RequestParam long agentId,
                                                    @RequestParam long sessionId,
                                                    @RequestParam long clientId,
                                                    @RequestParam String campaignId) {

        ApiOperationInquiryWSModel response = apiOperationInquiryMiddleware.apiGetOperationInquiry(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
