package com.faas.core.base.model.ws.client.inquiry;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.client.inquiry.dto.ClientInquiryWSDTO;

import java.util.List;

public class ClientInquiryWSModel {

    private GeneralWSModel general;
    private List<ClientInquiryWSDTO> clientInquiries;

    public ClientInquiryWSModel() {
    }

    public ClientInquiryWSModel(GeneralWSModel general, List<ClientInquiryWSDTO> clientInquiries) {
        this.general = general;
        this.clientInquiries = clientInquiries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientInquiryWSDTO> getClientInquiries() {
        return clientInquiries;
    }

    public void setClientInquiries(List<ClientInquiryWSDTO> clientInquiries) {
        this.clientInquiries = clientInquiries;
    }
}
