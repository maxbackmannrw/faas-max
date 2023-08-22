package com.faas.core.base.repo.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.SmsMessageTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsMessageTempRepository extends MongoRepository<SmsMessageTempDBModel, String> {

    List<SmsMessageTempDBModel> findByStatus(int status);

    List<SmsMessageTempDBModel> findByProcessId(String processId);

    List<SmsMessageTempDBModel>findByIdAndProcessId(String tempId,String processId);
}
