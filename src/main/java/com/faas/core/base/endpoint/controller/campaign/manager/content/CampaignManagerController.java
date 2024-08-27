package com.faas.core.base.endpoint.controller.campaign.manager.content;

import com.faas.core.base.middleware.campaign.manager.content.CampaignManagerMiddleware;
import com.faas.core.base.model.ws.campaign.manager.content.CampaignManagerWSModel;
import com.faas.core.base.model.ws.campaign.manager.details.CampaignManagerDetailsWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/manager/")
public class CampaignManagerController {


    @Autowired
    CampaignManagerMiddleware campaignManagerMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGERS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManagers(@RequestParam long userId) {

        CampaignManagerWSModel response = campaignManagerMiddleware.getCampaignManagers(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGERS_BY_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManagersByCategory(@RequestParam long userId,
                                                           @RequestParam String campaignCategory) {

        CampaignManagerWSModel response = campaignManagerMiddleware.getCampaignManagersByCategory(userId,campaignCategory);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGERS_BY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManagersByState(@RequestParam long userId,
                                                        @RequestParam String campaignState) {

        CampaignManagerWSModel response = campaignManagerMiddleware.getCampaignManagersByState(userId,campaignState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGER, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManager(@RequestParam long userId,
                                                @RequestParam String campaignId) {

        CampaignManagerWSModel response = campaignManagerMiddleware.getCampaignManager(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_MANAGER_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignManagerState(@RequestParam long userId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam String campaignState) {

        CampaignManagerWSModel response = campaignManagerMiddleware.updateCampaignManagerState(userId,campaignId,campaignState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_MANAGER_INQUIRY_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignManagerInquiryState(@RequestParam long userId,
                                                               @RequestParam String campaignId,
                                                               @RequestParam String inquiryState) {

        CampaignManagerWSModel response = campaignManagerMiddleware.updateCampaignManagerInquiryState(userId,campaignId,inquiryState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_MANAGER_FLOW_STATE, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignManagerFlowState(@RequestParam long userId,
                                                            @RequestParam String campaignId,
                                                            @RequestParam String flowState) {

        CampaignManagerWSModel response = campaignManagerMiddleware.updateCampaignManagerFlowState(userId,campaignId,flowState);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_MANAGER_DETAILS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignManagerDetails(@RequestParam long userId,
                                                       @RequestParam String campaignId) {

        CampaignManagerDetailsWSModel response = campaignManagerMiddleware.getCampaignManagerDetails(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}