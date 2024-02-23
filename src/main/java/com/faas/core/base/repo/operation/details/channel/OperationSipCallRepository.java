package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationSipCallRepository extends MongoRepository<OperationSipCallDBModel, String> {

    boolean existsByIdAndCallState(String callId,String callState);
    boolean existsBySessionIdAndCallState(long sessionId,String callState);
    boolean existsByOperationIdAndCallState(String operationId,String callState);
    List<OperationSipCallDBModel>findBySessionId(long sessionId);
    List<OperationSipCallDBModel>findByOperationId(String operationId);
    List<OperationSipCallDBModel>findByIdAndSessionId(String callId, long sessionId);
    List<OperationSipCallDBModel>findByIdAndOperationId(String callId, String operationId);
    List<OperationSipCallDBModel>findByOperationIdAndAgentId(String operationId,long agentId);
    List<OperationSipCallDBModel>findByIdAndSessionIdAndAgentIdAndClientId(String callId, long sessionId, long agentId, long clientId);
    List<OperationSipCallDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId, String campaignId, String processId);
    List<OperationSipCallDBModel>findBySessionIdAndCampaignId(long sessionId, String campaignId);
    List<OperationSipCallDBModel>findByIdAndSessionIdAndCampaignIdAndProcessId(String callId, long sessionId, String campaignId, String processId);
    List<OperationSipCallDBModel>findBySessionIdAndCallState(long sessionId, String callState);
    List<OperationSipCallDBModel>findByOperationIdAndCallState(String operationId, String callState);
    List<OperationSipCallDBModel>findByClientId(long clientId);
    List<OperationSipCallDBModel>findBySessionIdAndClientId(long sessionId, long clientId);
}
