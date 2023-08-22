package com.faas.core.base.repo.process.details.channel.content;

import com.faas.core.base.model.db.process.details.channel.content.ProcessWappChannelDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcessWappChannelRepository extends MongoRepository<ProcessWappChannelDBModel, String> {

    List<ProcessWappChannelDBModel>findByStatus(int status);
    List<ProcessWappChannelDBModel>findByProcessId(String processId);

}
