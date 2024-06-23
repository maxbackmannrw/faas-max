package com.faas.core.utility.helpers.remote;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.remote.ProcessRemoteDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.model.db.utils.UrlDBModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteWSDTO;
import com.faas.core.base.repo.process.details.remote.ProcessRemoteRepository;
import com.faas.core.base.repo.utils.UrlRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RemoteHelper {


    @Autowired
    ProcessRemoteRepository processRemoteRepository;

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteWSDTO mapRemoteWSDTOHelper(RemoteDBModel remoteDBModel){

        RemoteWSDTO remoteWSDTO = new RemoteWSDTO();
        remoteWSDTO.setRemote(remoteDBModel);
        remoteWSDTO.setRemoteUrls(urlRepository.findByBaseTypeAndOwnerId(AppConstant.REMOTE_URL,remoteDBModel.getId()));
        return remoteWSDTO;
    }


    public ProcessRemoteDBModel createProcessRemoteDBModel(ProcessDBModel processDBModel, RemoteDBModel remoteDBModel,String remoteCategory){

        ProcessRemoteDBModel processRemoteDBModel = new ProcessRemoteDBModel();

        processRemoteDBModel.setProcessId(processDBModel.getId());
        processRemoteDBModel.setProcess(processDBModel.getProcess());
        processRemoteDBModel.setRemoteId(remoteDBModel.getId());
        processRemoteDBModel.setRemote(remoteDBModel.getRemote());
        processRemoteDBModel.setRemoteDesc(remoteDBModel.getRemoteDesc());
        processRemoteDBModel.setVersion(remoteDBModel.getVersion());
        if (remoteDBModel.getRemoteDatas() != null) {
            processRemoteDBModel.setRemoteDatas(remoteDBModel.getRemoteDatas());
        }else {
            processRemoteDBModel.setRemoteDatas(new ArrayList<>());
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



    public UrlDBModel createRemoteUrlHelper(String remoteId,String remoteUrl, String urlType,String baseType) {

        UrlDBModel remoteUrlDBModel = new UrlDBModel();
        remoteUrlDBModel.setUrl(remoteUrl);
        remoteUrlDBModel.setUrlType(urlType);
        remoteUrlDBModel.setBaseType(baseType);
        remoteUrlDBModel.setOwnerId(remoteId);
        remoteUrlDBModel.setuDate(appUtils.getCurrentTimeStamp());
        remoteUrlDBModel.setcDate(appUtils.getCurrentTimeStamp());
        remoteUrlDBModel.setStatus(1);

        return remoteUrlDBModel;
    }

}
