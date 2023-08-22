package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.WappCallDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappCallRepository extends PagingAndSortingRepository<WappCallDBModel, Long> {

    List<WappCallDBModel>findBySessionId(long sessionId);
    List<WappCallDBModel>findBySessionIdAndCallState(long sessionId, String callState);
    List<WappCallDBModel>findByIdAndSessionId(long callId, long sessionId);
    List<WappCallDBModel>findByClientId(long clientId);
    List<WappCallDBModel>findBySessionIdAndClientId(long sessionId,long clientId);
}
