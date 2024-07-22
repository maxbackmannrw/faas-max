package com.faas.core.base.repo.remoteapp;

import com.faas.core.base.model.db.remoteapp.RemoteAppDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteAppRepository extends MongoRepository<RemoteAppDBModel, String> {


    long countByRemoteState(String remoteState);
    List<RemoteAppDBModel>findByStatus(int status);
    List<RemoteAppDBModel>findByClientId(long clientId);
    List<RemoteAppDBModel>findByIdAndClientId(String clientRemoteId, long clientId);
    Page<RemoteAppDBModel>findAllByStatus(int status, Pageable pageable);
    Page<RemoteAppDBModel>findAllByRemoteState(String remoteState, Pageable pageable);
    Page<RemoteAppDBModel>findAllByRemoteStateAndBaseType(String remoteState, String baseType, Pageable pageable);



}
