package com.faas.core.base.repo.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PushTempRepository extends MongoRepository<ProcessPushTempDBModel, String> {

    List<ProcessPushTempDBModel> findByStatus(int status);

    List<ProcessPushTempDBModel> findByProcessId(String processId);
}
