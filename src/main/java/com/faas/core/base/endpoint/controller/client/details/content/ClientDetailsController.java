package com.faas.core.base.endpoint.controller.client.details.content;

import com.faas.core.base.middleware.client.details.content.ClientDetailsMiddleware;
import com.faas.core.base.model.ws.client.details.content.*;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/details/")
public class ClientDetailsController {


    @Autowired
    ClientDetailsMiddleware clientDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_CLIENT_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientDetails(@RequestParam long userId,
                                              @RequestParam long clientId) {

        ClientDetailsWSModel response = clientDetailsMiddleware.getClientDetails(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientDatas(@RequestParam long userId,
                                            @RequestParam long clientId) {

        ClientDataWSModel response = clientDetailsMiddleware.getClientDatas(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getClientData(@RequestParam long userId,
                                           @RequestParam long clientId,
                                           @RequestParam String dataId) {

        ClientDataWSModel response = clientDetailsMiddleware.getClientData(userId,clientId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CLIENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createClientData(@RequestParam long userId,
                                              @RequestParam long clientId,
                                              @RequestParam long typeId,
                                              @RequestParam String value) {

        ClientDataWSModel response = clientDetailsMiddleware.createClientData(userId,clientId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CLIENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateClientData(@RequestParam long userId,
                                              @RequestParam long clientId,
                                              @RequestParam String dataId,
                                              @RequestParam long typeId,
                                              @RequestParam String value) {

        ClientDataWSModel response = clientDetailsMiddleware.updateClientData(userId,clientId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CLIENT_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeClientData(@RequestParam long userId,
                                              @RequestParam long clientId,
                                              @RequestParam String dataId) {

        ClientDataWSModel response = clientDetailsMiddleware.removeClientData(userId,clientId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_CLIENT_ADDRESSES, method = RequestMethod.POST)
    public ResponseEntity<?> getClientAddresses(@RequestParam long userId,
                                                @RequestParam long clientId) {

        ClientAddressWSModel response = clientDetailsMiddleware.getClientAddresses(userId, clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_ADDRESS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientAddress(@RequestParam long userId,
                                              @RequestParam long clientId,
                                              @RequestParam String addressId) {

        ClientAddressWSModel response = clientDetailsMiddleware.getClientAddress(userId,clientId,addressId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CLIENT_ADDRESS, method = RequestMethod.POST)
    public ResponseEntity<?> createClientAddress(@RequestParam long userId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String street,
                                                 @RequestParam String city,
                                                 @RequestParam String zipCode,
                                                 @RequestParam String state,
                                                 @RequestParam String country) {

        ClientAddressWSModel response = clientDetailsMiddleware.createClientAddress(userId,clientId,street,city,zipCode,state,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CLIENT_ADDRESS, method = RequestMethod.POST)
    public ResponseEntity<?> updateClientAddress(@RequestParam long userId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String addressId,
                                                 @RequestParam String street,
                                                 @RequestParam String city,
                                                 @RequestParam String zipCode,
                                                 @RequestParam String state,
                                                 @RequestParam String country) {

        ClientAddressWSModel response = clientDetailsMiddleware.updateClientAddress(userId,clientId,addressId,street,city,zipCode,state,country);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CLIENT_ADDRESS, method = RequestMethod.POST)
    public ResponseEntity<?> removeClientAddress(@RequestParam long userId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String addressId) {

        ClientAddressWSModel response = clientDetailsMiddleware.removeClientAddress(userId,clientId,addressId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




    @RequestMapping(value = BaseRoute.GET_CLIENT_EMAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientEmails(@RequestParam long userId,
                                             @RequestParam long clientId) {

        ClientEmailWSModel response = clientDetailsMiddleware.getClientEmails(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> getClientEmail(@RequestParam long userId,
                                            @RequestParam long clientId,
                                            @RequestParam String emailId) {

        ClientEmailWSModel response = clientDetailsMiddleware.getClientEmail(userId,clientId,emailId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CLIENT_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> createClientEmail(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String emailAddress) {

        ClientEmailWSModel response = clientDetailsMiddleware.createClientEmail(userId,clientId,emailAddress);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CLIENT_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> updateClientEmail(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String emailId,
                                               @RequestParam String emailAddress) {

        ClientEmailWSModel response = clientDetailsMiddleware.updateClientEmail(userId,clientId,emailId,emailAddress);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CLIENT_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<?> removeClientEmail(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String emailId) {

        ClientEmailWSModel response = clientDetailsMiddleware.removeClientEmail(userId,clientId,emailId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_CLIENT_PHONES, method = RequestMethod.POST)
    public ResponseEntity<?> getClientPhones(@RequestParam long userId,
                                             @RequestParam long clientId) {

        ClientPhoneWSModel response = clientDetailsMiddleware.getClientPhones(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_PHONE, method = RequestMethod.POST)
    public ResponseEntity<?> getClientPhone(@RequestParam long userId,
                                            @RequestParam long clientId,
                                            @RequestParam String numberId) {

        ClientPhoneWSModel response = clientDetailsMiddleware.getClientPhone(userId,clientId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CLIENT_PHONE, method = RequestMethod.POST)
    public ResponseEntity<?> createClientPhone(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String phoneNumber,
                                               @RequestParam String phoneCarrier) {

        ClientPhoneWSModel response = clientDetailsMiddleware.createClientPhone(userId,clientId,phoneNumber,phoneCarrier);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CLIENT_PHONE, method = RequestMethod.POST)
    public ResponseEntity<?> updateClientPhone(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String numberId,
                                               @RequestParam String phoneNumber,
                                               @RequestParam String phoneCarrier) {

        ClientPhoneWSModel response = clientDetailsMiddleware.updateClientPhone(userId,clientId,numberId,phoneNumber,phoneCarrier);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CLIENT_PHONE, method = RequestMethod.POST)
    public ResponseEntity<?> removeClientPhone(@RequestParam long userId,
                                               @RequestParam long clientId,
                                               @RequestParam String numberId) {

        ClientPhoneWSModel response = clientDetailsMiddleware.removeClientPhone(userId,clientId,numberId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
