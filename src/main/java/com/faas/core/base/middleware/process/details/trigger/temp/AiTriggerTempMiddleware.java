package com.faas.core.base.middleware.process.details.trigger.temp;

import com.faas.core.base.framework.process.details.trigger.temp.AiTriggerTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.AITriggerTempWSModel;
import com.faas.core.base.model.ws.process.details.trigger.temp.dto.AITriggerTempWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AiTriggerTempMiddleware {


    @Autowired
    AiTriggerTempFramework aiTriggerTempFramework;


    public AITriggerTempWSModel getAITriggerTemps(long userId, String processId) {

        AITriggerTempWSModel response = new AITriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<AITriggerTempWSDTO> AITriggerTempWSDTOS = aiTriggerTempFramework.getAITriggerTempsService(userId,processId);
        if (AITriggerTempWSDTOS != null){
            response.setAiTriggerTemps(AITriggerTempWSDTOS);
        }

        general.setOperation("getAITriggerTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AITriggerTempWSModel getAITriggerTemp(long userId, String tempId) {

        AITriggerTempWSModel response = new AITriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AITriggerTempWSDTO> AITriggerTempWSDTOS = new ArrayList<>();

        AITriggerTempWSDTO AITriggerTempWSDTO = aiTriggerTempFramework.getAITriggerTempService(userId,tempId);
        if (AITriggerTempWSDTO != null){
            AITriggerTempWSDTOS.add(AITriggerTempWSDTO);
        }

        response.setAiTriggerTemps(AITriggerTempWSDTOS);
        general.setOperation("getAITriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AITriggerTempWSModel createAITriggerTemp(long userId, String processId, String trigger, String accountId, long typeId) {

        AITriggerTempWSModel response = new AITriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AITriggerTempWSDTO> AITriggerTempWSDTOS = new ArrayList<>();

        AITriggerTempWSDTO AITriggerTempWSDTO = aiTriggerTempFramework.createAITriggerTempService(userId,processId,trigger,accountId,typeId);
        if (AITriggerTempWSDTO != null){
            AITriggerTempWSDTOS.add(AITriggerTempWSDTO);
        }

        response.setAiTriggerTemps(AITriggerTempWSDTOS);
        general.setOperation("createAITriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AITriggerTempWSModel updateAITriggerTemp(long userId, String tempId, String trigger, String accountId) {

        AITriggerTempWSModel response = new AITriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AITriggerTempWSDTO> AITriggerTempWSDTOS = new ArrayList<>();

        AITriggerTempWSDTO AITriggerTempWSDTO = aiTriggerTempFramework.updateAITriggerTempService(userId,tempId,trigger,accountId);
        if (AITriggerTempWSDTO != null){
            AITriggerTempWSDTOS.add(AITriggerTempWSDTO);
        }

        response.setAiTriggerTemps(AITriggerTempWSDTOS);
        general.setOperation("updateAITriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public AITriggerTempWSModel removeAITriggerTemp(long userId, String tempId) {

        AITriggerTempWSModel response = new AITriggerTempWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<AITriggerTempWSDTO> AITriggerTempWSDTOS = new ArrayList<>();

        AITriggerTempWSDTO AITriggerTempWSDTO = aiTriggerTempFramework.removeAITriggerTempService(userId,tempId);
        if (AITriggerTempWSDTO != null){
            AITriggerTempWSDTOS.add(AITriggerTempWSDTO);
        }

        response.setAiTriggerTemps(AITriggerTempWSDTOS);
        general.setOperation("removeAITriggerTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
