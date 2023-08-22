package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.PushMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PushMessageRepository extends MongoRepository<PushMessageDBModel, String> {

    List<PushMessageDBModel>findBySessionId(long sessionId);
    List<PushMessageDBModel>findByClientId(long clientId);
}
