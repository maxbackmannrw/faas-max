package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.SmsMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsMessageRepository extends MongoRepository<SmsMessageDBModel, String> {

    List<SmsMessageDBModel>findBySessionId(long sessionId);
    List<SmsMessageDBModel>findBySessionIdAndClientIdAndProcessId(long sessionId,long clientId,String processId);
    List<SmsMessageDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId,String campaignId,String processId);
    List<SmsMessageDBModel>findByIdAndSessionIdAndClientIdAndProcessId(String messageId,long sessionId,long clientId,String processId);
    List<SmsMessageDBModel>findByIdAndSessionIdAndClientIdAndCampaignIdAndProcessId(String messageId,long sessionId,long clientId,String campaignId,String processId);
    List<SmsMessageDBModel>findBySessionIdAndClientIdAndCampaignIdAndProcessId(long sessionId,long clientId,String campaignId,String processId);
    List<SmsMessageDBModel>findByIdAndSessionId(String messageId,long sessionId);
    List<SmsMessageDBModel>findByIdAndSessionIdAndCampaignIdAndProcessId(String messageId,long sessionId,String campaignId,String processId);
    List<SmsMessageDBModel>findByClientId(long clientId);
}
