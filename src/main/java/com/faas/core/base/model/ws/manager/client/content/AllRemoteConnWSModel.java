package com.faas.core.base.model.ws.manager.client.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.client.content.dto.AllRemoteConnWSDTO;

public class AllRemoteConnWSModel {

    private GeneralWSModel general;
    private AllRemoteConnWSDTO allRemoteConn;

    public AllRemoteConnWSModel() {
    }

    public AllRemoteConnWSModel(GeneralWSModel general, AllRemoteConnWSDTO allRemoteConn) {
        this.general = general;
        this.allRemoteConn = allRemoteConn;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AllRemoteConnWSDTO getAllRemoteConn() {
        return allRemoteConn;
    }

    public void setAllRemoteConn(AllRemoteConnWSDTO allRemoteConn) {
        this.allRemoteConn = allRemoteConn;
    }
}
