package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.WappMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappMessageRepository extends MongoRepository<WappMessageDBModel, String> {

    List<WappMessageDBModel>findBySessionId(long sessionId);
    List<WappMessageDBModel>findByIdAndSessionId(String messageId, long sessionId);
    List<WappMessageDBModel>findBySessionIdAndClientIdAndProcessId(long sessionId,long clientId,String processId);
    List<WappMessageDBModel>findByIdAndSessionIdAndClientIdAndProcessId(String messageId,long sessionId,long clientId,String processId);
    List<WappMessageDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId,String campaignId,String processId);
    List<WappMessageDBModel>findByIdAndSessionIdAndCampaignIdAndProcessId(String messageId,long sessionId,String campaignId,String processId);
    List<WappMessageDBModel>findByClientId(long clientId);

}
