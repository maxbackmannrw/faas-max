package com.faas.core.base.repo.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PushTempRepository extends MongoRepository<PushTempDBModel, String> {

    List<PushTempDBModel> findByStatus(int status);

    List<PushTempDBModel> findByProcessId(String processId);
}
