package com.faas.core.api.endpoint.controller.operation.details.client.hook;

import com.faas.core.api.middleware.operation.details.client.hook.ApiClientHookMiddleware;
import com.faas.core.api.model.ws.operation.details.client.hook.ApiClientHookWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/client/hook/")
public class ApiClientHookController {


    @Autowired
    ApiClientHookMiddleware apiClientHookMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_CLIENT_HOOKS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientHooks(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam long clientId,
                                               @RequestParam String campaignId) {

        ApiClientHookWSModel response = apiClientHookMiddleware.apiGetClientHooks(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
