package com.faas.core.base.repo.operation.content;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends MongoRepository<OperationDBModel, String> {

    boolean existsBySessionId(long sessionId);
    boolean existsByClientIdAndOperationState(long clientId,String operationState);
    boolean existsBySessionIdAndOperationState(long sessionId,String operationState);
    boolean existsBySessionIdAndClientId(long sessionId,long clientId);
    boolean existsByClientIdAndAgentId(long clientId,long agentId);
    long countByAgentIdAndOperationState(long agentId,String operationState);
    long countByAgentIdAndCampaignIdAndOperationState(long agentId,String campaignId,String operationState);
    long countByAgentIdAndCampaignId(long agentId,String campaignId);
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
    List<OperationDBModel>findByAgentIdAndOperationState(long agentId,String operationState);
    List<OperationDBModel>findByAgentIdAndSessionId(long agentId,long sessionId);
    List<OperationDBModel>findByIdAndAgentId(String operationId,long agentId);
    List<OperationDBModel>findByIdAndAgentIdAndOperationState(String operationId,long agentId,String operationState);
    List<OperationDBModel>findByAgentIdAndSessionIdAndOperationState(long agentId,long sessionId,String operationState);
    List<OperationDBModel>findByCampaignId(String campaignId);
    List<OperationDBModel>findByCampaignIdAndProcessId(String campaignId,String processId);
    List<OperationDBModel>findBySessionIdAndProcessId(long sessionId,String processId);
    Page<OperationDBModel>findAllByStatus(int status, Pageable pageable);
    Page<OperationDBModel>findAllByAgentId(long agentId, Pageable pageable);
    Page<OperationDBModel>findAllByAgentIdAndCampaignId(long agentId,String campaignId, Pageable pageable);
    Page<OperationDBModel>findAllByOperationState(String operationState, Pageable pageable);
    Page<OperationDBModel>findAllByOperationType(String operationType,Pageable pageable);
    Page<OperationDBModel>findAllByOperationStateAndOperationType(String operationState,String operationType, Pageable pageable);
    Page<OperationDBModel>findAllByAgentIdAndOperationState(long agentId,String operationState, Pageable pageable);
    Page<OperationDBModel>findAllByAgentIdAndOperationTypeAndOperationStateAndOperationInquiryState(long agentId,String operationType,String operationState, String operationInquiryState, Pageable pageable);Page<OperationDBModel>findAllByAgentIdAndOperationTypeAndOperationState(long agentId,String operationType,String operationState, Pageable pageable);
    Page<OperationDBModel>findAllByAgentIdAndOperationTypeAndOperationStateAndOperationFlowState(long agentId,String operationType,String operationState,String operationFlowState, Pageable pageable);
    Page<OperationDBModel>findAllByAgentIdAndOperationTypeAndOperationStateAndOperationInquiryStateAndOperationFlowState(long agentId,String operationType,String operationState, String operationInquiryState, String operationFlowState, Pageable pageable);
    Page<OperationDBModel>findAllByAgentIdAndCampaignIdAndOperationState(long agentId,String campaignId,String operationState, Pageable pageable);
    Page<OperationDBModel>findAllByAgentIdAndCampaignIdAndOperationStateAndOperationInquiryState(long agentId,String campaignId,String operationState,String operationInquiryState, Pageable pageable);
    Page<OperationDBModel>findAllByAgentIdAndCampaignIdAndOperationStateAndOperationFlowState(long agentId,String campaignId,String operationState,String operationFlowState, Pageable pageable);


}
