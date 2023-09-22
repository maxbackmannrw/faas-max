package com.faas.core.base.repo.client.flow;

import com.faas.core.base.model.db.client.flow.ClientFlowDBModel;
import com.faas.core.base.model.db.client.inquiry.ClientInquiryDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientFlowRepository extends MongoRepository<ClientFlowDBModel,String> {

    List<ClientFlowDBModel> findByClientId(long clientId);
    List<ClientFlowDBModel>findBySessionIdAndClientId(long sessionId,long clientId);

    List<ClientFlowDBModel>findBySessionId(long sessionId);

    boolean existsByClientIdAndCampaignId(long clientId,String campaignId);

}
