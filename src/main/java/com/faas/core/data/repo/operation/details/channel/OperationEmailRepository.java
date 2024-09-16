package com.faas.core.data.repo.operation.details.channel;

import com.faas.core.data.db.operation.details.channel.OperationEmailDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationEmailRepository extends MongoRepository<OperationEmailDBModel, String> {

    List<OperationEmailDBModel> findByOperationId(String operationId);

    List<OperationEmailDBModel> findByOperationIdAndAgentId(String operationId, long agentId);

    List<OperationEmailDBModel> findByClientId(long clientId);

    List<OperationEmailDBModel> findByIdAndOperationId(String emailId, String operationId);

}
