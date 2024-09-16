package com.faas.core.base.controller.campaign.details.scenario;

import com.faas.core.base.middleware.campaign.details.scenario.CampaignScenarioMiddleware;
import com.faas.core.data.ws.base.campaign.details.scenario.CampaignScenarioDataWSModel;
import com.faas.core.data.ws.base.campaign.details.scenario.CampaignScenarioWSModel;
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
@RequestMapping(value = AppConstant.API_VERSION + "/base/campaign/details/scenario/")
public class CampaignScenarioController {


    @Autowired
    CampaignScenarioMiddleware campaignScenarioMiddleware;


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SCENARIOS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignScenarios(@RequestParam long userId,
                                                  @RequestParam String campaignId) {

        CampaignScenarioWSModel response = campaignScenarioMiddleware.getCampaignScenarios(userId, campaignId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignScenario(@RequestParam long userId,
                                                 @RequestParam String campaignId,
                                                 @RequestParam String scenarioId) {

        CampaignScenarioWSModel response = campaignScenarioMiddleware.getCampaignScenario(userId, campaignId, scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignScenario(@RequestParam long userId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String scenarioId) {

        CampaignScenarioWSModel response = campaignScenarioMiddleware.createCampaignScenario(userId, campaignId, scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SCENARIO, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignScenario(@RequestParam long userId,
                                                    @RequestParam String campaignId,
                                                    @RequestParam String scenarioId) {

        CampaignScenarioWSModel response = campaignScenarioMiddleware.removeCampaignScenario(userId, campaignId, scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SCENARIO_DATAS, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignScenarioDatas(@RequestParam long userId,
                                                      @RequestParam String campaignId,
                                                      @RequestParam String scenarioId) {

        CampaignScenarioDataWSModel response = campaignScenarioMiddleware.getCampaignScenarioDatas(userId, campaignId, scenarioId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.GET_CAMPAIGN_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> getCampaignScenarioData(@RequestParam long userId,
                                                     @RequestParam String campaignId,
                                                     @RequestParam String scenarioId,
                                                     @RequestParam String dataId) {

        CampaignScenarioDataWSModel response = campaignScenarioMiddleware.getCampaignScenarioData(userId, campaignId, scenarioId, dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.CREATE_CAMPAIGN_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> createCampaignScenarioData(@RequestParam long userId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam String scenarioId,
                                                        @RequestParam long typeId,
                                                        @RequestParam String value) {

        CampaignScenarioDataWSModel response = campaignScenarioMiddleware.createCampaignScenarioData(userId, campaignId, scenarioId, typeId, value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.UPDATE_CAMPAIGN_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> updateCampaignScenarioData(@RequestParam long userId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam String scenarioId,
                                                        @RequestParam String dataId,
                                                        @RequestParam long typeId,
                                                        @RequestParam String value) {

        CampaignScenarioDataWSModel response = campaignScenarioMiddleware.updateCampaignScenarioData(userId, campaignId, scenarioId, dataId, typeId, value);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = BaseRoute.REMOVE_CAMPAIGN_SCENARIO_DATA, method = RequestMethod.POST)
    public ResponseEntity<?> removeCampaignScenarioData(@RequestParam long userId,
                                                        @RequestParam String campaignId,
                                                        @RequestParam String scenarioId,
                                                        @RequestParam String dataId) {

        CampaignScenarioDataWSModel response = campaignScenarioMiddleware.removeCampaignScenarioData(userId, campaignId, scenarioId, dataId);

        if (response.getGeneral().getStatus().equalsIgnoreCase(AppConstant.GENERAL_SUCCESS_STATUS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
