package com.faas.core.base.repo.remote.client;

import com.faas.core.base.model.db.remote.client.RemoteClientDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteClientRepository extends MongoRepository<RemoteClientDBModel, String> {


    long countByRemoteState(String remoteState);
    List<RemoteClientDBModel>findByStatus(int status);
    List<RemoteClientDBModel>findByClientId(long clientId);
    List<RemoteClientDBModel>findByIdAndClientId(String clientRemoteId, long clientId);
    Page<RemoteClientDBModel>findAllByStatus(int status, Pageable pageable);
    Page<RemoteClientDBModel>findAllByRemoteState(String remoteState, Pageable pageable);
    Page<RemoteClientDBModel>findAllByRemoteStateAndBaseType(String remoteState, String baseType, Pageable pageable);



}
