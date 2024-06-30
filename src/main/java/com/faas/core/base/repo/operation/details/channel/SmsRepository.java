package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsRepository extends MongoRepository<OperationSmsDBModel, String> {

    List<OperationSmsDBModel>findByOperationId(String operationId);
    List<OperationSmsDBModel>findByOperationIdAndAgentId(String operationId, long agentId);
    List<OperationSmsDBModel>findByIdAndOperationId(String smsId, String operationId);
    List<OperationSmsDBModel>findByClientId(long clientId);
}
