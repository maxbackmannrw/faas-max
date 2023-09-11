package com.faas.core.base.endpoint.controller.process.details.inquiry;

import com.faas.core.base.middleware.process.details.inquiry.ProcessInquiryMiddleware;
import com.faas.core.base.model.ws.process.details.inquiry.ProcessInquiryWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/inquiry/")
public class ProcessInquiryController {


    @Autowired
    ProcessInquiryMiddleware processInquiryMiddleware;

    @RequestMapping(value = BaseRoute.GET_PROCESS_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessInquiry(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessInquiryWSModel response = processInquiryMiddleware.getProcessInquiry(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
