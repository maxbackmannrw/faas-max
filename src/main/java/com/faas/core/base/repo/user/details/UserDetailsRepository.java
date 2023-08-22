package com.faas.core.base.repo.user.details;

import com.faas.core.base.model.db.user.details.UserDetailsDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetailsDBModel,String> {

    List<UserDetailsDBModel>findByUserId(long userId);


}
