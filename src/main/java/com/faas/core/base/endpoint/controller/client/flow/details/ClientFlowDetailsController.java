package com.faas.core.base.endpoint.controller.client.flow.details;

import com.faas.core.base.middleware.client.flow.details.ClientFlowDetailsMiddleware;
import com.faas.core.base.model.ws.client.flow.FlowCampaignWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/client/flow/details/")
public class ClientFlowDetailsController {


    @Autowired
    ClientFlowDetailsMiddleware clientFlowDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_FLOW_CAMPAIGNS, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowCampaigns(@RequestParam long userId,
                                              @RequestParam int reqPage,
                                              @RequestParam int reqSize) {

        FlowCampaignWSModel response = clientFlowDetailsMiddleware.getFlowCampaigns(userId,reqPage,reqSize);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
