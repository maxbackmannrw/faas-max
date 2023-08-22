package com.faas.core.api.model.ws.operation.channel.messenger;

import com.faas.core.api.model.ws.operation.channel.messenger.dto.ApiMessengerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiMessengerWSModel {

    private GeneralWSModel general;
    private List<ApiMessengerWSDTO> messengers;

    public ApiMessengerWSModel() {
    }

    public ApiMessengerWSModel(GeneralWSModel general, List<ApiMessengerWSDTO> messengers) {
        this.general = general;
        this.messengers = messengers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiMessengerWSDTO> getMessengers() {
        return messengers;
    }

    public void setMessengers(List<ApiMessengerWSDTO> messengers) {
        this.messengers = messengers;
    }
}
