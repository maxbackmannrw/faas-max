package com.faas.core.base.endpoint.controller.campaign.details.content;

import com.faas.core.base.middleware.campaign.details.content.CampaignFlowMiddleware;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDataWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignFlowWSModel;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/flow/")
public class CampaignFlowController {


    @Autowired
    CampaignFlowMiddleware campaignFlowMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignFlow(@RequestParam long userId,
                                             @RequestParam String campaignId) {

        CampaignFlowWSModel response = campaignFlowMiddleware.getCampaignFlow(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_FLOW, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignFlow(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam String campaignFlow) {

        CampaignFlowWSModel response = campaignFlowMiddleware.updateCampaignFlow(userId,campaignId,campaignFlow);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_FLOW_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignFlowDatas(@RequestParam long userId,
                                                  @RequestParam String campaignId) {

        CampaignDataWSModel response = campaignFlowMiddleware.getCampaignFlowDatas(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignFlowData(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam String dataId) {

        CampaignDataWSModel response = campaignFlowMiddleware.getCampaignFlowData(userId,campaignId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignFlowData(@RequestParam long userId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam long typeId,
                                                    @RequestParam String value) {

        CampaignDataWSModel response = campaignFlowMiddleware.createCampaignFlowData(userId,campaignId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignFlowData(@RequestParam long userId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String dataId,
                                                    @RequestParam long typeId,
                                                    @RequestParam String value) {

        CampaignDataWSModel response = campaignFlowMiddleware.updateCampaignFlowData(userId,campaignId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_FLOW_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignFlowData(@RequestParam long userId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String dataId) {

        CampaignDataWSModel response = campaignFlowMiddleware.removeCampaignFlowData(userId,campaignId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
