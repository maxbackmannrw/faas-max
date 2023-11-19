package com.faas.core.base.repo.remote;

import com.faas.core.base.model.db.remote.RemoteDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteRepository extends MongoRepository<RemoteDBModel, String> {

    long countByRemoteState(String remoteState);

    List<RemoteDBModel> findByStatus(int status);

    List<RemoteDBModel>findByClientId(long clientId);

    Page<RemoteDBModel>findAllByStatus(int status, Pageable pageable);

    Page<RemoteDBModel>findAllByRemoteStateAndStatus(String remoteState, int status, Pageable pageable);

    Page<RemoteDBModel>findAllByRemoteTypeAndStatus(String remoteType, int status, Pageable pageable);

    Page<RemoteDBModel>findAllByRemoteTypeAndRemoteStateAndStatus(String remoteType, String remoteState, int status, Pageable pageable);

}
