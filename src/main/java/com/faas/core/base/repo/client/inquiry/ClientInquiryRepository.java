package com.faas.core.base.repo.client.inquiry;

import com.faas.core.base.model.db.client.inquiry.ClientInquiryDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientInquiryRepository extends MongoRepository<ClientInquiryDBModel,String> {

    List<ClientInquiryDBModel>findByClientId(long clientId);
    List<ClientInquiryDBModel>findBySessionIdAndClientId(long sessionId,long clientId);

    List<ClientInquiryDBModel>findBySessionId(long sessionId);

}
