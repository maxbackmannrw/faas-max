package com.faas.core.base.endpoint.controller.manager.client.content;

import com.faas.core.base.middleware.manager.client.content.ClientManagerMiddleware;
import com.faas.core.base.model.ws.manager.client.content.AllRemoteConnWSModel;
import com.faas.core.base.model.ws.manager.client.content.RemoteConnListWSModel;
import com.faas.core.base.model.ws.manager.client.content.RemoteConnWSModel;
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


    @RequestMapping(value = BaseRoute.GET_ALL_REMOTE_CONNS, method = RequestMethod.POST)
    public ResponseEntity<?> getAllRemoteConns(@RequestParam long userId,
                                               @RequestParam int reqPage,
                                               @RequestParam int reqSize) {

        AllRemoteConnWSModel response = clientManagerMiddleware.getAllRemoteConns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CLIENT_REMOTE_CONNS, method = RequestMethod.POST)
    public ResponseEntity<?> getClientRemoteConns(@RequestParam long userId,
                                                  @RequestParam long clientId) {

        RemoteConnWSModel response = clientManagerMiddleware.getClientRemoteConns(userId,clientId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_REMOTE_CONNS, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteConns(@RequestParam long userId,
                                            @RequestParam String connType,
                                            @RequestParam String connState,
                                            @RequestParam int reqPage,
                                            @RequestParam int reqSize) {

        RemoteConnListWSModel response = clientManagerMiddleware.getRemoteConns(userId,connType,connState,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_REMOTE_CONN, method = RequestMethod.POST)
    public ResponseEntity<?> getRemoteConn(@RequestParam long userId,
                                           @RequestParam long clientId,
                                           @RequestParam String connId) {

        RemoteConnWSModel response = clientManagerMiddleware.getRemoteConn(userId,clientId,connId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }






}
