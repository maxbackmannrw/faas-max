package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappMessageRepository extends MongoRepository<OperationWappMessageDBModel, String> {

    List<OperationWappMessageDBModel>findByOperationId(String operationId);
    List<OperationWappMessageDBModel>findByOperationIdAndAgentId(String operationId, long agentId);
    List<OperationWappMessageDBModel>findByIdAndOperationId(String messageId, String operationId);
    List<OperationWappMessageDBModel>findByClientId(long clientId);

}
