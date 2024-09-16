package com.faas.core.data.repo.channel.account;

import com.faas.core.data.db.channel.account.SipAccountDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipAccountRepository extends MongoRepository<SipAccountDBModel, String> {

    List<SipAccountDBModel> findByStatus(int status);


}
