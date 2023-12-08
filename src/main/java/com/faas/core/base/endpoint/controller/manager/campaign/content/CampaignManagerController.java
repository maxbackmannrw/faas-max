package com.faas.core.base.endpoint.controller.manager.campaign.content;

import com.faas.core.base.middleware.manager.campaign.content.CampaignManagerMiddleware;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/campaign/")
public class CampaignManagerController {


    @Autowired
    CampaignManagerMiddleware campaignManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManager(@RequestParam long userId) {

        OperationListWSModel response = campaignManagerMiddleware.getCampaignManager(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
