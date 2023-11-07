package com.faas.core.base.endpoint.controller.manager.client.content;

import com.faas.core.base.middleware.manager.client.content.ClientManagerMiddleware;
import com.faas.core.base.model.ws.manager.client.content.ClientRemoteDeviceWSModel;
import com.faas.core.base.model.ws.manager.client.content.ClientRemoteListWSModel;
import com.faas.core.base.model.ws.manager.client.content.ClientRemoteWSModel;
import com.faas.core.base.model.ws.manager.client.content.ClientManagerRemoteWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/client/")
public class ClientManagerController {


    @Autowired
    ClientManagerMiddleware clientManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CLIENT_MANAGER_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> getClientManagerRemote(@RequestParam long userId,
                                                    @RequestParam int reqPage,
                                                    @RequestParam int reqSize) {

        ClientManagerRemoteWSModel response = clientManagerMiddleware.getClientManagerRemote(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTES, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemotes(@RequestParam long userId,
                                              @RequestParam boolean remote,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        ClientRemoteListWSModel response = clientManagerMiddleware.getClientRemotes(userId,remote,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemote(@RequestParam long userId,
                                             @RequestParam long clientId) {

        ClientRemoteWSModel response = clientManagerMiddleware.getClientRemote(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE_DEVICES, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemoteDevices(@RequestParam long userId,
                                                    @RequestParam long clientId) {

        ClientRemoteDeviceWSModel response = clientManagerMiddleware.getClientRemoteDevices(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE_DEVICE, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemoteDevice(@RequestParam long userId,
                                                   @RequestParam long clientId,
                                                   @RequestParam String deviceId) {

        ClientRemoteDeviceWSModel response = clientManagerMiddleware.getClientRemoteDevice(userId,clientId,deviceId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
