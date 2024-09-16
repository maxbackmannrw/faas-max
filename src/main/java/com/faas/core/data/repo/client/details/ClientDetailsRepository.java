package com.faas.core.data.repo.client.details;

import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDetailsRepository extends MongoRepository<ClientDetailsDBModel, String> {


    List<ClientDetailsDBModel> findByClientId(long clientId);

    boolean existsByClientId(long clientId);
}
