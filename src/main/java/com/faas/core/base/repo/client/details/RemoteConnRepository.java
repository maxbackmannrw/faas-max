package com.faas.core.base.repo.client.details;

import com.faas.core.base.model.db.client.details.RemoteConnDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteConnRepository extends MongoRepository<RemoteConnDBModel, String> {

    List<RemoteConnDBModel> findByStatus(int status);

    List<RemoteConnDBModel>findByClientId(long clientId);

    Page<RemoteConnDBModel>findAllByStatus(int status, Pageable pageable);

    Page<RemoteConnDBModel>findAllByConnStateAndStatus(String connState, int status, Pageable pageable);

    Page<RemoteConnDBModel>findAllByConnTypeAndStatus(String connType,int status, Pageable pageable);

    Page<RemoteConnDBModel>findAllByConnTypeAndConnStateAndStatus(String connType,String connState, int status, Pageable pageable);

}
