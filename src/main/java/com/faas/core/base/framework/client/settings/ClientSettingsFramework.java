package com.faas.core.base.framework.client.settings;

import com.faas.core.base.model.db.client.settings.ClientTypeDBModel;
import com.faas.core.base.model.ws.client.settings.dto.ClientTypeWSDTO;
import com.faas.core.base.repo.client.settings.ClientTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClientSettingsFramework {


    @Autowired
    ClientTypeRepository clientTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ClientTypeWSDTO fillClientTypeWSDTO(ClientTypeDBModel clientTypeDBModel) {

        ClientTypeWSDTO clientTypeWSDTO = new ClientTypeWSDTO();
        clientTypeWSDTO.setClientType(clientTypeDBModel);
        return clientTypeWSDTO;
    }


    public ClientTypeDBModel createClientTypeService(String clientType) {

        ClientTypeDBModel clientTypeDBModel = new ClientTypeDBModel();
        clientTypeDBModel.setClientType(clientType);
        clientTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientTypeDBModel.setStatus(1);

        return clientTypeRepository.save(clientTypeDBModel);
    }

    public ClientTypeDBModel updateClientTypeService(long typeId, String clientType) {

        Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(typeId);
        if (clientTypeDBModel.isPresent()) {
            clientTypeDBModel.get().setClientType(clientType);
            clientTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientTypeDBModel.get().setStatus(1);

            return clientTypeRepository.save(clientTypeDBModel.get());
        }
        return null;
    }


    public ClientTypeDBModel removeClientTypeService(long clientTypeId) {

        Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(clientTypeId);
        if (clientTypeDBModel.isPresent()) {
            clientTypeRepository.delete(clientTypeDBModel.get());
            return clientTypeDBModel.get();
        }
        return null;
    }


}
