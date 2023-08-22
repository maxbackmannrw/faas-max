package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.SipCallDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipCallRepository extends PagingAndSortingRepository<SipCallDBModel, Long> {

    boolean existsByIdAndCallState(long callId,String callState);
    boolean existsBySessionIdAndCallState(long sessionId,String callState);
    List<SipCallDBModel>findBySessionId(long sessionId);
    List<SipCallDBModel>findByIdAndSessionId(long callId, long sessionId);
    List<SipCallDBModel>findByIdAndSessionIdAndAgentIdAndClientId(long callId, long sessionId,long agentId,long clientId);
    List<SipCallDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId,String campaignId,String processId);
    List<SipCallDBModel>findBySessionIdAndCampaignId(long sessionId,String campaignId);
    List<SipCallDBModel>findByIdAndSessionIdAndCampaignIdAndProcessId(long callId,long sessionId,String campaignId,String processId);
    List<SipCallDBModel>findBySessionIdAndCallState(long sessionId, String callState);
    List<SipCallDBModel>findByClientId(long clientId);
    List<SipCallDBModel>findBySessionIdAndClientId(long sessionId,long clientId);
}
