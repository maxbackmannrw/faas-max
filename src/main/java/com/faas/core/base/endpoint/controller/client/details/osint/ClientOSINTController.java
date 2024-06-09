package com.faas.core.base.endpoint.controller.client.details.osint;

import com.faas.core.base.middleware.client.details.osint.ClientOSINTMiddleware;
import com.faas.core.base.model.ws.client.details.osint.ClientOSINTWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/details/osint/")
public class ClientOSINTController {


    @Autowired
    ClientOSINTMiddleware clientOSIntMiddleware;


    @RequestMapping(value = BaseRoute.GET_CLIENT_OS_INTS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientOSINTS(@RequestParam long userId,
                                             @RequestParam long clientId) {

        ClientOSINTWSModel response = clientOSIntMiddleware.getClientOSINTS(userId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
