package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.process.content.dao.ProcessRemoteDAO;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.remote.app.RemoteAppRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RemoteHelper {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessRemoteDAO createProcessRemoteDAO(RemoteDBModel remoteDBModel){

        ProcessRemoteDAO processRemoteDAO = new ProcessRemoteDAO();
        processRemoteDAO.setId(appUtils.generateUUID());
        processRemoteDAO.setRemote(remoteDBModel.getRemote());
        processRemoteDAO.setRemoteDesc(remoteDBModel.getRemoteDesc());
        processRemoteDAO.setRemoteVersion(remoteDBModel.getRemoteVersion());
        if (remoteDBModel.getRemoteDatas() != null) {
            processRemoteDAO.setRemoteDatas(remoteDBModel.getRemoteDatas());
        }else {
            processRemoteDAO.setRemoteDatas(new ArrayList<>());
        }
        if (remoteDBModel.getRemoteUrls() != null) {
            processRemoteDAO.setRemoteUrls(remoteDBModel.getRemoteUrls());
        }else {
            processRemoteDAO.setRemoteUrls(new ArrayList<>());
        }
        processRemoteDAO.setTypeId(remoteDBModel.getTypeId());
        processRemoteDAO.setRemoteType(remoteDBModel.getRemoteType());
        processRemoteDAO.setBaseType(remoteDBModel.getBaseType());
        processRemoteDAO.setuDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setcDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setStatus(1);

        return processRemoteDAO;
    }

    public ProcessRemoteDAO createFlowProcessRemoteDAO(RemoteDBModel remoteDBModel){

        ProcessRemoteDAO processRemoteDAO = new ProcessRemoteDAO();
        processRemoteDAO.setId(appUtils.generateUUID());
        processRemoteDAO.setRemote(remoteDBModel.getRemote());
        processRemoteDAO.setRemoteDesc(remoteDBModel.getRemoteDesc());
        processRemoteDAO.setRemoteVersion(remoteDBModel.getRemoteVersion());
        if (remoteDBModel.getRemoteDatas() != null) {
            processRemoteDAO.setRemoteDatas(remoteDBModel.getRemoteDatas());
        }else {
            processRemoteDAO.setRemoteDatas(new ArrayList<>());
        }
        if (remoteDBModel.getRemoteUrls() != null) {
            processRemoteDAO.setRemoteUrls(remoteDBModel.getRemoteUrls());
        }else {
            processRemoteDAO.setRemoteUrls(new ArrayList<>());
        }
        processRemoteDAO.setTypeId(remoteDBModel.getTypeId());
        processRemoteDAO.setRemoteType(remoteDBModel.getRemoteType());
        processRemoteDAO.setBaseType(remoteDBModel.getBaseType());
        processRemoteDAO.setuDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setcDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setStatus(1);

        return processRemoteDAO;
    }

    public ProcessRemoteDAO createInquiryProcessRemoteDAO(RemoteDBModel remoteDBModel){

        ProcessRemoteDAO processRemoteDAO = new ProcessRemoteDAO();
        processRemoteDAO.setId(appUtils.generateUUID());
        processRemoteDAO.setRemote(remoteDBModel.getRemote());
        processRemoteDAO.setRemoteDesc(remoteDBModel.getRemoteDesc());
        processRemoteDAO.setRemoteVersion(remoteDBModel.getRemoteVersion());

        if (remoteDBModel.getRemoteDatas() != null) {
            processRemoteDAO.setRemoteDatas(remoteDBModel.getRemoteDatas());
        }else {
            processRemoteDAO.setRemoteDatas(new ArrayList<>());
        }

        if (remoteDBModel.getRemoteUrls() != null) {
            processRemoteDAO.setRemoteUrls(remoteDBModel.getRemoteUrls());
        }else {
            processRemoteDAO.setRemoteUrls(new ArrayList<>());
        }

        processRemoteDAO.setTypeId(remoteDBModel.getTypeId());
        processRemoteDAO.setRemoteType(remoteDBModel.getRemoteType());
        processRemoteDAO.setBaseType(remoteDBModel.getBaseType());
        processRemoteDAO.setuDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setcDate(appUtils.getCurrentTimeStamp());
        processRemoteDAO.setStatus(1);

        return processRemoteDAO;
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
