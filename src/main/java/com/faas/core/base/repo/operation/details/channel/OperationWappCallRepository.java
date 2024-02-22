package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationWappCallRepository extends MongoRepository<OperationWappCallDBModel, String> {

    List<OperationWappCallDBModel>findBySessionId(long sessionId);
    List<OperationWappCallDBModel>findByOperationId(String operationId);
    List<OperationWappCallDBModel>findBySessionIdAndCallState(long sessionId, String callState);
    List<OperationWappCallDBModel>findByOperationIdAndCallState(String operationId, String callState);
    List<OperationWappCallDBModel>findByIdAndSessionId(String callId, long sessionId);
    List<OperationWappCallDBModel>findByIdAndOperationId(String callId, String operationId);
    List<OperationWappCallDBModel>findByClientId(long clientId);
    List<OperationWappCallDBModel>findBySessionIdAndClientId(long sessionId, long clientId);
}
