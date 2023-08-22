package com.faas.core.base.repo.channel.account;

import com.faas.core.base.model.db.channel.account.EmailAccountDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailAccountRepository extends MongoRepository<EmailAccountDBModel, String> {

    List<EmailAccountDBModel> findByStatus(int status);


}
