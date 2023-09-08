package com.faas.core.base.endpoint.controller.process.details.content;

import com.faas.core.base.middleware.process.details.content.ProcessDetailsMiddleware;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDetailsWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessUrlWSModel;
import com.faas.core.base.model.ws.process.details.content.CallScriptWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/")
public class ProcessDetailsController {


    @Autowired
    ProcessDetailsMiddleware processDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessDetails(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessDetailsWSModel response = processDetailsMiddleware.getProcessDetails(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_MANUAL_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> getManualProcess(@RequestParam long userId,
                                              @RequestParam String processId) {

        ProcessDetailsWSModel response = processDetailsMiddleware.getManualProcess(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryProcess(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessDetailsWSModel response = processDetailsMiddleware.getInquiryProcess(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticProcess(@RequestParam long userId,
                                                 @RequestParam String processId) {

        ProcessDetailsWSModel response = processDetailsMiddleware.getAutomaticProcess(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessDatas(@RequestParam long userId,
                                             @RequestParam String processId) {

        ProcessDataWSModel response = processDetailsMiddleware.getProcessDatas(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessData(@RequestParam long userId,
                                            @RequestParam String processId,
                                            @RequestParam String dataId) {

        ProcessDataWSModel response = processDetailsMiddleware.getProcessData(userId, processId, dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessData(@RequestParam long userId,
                                               @RequestParam String processId,
                                               @RequestParam long dataTypeId,
                                               @RequestParam String value) {

        ProcessDataWSModel response = processDetailsMiddleware.createProcessData(userId,processId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessData(@RequestParam long userId,
                                               @RequestParam String processId,
                                               @RequestParam String dataId,
                                               @RequestParam long dataTypeId,
                                               @RequestParam String value) {

        ProcessDataWSModel response = processDetailsMiddleware.updateProcessData(userId,processId,dataId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessData(@RequestParam long userId,
                                               @RequestParam String processId,
                                               @RequestParam String dataId) {

        ProcessDataWSModel response = processDetailsMiddleware.removeProcessData(userId, processId, dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_URLS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessUrls(@RequestParam long userId,
                                            @RequestParam String processId) {

        ProcessUrlWSModel response = processDetailsMiddleware.getProcessUrls(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_URL, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessUrl(@RequestParam long userId,
                                           @RequestParam String processId,
                                           @RequestParam String urlId) {

        ProcessUrlWSModel response = processDetailsMiddleware.getProcessUrl(userId,processId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.CREATE_PROCESS_URL, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessUrl(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String urlType,
                                              @RequestParam String url) {

        ProcessUrlWSModel response = processDetailsMiddleware.createProcessUrl(userId,processId,urlType,url);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_URL, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessUrl(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String urlId,
                                              @RequestParam String urlType,
                                              @RequestParam String url) {

        ProcessUrlWSModel response = processDetailsMiddleware.updateProcessUrl(userId,processId,urlId,urlType,url);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_URL, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessUrl(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String urlId) {

        ProcessUrlWSModel response = processDetailsMiddleware.removeProcessUrl(userId,processId,urlId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_CALL_SCRIPTS, method = RequestMethod.POST)
    public ResponseEntity<?> getCallScripts(@RequestParam long userId,
                                            @RequestParam String processId) {

        CallScriptWSModel response = processDetailsMiddleware.getCallScripts(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CALL_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> getCallScript(@RequestParam long userId,
                                           @RequestParam String processId,
                                           @RequestParam String scriptId) {

        CallScriptWSModel response = processDetailsMiddleware.getCallScript(userId,processId,scriptId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CALL_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> createCallScript(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam int scriptOrder,
                                              @RequestParam String scriptTitle,
                                              @RequestParam String scriptBody) {

        CallScriptWSModel response = processDetailsMiddleware.createCallScript(userId,processId,scriptOrder,scriptTitle,scriptBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CALL_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> updateCallScript(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String scriptId,
                                              @RequestParam int scriptOrder,
                                              @RequestParam String scriptTitle,
                                              @RequestParam String scriptBody) {

        CallScriptWSModel response = processDetailsMiddleware.updateCallScript(userId,processId,scriptId,scriptOrder,scriptTitle,scriptBody);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CALL_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> removeCallScript(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String scriptId) {

        CallScriptWSModel response = processDetailsMiddleware.removeCallScript(userId,processId,scriptId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
