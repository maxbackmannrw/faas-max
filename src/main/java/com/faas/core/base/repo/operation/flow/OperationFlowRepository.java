package com.faas.core.base.repo.operation.flow;

import com.faas.core.base.model.db.operation.flow.OperationFlowDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationFlowRepository extends MongoRepository<OperationFlowDBModel,String> {

    List<OperationFlowDBModel> findByClientId(long clientId);
    List<OperationFlowDBModel>findBySessionIdAndClientId(long sessionId, long clientId);

    List<OperationFlowDBModel>findBySessionId(long sessionId);

    boolean existsByClientIdAndCampaignId(long clientId,String campaignId);

}
