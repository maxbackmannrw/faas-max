package com.faas.core.base.repo.operation.details.channel;

import com.faas.core.base.model.db.operation.details.channel.OperationEmailMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationEmailMessageRepository extends MongoRepository<OperationEmailMessageDBModel, String> {

    List<OperationEmailMessageDBModel>findBySessionId(long sessionId);
    List<OperationEmailMessageDBModel>findByClientId(long clientId);


}
