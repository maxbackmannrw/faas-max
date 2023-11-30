package com.faas.core.base.repo.remote.client;

import com.faas.core.base.model.db.remote.client.ClientRemoteDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRemoteRepository extends MongoRepository<ClientRemoteDBModel, String> {

    long countByRemoteState(String remoteState);

    List<ClientRemoteDBModel> findByStatus(int status);

    List<ClientRemoteDBModel>findByClientId(long clientId);

    Page<ClientRemoteDBModel>findAllByStatus(int status, Pageable pageable);

    Page<ClientRemoteDBModel>findAllByRemoteStateAndStatus(String remoteState, int status, Pageable pageable);

    Page<ClientRemoteDBModel>findAllByRemoteTypeAndStatus(String remoteType, int status, Pageable pageable);

    Page<ClientRemoteDBModel>findAllByRemoteTypeAndRemoteStateAndStatus(String remoteType, String remoteState, int status, Pageable pageable);

}
