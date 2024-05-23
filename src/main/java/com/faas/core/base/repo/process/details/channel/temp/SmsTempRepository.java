package com.faas.core.base.repo.process.details.channel.temp;

import com.faas.core.base.model.db.process.details.channel.temp.SmsTempDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsTempRepository extends MongoRepository<SmsTempDBModel, String> {

    List<SmsTempDBModel> findByStatus(int status);

    List<SmsTempDBModel> findByProcessId(String processId);

    List<SmsTempDBModel>findByIdAndProcessId(String tempId, String processId);
}
