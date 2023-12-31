package com.faas.core.base.framework.remote.content;

import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.settings.RemoteTypeDBModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteWSDTO;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.remote.settings.RemoteTypeRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class RemoteFramework {

    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    RemoteTypeRepository remoteTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<RemoteWSDTO> getAllRemotesService(long userId) {

        List<RemoteWSDTO>remoteWSDTOS = new ArrayList<>();
        List<RemoteDBModel> remoteDBModels = remoteRepository.findByStatus(1);
        for (RemoteDBModel remoteDBModel : remoteDBModels) {
            remoteWSDTOS.add(new RemoteWSDTO(remoteDBModel));
        }
        return remoteWSDTOS;
    }


    public List<RemoteWSDTO> getRemotesByBaseTypeService(long userId, String baseType) {

        List<RemoteWSDTO>remoteWSDTOS = new ArrayList<>();
        List<RemoteDBModel> remoteDBModels = remoteRepository.findByBaseType(baseType);
        for (RemoteDBModel remoteDBModel : remoteDBModels) {
            remoteWSDTOS.add(new RemoteWSDTO(remoteDBModel));
        }
        return remoteWSDTOS;
    }


    public List<RemoteWSDTO> getRemotesByTypeService(long userId, String remoteType) {

        List<RemoteWSDTO>remoteWSDTOS = new ArrayList<>();
        List<RemoteDBModel> remoteDBModels = remoteRepository.findByRemoteType(remoteType);
        for (RemoteDBModel remoteDBModel : remoteDBModels) {
            remoteWSDTOS.add(new RemoteWSDTO(remoteDBModel));
        }
        return remoteWSDTOS;
    }


    public RemoteWSDTO getRemoteService(long userId, String remoteId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent()){
            return new RemoteWSDTO(remoteDBModel.get());
        }
        return null;
    }


    public RemoteWSDTO createRemoteService(long userId, String remote,String remoteDesc,String remoteVersion,long typeId) {

        Optional<RemoteTypeDBModel> remoteTypeDBModel = remoteTypeRepository.findById(typeId);
        if (remoteTypeDBModel.isPresent()) {

            RemoteDBModel remoteDBModel = new RemoteDBModel();
            remoteDBModel.setRemote(remote);
            remoteDBModel.setRemoteDesc(remoteDesc);
            remoteDBModel.setRemoteVersion(remoteVersion);
            remoteDBModel.setRemoteDatas(new ArrayList<>());
            remoteDBModel.setRemoteUrls(new ArrayList<>());
            remoteDBModel.setTypeId(typeId);
            remoteDBModel.setRemoteType(remoteTypeDBModel.get().getRemoteType());
            remoteDBModel.setBaseType(remoteTypeDBModel.get().getBaseType());
            remoteDBModel.setuDate(appUtils.getCurrentTimeStamp());
            remoteDBModel.setcDate(appUtils.getCurrentTimeStamp());
            remoteDBModel.setStatus(1);

            return new RemoteWSDTO(remoteRepository.save(remoteDBModel));
        }
        return null;
    }


    public RemoteWSDTO updateRemoteService(long userId, String remoteId,String remote,String remoteDesc,String remoteVersion) {

        Optional<RemoteDBModel>remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent()) {

            remoteDBModel.get().setRemote(remote);
            remoteDBModel.get().setRemoteDesc(remoteDesc);
            remoteDBModel.get().setRemoteVersion(remoteVersion);
            remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new RemoteWSDTO(remoteRepository.save(remoteDBModel.get()));
        }
        return null;
    }


    public RemoteWSDTO removeRemoteService(long userId,String remoteId) {

        Optional<RemoteDBModel>remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent()) {
            remoteRepository.delete(remoteDBModel.get());
            return new RemoteWSDTO(remoteDBModel.get());
        }
        return null;
    }


}
