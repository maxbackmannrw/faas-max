package com.faas.core.data.repo.operation.content;

import com.faas.core.data.db.operation.content.OperationDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends MongoRepository<OperationDBModel, String> {

    boolean existsByClientIdAndOperationState(long clientId, String operationState);

    boolean existsByClientIdAndAgentId(long clientId, long agentId);

    long countByCampaignId(String campaignId);

    long countByCampaignIdAndOperationState(String campaignId, String operationState);

    long countByAgentId(long agentId);

    long countByAgentIdAndOperationState(long agentId, String operationState);

    long countByAgentIdAndCampaignIdAndOperationState(long agentId, String campaignId, String operationState);

    long countByAgentIdAndCampaignId(long agentId, String campaignId);

    List<OperationDBModel> findByClientId(long clientId);

    List<OperationDBModel> findByAgentId(long agentId);

    List<OperationDBModel> findByAgentIdAndOperationState(long agentId, String operationState);

    List<OperationDBModel> findByIdAndAgentId(String operationId, long agentId);

    List<OperationDBModel> findByIdAndAgentIdAndOperationState(String operationId, long agentId, String operationState);

    List<OperationDBModel> findByCampaignId(String campaignId);

    Page<OperationDBModel> findAllByStatus(int status, Pageable pageable);

    Page<OperationDBModel> findAllByAgentId(long agentId, Pageable pageable);

    Page<OperationDBModel> findAllByAgentIdAndCampaignId(long agentId, String campaignId, Pageable pageable);

    Page<OperationDBModel> findAllByOperationState(String operationState, Pageable pageable);

    Page<OperationDBModel> findAllByOperationCategoryAndOperationState(String operationCategory, String operationState, Pageable pageable);

    Page<OperationDBModel> findAllByCampaignIdAndOperationState(String campaignId, String operationState, Pageable pageable);

    Page<OperationDBModel> findAllByAgentIdAndOperationState(long agentId, String operationState, Pageable pageable);

    Page<OperationDBModel> findAllByAgentIdAndOperationCategoryAndOperationState(long agentId, String operationCategory,String operationState, Pageable pageable);

    Page<OperationDBModel> findAllByAgentIdAndOperationCategoryAndOperationStateAndInquiryState(long agentId, String operationCategory,String operationState, String inquiryState, Pageable pageable);

    Page<OperationDBModel> findAllByAgentIdAndOperationCategoryAndOperationStateAndFlowState(long agentId, String operationCategory,String operationState, String flowState, Pageable pageable);

    Page<OperationDBModel> findAllByAgentIdAndCampaignIdAndOperationState(long agentId, String campaignId, String operationState, Pageable pageable);

}
