package com.faas.core.base.endpoint.controller.process.details.channel.content;

import com.faas.core.base.middleware.process.details.channel.content.ProcessChannelMiddleware;
import com.faas.core.base.model.ws.process.details.channel.content.ProcessChannelWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.ProcessSipChannelWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.ProcessWappChannelWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.ProcessEmailChannelWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.ProcessPushChannelWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.ProcessSmsChannelWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/process/details/channel/")
public class ProcessChannelController {


    @Autowired
    ProcessChannelMiddleware processChannelMiddleware;


    @RequestMapping(value = BaseRoute.GET_PROCESS_CHANNELS, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessChannels(@RequestParam long userId,
                                                @RequestParam String processId) {

        ProcessChannelWSModel response = processChannelMiddleware.getProcessChannels(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_PROCESS_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSipChannel(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessSipChannelWSModel response = processChannelMiddleware.getProcessSipChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessSipChannel(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String callerId,
                                                     @RequestParam String channelState) {

        ProcessSipChannelWSModel response = processChannelMiddleware.createProcessSipChannel(userId,processId,callerId,channelState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SIP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessSipChannel(@RequestParam long userId,
                                                     @RequestParam String processId) {

        ProcessSipChannelWSModel response = processChannelMiddleware.removeProcessSipChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_SMS_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessSmsChannel(@RequestParam long userId,
                                                  @RequestParam String processId) {

        ProcessSmsChannelWSModel response = processChannelMiddleware.getProcessSmsChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_SMS_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessSmsChannel(@RequestParam long userId,
                                                     @RequestParam String processId,
                                                     @RequestParam String accountId,
                                                     @RequestParam String channelState) {

        ProcessSmsChannelWSModel response = processChannelMiddleware.createProcessSmsChannel(userId,processId,accountId,channelState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_SMS_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessSmsChannel(@RequestParam long userId,
                                                     @RequestParam String processId) {

        ProcessSmsChannelWSModel response = processChannelMiddleware.removeProcessSmsChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_WAPP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessWappChannel(@RequestParam long userId,
                                                   @RequestParam String processId) {

        ProcessWappChannelWSModel response = processChannelMiddleware.getProcessWappChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_WAPP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessWappChannel(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String callState,
                                                      @RequestParam String messageState) {

        ProcessWappChannelWSModel response = processChannelMiddleware.createProcessWappChannel(userId,processId,callState,messageState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_WAPP_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessWappChannel(@RequestParam long userId,
                                                      @RequestParam String processId) {

        ProcessWappChannelWSModel response = processChannelMiddleware.removeProcessWappChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_PROCESS_EMAIL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessEmailChannel(@RequestParam long userId,
                                                    @RequestParam String processId) {

        ProcessEmailChannelWSModel response = processChannelMiddleware.getProcessEmailChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_EMAIL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessEmailChannel(@RequestParam long userId,
                                                       @RequestParam String processId,
                                                       @RequestParam String accountId,
                                                       @RequestParam String channelState) {

        ProcessEmailChannelWSModel response = processChannelMiddleware.createProcessEmailChannel(userId,processId,accountId,channelState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_EMAIL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessEmailChannel(@RequestParam long userId,
                                                       @RequestParam String processId) {

        ProcessEmailChannelWSModel response = processChannelMiddleware.removeProcessEmailChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




    @RequestMapping(value = BaseRoute.GET_PROCESS_PUSH_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> getProcessPushChannel(@RequestParam long userId,
                                                   @RequestParam String processId) {

        ProcessPushChannelWSModel response = processChannelMiddleware.getProcessPushChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_PROCESS_PUSH_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> createProcessPushChannel(@RequestParam long userId,
                                                      @RequestParam String processId,
                                                      @RequestParam String accountId,
                                                      @RequestParam String channelState) {

        ProcessPushChannelWSModel response = processChannelMiddleware.createProcessPushChannel(userId,processId,accountId,channelState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_PROCESS_PUSH_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeProcessPushChannel(@RequestParam long userId,
                                                      @RequestParam String processId) {

        ProcessPushChannelWSModel response = processChannelMiddleware.removeProcessPushChannel(userId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
