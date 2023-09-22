package com.faas.core.api.model.ws.client.session;

import com.faas.core.api.model.ws.client.session.dto.ApiSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiSessionWSModel {

    private GeneralWSModel general;
    private ApiSessionWSDTO session;

    public ApiSessionWSModel() {
    }

    public ApiSessionWSModel(GeneralWSModel general, ApiSessionWSDTO session) {
        this.general = general;
        this.session = session;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiSessionWSDTO getSession() {
        return session;
    }

    public void setSession(ApiSessionWSDTO session) {
        this.session = session;
    }
}
