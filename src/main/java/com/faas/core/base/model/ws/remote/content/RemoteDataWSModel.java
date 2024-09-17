package com.faas.core.base.model.ws.remote.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteDataWSDTO;

import java.util.List;

public class RemoteDataWSModel {

    private GeneralWSModel general;
    private List<RemoteDataWSDTO> remoteDatas;

    public RemoteDataWSModel() {
    }

    public RemoteDataWSModel(GeneralWSModel general, List<RemoteDataWSDTO> remoteDatas) {
        this.general = general;
        this.remoteDatas = remoteDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<RemoteDataWSDTO> getRemoteDatas() {
        return remoteDatas;
    }

    public void setRemoteDatas(List<RemoteDataWSDTO> remoteDatas) {
        this.remoteDatas = remoteDatas;
    }
}
