package com.faas.core.base.endpoint.controller.operation.automatic;

import com.faas.core.base.middleware.operation.automatic.AutomaticCampaignMiddleware;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/operation/manager/automatic/campaign/")
public class AutomaticCampaignController {


    @Autowired
    AutomaticCampaignMiddleware automaticCampaignMiddleware;


    @RequestMapping(value = BaseRoute.GET_AUTOMATIC_CAMPAIGN_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getAutomaticCampaignDetails(@RequestParam long userId) {

        OperationCampaignWSModel response = automaticCampaignMiddleware.getAutomaticCampaignDetails(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
