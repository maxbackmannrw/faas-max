package com.faas.core.base.endpoint.controller.process.details.inquiry;

import com.faas.core.base.middleware.process.details.inquiry.ProcessInquiryMiddleware;
import com.faas.core.base.model.ws.process.details.inquiry.InquiryDataWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.InquiryUrlWSModel;
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

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessInquiry(@RequestParam long userId,
                                                  @RequestParam String processId,
                                                  @RequestParam String processInquiry,
                                                  @RequestParam String inquiryDesc,
                                                  @RequestParam String inquiryType) {

        ProcessInquiryWSModel response = processInquiryMiddleware.createProcessInquiry(userId,processId,processInquiry,inquiryDesc,inquiryType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessInquiry(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessInquiryWSModel response = processInquiryMiddleware.removeProcessInquiry(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_INQUIRY_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessInquiryDatas(@RequestParam long userId,
                                                    @RequestParam String processId) {

        InquiryDataWSModel response = processInquiryMiddleware.getProcessInquiryDatas(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessInquiryData(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String dataId) {

        InquiryDataWSModel response = processInquiryMiddleware.getProcessInquiryData(userId,processId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessInquiryData(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam long dateTypeId,
                                                      @RequestParam String value) {

        InquiryDataWSModel response = processInquiryMiddleware.createProcessInquiryData(userId,processId,dateTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessInquiryData(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String dataId,
                                                      @RequestParam long dateTypeId,
                                                      @RequestParam String value) {

        InquiryDataWSModel response = processInquiryMiddleware.updateProcessInquiryData(userId,processId,dataId,dateTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessInquiryData(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String dataId) {

        InquiryDataWSModel response = processInquiryMiddleware.removeProcessInquiryData(userId,processId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_INQUIRY_URLS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessInquiryUrls(@RequestParam long userId,
                                                   @RequestParam String processId) {

        InquiryUrlWSModel response = processInquiryMiddleware.getProcessInquiryUrls(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_INQUIRY_URL, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessInquiryUrl(@RequestParam long userId,
                                                  @RequestParam String processId,
                                                  @RequestParam String urlId) {

        InquiryUrlWSModel response = processInquiryMiddleware.getProcessInquiryUrl(userId,processId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_INQUIRY_URL, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessInquiryUrl(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String urlType,
                                                     @RequestParam String url) {

        InquiryUrlWSModel response = processInquiryMiddleware.createProcessInquiryUrl(userId,processId,urlType,url);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_INQUIRY_URL, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessInquiryUrl(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String urlId,
                                                     @RequestParam String urlType,
                                                     @RequestParam String url) {

        InquiryUrlWSModel response = processInquiryMiddleware.updateProcessInquiryUrl(userId,processId,urlId,urlType,url);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_INQUIRY_URL, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessInquiryUrl(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String urlId) {

        InquiryUrlWSModel response = processInquiryMiddleware.removeProcessInquiryUrl(userId,processId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
