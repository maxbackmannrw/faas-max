package com.faas.core.base.repo.operation.inquiry;

import com.faas.core.base.model.db.operation.inquiry.OperationInquiryDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationInquiryRepository extends MongoRepository<OperationInquiryDBModel,String> {

    List<OperationInquiryDBModel>findByClientId(long clientId);
    List<OperationInquiryDBModel>findBySessionIdAndClientId(long sessionId, long clientId);

    List<OperationInquiryDBModel>findBySessionId(long sessionId);

     Page<OperationInquiryDBModel> findAllByAgentIdAndInquiryState(long agentId, String inquiryState, Pageable pageable);

    boolean existsByClientIdAndCampaignId(long clientId,String campaignId);

    long countByAgentIdAndInquiryState(long agentId, String inquiryState);

    long countByAgentId(long agentId);
}
