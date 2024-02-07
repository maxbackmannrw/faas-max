package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationPushMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationPushMessageRepository extends MongoRepository<OperationPushMessageDBModel, String> {

    List<OperationPushMessageDBModel>findBySessionId(long sessionId);
    List<OperationPushMessageDBModel>findByOperationId(String operationId);
    List<OperationPushMessageDBModel>findByClientId(long clientId);
    List<OperationPushMessageDBModel>findByIdAndSessionId(String pushId, long sessionId);
    List<OperationPushMessageDBModel>findByIdAndOperationId(String pushId, String operationId);
}
