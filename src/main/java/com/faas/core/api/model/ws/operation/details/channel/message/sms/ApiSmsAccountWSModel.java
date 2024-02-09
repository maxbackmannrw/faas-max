package com.faas.core.api.model.ws.operation.details.channel.message.sms;

import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiSmsAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ApiSmsAccountWSModel {

    private GeneralWSModel general;
    private List<ApiSmsAccountWSDTO> smsAccounts;

    public ApiSmsAccountWSModel() {
    }

    public ApiSmsAccountWSModel(GeneralWSModel general, List<ApiSmsAccountWSDTO> smsAccounts) {
        this.general = general;
        this.smsAccounts = smsAccounts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiSmsAccountWSDTO> getSmsAccounts() {
        return smsAccounts;
    }

    public void setSmsAccounts(List<ApiSmsAccountWSDTO> smsAccounts) {
        this.smsAccounts = smsAccounts;
    }
}
