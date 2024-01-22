package com.faas.core.api.middleware.client.details;

import com.faas.core.api.framework.client.details.ApiClientDetailsFramework;
import com.faas.core.api.model.ws.client.details.ApiClientDetailsWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientNoteWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientOSINTWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientRemoteAppWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiClientDetailsMiddleware {


    @Autowired
    ApiClientDetailsFramework apiClientDetailsFramework;


    public ApiClientDetailsWSModel apiGetClientDetails(long agentId, long clientId) {

        ApiClientDetailsWSModel response = new ApiClientDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientNoteWSModel apiGetClientNotes(long agentId, long clientId) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientNoteWSModel apiGetClientNote(long agentId, long clientId) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientNoteWSModel apiCreateClientNote(long agentId, long clientId) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiCreateClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientNoteWSModel apiUpdateClientNote(long agentId, long clientId) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiUpdateClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientNoteWSModel apiRemoveClientNote(long agentId, long clientId) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiRemoveClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientRemoteAppWSModel apiGetClientRemoteApps(long agentId, long clientId) {

        ApiClientRemoteAppWSModel response = new ApiClientRemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientRemoteAppWSModel apiGetClientRemoteApp(long agentId, long clientId) {

        ApiClientRemoteAppWSModel response = new ApiClientRemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientOSINTWSModel apiGetClientOSINTs(long agentId, long clientId) {

        ApiClientOSINTWSModel response = new ApiClientOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientOSINTs");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientOSINTWSModel apiGetClientOSINT(long agentId, long clientId) {

        ApiClientOSINTWSModel response = new ApiClientOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientOSINT");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
