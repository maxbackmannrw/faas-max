package com.faas.core.base.middleware.campaign.details.scenario;

import com.faas.core.base.framework.campaign.details.scenario.CampaignScenarioFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.scenario.CampaignScenarioDataWSModel;
import com.faas.core.base.model.ws.campaign.details.scenario.CampaignScenarioWSModel;
import com.faas.core.base.model.ws.campaign.details.scenario.dto.ProcessScenarioDataWSDTO;
import com.faas.core.base.model.ws.campaign.details.scenario.dto.CampaignScenarioWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignScenarioMiddleware {


    @Autowired
    CampaignScenarioFramework campaignScenarioFramework;


    public CampaignScenarioWSModel getCampaignScenarios(long userId, String campaignId) {

        CampaignScenarioWSModel response = new CampaignScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignScenarioWSDTO> campaignScenarioWSDTOS = campaignScenarioFramework.getCampaignScenariosService(userId, campaignId);
        if (campaignScenarioWSDTOS != null){
            response.setCampaignScenarios(campaignScenarioWSDTOS);
        }

        general.setOperation("getCampaignScenarios");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScenarioWSModel getCampaignScenario(long userId, String campaignId, String scenarioId) {

        CampaignScenarioWSModel response = new CampaignScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignScenarioWSDTO> campaignScenarioWSDTOS = new ArrayList<>();

        CampaignScenarioWSDTO campaignScenarioWSDTO = campaignScenarioFramework.getCampaignScenarioService(userId, campaignId, scenarioId);
        if (campaignScenarioWSDTO != null){
            campaignScenarioWSDTOS.add(campaignScenarioWSDTO);
        }

        response.setCampaignScenarios(campaignScenarioWSDTOS);
        general.setOperation("getCampaignScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScenarioWSModel createCampaignScenario(long userId, String campaignId, String scenarioId) {

        CampaignScenarioWSModel response = new CampaignScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignScenarioWSDTO> campaignScenarioWSDTOS = new ArrayList<>();

        CampaignScenarioWSDTO campaignScenarioWSDTO = campaignScenarioFramework.createCampaignScenarioService(userId, campaignId, scenarioId);
        if (campaignScenarioWSDTO != null){
            campaignScenarioWSDTOS.add(campaignScenarioWSDTO);
        }

        response.setCampaignScenarios(campaignScenarioWSDTOS);
        general.setOperation("createCampaignScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScenarioWSModel removeCampaignScenario(long userId, String campaignId, String scenarioId) {

        CampaignScenarioWSModel response = new CampaignScenarioWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<CampaignScenarioWSDTO> campaignScenarioWSDTOS = new ArrayList<>();

        CampaignScenarioWSDTO campaignScenarioWSDTO = campaignScenarioFramework.removeCampaignScenarioService(userId,campaignId,scenarioId);
        if (campaignScenarioWSDTO != null){
            campaignScenarioWSDTOS.add(campaignScenarioWSDTO);
        }

        response.setCampaignScenarios(campaignScenarioWSDTOS);
        general.setOperation("removeCampaignScenario");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignScenarioDataWSModel getCampaignScenarioDatas(long userId, String campaignId, String scenarioId) {

        CampaignScenarioDataWSModel response = new CampaignScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = campaignScenarioFramework.getCampaignScenarioDatasService(userId,campaignId,scenarioId);
        if (scenarioDataWSDTOS != null){
            response.setScenarioDatas(scenarioDataWSDTOS);
        }

        general.setOperation("getCampaignScenarioDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScenarioDataWSModel getCampaignScenarioData(long userId, String campaignId, String scenarioId, String dataId) {

        CampaignScenarioDataWSModel response = new CampaignScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ProcessScenarioDataWSDTO scenarioDataWSDTO = campaignScenarioFramework.getCampaignScenarioDataService(userId,campaignId,scenarioId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("getCampaignScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScenarioDataWSModel createCampaignScenarioData(long userId, String campaignId, String scenarioId, long typeId, String value) {

        CampaignScenarioDataWSModel response = new CampaignScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ProcessScenarioDataWSDTO scenarioDataWSDTO = campaignScenarioFramework.createCampaignScenarioDataService(userId, campaignId,scenarioId,typeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("createCampaignScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScenarioDataWSModel updateCampaignScenarioData(long userId, String campaignId, String scenarioId, String dataId, long typeId, String value) {

        CampaignScenarioDataWSModel response = new CampaignScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ProcessScenarioDataWSDTO scenarioDataWSDTO = campaignScenarioFramework.updateCampaignScenarioDataService(userId, campaignId,scenarioId,dataId,typeId,value);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("updateCampaignScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignScenarioDataWSModel removeCampaignScenarioData(long userId, String campaignId, String scenarioId, String dataId) {

        CampaignScenarioDataWSModel response = new CampaignScenarioDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ProcessScenarioDataWSDTO> scenarioDataWSDTOS = new ArrayList<>();

        ProcessScenarioDataWSDTO scenarioDataWSDTO = campaignScenarioFramework.removeCampaignScenarioDataService(userId, campaignId,scenarioId,dataId);
        if (scenarioDataWSDTO != null){
            scenarioDataWSDTOS.add(scenarioDataWSDTO);
        }

        response.setScenarioDatas(scenarioDataWSDTOS);
        general.setOperation("removeCampaignScenarioData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
