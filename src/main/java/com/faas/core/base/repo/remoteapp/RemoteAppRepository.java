package com.faas.core.base.repo.remoteapp;

import com.faas.core.base.model.db.remoteapp.RemoteAppDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteAppRepository extends MongoRepository<RemoteAppDBModel, String> {

    long countByAppState(String remoteState);
    List<RemoteAppDBModel>findByStatus(int status);
    List<RemoteAppDBModel>findByClientId(long clientId);
    List<RemoteAppDBModel>findByIdAndClientId(String clientRemoteId, long clientId);
    Page<RemoteAppDBModel>findAllByStatus(int status, Pageable pageable);
    Page<RemoteAppDBModel>findAllByAppState(String appState, Pageable pageable);
    Page<RemoteAppDBModel>findAllByAppStateAndBaseType(String appState, String baseType, Pageable pageable);



}
