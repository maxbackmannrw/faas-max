package com.faas.core.base.framework.dashboard.flow;

import com.faas.core.data.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.client.content.dto.ClientListWSDTO;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public class DashFlowFramework {

    @Autowired
    AppUtils appUtils;


    public ClientListWSDTO fillClientsWSDTO(Page<ClientDBModel> clientDBModelPage) {

        ClientListWSDTO clientListWSDTO = new ClientListWSDTO();

        return clientListWSDTO;
    }


}
