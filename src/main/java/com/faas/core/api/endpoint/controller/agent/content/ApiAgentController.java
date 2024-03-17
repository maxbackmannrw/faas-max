package com.faas.core.api.endpoint.controller.agent.content;

import com.faas.core.utils.config.ApiRoute;
import com.faas.core.api.middleware.agent.content.ApiAgentMiddleware;
import com.faas.core.api.model.ws.agent.content.ApiAgentWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/agent/")
public class ApiAgentController {


    @Autowired
    ApiAgentMiddleware apiAgentMiddleware;


    @RequestMapping(value = ApiRoute.API_AGENT_LOGIN, method = RequestMethod.POST)
    public ResponseEntity<?> apiAgentLogin(@RequestParam String userEmail,
                                           @RequestParam String password) {

        ApiAgentWSModel response = apiAgentMiddleware.apiAgentLogin(userEmail, password);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
