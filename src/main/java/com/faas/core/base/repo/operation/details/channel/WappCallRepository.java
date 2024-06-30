package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationWappCallDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappCallRepository extends MongoRepository<OperationWappCallDBModel, String> {

    boolean existsByIdAndCallState(String callId,String callState);
    boolean existsByOperationIdAndCallState(String operationId,String callState);
    List<OperationWappCallDBModel>findByOperationId(String operationId);
    List<OperationWappCallDBModel>findByOperationIdAndAgentId(String operationId, long agentId);
    List<OperationWappCallDBModel>findByOperationIdAndAgentIdAndCallState(String operationId, long agentId, String callState);
    List<OperationWappCallDBModel>findByOperationIdAndCallState(String operationId, String callState);
    List<OperationWappCallDBModel>findByIdAndOperationId(String callId, String operationId);
    List<OperationWappCallDBModel>findByIdAndOperationIdAndAgentId(String callId, String operationId, long agentId);
    List<OperationWappCallDBModel>findByClientId(long clientId);
}
