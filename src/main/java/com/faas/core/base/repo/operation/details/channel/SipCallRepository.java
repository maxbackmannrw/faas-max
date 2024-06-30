package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationSipCallDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipCallRepository extends MongoRepository<OperationSipCallDBModel, String> {

    boolean existsByIdAndCallState(String callId,String callState);
    boolean existsByOperationIdAndCallState(String operationId,String callState);
    List<OperationSipCallDBModel>findByOperationId(String operationId);
    List<OperationSipCallDBModel>findByIdAndOperationId(String callId, String operationId);
    List<OperationSipCallDBModel>findByIdAndOperationIdAndAgentId(String callId, String operationId, long agentId);
    List<OperationSipCallDBModel>findByOperationIdAndAgentId(String operationId, long agentId);

    List<OperationSipCallDBModel>findByOperationIdAndCallState(String operationId, String callState);
    List<OperationSipCallDBModel>findByOperationIdAndAgentIdAndCallState(String operationId, long agentId, String callState);
    List<OperationSipCallDBModel>findByClientId(long clientId);
}
