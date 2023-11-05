package com.faas.core.base.endpoint.controller.manager.client.manager;

import com.faas.core.base.middleware.manager.client.manager.ClientManagerMiddleware;
import com.faas.core.base.model.ws.manager.inquiry.campaign.InquiryCampaignWSModel;
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


    @RequestMapping(value = BaseRoute.GET_MANAGER_CLIENTS, method = RequestMethod.POST)
    public ResponseEntity<?> getManagerClients(@RequestParam long userId) {

        InquiryCampaignWSModel response = clientManagerMiddleware.getInquiryCampaigns(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getManagerClients2(@RequestParam long userId) {

        InquiryCampaignWSModel response = clientManagerMiddleware.getInquiryCampaigns(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
