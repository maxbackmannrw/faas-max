package com.faas.core.base.endpoint.controller.process.details.flow;

import com.faas.core.base.middleware.process.details.flow.ProcessFlowMiddleware;
import com.faas.core.base.model.ws.process.details.flow.ProcessFlowWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/flow/")
public class ProcessFlowController {


    @Autowired
    ProcessFlowMiddleware processFlowMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessFlow(@RequestParam long userId,
                                            @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.getProcessFlow(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_FLOW_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessFlowDatas(@RequestParam long userId,
                                                 @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.getProcessFlowDatas(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessFlowData(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.getProcessFlowData(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessFlowData(@RequestParam long userId,
                                                   @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.createProcessFlowData(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessFlowData(@RequestParam long userId,
                                                   @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.updateProcessFlowData(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessFlowData(@RequestParam long userId,
                                                   @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.removeProcessFlowData(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_FLOW_URLS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessFlowUrls(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.getProcessFlowUrls(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_FLOW_URL, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessFlowUrl(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.getProcessFlowUrl(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_FLOW_URL, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessFlowUrl(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.createProcessFlowUrl(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_FLOW_URL, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessFlowUrl(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.updateProcessFlowUrl(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_FLOW_URL, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessFlowUrl(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessFlowWSModel response = processFlowMiddleware.removeProcessFlowUrl(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
