package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.remote.ProcessRemoteDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.repo.process.details.remote.ProcessRemoteRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RemoteHelper {


    @Autowired
    ProcessRemoteRepository processRemoteRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessRemoteDBModel createProcessRemoteDBModel(ProcessDBModel processDBModel, RemoteDBModel remoteDBModel,String remoteCategory){

        ProcessRemoteDBModel processRemoteDBModel = new ProcessRemoteDBModel();

        processRemoteDBModel.setProcessId(processDBModel.getId());
        processRemoteDBModel.setProcess(processDBModel.getProcess());
        processRemoteDBModel.setRemoteId(remoteDBModel.getId());
        processRemoteDBModel.setRemote(remoteDBModel.getRemote());
        processRemoteDBModel.setRemoteDesc(remoteDBModel.getRemoteDesc());
        processRemoteDBModel.setVersion(remoteDBModel.getVersion());
        processRemoteDBModel.setSourceUrl(remoteDBModel.getSourceUrl());
        if (remoteDBModel.getRemoteDatas() != null) {
            processRemoteDBModel.setRemoteDatas(remoteDBModel.getRemoteDatas());
        }else {
            processRemoteDBModel.setRemoteDatas(new ArrayList<>());
        }
        if (remoteDBModel.getRemoteUrls() != null) {
            processRemoteDBModel.setRemoteUrls(remoteDBModel.getRemoteUrls());
        }else {
            processRemoteDBModel.setRemoteUrls(new ArrayList<>());
        }
        processRemoteDBModel.setRemoteCategory(remoteCategory);
        processRemoteDBModel.setTypeId(remoteDBModel.getTypeId());
        processRemoteDBModel.setRemoteType(remoteDBModel.getRemoteType());
        processRemoteDBModel.setBaseType(remoteDBModel.getBaseType());
        processRemoteDBModel.setuDate(appUtils.getCurrentTimeStamp());
        processRemoteDBModel.setcDate(appUtils.getCurrentTimeStamp());
        processRemoteDBModel.setStatus(1);

        return processRemoteRepository.save(processRemoteDBModel);
    }


    public RemoteDataDAO createRemoteDataDAO(String dataId, String dataType, String value){

        RemoteDataDAO remoteDataDAO = new RemoteDataDAO();
        remoteDataDAO.setDataId(dataId);
        remoteDataDAO.setDataType(dataType);
        remoteDataDAO.setValue(value);
        remoteDataDAO.setcDate(appUtils.getCurrentTimeStamp());
        remoteDataDAO.setStatus(1);

        return remoteDataDAO;
    }


}
