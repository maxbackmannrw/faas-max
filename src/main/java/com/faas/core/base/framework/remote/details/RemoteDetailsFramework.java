package com.faas.core.base.framework.remote.details;

import com.faas.core.data.db.remote.content.RemoteDBModel;
import com.faas.core.data.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.data.db.utils.DataTypeDBModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteDataWSDTO;
import com.faas.core.base.model.ws.remote.details.dto.RemoteDetailsWSDTO;
import com.faas.core.data.repo.remote.content.RemoteRepository;
import com.faas.core.data.repo.utils.DataTypeRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.remote.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RemoteDetailsFramework {

    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteDetailsWSDTO getRemoteDetailsService(long userId, String remoteId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent()) {
            RemoteDetailsWSDTO remoteDetailsWSDTO = new RemoteDetailsWSDTO();
            remoteDetailsWSDTO.setRemote(remoteDBModel.get());
            return remoteDetailsWSDTO;
        }
        return null;
    }

    public List<RemoteDataWSDTO> getRemoteDatasService(long userId, String remoteId) {

        List<RemoteDataWSDTO> remoteDataWSDTOS = new ArrayList<>();
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteDatas() != null) {
            for (int i = 0; i < remoteDBModel.get().getRemoteDatas().size(); i++) {
                remoteDataWSDTOS.add(new RemoteDataWSDTO(remoteDBModel.get().getRemoteDatas().get(i)));
            }
        }
        return remoteDataWSDTOS;
    }

    public RemoteDataWSDTO getRemoteDataService(long userId, String remoteId, String dataId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteDatas() != null) {
            for (int i = 0; i < remoteDBModel.get().getRemoteDatas().size(); i++) {
                if (remoteDBModel.get().getRemoteDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {
                    return new RemoteDataWSDTO(remoteDBModel.get().getRemoteDatas().get(i));
                }
            }
        }
        return null;
    }

    public RemoteDataWSDTO createRemoteDataService(long userId, String remoteId, long typeId, String value) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (remoteDBModel.isPresent() && dataTypeDBModel.isPresent()) {
            RemoteDataDAO remoteDataDAO = remoteHelper.createRemoteDataDAO(appUtils.generateUUID(), dataTypeDBModel.get().getDataType(), value);
            if (remoteDBModel.get().getRemoteDatas() == null) {
                List<RemoteDataDAO> remoteDataDAOS = new ArrayList<>();
                remoteDataDAOS.add(remoteDataDAO);
                remoteDBModel.get().setRemoteDatas(remoteDataDAOS);
            } else {
                remoteDBModel.get().getRemoteDatas().add(remoteDataDAO);
            }
            remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            remoteRepository.save(remoteDBModel.get());

            return new RemoteDataWSDTO(remoteDataDAO);
        }
        return null;
    }

    public RemoteDataWSDTO updateRemoteDataService(long userId, String remoteId, String dataId, long typeId, String value) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteDatas() != null && dataTypeDBModel.isPresent()) {
            for (int i = 0; i < remoteDBModel.get().getRemoteDatas().size(); i++) {
                if (remoteDBModel.get().getRemoteDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    remoteDBModel.get().getRemoteDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    remoteDBModel.get().getRemoteDatas().get(i).setValue(value);
                    remoteDBModel.get().getRemoteDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    remoteDBModel.get().getRemoteDatas().get(i).setStatus(1);
                    remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    remoteRepository.save(remoteDBModel.get());

                    return new RemoteDataWSDTO(remoteDBModel.get().getRemoteDatas().get(i));
                }
            }
            return new RemoteDataWSDTO();
        }
        return null;
    }

    public RemoteDataWSDTO removeRemoteDataService(long userId, String remoteId, String dataId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteDatas() != null) {
            for (int i = 0; i < remoteDBModel.get().getRemoteDatas().size(); i++) {
                if (remoteDBModel.get().getRemoteDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    RemoteDataDAO remoteDataDAO = remoteDBModel.get().getRemoteDatas().get(i);
                    remoteDBModel.get().getRemoteDatas().remove(remoteDataDAO);
                    remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    remoteRepository.save(remoteDBModel.get());

                    return new RemoteDataWSDTO(remoteDataDAO);
                }
            }
            return new RemoteDataWSDTO();
        }
        return null;
    }


}
