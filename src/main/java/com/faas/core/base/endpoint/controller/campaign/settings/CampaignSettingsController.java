package com.faas.core.base.endpoint.controller.campaign.settings;

import com.faas.core.base.middleware.campaign.settings.CampaignSettingsMiddleware;
import com.faas.core.base.model.ws.campaign.settings.CampaignTypeWSModel;
import com.faas.core.base.model.ws.campaign.settings.FlowTypeWSModel;
import com.faas.core.base.model.ws.campaign.settings.InquiryTypeWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/settings/")
public class CampaignSettingsController {


    @Autowired
    CampaignSettingsMiddleware campaignSettingsMiddleware;


    @RequestMapping(value = BaseRoute.GET_ALL_CAMPAIGN_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllCampaignTypes(@RequestParam long userId) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.getAllCampaignTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignType(@RequestParam long userId,
                                             @RequestParam long typeId) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.getCampaignType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignType(@RequestParam long userId,
                                                @RequestParam String campaignType) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.createCampaignType(userId, campaignType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignType(@RequestParam long userId,
                                                @RequestParam long typeId,
                                                @RequestParam String campaignType) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.updateCampaignType(userId, typeId, campaignType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignType(@RequestParam long userId,
                                                @RequestParam long typeId) {

        CampaignTypeWSModel response = campaignSettingsMiddleware.removeCampaignType(userId, typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_INQUIRY_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllInquiryTypes(@RequestParam long userId) {

        InquiryTypeWSModel response = campaignSettingsMiddleware.getAllInquiryTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getInquiryType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        InquiryTypeWSModel response = campaignSettingsMiddleware.getInquiryType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createInquiryType(@RequestParam long userId,
                                               @RequestParam String inquiryType) {

        InquiryTypeWSModel response = campaignSettingsMiddleware.createInquiryType(userId,inquiryType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateInquiryType(@RequestParam long userId,
                                               @RequestParam long typeId,
                                               @RequestParam String inquiryType) {

        InquiryTypeWSModel response = campaignSettingsMiddleware.updateInquiryType(userId,typeId,inquiryType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_INQUIRY_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeInquiryType(@RequestParam long userId,
                                               @RequestParam long typeId) {

        InquiryTypeWSModel response = campaignSettingsMiddleware.removeInquiryType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



    @RequestMapping(value = BaseRoute.GET_ALL_FLOW_TYPES, method = RequestMethod.POST)
    public ResponseEntity<?> getAllFlowTypes(@RequestParam long userId) {

        FlowTypeWSModel response = campaignSettingsMiddleware.getAllFlowTypes(userId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> getFlowType(@RequestParam long userId,
                                         @RequestParam long typeId) {

        FlowTypeWSModel response = campaignSettingsMiddleware.getFlowType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.CREATE_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> createFlowType(@RequestParam long userId,
                                            @RequestParam String flowType) {

        FlowTypeWSModel response = campaignSettingsMiddleware.createFlowType(userId,flowType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.UPDATE_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> updateFlowType(@RequestParam long userId,
                                            @RequestParam long typeId,
                                            @RequestParam String flowType) {

        FlowTypeWSModel response = campaignSettingsMiddleware.updateFlowType(userId,typeId,flowType);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.REMOVE_FLOW_TYPE, method = RequestMethod.POST)
    public ResponseEntity<?> removeFlowType(@RequestParam long userId,
                                            @RequestParam long typeId) {

        FlowTypeWSModel response = campaignSettingsMiddleware.removeFlowType(userId,typeId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}

