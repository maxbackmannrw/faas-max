package com.faas.core.base.endpoint.controller.campaign.details.content;

import com.faas.core.base.middleware.campaign.details.content.CampaignInquiryMiddleware;
import com.faas.core.base.model.ws.campaign.details.content.CampaignDataWSModel;
import com.faas.core.base.model.ws.campaign.details.content.CampaignInquiryWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/inquiry/")
public class CampaignInquiryController {


    @Autowired
    CampaignInquiryMiddleware campaignInquiryMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquiry(@RequestParam long userId,
                                                @RequestParam String campaignId) {

        CampaignInquiryWSModel response = campaignInquiryMiddleware.getCampaignInquiry(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_INQUIRY, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignInquiry(@RequestParam long userId,
                                                   @RequestParam String campaignId,
                                                   @RequestParam String campaignInquiry) {

        CampaignInquiryWSModel response = campaignInquiryMiddleware.updateCampaignInquiry(userId,campaignId,campaignInquiry);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRY_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquiryDatas(@RequestParam long userId,
                                                     @RequestParam String campaignId) {

        CampaignDataWSModel response = campaignInquiryMiddleware.getCampaignInquiryDatas(userId,campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignInquiryData(@RequestParam long userId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String dataId) {

        CampaignDataWSModel response = campaignInquiryMiddleware.getCampaignInquiryData(userId,campaignId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignInquiryData(@RequestParam long userId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam long typeId,
                                                       @RequestParam String value) {

        CampaignDataWSModel response = campaignInquiryMiddleware.createCampaignInquiryData(userId,campaignId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignInquiryData(@RequestParam long userId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam String dataId,
                                                       @RequestParam long typeId,
                                                       @RequestParam String value) {

        CampaignDataWSModel response = campaignInquiryMiddleware.updateCampaignInquiryData(userId,campaignId,dataId,typeId,value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_INQUIRY_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignInquiryData(@RequestParam long userId,
                                                       @RequestParam String campaignId,
                                                       @RequestParam String dataId) {

        CampaignDataWSModel response = campaignInquiryMiddleware.removeCampaignInquiryData(userId,campaignId,dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
