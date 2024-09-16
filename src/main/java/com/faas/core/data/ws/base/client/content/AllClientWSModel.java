package com.faas.core.data.ws.base.client.content;

import com.faas.core.data.ws.base.client.content.dto.AllClientWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;


public class AllClientWSModel {

    private GeneralWSModel general;
    private AllClientWSDTO allClient;

    public AllClientWSModel() {
    }

    public AllClientWSModel(GeneralWSModel general, AllClientWSDTO allClient) {
        this.general = general;
        this.allClient = allClient;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AllClientWSDTO getAllClient() {
        return allClient;
    }

    public void setAllClient(AllClientWSDTO allClient) {
        this.allClient = allClient;
    }
}
