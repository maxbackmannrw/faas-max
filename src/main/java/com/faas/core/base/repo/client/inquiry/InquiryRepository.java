package com.faas.core.base.repo.client.inquiry;

import com.faas.core.base.model.db.client.inquiry.InquiryDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends MongoRepository<InquiryDBModel,String> {


}
