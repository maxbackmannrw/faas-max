package com.faas.core.data.repo.user.details;

import com.faas.core.data.db.user.details.UserDetailsDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetailsDBModel, String> {

    List<UserDetailsDBModel> findByUserId(long userId);


}
