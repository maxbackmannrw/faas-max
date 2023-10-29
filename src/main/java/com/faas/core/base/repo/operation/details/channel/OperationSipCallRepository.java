package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationSipCallRepository extends PagingAndSortingRepository<OperationSipCallDBModel, Long> {

    boolean existsByIdAndCallState(long callId,String callState);
    boolean existsBySessionIdAndCallState(long sessionId,String callState);
    List<OperationSipCallDBModel>findBySessionId(long sessionId);
    List<OperationSipCallDBModel>findByIdAndSessionId(long callId, long sessionId);
    List<OperationSipCallDBModel>findByIdAndSessionIdAndAgentIdAndClientId(long callId, long sessionId, long agentId, long clientId);
    List<OperationSipCallDBModel>findBySessionIdAndCampaignIdAndProcessId(long sessionId, String campaignId, String processId);
    List<OperationSipCallDBModel>findBySessionIdAndCampaignId(long sessionId, String campaignId);
    List<OperationSipCallDBModel>findByIdAndSessionIdAndCampaignIdAndProcessId(long callId, long sessionId, String campaignId, String processId);
    List<OperationSipCallDBModel>findBySessionIdAndCallState(long sessionId, String callState);
    List<OperationSipCallDBModel>findByClientId(long clientId);
    List<OperationSipCallDBModel>findBySessionIdAndClientId(long sessionId, long clientId);
}
