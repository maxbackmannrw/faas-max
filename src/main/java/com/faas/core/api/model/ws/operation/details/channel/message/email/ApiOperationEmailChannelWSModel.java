package com.faas.core.api.model.ws.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationEmailChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationEmailChannelWSDTO emailChannel;

    public ApiOperationEmailChannelWSModel() {
    }

    public ApiOperationEmailChannelWSModel(GeneralWSModel general, ApiOperationEmailChannelWSDTO emailChannel) {
        this.general = general;
        this.emailChannel = emailChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationEmailChannelWSDTO getEmailChannel() {
        return emailChannel;
    }

    public void setEmailChannel(ApiOperationEmailChannelWSDTO emailChannel) {
        this.emailChannel = emailChannel;
    }
}
