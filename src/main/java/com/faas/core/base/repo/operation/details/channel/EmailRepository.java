package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationEmailDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends MongoRepository<OperationEmailDBModel, String> {

    List<OperationEmailDBModel>findByOperationId(String operationId);
    List<OperationEmailDBModel>findByOperationIdAndAgentId(String operationId, long agentId);
    List<OperationEmailDBModel>findByClientId(long clientId);
    List<OperationEmailDBModel>findByIdAndOperationId(String emailId, String operationId);


}
