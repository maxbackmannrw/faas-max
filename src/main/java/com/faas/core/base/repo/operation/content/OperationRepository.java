package com.faas.core.base.repo.operation.content;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends MongoRepository<OperationDBModel, String> {

    boolean existsBySessionId(long sessionId);
    boolean existsBySessionIdAndClientId(long sessionId,long clientId);
    List<OperationDBModel>findByIdAndSessionId(String operationId,long sessionId);
    List<OperationDBModel>findByClientId(long clientId);
    List<OperationDBModel>findBySessionId(long sessionId);
    List<OperationDBModel>findBySessionIdAndCampaignId(long sessionId,String campaignId);
    List<OperationDBModel>findBySessionIdAndCampaignIdAndOperationState(long sessionId,String campaignId,String operationState);
    List<OperationDBModel>findBySessionIdAndClientId(long sessionId,long clientId);
    List<OperationDBModel>findBySessionIdAndClientIdAndAgentId(long sessionId,long clientId,long agentId);
    List<OperationDBModel>findBySessionIdAndClientIdAndAgentIdAndCampaignId(long sessionId,long clientId,long agentId,String campaignId);
    List<OperationDBModel>findBySessionIdAndClientIdAndAgentIdAndCampaignIdAndOperationState(long sessionId,long clientId,long agentId,String campaignId,String operationState);
    List<OperationDBModel>findByAgentId(long agentId);
    List<OperationDBModel>findByAgentIdAndSessionId(long agentId,long sessionId);
    List<OperationDBModel>findByAgentIdAndSessionIdAndOperationState(long agentId,long sessionId,String operationState);
    List<OperationDBModel>findByCampaignId(String campaignId);
    List<OperationDBModel>findByCampaignIdAndProcessId(String campaignId,String processId);
    List<OperationDBModel>findBySessionIdAndProcessId(long sessionId,String processId);
}
