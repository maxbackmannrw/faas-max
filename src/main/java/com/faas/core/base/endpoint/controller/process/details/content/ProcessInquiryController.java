package com.faas.core.base.endpoint.controller.process.details.content;

import com.faas.core.base.middleware.process.details.content.ProcessInquiryMiddleware;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessInquiryWSModel;
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

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessInquiry(@RequestParam long userId,
                                                  @RequestParam String processId,
                                                  @RequestParam String processInquiry) {

        ProcessInquiryWSModel response = processInquiryMiddleware.updateProcessInquiry(userId,processId,processInquiry);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_INQUIRY_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessInquiryDatas(@RequestParam long userId,
                                                    @RequestParam String processId) {

        ProcessDataWSModel response = processInquiryMiddleware.getProcessInquiryDatas(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessInquiryData(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String dataId) {

        ProcessDataWSModel response = processInquiryMiddleware.getProcessInquiryData(userId,processId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessInquiryData(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam long typeId,
                                                      @RequestParam String value) {

        ProcessDataWSModel response = processInquiryMiddleware.createProcessInquiryData(userId,processId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessInquiryData(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String dataId,
                                                      @RequestParam long typeId,
                                                      @RequestParam String value) {

        ProcessDataWSModel response = processInquiryMiddleware.updateProcessInquiryData(userId,processId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessInquiryData(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String dataId) {

        ProcessDataWSModel response = processInquiryMiddleware.removeProcessInquiryData(userId,processId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
