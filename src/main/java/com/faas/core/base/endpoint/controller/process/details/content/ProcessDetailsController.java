package com.faas.core.base.endpoint.controller.process.details.content;

import com.faas.core.base.middleware.process.details.content.ProcessDetailsMiddleware;
import com.faas.core.base.model.ws.process.details.content.ProcessDataWSModel;
import com.faas.core.base.model.ws.process.details.content.ProcessDetailsWSModel;
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
                                               @RequestParam long typeId,
                                               @RequestParam String value) {

        ProcessDataWSModel response = processDetailsMiddleware.createProcessData(userId,processId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessData(@RequestParam long userId,
                                               @RequestParam String processId,
                                               @RequestParam String dataId,
                                               @RequestParam long typeId,
                                               @RequestParam String value) {

        ProcessDataWSModel response = processDetailsMiddleware.updateProcessData(userId,processId,dataId,typeId,value);

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


}
