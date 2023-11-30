package com.faas.core.base.repo.remote.content;

import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.settings.RemoteTypeDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteRepository extends MongoRepository<RemoteDBModel, String> {

    List<RemoteDBModel> findByStatus(int status);

    List<RemoteDBModel>findByBaseType(String baseType);

}
