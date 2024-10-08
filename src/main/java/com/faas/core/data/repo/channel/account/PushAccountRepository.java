package com.faas.core.data.repo.channel.account;

import com.faas.core.data.db.channel.account.PushAccountDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PushAccountRepository extends MongoRepository<PushAccountDBModel, String> {

    List<PushAccountDBModel> findByStatus(int status);

}
