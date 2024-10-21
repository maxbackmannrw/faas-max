package com.faas.core.base.endpoint.controller.client.content;

import com.faas.core.base.middleware.client.content.ClientMiddleware;
import com.faas.core.base.model.ws.client.content.AllClientWSModel;
import com.faas.core.base.model.ws.client.content.ClientListWSModel;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
import com.faas.core.base.model.ws.client.content.CreateClientRequest;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/")
public class ClientController {


    @Autowired
    ClientMiddleware clientMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllClients(@RequestParam long userId,
                                           @RequestParam int reqPage,
                                           @RequestParam int reqSize) {

        AllClientWSModel response = clientMiddleware.getAllClients(userId, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getClients(@RequestParam long userId,
                                        @RequestParam String clientState,
                                        @RequestParam int reqPage,
                                        @RequestParam int reqSize) {

        ClientListWSModel response = clientMiddleware.getClients(userId, clientState, reqPage, reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> getClient(@RequestParam long userId,
                                       @RequestParam long clientId) {

        ClientWSModel response = clientMiddleware.getClient(userId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> createClient(@RequestParam long userId,
                                          @RequestParam String clientName,
                                          @RequestParam String nationalId,
                                          @RequestParam String phoneNumber,
                                          @RequestParam String emailAddress,
                                          @RequestParam String clientCity,
                                          @RequestParam String clientCountry,
                                          @RequestParam long clientTypeId) {

        ClientWSModel response = clientMiddleware.createClient(userId, clientName, nationalId, phoneNumber, emailAddress, clientCity, clientCountry, clientTypeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_VOLUME_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> createVolumeClient(@RequestBody CreateClientRequest createClientRequest) {

        ClientWSModel response = clientMiddleware.createVolumeClient(createClientRequest);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> updateClient(@RequestParam long userId,
                                          @RequestParam long clientId,
                                          @RequestParam String clientName,
                                          @RequestParam String nationalId,
                                          @RequestParam String phoneNumber,
                                          @RequestParam String emailAddress,
                                          @RequestParam String clientCity,
                                          @RequestParam String clientCountry,
                                          @RequestParam long clientTypeId) {

        ClientWSModel response = clientMiddleware.updateClient(userId, clientId, clientName, nationalId, phoneNumber, emailAddress, clientCity, clientCountry, clientTypeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CLIENT, method = RequestMethod.POST)
    public ResponseEntity<?> removeClient(@RequestParam long userId,
                                          @RequestParam long clientId) {

        ClientWSModel response = clientMiddleware.removeClient(userId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
