package com.faas.core.base.endoint.controller.campaign.details.content;

import com.faas.core.base.middleware.campaign.details.content.CampaignDetailsMiddleware;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDataWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDetailsWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignScriptWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.BaseRoute;
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

        CampaignDetailsWSModel response = campaignDetailsMiddleware.getCampaignDetails(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignDatas(@RequestParam long userId,
                                              @RequestParam String campaignId) {

        CampaignDataWSModel response = campaignDetailsMiddleware.getCampaignDatas(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignData(@RequestParam long userId,
                                             @RequestParam String campaignId,
                                             @RequestParam String dataId) {

        CampaignDataWSModel response = campaignDetailsMiddleware.getCampaignData(userId, campaignId, dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignData(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam long typeId,
                                                @RequestParam String value) {

        CampaignDataWSModel response = campaignDetailsMiddleware.createCampaignData(userId, campaignId, typeId, value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignData(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam String dataId,
                                                @RequestParam long typeId,
                                                @RequestParam String value) {

        CampaignDataWSModel response = campaignDetailsMiddleware.updateCampaignData(userId, campaignId, dataId, typeId, value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignData(@RequestParam long userId,
                                                @RequestParam String campaignId,
                                                @RequestParam String dataId) {

        CampaignDataWSModel response = campaignDetailsMiddleware.removeCampaignData(userId, campaignId, dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SCRIPTS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignScripts(@RequestParam long userId,
                                                @RequestParam String campaignId) {

        CampaignScriptWSModel response = campaignDetailsMiddleware.getCampaignScripts(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignScript(@RequestParam long userId,
                                               @RequestParam String campaignId,
                                               @RequestParam String scriptId) {

        CampaignScriptWSModel response = campaignDetailsMiddleware.getCampaignScript(userId, campaignId, scriptId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignScript(@RequestParam long userId,
                                                  @RequestParam String campaignId,
                                                  @RequestParam String scriptTitle,
                                                  @RequestParam String scriptBody,
                                                  @RequestParam int scriptOrder) {

        CampaignScriptWSModel response = campaignDetailsMiddleware.createCampaignScript(userId, campaignId, scriptTitle, scriptBody, scriptOrder);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignScript(@RequestParam long userId,
                                                  @RequestParam String campaignId,
                                                  @RequestParam String scriptId,
                                                  @RequestParam String scriptTitle,
                                                  @RequestParam String scriptBody,
                                                  @RequestParam int scriptOrder) {

        CampaignScriptWSModel response = campaignDetailsMiddleware.updateCampaignScript(userId, campaignId, scriptId, scriptTitle, scriptBody, scriptOrder);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SCRIPT, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignScript(@RequestParam long userId,
                                                  @RequestParam String campaignId,
                                                  @RequestParam String scriptId) {

        CampaignScriptWSModel response = campaignDetailsMiddleware.removeCampaignScript(userId, campaignId, scriptId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
