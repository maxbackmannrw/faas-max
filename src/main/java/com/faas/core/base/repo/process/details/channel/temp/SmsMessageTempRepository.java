package com.faas.core.base.repo.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsMessageTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsMessageTempRepository extends MongoRepository<ProcessSmsMessageTempDBModel, String> {

    List<ProcessSmsMessageTempDBModel> findByStatus(int status);

    List<ProcessSmsMessageTempDBModel> findByProcessId(String processId);

    List<ProcessSmsMessageTempDBModel>findByIdAndProcessId(String tempId, String processId);
}
