package com.faas.core.base.repo.remote.content;

import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteRepository extends MongoRepository<RemoteDBModel, String> {

    List<RemoteDBModel> findByStatus(int status);

    List<RemoteDBModel>findByBaseType(String baseType);

    List<RemoteDBModel>findByRemoteType(String remoteType);

}
