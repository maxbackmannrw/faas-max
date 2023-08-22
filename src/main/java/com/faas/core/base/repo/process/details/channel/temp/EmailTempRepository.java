package com.faas.core.base.repo.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.EmailTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailTempRepository extends MongoRepository<EmailTempDBModel, String> {

    List<EmailTempDBModel> findByStatus(int status);

    List<EmailTempDBModel> findByProcessId(String processId);
}
