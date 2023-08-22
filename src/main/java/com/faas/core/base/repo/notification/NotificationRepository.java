package com.faas.core.base.repo.notification;

import com.faas.core.base.model.db.notification.NotificationDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<NotificationDBModel, String> {

}
