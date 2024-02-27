package com.faas.core.api.endpoint.controller.operation.details.channel.message.email;

import com.faas.core.api.middleware.operation.details.channel.message.email.ApiOperationEmailChannelMiddleware;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/channel/message/email/")
public class ApiOperationEmailChannelController {


    @Autowired
    ApiOperationEmailChannelMiddleware apiOperationEmailChannelMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_EMAIL_CHANNEL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationEmailChannel(@RequestParam long agentId,
                                                         @RequestParam String operationId) {

        ApiOperationEmailChannelWSModel response = apiOperationEmailChannelMiddleware.apiGetOperationEmailChannel(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_EMAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationEmails(@RequestParam long agentId,
                                                   @RequestParam String operationId) {

        ApiOperationEmailWSModel response = apiOperationEmailChannelMiddleware.apiGetOperationEmails(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationEmail(@RequestParam long agentId,
                                                  @RequestParam String operationId,
                                                  @RequestParam String emailId) {

        ApiOperationEmailWSModel response = apiOperationEmailChannelMiddleware.apiGetOperationEmail(agentId,operationId,emailId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_SEND_OPERATION_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> apiSendOperationEmail(@RequestParam long agentId,
                                                   @RequestParam String operationId,
                                                   @RequestParam String tempId,
                                                   @RequestParam String emailAddressId) {

        ApiOperationEmailWSModel response = apiOperationEmailChannelMiddleware.apiSendOperationEmail(agentId,operationId,tempId,emailAddressId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_UPDATE_OPERATION_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateOperationEmail(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String emailId,
                                                     @RequestParam String emailState) {

        ApiOperationEmailWSModel response = apiOperationEmailChannelMiddleware.apiUpdateOperationEmail(agentId,operationId,emailId,emailState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_REMOVE_OPERATION_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveOperationEmail(@RequestParam long agentId,
                                                     @RequestParam String operationId,
                                                     @RequestParam String emailId) {

        ApiOperationEmailWSModel response = apiOperationEmailChannelMiddleware.apiRemoveOperationEmail(agentId,operationId,emailId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = ApiRoute.API_GET_OPERATION_EMAIL_TEMPS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationEmailTemps(@RequestParam long agentId,
                                                       @RequestParam String operationId) {

        ApiOperationEmailTempWSModel response = apiOperationEmailChannelMiddleware.apiGetOperationEmailTemps(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_EMAIL_TEMP, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationEmailTemp(@RequestParam long agentId,
                                                      @RequestParam String operationId,
                                                      @RequestParam String tempId) {

        ApiOperationEmailTempWSModel response = apiOperationEmailChannelMiddleware.apiGetOperationEmailTemp(agentId,operationId,tempId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_OPERATION_EMAIL_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationEmailAccount(@RequestParam long agentId,
                                                         @RequestParam String operationId) {

        ApiOperationEmailAccountWSModel response = apiOperationEmailChannelMiddleware.apiGetOperationEmailAccount(agentId,operationId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
