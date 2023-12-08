package com.faas.core.base.endpoint.controller.manager.campaign.details.inquiry;

import com.faas.core.base.middleware.manager.campaign.details.inquiry.InquiryCampaignMiddleware;
import com.faas.core.base.model.ws.manager.campaign.content.OperationCampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/manager/campaign/details/inquiry/")
public class InquiryCampaignController {


    @Autowired
    InquiryCampaignMiddleware inquiryCampaignMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGER_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManagerDetails(@RequestParam long userId) {

        OperationCampaignWSModel response = inquiryCampaignMiddleware.getCampaignManagerDetails(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }




}
