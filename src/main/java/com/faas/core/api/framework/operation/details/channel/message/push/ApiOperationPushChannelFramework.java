package com.faas.core.api.framework.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushWSDTO;
import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationPushMessageDBModel;
import com.faas.core.base.model.db.process.details.channel.content.ProcessPushChannelDBModel;
import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.OperationPushMessageRepository;
import com.faas.core.base.repo.process.details.channel.content.ProcessPushChannelRepository;
import com.faas.core.base.repo.process.details.channel.temp.ProcessPushTempRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ChannelHelper;
import com.faas.core.utils.helpers.OperationHelper;
import com.faas.core.utils.service.channel.push.PushChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationPushChannelFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ChannelHelper channelHelper;

    @Autowired
    PushChannelService pushChannelService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ProcessPushTempRepository processPushTempRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    OperationPushMessageRepository operationPushMessageRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationPushChannelWSDTO apiGetOperationPushChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()){
                return operationHelper.getApiOperationPushChannelWSDTO(operationDBModels.get(0),clientDetailsDBModels.get(0));
            }
        }
        return null;
    }

    public List<ApiOperationPushWSDTO> apiGetOperationPushesService(long agentId,String operationId) {

        List<ApiOperationPushWSDTO> operationPushWSDTOS = new ArrayList<>();
        List<OperationPushMessageDBModel> operationPushMessageDBModels = operationPushMessageRepository.findByOperationIdAndAgentId(operationId,agentId);
        for (OperationPushMessageDBModel operationPushMessageDBModel : operationPushMessageDBModels) {
            operationPushWSDTOS.add(new ApiOperationPushWSDTO(operationPushMessageDBModel));
        }
        return operationPushWSDTOS;
    }

    public ApiOperationPushWSDTO apiGetOperationPushService(long agentId,String operationId,String pushId) {

        List<OperationPushMessageDBModel> operationPushMessageDBModels = operationPushMessageRepository.findByIdAndOperationId(pushId,operationId);
        if (!operationPushMessageDBModels.isEmpty()){

            return new ApiOperationPushWSDTO(operationPushMessageDBModels.get(0));
        }
        return null;
    }

    public ApiOperationPushWSDTO apiSendOperationPushService(long agentId,String operationId,String tempId,String remoteAppId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){

            List<ProcessPushTempDBModel> pushTempDBModels = processPushTempRepository.findByIdAndProcessId(tempId,sessionDBModels.get(0).getProcessId());
            List<ProcessPushChannelDBModel> pushChannelDBModels = processPushChannelRepository.findByProcessId(sessionDBModels.get(0).getProcessId());
            if (!pushTempDBModels.isEmpty() && !pushChannelDBModels.isEmpty() ){

                OperationPushMessageDBModel operationPushMessageDBModel = channelHelper.createOperationPushMessageDBModel(sessionDBModels.get(0));
                return new ApiOperationPushWSDTO(operationPushMessageDBModel);
            }
        }
        return null;
    }

    public ApiOperationPushWSDTO apiUpdateOperationPushService(long agentId,String operationId,String pushId,String pushState) {

        List<OperationPushMessageDBModel> operationPushMessageDBModels = operationPushMessageRepository.findByIdAndOperationId(pushId,operationId);
        if (!operationPushMessageDBModels.isEmpty()){

            operationPushMessageDBModels.get(0).setPushState(pushState);
            operationPushMessageDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            return new ApiOperationPushWSDTO(operationPushMessageRepository.save(operationPushMessageDBModels.get(0)));
        }
        return null;
    }

    public ApiOperationPushWSDTO apiRemoveOperationPushService(long agentId,String operationId,String pushId) {

        List<OperationPushMessageDBModel> operationPushMessageDBModels = operationPushMessageRepository.findByIdAndOperationId(pushId,operationId);
        if (!operationPushMessageDBModels.isEmpty()){

            operationPushMessageRepository.delete(operationPushMessageDBModels.get(0));
            return new ApiOperationPushWSDTO(operationPushMessageDBModels.get(0));
        }
        return null;
    }


    public ApiOperationPushTempWSDTO apiGetOperationPushTempsService(long agentId,String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){

            ApiOperationPushTempWSDTO pushTempWSDTO = new ApiOperationPushTempWSDTO();
            pushTempWSDTO.setPushAccount(channelHelper.getApiPushAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            pushTempWSDTO.setOperationPushTemps(processPushTempRepository.findByProcessId(sessionDBModels.get(0).getProcessId()));
            return pushTempWSDTO;
        }
        return null;
    }

    public ApiOperationPushTempWSDTO apiGetOperationPushTempService(long agentId,String operationId,String tempId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){

            ApiOperationPushTempWSDTO pushTempWSDTO = new ApiOperationPushTempWSDTO();
            pushTempWSDTO.setPushAccount(channelHelper.getApiPushAccountWSDTO(sessionDBModels.get(0).getProcessId()));
            pushTempWSDTO.setOperationPushTemps(processPushTempRepository.findByIdAndProcessId(tempId,sessionDBModels.get(0).getProcessId()));
            return pushTempWSDTO;
        }
        return null;
    }

    public ApiOperationPushAccountWSDTO apiGetOperationPushAccountService(long agentId, String operationId) {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByAgentIdAndOperationId(agentId,operationId);
        if (!sessionDBModels.isEmpty()){
            return channelHelper.getApiPushAccountWSDTO(sessionDBModels.get(0).getProcessId());
        }
        return null;
    }


}
