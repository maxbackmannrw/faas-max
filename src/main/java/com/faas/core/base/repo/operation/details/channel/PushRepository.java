package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationPushDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PushRepository extends MongoRepository<OperationPushDBModel, String> {

    List<OperationPushDBModel>findByOperationId(String operationId);
    List<OperationPushDBModel>findByOperationIdAndAgentId(String operationId, long agentId);
    List<OperationPushDBModel>findByClientId(long clientId);
    List<OperationPushDBModel>findByIdAndOperationId(String pushId, String operationId);
}
