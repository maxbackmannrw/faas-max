package com.faas.core.base.middleware.client.settings;

import com.faas.core.base.framework.client.settings.ClientSettingsFramework;
import com.faas.core.base.model.db.client.settings.ClientTypeDBModel;
import com.faas.core.base.model.ws.client.settings.ClientTypeWSModel;
import com.faas.core.base.model.ws.client.settings.dto.ClientTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.client.settings.ClientTypeRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientSettingsMiddleware {


    @Autowired
    ClientSettingsFramework clientSettingsFramework;

    @Autowired
    ClientTypeRepository clientTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ClientTypeWSModel getAllClientTypes(long userId) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        List<ClientTypeDBModel> clientTypeDBModels = clientTypeRepository.findByStatus(1);
        for (ClientTypeDBModel clientTypeDBModel : clientTypeDBModels) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("getAllClientTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientTypeWSModel getClientType(long userId, long typeId) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(typeId);
        if (clientTypeDBModel.isPresent()) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel.get()));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("getClientType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientTypeWSModel createClientType(long userId, String clientType) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        ClientTypeDBModel clientTypeDBModel = clientSettingsFramework.createClientTypeService(clientType);
        if (clientTypeDBModel != null) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("createClientType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientTypeWSModel updateClientType(long userId, long typeId, String clientType) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        ClientTypeDBModel clientTypeDBModel = clientSettingsFramework.updateClientTypeService(typeId, clientType);
        if (clientTypeDBModel != null) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("updateClientType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientTypeWSModel removeClientType(long userId, long typeId) {

        ClientTypeWSModel response = new ClientTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientTypeWSDTO> clientTypeWSDTOS = new ArrayList<>();

        ClientTypeDBModel clientTypeDBModel = clientSettingsFramework.removeClientTypeService(typeId);
        if (clientTypeDBModel != null) {
            clientTypeWSDTOS.add(clientSettingsFramework.fillClientTypeWSDTO(clientTypeDBModel));
        }

        response.setClientTypes(clientTypeWSDTOS);
        general.setOperation("removeClientType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
