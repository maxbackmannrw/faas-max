package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationSmsRepository extends MongoRepository<OperationSmsDBModel, String> {

    List<OperationSmsDBModel>findBySessionId(long sessionId);
    List<OperationSmsDBModel>findByOperationId(String operationId);
    List<OperationSmsDBModel>findByOperationIdAndAgentId(String operationId, long agentId);
    List<OperationSmsDBModel>findBySessionIdAndClientIdAndProcessId(long sessionId, long clientId, String processId);
    List<OperationSmsDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId, String campaignId, String processId);
    List<OperationSmsDBModel>findByIdAndSessionIdAndClientIdAndProcessId(String smsId, long sessionId, long clientId, String processId);
    List<OperationSmsDBModel>findByIdAndSessionIdAndClientIdAndCampaignIdAndProcessId(String smsId, long sessionId, long clientId, String campaignId, String processId);
    List<OperationSmsDBModel>findBySessionIdAndClientIdAndCampaignIdAndProcessId(long sessionId, long clientId, String campaignId, String processId);
    List<OperationSmsDBModel>findByIdAndSessionId(String smsId, long sessionId);
    List<OperationSmsDBModel>findByIdAndOperationId(String smsId, String operationId);
    List<OperationSmsDBModel>findByIdAndSessionIdAndCampaignIdAndProcessId(String smsId, long sessionId, String campaignId, String processId);
    List<OperationSmsDBModel>findByClientId(long clientId);
}
