package com.faas.core.base.repo.remote.app;

import com.faas.core.base.model.db.remote.app.RemoteAppDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteAppRepository extends MongoRepository<RemoteAppDBModel, String> {


    long countByConnState(String connState);
    List<RemoteAppDBModel> findByStatus(int status);

    List<RemoteAppDBModel>findByClientId(long clientId);

    Page<RemoteAppDBModel>findAllByStatus(int status, Pageable pageable);

    Page<RemoteAppDBModel>findAllByConnState(String connState, Pageable pageable);

    Page<RemoteAppDBModel>findAllByConnStateAndBaseType(String connState, String baseType, Pageable pageable);



}
