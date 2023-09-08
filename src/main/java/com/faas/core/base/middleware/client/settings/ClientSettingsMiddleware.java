package com.faas.core.base.middleware.client.settings;

import com.faas.core.base.framework.client.settings.ClientSettingsFramework;
import com.faas.core.base.model.db.client.settings.ClientTypeDBModel;
import com.faas.core.base.model.ws.client.settings.FlowTypeWSModel;
import com.faas.core.base.model.ws.client.settings.InquiryTypeWSModel;
import com.faas.core.base.model.ws.client.settings.dto.FlowTypeWSDTO;
import com.faas.core.base.model.ws.client.settings.dto.InquiryTypeWSDTO;
import com.faas.core.base.model.ws.client.settings.ClientTypeWSModel;
import com.faas.core.base.model.ws.client.settings.dto.ClientTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.client.settings.ClientTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
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




    public InquiryTypeWSModel getAllInquiryTypes(long userId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = clientSettingsFramework.getAllInquiryTypesService(userId);
        if (inquiryTypeWSDTOS != null){
            response.setInquiryTypes(inquiryTypeWSDTOS);
        }

        general.setOperation("getAllInquiryTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel getInquiryType(long userId,long typeId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = new ArrayList<>();

        InquiryTypeWSDTO inquiryTypeWSDTO = clientSettingsFramework.getInquiryTypeService(typeId);
        if (inquiryTypeWSDTO != null){
            inquiryTypeWSDTOS.add(inquiryTypeWSDTO);
        }

        response.setInquiryTypes(inquiryTypeWSDTOS);
        general.setOperation("getInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel createInquiryType(long userId,String inquiryType) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = new ArrayList<>();

        InquiryTypeWSDTO inquiryTypeWSDTO = clientSettingsFramework.createInquiryTypeService(inquiryType);
        if (inquiryTypeWSDTO != null){
            inquiryTypeWSDTOS.add(inquiryTypeWSDTO);
        }

        response.setInquiryTypes(inquiryTypeWSDTOS);
        general.setOperation("createInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel updateInquiryType(long userId,long typeId,String inquiryType) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = new ArrayList<>();

        InquiryTypeWSDTO inquiryTypeWSDTO = clientSettingsFramework.updateInquiryTypeService(typeId,inquiryType);
        if (inquiryTypeWSDTO != null){
            inquiryTypeWSDTOS.add(inquiryTypeWSDTO);
        }

        response.setInquiryTypes(inquiryTypeWSDTOS);
        general.setOperation("updateInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryTypeWSModel removeInquiryType(long userId,long typeId) {

        InquiryTypeWSModel response = new InquiryTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryTypeWSDTO> inquiryTypeWSDTOS = new ArrayList<>();

        InquiryTypeWSDTO inquiryTypeWSDTO = clientSettingsFramework.removeInquiryTypeService(typeId);
        if (inquiryTypeWSDTO != null){
            inquiryTypeWSDTOS.add(inquiryTypeWSDTO);
        }

        response.setInquiryTypes(inquiryTypeWSDTOS);
        general.setOperation("removeInquiryType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public FlowTypeWSModel getAllFlowTypes(long userId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<FlowTypeWSDTO> flowTypeWSDTOS = clientSettingsFramework.getAllFlowTypesService(userId);
        if (flowTypeWSDTOS != null){
            response.setFlowTypes(flowTypeWSDTOS);
        }

        general.setOperation("getAllFlowTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel getFlowType(long userId,long typeId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowTypeWSDTO> flowTypeWSDTOS = new ArrayList<>();

        FlowTypeWSDTO flowTypeWSDTO = clientSettingsFramework.getFlowTypeService(typeId);
        if (flowTypeWSDTO != null){
            flowTypeWSDTOS.add(flowTypeWSDTO);
        }

        response.setFlowTypes(flowTypeWSDTOS);
        general.setOperation("getFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel createFlowType(long userId,String flowType) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowTypeWSDTO> flowTypeWSDTOS = new ArrayList<>();

        FlowTypeWSDTO flowTypeWSDTO = clientSettingsFramework.createFlowTypeService(flowType);
        if (flowTypeWSDTO != null){
            flowTypeWSDTOS.add(flowTypeWSDTO);
        }

        response.setFlowTypes(flowTypeWSDTOS);
        general.setOperation("createFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel updateFlowType(long userId,long typeId,String flowType) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowTypeWSDTO> flowTypeWSDTOS = new ArrayList<>();

        FlowTypeWSDTO flowTypeWSDTO = clientSettingsFramework.updateFlowTypeService(typeId,flowType);
        if (flowTypeWSDTO != null){
            flowTypeWSDTOS.add(flowTypeWSDTO);
        }

        response.setFlowTypes(flowTypeWSDTOS);
        general.setOperation("updateFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public FlowTypeWSModel removeFlowType(long userId,long typeId) {

        FlowTypeWSModel response = new FlowTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<FlowTypeWSDTO> flowTypeWSDTOS = new ArrayList<>();

        FlowTypeWSDTO flowTypeWSDTO = clientSettingsFramework.removeFlowTypeService(typeId);
        if (flowTypeWSDTO != null){
            flowTypeWSDTOS.add(flowTypeWSDTO);
        }

        response.setFlowTypes(flowTypeWSDTOS);
        general.setOperation("removeFlowType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
