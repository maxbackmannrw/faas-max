package com.faas.core.base.endpoint.controller.campaign.details.content;

import com.faas.core.base.middleware.campaign.details.content.CampaignDetailsMiddleware;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDataWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDetailsWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignProcessWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/")
public class CampaignDetailsController {


    @Autowired
    CampaignDetailsMiddleware campaignDetailsMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignDetails(@RequestParam long userId,
                                                @RequestParam String campaignId) {

        CampaignDetailsWSModel response = campaignDetailsMiddleware.getCampaignDetails(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_PROCESS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignProcess(@RequestParam long userId,
                                                @RequestParam String campaignId) {

        CampaignProcessWSModel response = campaignDetailsMiddleware.getCampaignProcess(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignDatas(@RequestParam long userId,
                                              @RequestParam String campaignId) {

        CampaignDataWSModel response = campaignDetailsMiddleware.getCampaignDatas(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignData(@RequestParam long userId,
                                             @RequestParam String campaignId,
                                             @RequestParam String dataId) {

        CampaignDataWSModel response = campaignDetailsMiddleware.getCampaignData(userId,campaignId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignData(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam long dataTypeId,
                                                @RequestParam String value) {

        CampaignDataWSModel response = campaignDetailsMiddleware.createCampaignData(userId,campaignId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignData(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam String dataId,
                                                @RequestParam long dataTypeId,
                                                @RequestParam String value) {

        CampaignDataWSModel response = campaignDetailsMiddleware.updateCampaignData(userId,campaignId,dataId,dataTypeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignData(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam String dataId) {

        CampaignDataWSModel response = campaignDetailsMiddleware.removeCampaignData(userId,campaignId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
