package com.faas.core.base.framework.remote.details;

import com.faas.core.data.db.remote.details.RemoteUrlDBModel;
import com.faas.core.data.ws.base.remote.details.dto.RemoteUrlWSDTO;
import com.faas.core.data.repo.remote.details.RemoteUrlRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RemoteUrlFramework {


    @Autowired
    RemoteUrlRepository remoteUrlRepository;

    @Autowired
    AppUtils appUtils;

    public List<RemoteUrlWSDTO> getAllRemoteUrlsService(long userId) {

        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();
        List<RemoteUrlDBModel> remoteUrlDBModels = remoteUrlRepository.findByStatus(1);
        for (RemoteUrlDBModel remoteUrlDBModel : remoteUrlDBModels) {
            remoteUrlWSDTOS.add(new RemoteUrlWSDTO(remoteUrlDBModel));
        }
        return remoteUrlWSDTOS;
    }

    public List<RemoteUrlWSDTO> getRemoteUrlsService(long userId, String remoteId) {

        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();
        List<RemoteUrlDBModel> remoteUrlDBModels = remoteUrlRepository.findByRemoteId(remoteId);
        for (RemoteUrlDBModel remoteUrlDBModel : remoteUrlDBModels) {
            remoteUrlWSDTOS.add(new RemoteUrlWSDTO(remoteUrlDBModel));
        }
        return remoteUrlWSDTOS;
    }

    public RemoteUrlWSDTO getRemoteUrlService(long userId, long urlId) {

        Optional<RemoteUrlDBModel> urlDBModel = remoteUrlRepository.findById(urlId);
        if (urlDBModel.isPresent()) {
            return new RemoteUrlWSDTO(urlDBModel.get());
        }
        return null;
    }

    public RemoteUrlWSDTO createRemoteUrlService(long userId, String remoteId, String remoteUrl, String urlType) {

        RemoteUrlDBModel remoteUrlDBModel = new RemoteUrlDBModel();
        remoteUrlDBModel.setRemoteId(remoteId);
        remoteUrlDBModel.setRemoteUrl(remoteUrl);
        remoteUrlDBModel.setUrlType(urlType);
        remoteUrlDBModel.setuDate(appUtils.getCurrentTimeStamp());
        remoteUrlDBModel.setcDate(appUtils.getCurrentTimeStamp());
        remoteUrlDBModel.setStatus(1);

        return new RemoteUrlWSDTO(remoteUrlRepository.save(remoteUrlDBModel));
    }

    public RemoteUrlWSDTO updateRemoteUrlService(long userId, long urlId, String remoteUrl, String urlType) {

        Optional<RemoteUrlDBModel> remoteUrlDBModel = remoteUrlRepository.findById(urlId);
        if (remoteUrlDBModel.isPresent()) {

            remoteUrlDBModel.get().setRemoteUrl(remoteUrl);
            remoteUrlDBModel.get().setUrlType(urlType);
            remoteUrlDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            remoteUrlDBModel.get().setStatus(1);

            return new RemoteUrlWSDTO(remoteUrlRepository.save(remoteUrlDBModel.get()));
        }
        return null;
    }

    public RemoteUrlWSDTO removeRemoteUrlService(long userId, long urlId) {

        Optional<RemoteUrlDBModel> urlDBModel = remoteUrlRepository.findById(urlId);
        if (urlDBModel.isPresent()) {
            remoteUrlRepository.delete(urlDBModel.get());
            return new RemoteUrlWSDTO(urlDBModel.get());
        }
        return null;
    }


}
