package com.faas.core.base.endpoint.controller.process.details.remote;

import com.faas.core.base.middleware.process.details.remote.ProcessRemoteMiddleware;
import com.faas.core.base.model.ws.process.details.remote.ProcessRemoteWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/remote/")
public class ProcessRemoteController {


    @Autowired
    ProcessRemoteMiddleware processRemoteMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessRemotes(@RequestParam long userId,
                                               @RequestParam String processId) {

        ProcessRemoteWSModel response = processRemoteMiddleware.getProcessRemotes(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_REMOTES_BY_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessRemotesByCategory(@RequestParam long userId,
                                                         @RequestParam String processId,
                                                         @RequestParam String remoteCategory) {

        ProcessRemoteWSModel response = processRemoteMiddleware.getProcessRemotesByCategory(userId,processId,remoteCategory);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_PROCESS_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessRemote(@RequestParam long userId,
                                              @RequestParam String processId,
                                              @RequestParam String processRemoteId) {

        ProcessRemoteWSModel response = processRemoteMiddleware.getProcessRemote(userId,processId,processRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_PROCESS_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessRemote(@RequestParam long userId,
                                                 @RequestParam String processId,
                                                 @RequestParam String remoteId,
                                                 @RequestParam String remoteCategory) {

        ProcessRemoteWSModel response = processRemoteMiddleware.createProcessRemote(userId,processId,remoteId,remoteCategory);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessRemote(@RequestParam long userId,
                                                 @RequestParam String processId,
                                                 @RequestParam String processRemoteId) {

        ProcessRemoteWSModel response = processRemoteMiddleware.removeProcessRemote(userId,processId,processRemoteId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
