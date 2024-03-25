package com.faas.core.base.repo.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessSmsMessageTempRepository extends MongoRepository<ProcessSmsTempDBModel, String> {

    List<ProcessSmsTempDBModel> findByStatus(int status);

    List<ProcessSmsTempDBModel> findByProcessId(String processId);

    List<ProcessSmsTempDBModel>findByIdAndProcessId(String tempId, String processId);
}
