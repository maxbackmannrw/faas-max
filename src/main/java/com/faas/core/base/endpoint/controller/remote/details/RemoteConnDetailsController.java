package com.faas.core.base.endpoint.controller.remote.details;

import com.faas.core.base.middleware.remote.details.RemoteConnDetailsMiddleware;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/remote/conn/details/")
public class RemoteConnDetailsController {


    @Autowired
    RemoteConnDetailsMiddleware remoteConnDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_INQUIRY_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryCampaigns(@RequestParam long userId) {

        InquiryCampaignWSModel response = remoteConnDetailsMiddleware.getInquiryCampaigns(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
