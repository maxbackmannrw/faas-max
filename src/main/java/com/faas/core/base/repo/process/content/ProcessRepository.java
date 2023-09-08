package com.faas.core.base.repo.process.content;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessRepository extends MongoRepository<ProcessDBModel, String> {

    List<ProcessDBModel>findByIdAndProcessState(String processId,String processState);

    List<ProcessDBModel>findByProcessState(String processState);

    List<ProcessDBModel> findByStatus(int status);

    List<ProcessDBModel>findByIdAndStatus(String processId,int status);

    List<ProcessDBModel> findByProcessType(String processType);

    List<ProcessDBModel>findByBaseType(String baseType);

    List<ProcessDBModel>findByCategory(String category);

}

