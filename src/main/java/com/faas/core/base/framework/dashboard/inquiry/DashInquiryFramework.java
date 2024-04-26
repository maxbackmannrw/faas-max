package com.faas.core.base.framework.dashboard.inquiry;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.client.content.dto.ClientListWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public class DashInquiryFramework {

    @Autowired
    AppUtils appUtils;


    public ClientListWSDTO fillClientsWSDTO(Page<ClientDBModel> clientDBModelPage) {

        ClientListWSDTO clientListWSDTO = new ClientListWSDTO();

        return clientListWSDTO;
    }




}
