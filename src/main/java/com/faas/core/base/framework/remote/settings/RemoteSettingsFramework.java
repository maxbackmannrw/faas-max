package com.faas.core.base.framework.remote.settings;

import com.faas.core.data.db.remote.settings.RemoteTypeDBModel;
import com.faas.core.base.model.ws.remote.settings.dto.RemoteTypeWSDTO;
import com.faas.core.data.repo.remote.settings.RemoteTypeRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RemoteSettingsFramework {


    @Autowired
    RemoteTypeRepository remoteTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<RemoteTypeWSDTO> getAllRemoteTypesService(long userId) {

        List<RemoteTypeWSDTO> remoteTypeWSDTOS = new ArrayList<>();
        List<RemoteTypeDBModel> remoteTypeDBModels = remoteTypeRepository.findByStatus(1);
        for (RemoteTypeDBModel remoteTypeDBModel : remoteTypeDBModels) {
            remoteTypeWSDTOS.add(new RemoteTypeWSDTO(remoteTypeDBModel));
        }
        return remoteTypeWSDTOS;
    }

    public List<RemoteTypeWSDTO> getRemoteTypesByBaseTypeService(long userId, String baseType) {

        List<RemoteTypeWSDTO> remoteTypeWSDTOS = new ArrayList<>();
        List<RemoteTypeDBModel> remoteTypeDBModels = remoteTypeRepository.findByBaseType(baseType);
        for (RemoteTypeDBModel remoteTypeDBModel : remoteTypeDBModels) {
            remoteTypeWSDTOS.add(new RemoteTypeWSDTO(remoteTypeDBModel));
        }
        return remoteTypeWSDTOS;
    }

    public RemoteTypeWSDTO getRemoteTypeService(long userId, long remoteTypeId) {

        Optional<RemoteTypeDBModel> remoteTypeDBModel = remoteTypeRepository.findById(remoteTypeId);
        if (remoteTypeDBModel.isPresent()) {
            return new RemoteTypeWSDTO(remoteTypeDBModel.get());
        }
        return null;
    }

    public RemoteTypeWSDTO createRemoteTypeService(long userId, String remoteType, String baseType) {

        RemoteTypeDBModel remoteTypeDBModel = new RemoteTypeDBModel();
        remoteTypeDBModel.setRemoteType(remoteType);
        remoteTypeDBModel.setBaseType(baseType);
        remoteTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        remoteTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        remoteTypeDBModel.setStatus(1);

        return new RemoteTypeWSDTO(remoteTypeRepository.save(remoteTypeDBModel));
    }

    public RemoteTypeWSDTO updateRemoteTypeService(long userId, long remoteTypeId, String remoteType, String baseType) {

        Optional<RemoteTypeDBModel> remoteTypeDBModel = remoteTypeRepository.findById(remoteTypeId);
        if (remoteTypeDBModel.isPresent()) {
            remoteTypeDBModel.get().setRemoteType(remoteType);
            remoteTypeDBModel.get().setBaseType(baseType);
            remoteTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            remoteTypeDBModel.get().setStatus(1);

            return new RemoteTypeWSDTO(remoteTypeRepository.save(remoteTypeDBModel.get()));
        }
        return null;
    }

    public RemoteTypeWSDTO removeRemoteTypeService(long userId, long remoteTypeId) {

        Optional<RemoteTypeDBModel> remoteTypeDBModel = remoteTypeRepository.findById(remoteTypeId);
        if (remoteTypeDBModel.isPresent()) {
            remoteTypeRepository.delete(remoteTypeDBModel.get());
            return new RemoteTypeWSDTO(remoteTypeDBModel.get());
        }
        return null;
    }


}
