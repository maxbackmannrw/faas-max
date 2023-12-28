package com.faas.core.base.framework.remote.app;

import com.faas.core.base.model.db.remote.app.RemoteDBModel;
import com.faas.core.base.model.db.remote.app.dao.RemoteDataDAO;
import com.faas.core.base.model.db.remote.app.dao.RemoteUrlDAO;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteDataWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteDetailsWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteUrlWSDTO;
import com.faas.core.base.repo.remote.app.RemoteRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteDatas() != null){
            for (int i=0;i<remoteDBModel.get().getRemoteDatas().size();i++){
                remoteDataWSDTOS.add(new RemoteDataWSDTO(remoteDBModel.get().getRemoteDatas().get(i)));
            }
        }
        return remoteDataWSDTOS;
    }

    public RemoteDataWSDTO getRemoteDataService(long userId,String remoteId,String dataId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteDatas() != null){
            for (int i=0;i<remoteDBModel.get().getRemoteDatas().size();i++){
                if (remoteDBModel.get().getRemoteDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new RemoteDataWSDTO(remoteDBModel.get().getRemoteDatas().get(i));
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
            if (remoteDBModel.get().getRemoteDatas() == null){
                List<RemoteDataDAO> remoteDataDAOS = new ArrayList<>();
                remoteDataDAOS.add(remoteDataDAO);
                remoteDBModel.get().setRemoteDatas(remoteDataDAOS);
            }else {
                remoteDBModel.get().getRemoteDatas().add(remoteDataDAO);
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
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<remoteDBModel.get().getRemoteDatas().size();i++){
                if (remoteDBModel.get().getRemoteDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

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
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteDatas() != null){
            for (int i=0;i<remoteDBModel.get().getRemoteDatas().size();i++){
                if (remoteDBModel.get().getRemoteDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

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



    public List<RemoteUrlWSDTO> getRemoteUrlsService(long userId, String remoteId) {

        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteUrls() != null){
            for (int i=0;i<remoteDBModel.get().getRemoteUrls().size();i++){
                remoteUrlWSDTOS.add(new RemoteUrlWSDTO(remoteDBModel.get().getRemoteUrls().get(i)));
            }
        }
        return remoteUrlWSDTOS;
    }

    public RemoteUrlWSDTO getRemoteUrlService(long userId,String remoteId,String urlId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteUrls() != null){
            for (int i=0;i<remoteDBModel.get().getRemoteUrls().size();i++){
                if (remoteDBModel.get().getRemoteUrls().get(i).getId().equalsIgnoreCase(urlId)){
                    return new RemoteUrlWSDTO(remoteDBModel.get().getRemoteUrls().get(i));
                }
            }
        }
        return null;
    }

    public RemoteUrlWSDTO createRemoteUrlService(long userId,String remoteId,String remoteUrl,String urlType) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent()){

            RemoteUrlDAO remoteUrlDAO = new RemoteUrlDAO();
            remoteUrlDAO.setId(appUtils.generateUUID());
            remoteUrlDAO.setRemoteUrl(remoteUrl);
            remoteUrlDAO.setUrlType(urlType);
            remoteUrlDAO.setcDate(appUtils.getCurrentTimeStamp());
            remoteUrlDAO.setStatus(1);

            if (remoteDBModel.get().getRemoteUrls() == null){
                List<RemoteUrlDAO> remoteUrlDAOS = new ArrayList<>();
                remoteUrlDAOS.add(remoteUrlDAO);
                remoteDBModel.get().setRemoteUrls(remoteUrlDAOS);
            }else {
                remoteDBModel.get().getRemoteUrls().add(remoteUrlDAO);
            }
            remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            remoteRepository.save(remoteDBModel.get());

            return new RemoteUrlWSDTO(remoteUrlDAO);
        }
        return null;
    }

    public RemoteUrlWSDTO updateRemoteUrlService(long userId,String remoteId,String urlId,String remoteUrl,String urlType) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteUrls() != null){
            for (int i=0;i<remoteDBModel.get().getRemoteUrls().size();i++){
                if (remoteDBModel.get().getRemoteUrls().get(i).getId().equalsIgnoreCase(urlId)){

                    remoteDBModel.get().getRemoteUrls().get(i).setRemoteUrl(remoteUrl);
                    remoteDBModel.get().getRemoteUrls().get(i).setUrlType(urlType);
                    remoteDBModel.get().getRemoteUrls().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    remoteDBModel.get().getRemoteUrls().get(i).setStatus(1);
                    remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    remoteRepository.save(remoteDBModel.get());

                    return new RemoteUrlWSDTO(remoteDBModel.get().getRemoteUrls().get(i));
                }
            }
        }
        return null;
    }

    public RemoteUrlWSDTO removeRemoteUrlService(long userId,String remoteId,String urlId) {

        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent() && remoteDBModel.get().getRemoteUrls() != null){
            for (int i=0;i<remoteDBModel.get().getRemoteUrls().size();i++){
                if (remoteDBModel.get().getRemoteUrls().get(i).getId().equalsIgnoreCase(urlId)){
                    RemoteUrlDAO remoteUrlDAO = remoteDBModel.get().getRemoteUrls().get(i);
                    remoteDBModel.get().getRemoteUrls().remove(remoteUrlDAO);
                    remoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    remoteRepository.save(remoteDBModel.get());

                    return new RemoteUrlWSDTO(remoteUrlDAO);
                }
            }
        }
        return null;
    }


}
