package com.faas.core.data.repo.channel.account;

import com.faas.core.data.db.channel.account.SmsAccountDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsAccountRepository extends MongoRepository<SmsAccountDBModel, String> {

    List<SmsAccountDBModel> findByStatus(int status);


}
