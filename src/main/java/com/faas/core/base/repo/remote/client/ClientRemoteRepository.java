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
    Page<ClientRemoteDBModel>findAllByRemoteState(String remoteState, Pageable pageable);
    Page<ClientRemoteDBModel>findAllByRemoteStateAndBaseType(String remoteState, String baseType, Pageable pageable);



}
