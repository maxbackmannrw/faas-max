package com.faas.core.base.endpoint.controller.client.intel;

import com.faas.core.base.middleware.client.intel.ClientIntelMiddleware;
import com.faas.core.base.model.ws.client.details.*;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/intel/")
public class ClientIntelController {


    @Autowired
    ClientIntelMiddleware clientIntelMiddleware;


    @RequestMapping(value = BaseRoute.GET_CLIENT_INTELS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientIntels(@RequestParam long userId,
                                             @RequestParam long clientId) {

        ClientIntelWSModel response = clientIntelMiddleware.getClientIntels(userId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CLIENT_INTEL, method = RequestMethod.POST)
    public ResponseEntity<?> getClientIntel(@RequestParam long userId,
                                            @RequestParam long clientId,
                                            @RequestParam String addressId) {

        ClientIntelWSModel response = clientIntelMiddleware.getClientIntel(userId, clientId, addressId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CLIENT_INTEL, method = RequestMethod.POST)
    public ResponseEntity<?> createClientIntel(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String street,
                                               @RequestParam String city,
                                               @RequestParam String zipCode,
                                               @RequestParam String state,
                                               @RequestParam String country) {

        ClientIntelWSModel response = clientIntelMiddleware.createClientIntel(userId, clientId, street, city, zipCode, state, country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CLIENT_INTEL, method = RequestMethod.POST)
    public ResponseEntity<?> updateClientIntel(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String addressId,
                                               @RequestParam String street,
                                               @RequestParam String city,
                                               @RequestParam String zipCode,
                                               @RequestParam String state,
                                               @RequestParam String country) {

        ClientIntelWSModel response = clientIntelMiddleware.updateClientIntel(userId, clientId, addressId, street, city, zipCode, state, country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CLIENT_INTEL, method = RequestMethod.POST)
    public ResponseEntity<?> removeClientIntel(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String addressId) {

        ClientIntelWSModel response = clientIntelMiddleware.removeClientIntel(userId, clientId, addressId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
