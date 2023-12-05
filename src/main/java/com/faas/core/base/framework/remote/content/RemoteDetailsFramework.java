package com.faas.core.base.framework.remote.content;

import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteDataWSDTO;
import com.faas.core.base.model.ws.remote.content.dto.RemoteDetailsWSDTO;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
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
        if (remoteDBModel.isPresent()){
            RemoteDetailsWSDTO remoteDetailsWSDTO = new RemoteDetailsWSDTO();
            remoteDetailsWSDTO.setRemote(remoteDBModel.get());
            return remoteDetailsWSDTO;
        }
        return null;
    }


    public List<RemoteDataWSDTO> getRemoteDatasService(long userId, String remoteId) {

        List<RemoteDataWSDTO>remoteDataWSDTOS = new ArrayList<>();
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getDatas() != null){
            for (int i=0;i<remoteDBModel.get().getDatas().size();i++){
                remoteDataWSDTOS.add(new RemoteDataWSDTO(remoteDBModel.get().getDatas().get(i)));
            }
        }
        return remoteDataWSDTOS;
    }

    public RemoteDataWSDTO getRemoteDataService(long userId,String remoteId,String dataId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getDatas() != null){
            for (int i=0;i<remoteDBModel.get().getDatas().size();i++){
                if (remoteDBModel.get().getDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new RemoteDataWSDTO(remoteDBModel.get().getDatas().get(i));
                }
            }
        }
        return null;
    }

    public RemoteDataWSDTO createRemoteDataService(long userId,String remoteId,long typeId,String value) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (remoteDBModel.isPresent() && dataTypeDBModel.isPresent()){
            RemoteDataDAO remoteDataDAO = remoteHelper.createRemoteDataDAO(appUtils.generateUUID(),dataTypeDBModel.get().getDataType(),value);
            if (remoteDBModel.get().getDatas() == null){
                List<RemoteDataDAO> remoteDataDAOS = new ArrayList<>();
                remoteDataDAOS.add(remoteDataDAO);
                remoteDBModel.get().setDatas(remoteDataDAOS);
            }else {
                remoteDBModel.get().getDatas().add(remoteDataDAO);
            }
            remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            remoteRepository.save(remoteDBModel.get());

            return new RemoteDataWSDTO(remoteDataDAO);
        }
        return null;
    }

    public RemoteDataWSDTO updateRemoteDataService(long userId,String remoteId,String dataId,long typeId,String value) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<remoteDBModel.get().getDatas().size();i++){
                if (remoteDBModel.get().getDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    remoteDBModel.get().getDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    remoteDBModel.get().getDatas().get(i).setValue(value);
                    remoteDBModel.get().getDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    remoteDBModel.get().getDatas().get(i).setStatus(1);
                    remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    remoteRepository.save(remoteDBModel.get());

                    return new RemoteDataWSDTO(remoteDBModel.get().getDatas().get(i));
                }
            }
            return new RemoteDataWSDTO();
        }
        return null;
    }

    public RemoteDataWSDTO removeRemoteDataService(long userId, String remoteId, String dataId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getDatas() != null){
            for (int i=0;i<remoteDBModel.get().getDatas().size();i++){

                if (remoteDBModel.get().getDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    RemoteDataDAO remoteDataDAO = remoteDBModel.get().getDatas().get(i);
                    remoteDBModel.get().getDatas().remove(remoteDataDAO);
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
