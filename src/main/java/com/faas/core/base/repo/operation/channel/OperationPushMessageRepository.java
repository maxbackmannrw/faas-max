package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.OperationPushMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationPushMessageRepository extends MongoRepository<OperationPushMessageDBModel, String> {

    List<OperationPushMessageDBModel>findBySessionId(long sessionId);
    List<OperationPushMessageDBModel>findByClientId(long clientId);
}
