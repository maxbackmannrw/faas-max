package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationSmsMessageRepository extends MongoRepository<OperationSmsMessageDBModel, String> {

    List<OperationSmsMessageDBModel>findBySessionId(long sessionId);
    List<OperationSmsMessageDBModel>findByOperationId(String operationId);
    List<OperationSmsMessageDBModel>findBySessionIdAndClientIdAndProcessId(long sessionId, long clientId, String processId);
    List<OperationSmsMessageDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId, String campaignId, String processId);
    List<OperationSmsMessageDBModel>findByIdAndSessionIdAndClientIdAndProcessId(String smsId, long sessionId, long clientId, String processId);
    List<OperationSmsMessageDBModel>findByIdAndSessionIdAndClientIdAndCampaignIdAndProcessId(String smsId, long sessionId, long clientId, String campaignId, String processId);
    List<OperationSmsMessageDBModel>findBySessionIdAndClientIdAndCampaignIdAndProcessId(long sessionId, long clientId, String campaignId, String processId);
    List<OperationSmsMessageDBModel>findByIdAndSessionId(String smsId, long sessionId);
    List<OperationSmsMessageDBModel>findByIdAndOperationId(String smsId, String operationId);
    List<OperationSmsMessageDBModel>findByIdAndSessionIdAndCampaignIdAndProcessId(String smsId, long sessionId, String campaignId, String processId);
    List<OperationSmsMessageDBModel>findByClientId(long clientId);
}
