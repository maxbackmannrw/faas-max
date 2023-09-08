package com.faas.core.base.repo.client.inquiry;

import com.faas.core.base.model.db.client.inquiry.ClientInquiryDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientInquiryRepository extends MongoRepository<ClientInquiryDBModel,String> {


}
