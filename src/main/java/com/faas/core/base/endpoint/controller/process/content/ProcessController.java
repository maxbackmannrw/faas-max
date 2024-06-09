package com.faas.core.base.endpoint.controller.process.content;

import com.faas.core.base.middleware.process.content.ProcessMiddleware;
import com.faas.core.base.model.ws.process.content.ProcessWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/")
public class ProcessController {


    @Autowired
    ProcessMiddleware processMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_PROCESSES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllProcesses(@RequestParam long userId) {

        ProcessWSModel response = processMiddleware.getAllProcesses(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESSES_BY_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessesByCategory(@RequestParam long userId,
                                                    @RequestParam String processCategory) {

        ProcessWSModel response = processMiddleware.getProcessesByCategory(userId,processCategory);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    
    @RequestMapping(value = BaseRoute.GET_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcess(@RequestParam long userId,
                                        @RequestParam String processId) {

        ProcessWSModel response = processMiddleware.getProcess(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> createProcess(@RequestParam long userId,
                                           @RequestParam String process,
                                           @RequestParam String processDesc,
                                           @RequestParam long processTypeId,
                                           @RequestParam String processCategory,
                                           @RequestParam String processState) {

        ProcessWSModel response = processMiddleware.createProcess(userId,process,processDesc,processTypeId,processCategory,processState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcess(@RequestParam long userId,
                                           @RequestParam String processId,
                                           @RequestParam String process,
                                           @RequestParam String processDesc,
                                           @RequestParam String processState) {

        ProcessWSModel response = processMiddleware.updateProcess(userId,processId,process,processDesc,processState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcess(@RequestParam long userId,
                                           @RequestParam String processId) {

        ProcessWSModel response = processMiddleware.removeProcess(userId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
