package com.faas.core.api.middleware.operation.client.details;

import com.faas.core.api.framework.operation.client.details.ApiOperationClientDetailsFramework;
import com.faas.core.api.model.ws.operation.client.details.ApiOperationClientDetailsWSModel;
import com.faas.core.api.model.ws.operation.client.details.ApiOperationClientNoteWSModel;
import com.faas.core.api.model.ws.operation.client.details.ApiOperationClientOSINTWSModel;
import com.faas.core.api.model.ws.operation.client.details.ApiOperationClientRemoteWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationClientDetailsMiddleware {


    @Autowired
    ApiOperationClientDetailsFramework apiOperationClientDetailsFramework;


    public ApiOperationClientDetailsWSModel apiGetClientDetails(long agentId, long clientId) {

        ApiOperationClientDetailsWSModel response = new ApiOperationClientDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationClientNoteWSModel apiGetClientNotes(long agentId, long clientId) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientNoteWSModel apiGetClientNote(long agentId, long clientId) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientNoteWSModel apiCreateClientNote(long agentId, long clientId) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiCreateClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientNoteWSModel apiUpdateClientNote(long agentId, long clientId) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiUpdateClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientNoteWSModel apiRemoveClientNote(long agentId, long clientId) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiRemoveClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationClientRemoteWSModel apiGetClientRemotes(long agentId, long clientId) {

        ApiOperationClientRemoteWSModel response = new ApiOperationClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientRemoteWSModel apiGetClientRemote(long agentId, long clientId, String clientRemoteId) {

        ApiOperationClientRemoteWSModel response = new ApiOperationClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationClientOSINTWSModel apiGetClientOSINTs(long agentId, long clientId) {

        ApiOperationClientOSINTWSModel response = new ApiOperationClientOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientOSINTs");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientOSINTWSModel apiGetClientOSINT(long agentId, long clientId) {

        ApiOperationClientOSINTWSModel response = new ApiOperationClientOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientOSINT");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
