
package com.faas.core.api.endpoint.controller.inquiry.details;

import com.faas.core.api.middleware.inquiry.details.ApiOperationInquiryDetailsMiddleware;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.api.model.ws.inquiry.details.ApiInquiryDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/inquiry/details/")
public class ApiOperationInquiryDetailsController {


    @Autowired
    ApiOperationInquiryDetailsMiddleware apiOperationInquiryDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_INQUIRY_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationInquiryDetails(@RequestParam long agentId,
                                                           @RequestParam long inquiryId) {

        ApiInquiryDetailsWSModel response = apiOperationInquiryDetailsMiddleware.apiGetOperationInquiryDetails(agentId,inquiryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_INQUIRY_SUMMARY, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationInquirySummary(@RequestParam long agentId) {

        ApiSummaryWSModel response = apiOperationInquiryDetailsMiddleware.apiGetOperationInquirySummary(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
