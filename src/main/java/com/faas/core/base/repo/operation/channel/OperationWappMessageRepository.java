package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.OperationWappMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationWappMessageRepository extends MongoRepository<OperationWappMessageDBModel, String> {

    List<OperationWappMessageDBModel>findBySessionId(long sessionId);
    List<OperationWappMessageDBModel>findByIdAndSessionId(String messageId, long sessionId);
    List<OperationWappMessageDBModel>findBySessionIdAndClientIdAndProcessId(long sessionId, long clientId, String processId);
    List<OperationWappMessageDBModel>findByIdAndSessionIdAndClientIdAndProcessId(String messageId, long sessionId, long clientId, String processId);
    List<OperationWappMessageDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId, String campaignId, String processId);
    List<OperationWappMessageDBModel>findByIdAndSessionIdAndCampaignIdAndProcessId(String messageId, long sessionId, String campaignId, String processId);
    List<OperationWappMessageDBModel>findByClientId(long clientId);

}
