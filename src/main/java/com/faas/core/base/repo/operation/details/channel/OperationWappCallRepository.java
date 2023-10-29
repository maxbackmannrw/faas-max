package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationWappCallRepository extends PagingAndSortingRepository<OperationWappCallDBModel, Long> {

    List<OperationWappCallDBModel>findBySessionId(long sessionId);
    List<OperationWappCallDBModel>findBySessionIdAndCallState(long sessionId, String callState);
    List<OperationWappCallDBModel>findByIdAndSessionId(long callId, long sessionId);
    List<OperationWappCallDBModel>findByClientId(long clientId);
    List<OperationWappCallDBModel>findBySessionIdAndClientId(long sessionId, long clientId);
}
