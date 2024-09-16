package com.faas.core.api.controller.user.content;

import com.faas.core.api.middleware.user.content.ApiUserMiddleware;
import com.faas.core.data.ws.api.agent.content.ApiAgentWSModel;
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


}