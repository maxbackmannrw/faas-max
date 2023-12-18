package com.faas.core.base.repo.client.details;

import com.faas.core.base.model.db.client.details.content.ClientDetailsDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDetailsRepository extends MongoRepository<ClientDetailsDBModel, String> {


    List<ClientDetailsDBModel>findByClientId(long clientId);

    boolean existsByClientId(long clientId);
}
