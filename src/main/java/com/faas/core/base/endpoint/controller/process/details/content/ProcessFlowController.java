package com.faas.core.base.endpoint.controller.process.details.content;

import com.faas.core.base.middleware.process.details.content.ProcessFlowMiddleware;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessFlowWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
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

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessFlow(@RequestParam long userId,
                                               @RequestParam String processId,
                                               @RequestParam String processFlow) {

        ProcessFlowWSModel response = processFlowMiddleware.updateProcessFlow(userId,processId,processFlow);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_FLOW_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessFlowDatas(@RequestParam long userId,
                                                 @RequestParam String processId) {

        ProcessDataWSModel response = processFlowMiddleware.getProcessFlowDatas(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessFlowData(@RequestParam long userId,
                                                @RequestParam String processId,
                                                @RequestParam String dataId) {

        ProcessDataWSModel response = processFlowMiddleware.getProcessFlowData(userId,processId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessFlowData(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam long typeId,
                                                   @RequestParam String value) {

        ProcessDataWSModel response = processFlowMiddleware.createProcessFlowData(userId,processId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessFlowData(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String dataId,
                                                   @RequestParam long typeId,
                                                   @RequestParam String value) {

        ProcessDataWSModel response = processFlowMiddleware.updateProcessFlowData(userId,processId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessFlowData(@RequestParam long userId,
                                                   @RequestParam String processId,
                                                   @RequestParam String dataId) {

        ProcessDataWSModel response = processFlowMiddleware.removeProcessFlowData(userId,processId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
