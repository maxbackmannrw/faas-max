package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationWappMessageRepository extends MongoRepository<OperationWappMessageDBModel, String> {

    List<OperationWappMessageDBModel>findBySessionId(long sessionId);
    List<OperationWappMessageDBModel>findByOperationId(String operationId);
    List<OperationWappMessageDBModel>findByOperationIdAndAgentId(String operationId,long agentId);
    List<OperationWappMessageDBModel>findByIdAndSessionId(String messageId, long sessionId);
    List<OperationWappMessageDBModel>findByIdAndOperationId(String messageId, String operationId);
    List<OperationWappMessageDBModel>findBySessionIdAndClientIdAndProcessId(long sessionId, long clientId, String processId);
    List<OperationWappMessageDBModel>findByIdAndSessionIdAndClientIdAndProcessId(String messageId, long sessionId, long clientId, String processId);
    List<OperationWappMessageDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId, String campaignId, String processId);
    List<OperationWappMessageDBModel>findByIdAndSessionIdAndCampaignIdAndProcessId(String messageId, long sessionId, String campaignId, String processId);
    List<OperationWappMessageDBModel>findByClientId(long clientId);

}
