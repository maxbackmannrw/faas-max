package com.faas.core.base.repo.process.details.channel.content;

import com.faas.core.base.model.db.process.details.channel.content.ProcessEmailChannelDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcessEmailChannelRepository extends MongoRepository<ProcessEmailChannelDBModel, String> {

    List<ProcessEmailChannelDBModel>findByStatus(int status);
    List<ProcessEmailChannelDBModel>findByProcessId(String processId);

}
