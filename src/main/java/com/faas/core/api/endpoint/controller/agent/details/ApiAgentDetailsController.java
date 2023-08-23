package com.faas.core.api.endpoint.controller.agent.details;

import com.faas.core.api.model.ws.agent.details.ApiAgentDetailsWSModel;
import com.faas.core.api.model.ws.agent.details.ApiAgentInfoWSModel;
import com.faas.core.api.model.ws.agent.details.ApiAgentSipAccountWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.api.middleware.agent.details.ApiAgentDetailsMiddleware;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/agent/details/")
public class ApiAgentDetailsController {


    @Autowired
    ApiAgentDetailsMiddleware apiAgentDetailsMiddleware;


    @RequestMapping(value = ApiRoute.API_GET_AGENT_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentDetails(@RequestParam long agentId) {

        ApiAgentDetailsWSModel response = apiAgentDetailsMiddleware.apiGetAgentDetails(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_AGENT_SIP_ACCOUNT, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentSipAccount(@RequestParam long agentId,
                                                   @RequestParam String processId) {

        ApiAgentSipAccountWSModel response = apiAgentDetailsMiddleware.apiGetAgentSipAccount(agentId,processId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_GET_AGENT_INFO, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetAgentInfo(@RequestParam long agentId) {

        ApiAgentInfoWSModel response = apiAgentDetailsMiddleware.apiGetAgentInfo(agentId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
