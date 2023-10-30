package com.faas.core.base.repo.client.session;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends PagingAndSortingRepository<SessionDBModel, Long> {


    long countByAgentIdAndSessionState(long agentId,String sessionState);
    long countByAgentId(long agentId);
    long countByAgentIdAndCampaignId(long agentId,String campaignId);
    long countByAgentIdAndCampaignIdAndSessionState(long agentId,String campaignId,String sessionState);
    boolean existsByIdAndClientIdAndProcessId(long sessionId,long clientId,String processId);
    boolean existsByIdAndAgentIdAndProcessId(long sessionId,long agentId,String processId);
    List<SessionDBModel>findByStatus(int status);
    List<SessionDBModel>findByClientId(long clientId);
    List<SessionDBModel>findByIdAndClientId(long sessionId,long clientId);
    List<SessionDBModel>findByIdAndClientIdAndAgentIdAndCampaignId(long sessionId,long clientId,long agentId,String campaignId);
    List<SessionDBModel>findByIdAndClientIdAndAgentId(long sessionId,long clientId,long agentId);
    List<SessionDBModel>findByIdAndClientIdAndAgentIdAndCampaignIdAndProcessId(long sessionId,long clientId,long agentId,String campaignId,String processId);
    List<SessionDBModel>findByIdAndClientIdAndAgentIdAndCampaignIdAndSessionState(long sessionId,long clientId,long agentId,String campaignId,String sessionState);
    List<SessionDBModel>findByClientIdAndCampaignId(long clientId, String campaignId);
    List<SessionDBModel>findByCampaignId(String campaign);
    List<SessionDBModel>findByIdAndCampaignId(long sessionId, String campaignId);
    List<SessionDBModel>findByIdAndCampaignIdAndSessionStateAndSessionType(long sessionId, String campaignId,String sessionState,String sessionType);
    List<SessionDBModel>findByCampaignIdAndSessionState(String campaign, String sessionState);
    List<SessionDBModel>findByIdAndAgentId(long sessionId, long agentId);
    List<SessionDBModel>findByIdAndAgentIdAndSessionState(long sessionId, long agentId,String sessionState);
    List<SessionDBModel>findByIdAndAgentIdAndProcessId(long sessionId, long agentId,String processId);
    List<SessionDBModel>findByIdAndClientIdAndAgentIdAndProcessId(long sessionId,long clientId, long agentId,String processId);
    List<SessionDBModel>findByAgentId(long agentId);
    List<SessionDBModel>findByAgentIdAndSessionState(long agentId, String sessionState);
    List<SessionDBModel>findByAgentIdAndCampaignIdAndSessionState(long agentId, String campaignId, String sessionState);
    List<SessionDBModel>findByAgentIdAndCampaignIdAndProcessIdAndSessionState(long agentId, String campaignId, String processId, String sessionState);


    Page<SessionDBModel>findAllByCampaignCategoryAndSessionState(String campaignCategory, String sessionState, Pageable pageable);
    Page<SessionDBModel>findAllByCampaignCategory(String campaignCategory, Pageable pageable);
    Page<SessionDBModel>findAllBySessionTypeAndSessionState(String sessionType,String sessionState, Pageable pageable);
    Page<SessionDBModel>findAllBySessionType(String sessionType, Pageable pageable);
    Page<SessionDBModel>findAllBySessionState(String sessionState, Pageable pageable);
    Page<SessionDBModel>findAllByStatus(int status, Pageable pageable);
    Page<SessionDBModel>findAllByIdAndAgentId(long sessionId,long agentId, Pageable pageable);
    Page<SessionDBModel>findAllByStatusAndSessionState(int status, String sessionState, Pageable pageable);
    Page<SessionDBModel>findAllByAgentId(long agentId, Pageable pageable);
    Page<SessionDBModel>findAllByAgentIdAndSessionState(long agentId, String sessionState, Pageable pageable);
    Page<SessionDBModel>findAllByAgentIdAndSessionStateAndSessionType(long agentId, String sessionState,String sessionType, Pageable pageable);
    Page<SessionDBModel>findAllByAgentIdAndSessionTypeAndSessionState(long agentId, String sessionType,String sessionState, Pageable pageable);
    Page<SessionDBModel>findAllByCampaignId(String campaignId, Pageable pageable);
    Page<SessionDBModel>findAllByCampaignIdAndSessionState(String campaignId, String sessionState, Pageable pageable);
    Page<SessionDBModel>findAllByProcessId(String processId, Pageable pageable);
    Page<SessionDBModel>findAllByProcessIdAndSessionState(String processId, String sessionState, Pageable pageable);
    Page<SessionDBModel>findAllByCampaignIdAndProcessId(String campaignId, String processId, Pageable pageable);
    Page<SessionDBModel>findAllByCampaignIdAndProcessIdAndSessionState(String campaignId, String processId, String sessionState, Pageable pageable);
    Page<SessionDBModel>findAllByCampaignIdAndClientCityAndClientCountry(String campaignId,String city,String country,Pageable pageable);


}
