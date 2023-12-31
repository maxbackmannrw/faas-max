package com.faas.core.base.framework.remote.app;

import com.faas.core.base.model.ws.remote.app.dto.RemoteAppSummaryWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remote.app.RemoteAppRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteAppDetailsFramework {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteAppWSDTO getRemoteAppDetailsService(long userId) {

        return null;
    }


    public RemoteAppSummaryWSDTO getRemoteAppSummaryService(long userId) {

        RemoteAppSummaryWSDTO remoteAppSummaryWSDTO = new RemoteAppSummaryWSDTO();
        remoteAppSummaryWSDTO.setTotalRemote(remoteAppRepository.count());

        return remoteAppSummaryWSDTO;
    }


}
