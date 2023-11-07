package com.faas.core.base.repo.client.details;

import com.faas.core.base.model.db.client.details.ClientRemoteDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRemoteRepository extends MongoRepository<ClientRemoteDBModel, String> {

    List<ClientRemoteDBModel> findByStatus(int status);

    List<ClientRemoteDBModel>findByClientId(long clientId);


}
