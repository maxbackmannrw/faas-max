package com.faas.core.api.model.ws.operation.details.client.hook;

import com.faas.core.api.model.ws.operation.details.client.hook.dto.ApiClientHookWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiClientHookWSModel {

    private GeneralWSModel general;
    private List<ApiClientHookWSDTO> clientHooks;

    public ApiClientHookWSModel() {
    }

    public ApiClientHookWSModel(GeneralWSModel general, List<ApiClientHookWSDTO> clientHooks) {
        this.general = general;
        this.clientHooks = clientHooks;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiClientHookWSDTO> getClientHooks() {
        return clientHooks;
    }

    public void setClientHooks(List<ApiClientHookWSDTO> clientHooks) {
        this.clientHooks = clientHooks;
    }
}
