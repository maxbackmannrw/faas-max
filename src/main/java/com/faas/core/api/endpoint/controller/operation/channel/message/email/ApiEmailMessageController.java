package com.faas.core.api.endpoint.controller.operation.channel.message.email;

import com.faas.core.api.middleware.operation.channel.message.email.ApiEmailMessageMiddleware;
import com.faas.core.api.model.ws.operation.channel.message.email.ApiEmailTempWSModel;
import com.faas.core.api.model.ws.operation.channel.message.email.ApiEmailWSModel;
import com.faas.core.api.model.ws.operation.channel.message.email.ApiOperationEmailWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/channel/message/email/")
public class ApiEmailMessageController {


    @Autowired
    ApiEmailMessageMiddleware apiEmailMessageMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationEmail(@RequestParam long agentId,
                                                  @RequestParam long sessionId) {

        ApiOperationEmailWSModel response = apiEmailMessageMiddleware.apiGetOperationEmail(agentId,sessionId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_EMAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetEmails(@RequestParam long agentId,
                                          @RequestParam long sessionId,
                                          @RequestParam String campaignId,
                                          @RequestParam String processId) {

        ApiEmailWSModel response = apiEmailMessageMiddleware.apiGetEmails(agentId,sessionId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetEmail(@RequestParam long agentId,
                                         @RequestParam long sessionId,
                                         @RequestParam String campaignId,
                                         @RequestParam String processId,
                                         @RequestParam String emailId) {

        ApiEmailWSModel response = apiEmailMessageMiddleware.apiGetEmail(agentId,sessionId,campaignId,processId,emailId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_SEND_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendEmail(@RequestParam long agentId,
                                          @RequestParam long sessionId,
                                          @RequestParam String campaignId,
                                          @RequestParam String processId,
                                          @RequestParam String tempId,
                                          @RequestParam long emailAddressId) {

        ApiEmailWSModel response = apiEmailMessageMiddleware.apiSendEmail(agentId,sessionId,campaignId,processId,tempId,emailAddressId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateEmail(@RequestParam long agentId,
                                            @RequestParam long sessionId,
                                            @RequestParam String campaignId,
                                            @RequestParam String processId,
                                            @RequestParam String emailId) {

        ApiEmailWSModel response = apiEmailMessageMiddleware.apiUpdateEmail(agentId,sessionId,campaignId,processId,emailId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveEmail(@RequestParam long agentId,
                                            @RequestParam long sessionId,
                                            @RequestParam String campaignId,
                                            @RequestParam String processId,
                                            @RequestParam String emailId) {

        ApiEmailWSModel response = apiEmailMessageMiddleware.apiRemoveEmail(agentId,sessionId,campaignId,processId,emailId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_EMAIL_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetEmailTemps(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam String campaignId,
                                              @RequestParam String processId) {

        ApiEmailTempWSModel response = apiEmailMessageMiddleware.apiGetEmailTemps(agentId,sessionId,campaignId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetEmailTemp(@RequestParam long agentId,
                                             @RequestParam long sessionId,
                                             @RequestParam String campaignId,
                                             @RequestParam String processId,
                                             @RequestParam String tempId) {

        ApiEmailTempWSModel response = apiEmailMessageMiddleware.apiGetEmailTemp(agentId,sessionId,campaignId,processId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
