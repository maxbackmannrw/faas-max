package com.faas.core.base.framework.remote.content;

import com.faas.core.data.db.remote.content.RemoteDBModel;
import com.faas.core.data.db.remote.settings.RemoteTypeDBModel;
import com.faas.core.data.ws.base.remote.content.dto.RemoteWSDTO;
import com.faas.core.data.repo.remote.content.RemoteRepository;
import com.faas.core.data.repo.remote.details.RemoteUrlRepository;
import com.faas.core.data.repo.remote.settings.RemoteTypeRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.remote.RemoteHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RemoteFramework {

    @Autowired
    RemoteHelpers remoteHelpers;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    RemoteTypeRepository remoteTypeRepository;

    @Autowired
    RemoteUrlRepository remoteUrlRepository;

    @Autowired
    AppUtils appUtils;


    public List<RemoteWSDTO> getAllRemotesService(long userId) {

        List<RemoteWSDTO> remoteWSDTOS = new ArrayList<>();
        List<RemoteDBModel> remoteDBModels = remoteRepository.findByStatus(1);
        for (RemoteDBModel remoteDBModel : remoteDBModels) {
            remoteWSDTOS.add(remoteHelpers.mapRemoteWSDTOHelper(remoteDBModel));
        }
        return remoteWSDTOS;
    }

    public List<RemoteWSDTO> getRemotesByBaseTypeService(long userId, String baseType) {

        List<RemoteWSDTO> remoteWSDTOS = new ArrayList<>();
        List<RemoteDBModel> remoteDBModels = remoteRepository.findByBaseType(baseType);
        for (RemoteDBModel remoteDBModel : remoteDBModels) {
            remoteWSDTOS.add(remoteHelpers.mapRemoteWSDTOHelper(remoteDBModel));
        }
        return remoteWSDTOS;
    }

    public List<RemoteWSDTO> getRemotesByTypeService(long userId, String remoteType) {

        List<RemoteWSDTO> remoteWSDTOS = new ArrayList<>();
        List<RemoteDBModel> remoteDBModels = remoteRepository.findByRemoteType(remoteType);
        for (RemoteDBModel remoteDBModel : remoteDBModels) {
            remoteWSDTOS.add(remoteHelpers.mapRemoteWSDTOHelper(remoteDBModel));
        }
        return remoteWSDTOS;
    }

    public RemoteWSDTO getRemoteService(long userId, String remoteId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent()) {
            return remoteHelpers.mapRemoteWSDTOHelper(remoteDBModel.get());
        }
        return null;
    }

    public RemoteWSDTO createRemoteService(long userId, String remote, String remoteDesc, String version, String baseUrl, long typeId) {

        Optional<RemoteTypeDBModel> remoteTypeDBModel = remoteTypeRepository.findById(typeId);
        if (remoteTypeDBModel.isPresent()) {

            RemoteDBModel remoteDBModel = new RemoteDBModel();
            remoteDBModel.setRemote(remote);
            remoteDBModel.setRemoteDesc(remoteDesc);
            remoteDBModel.setVersion(version);
            remoteDBModel.setRemoteDatas(new ArrayList<>());
            remoteDBModel.setTypeId(typeId);
            remoteDBModel.setRemoteType(remoteTypeDBModel.get().getRemoteType());
            remoteDBModel.setBaseType(remoteTypeDBModel.get().getBaseType());
            remoteDBModel.setuDate(appUtils.getCurrentTimeStamp());
            remoteDBModel.setcDate(appUtils.getCurrentTimeStamp());
            remoteDBModel.setStatus(1);

            remoteDBModel = remoteRepository.save(remoteDBModel);
            if (baseUrl != null) {
                remoteUrlRepository.save(remoteHelpers.createRemoteUrlHelper(remoteDBModel.getId(), baseUrl, AppConstant.BASE_URL));
            }
            return remoteHelpers.mapRemoteWSDTOHelper(remoteDBModel);
        }
        return null;
    }

    public RemoteWSDTO updateRemoteService(long userId, String remoteId, String remote, String remoteDesc, String version) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent()) {

            remoteDBModel.get().setRemote(remote);
            remoteDBModel.get().setRemoteDesc(remoteDesc);
            remoteDBModel.get().setVersion(version);
            remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return remoteHelpers.mapRemoteWSDTOHelper(remoteRepository.save(remoteDBModel.get()));
        }
        return null;
    }

    public RemoteWSDTO removeRemoteService(long userId, String remoteId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent()) {
            remoteRepository.delete(remoteDBModel.get());
            return remoteHelpers.mapRemoteWSDTOHelper(remoteDBModel.get());
        }
        return null;
    }


}
