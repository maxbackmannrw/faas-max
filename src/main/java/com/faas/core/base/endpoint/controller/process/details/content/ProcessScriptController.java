package com.faas.core.base.endpoint.controller.process.details.content;

import com.faas.core.base.middleware.process.details.content.ProcessScriptMiddleware;
import com.faas.core.base.model.ws.process.details.content.ProcessScriptWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/script/")
public class ProcessScriptController {


    @Autowired
    ProcessScriptMiddleware processScriptMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_SCRIPTS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScripts(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessScriptWSModel response = processScriptMiddleware.getProcessScripts(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessScript(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String scriptId) {

        ProcessScriptWSModel response = processScriptMiddleware.getProcessScript(userId,processId,scriptId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessScript(@RequestParam long userId,
                                                 @RequestParam String processId,
                                                 @RequestParam String scriptTitle,
                                                 @RequestParam String scriptBody,
                                                 @RequestParam int scriptOrder) {

        ProcessScriptWSModel response = processScriptMiddleware.createProcessScript(userId,processId,scriptTitle,scriptBody,scriptOrder);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_PROCESS_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> updateProcessScript(@RequestParam long userId,
                                                 @RequestParam String processId,
                                                 @RequestParam String scriptId,
                                                 @RequestParam String scriptTitle,
                                                 @RequestParam String scriptBody,
                                                 @RequestParam int scriptOrder) {

        ProcessScriptWSModel response = processScriptMiddleware.updateProcessScript(userId,processId,scriptId,scriptTitle,scriptBody,scriptOrder);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessScript(@RequestParam long userId,
                                                 @RequestParam String processId,
                                                 @RequestParam String scriptId) {

        ProcessScriptWSModel response = processScriptMiddleware.removeProcessScript(userId,processId,scriptId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
