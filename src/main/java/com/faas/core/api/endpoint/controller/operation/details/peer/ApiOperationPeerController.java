package com.faas.core.api.endpoint.controller.operation.details.peer;

import com.faas.core.api.middleware.operation.details.peer.ApiOperationPeerMiddleware;
import com.faas.core.api.model.ws.operation.details.peer.ApiClientPeerWSModel;
import com.faas.core.api.model.ws.operation.details.peer.ApiOperationPeerWSModel;
import com.faas.core.utils.config.ApiRoute;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/api/operation/details/peer/")
public class ApiOperationPeerController {


    @Autowired
    ApiOperationPeerMiddleware apiOperationPeerMiddleware;

    @RequestMapping(value = ApiRoute.API_GET_OPERATION_PEER, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetOperationPeer(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String campaignId) {

        ApiOperationPeerWSModel response = apiOperationPeerMiddleware.apiGetOperationPeer(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_PEERS, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientPeers(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String campaignId) {

        ApiClientPeerWSModel response = apiOperationPeerMiddleware.apiGetClientPeers(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = ApiRoute.API_GET_CLIENT_PEER, method = RequestMethod.POST)
    public ResponseEntity<?> apiGetClientPeer(@RequestParam long agentId,
                                               @RequestParam long sessionId,
                                               @RequestParam long clientId,
                                               @RequestParam String campaignId) {

        ApiClientPeerWSModel response = apiOperationPeerMiddleware.apiGetClientPeer(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_CREATE_CLIENT_PEER, method = RequestMethod.POST)
    public ResponseEntity<?> apiCreateClientPeer(@RequestParam long agentId,
                                              @RequestParam long sessionId,
                                              @RequestParam long clientId,
                                              @RequestParam String campaignId) {

        ApiClientPeerWSModel response = apiOperationPeerMiddleware.apiCreateClientPeer(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_UPDATE_CLIENT_PEER, method = RequestMethod.POST)
    public ResponseEntity<?> apiUpdateClientPeer(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String campaignId) {

        ApiClientPeerWSModel response = apiOperationPeerMiddleware.apiUpdateClientPeer(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = ApiRoute.API_REMOVE_CLIENT_PEER, method = RequestMethod.POST)
    public ResponseEntity<?> apiRemoveClientPeer(@RequestParam long agentId,
                                                 @RequestParam long sessionId,
                                                 @RequestParam long clientId,
                                                 @RequestParam String campaignId) {

        ApiClientPeerWSModel response = apiOperationPeerMiddleware.apiRemoveClientPeer(agentId,sessionId,clientId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
