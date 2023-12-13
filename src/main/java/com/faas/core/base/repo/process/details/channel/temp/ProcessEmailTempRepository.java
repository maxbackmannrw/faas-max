package com.faas.core.base.repo.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessEmailTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessEmailTempRepository extends MongoRepository<ProcessEmailTempDBModel, String> {

    List<ProcessEmailTempDBModel> findByStatus(int status);

    List<ProcessEmailTempDBModel> findByProcessId(String processId);
}
