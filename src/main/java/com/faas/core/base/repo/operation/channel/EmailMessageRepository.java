package com.faas.core.base.repo.operation.channel;

import com.faas.core.base.model.db.operation.channel.EmailMessageDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailMessageRepository extends MongoRepository<EmailMessageDBModel, String> {

    List<EmailMessageDBModel>findBySessionId(long sessionId);
    List<EmailMessageDBModel>findByClientId(long clientId);


}
