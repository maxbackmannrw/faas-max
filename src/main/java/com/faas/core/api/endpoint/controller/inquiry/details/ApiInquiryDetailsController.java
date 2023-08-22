
package com.faas.core.api.endpoint.controller.inquiry.details;

import com.faas.core.api.middleware.inquiry.details.ApiInquiryDetailsMiddleware;
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
public class ApiInquiryDetailsController {


    @Autowired
    ApiInquiryDetailsMiddleware apiInquiryDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_INQUIRY_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetInquiryDetails(@RequestParam long agentId,
                                                  @RequestParam long inquiryId) {

        ApiInquiryDetailsWSModel response = apiInquiryDetailsMiddleware.apiGetInquiryDetails(agentId,inquiryId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
