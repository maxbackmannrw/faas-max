package com.faas.core.api.endpoint.controller.user;

import com.faas.core.api.middleware.user.ApiUserMiddleware;
import com.faas.core.api.model.ws.user.content.ApiAgentWSModel;
import com.faas.core.api.model.ws.user.details.ApiAgentDetailsWSModel;
import com.faas.core.api.model.ws.user.details.ApiAgentInfoWSModel;
import com.faas.core.api.model.ws.user.details.ApiAgentSipAccountWSModel;
import com.faas.core.misc.config.ApiRoute;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/user/")
public class ApiUserController {


    @Autowired
    ApiUserMiddleware apiUserMiddleware;


    @RequestMapping(value = ApiRoute.API_AGENT_LOGIN, method = RequestMethod.POST)
    public ResponseEntity<?> apiAgentLogin(@RequestParam String userEmail,
                                           @RequestParam String password) {

        ApiAgentWSModel response = apiUserMiddleware.apiAgentLogin(userEmail, password);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentDetails(@RequestParam long agentId) {

        ApiAgentDetailsWSModel response = apiUserMiddleware.apiGetAgentDetails(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentSipAccount(@RequestParam long agentId,
                                                   @RequestParam String processId) {

        ApiAgentSipAccountWSModel response = apiUserMiddleware.apiGetAgentSipAccount(agentId, processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_AGENT_INFO, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentInfo(@RequestParam long agentId) {

        ApiAgentInfoWSModel response = apiUserMiddleware.apiGetAgentInfo(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}