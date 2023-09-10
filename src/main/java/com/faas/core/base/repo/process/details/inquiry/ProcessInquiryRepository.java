package com.faas.core.base.repo.process.details.inquiry;

import com.faas.core.base.model.db.process.details.inquiry.ProcessInquiryDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessInquiryRepository extends MongoRepository<ProcessInquiryDBModel, String> {

    List<ProcessInquiryDBModel> findByStatus(int status);
    List<ProcessInquiryDBModel>findByProcessId(String processId);
    List<ProcessInquiryDBModel>findByIdAndProcessId(String inquiryId,String processId);


}
