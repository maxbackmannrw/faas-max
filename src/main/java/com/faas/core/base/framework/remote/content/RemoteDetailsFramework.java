package com.faas.core.base.framework.remote.content;

import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;
import com.faas.core.base.model.db.utils.config.DataTypeDBModel;
import com.faas.core.base.model.db.utils.config.UrlDBModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteDataWSDTO;
import com.faas.core.base.model.ws.remote.content.dto.RemoteDetailsWSDTO;
import com.faas.core.base.model.ws.remote.content.dto.RemoteUrlWSDTO;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.utils.config.DataTypeRepository;
import com.faas.core.base.repo.utils.config.UrlRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.remote.RemoteHelper;
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
    UrlRepository urlRepository;

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
        List<UrlDBModel> urlDBModels = urlRepository.findByBaseTypeAndOwnerId(AppConstant.REMOTE_URL,remoteId);
        for (UrlDBModel urlDBModel : urlDBModels) {
            remoteUrlWSDTOS.add(new RemoteUrlWSDTO(urlDBModel));
        }
        return remoteUrlWSDTOS;
    }

    public RemoteUrlWSDTO getRemoteUrlService(long userId, long urlId) {

        Optional<UrlDBModel> urlDBModel = urlRepository.findById(urlId);
        if (urlDBModel.isPresent()) {
            return new RemoteUrlWSDTO(urlDBModel.get());
        }
        return null;
    }

    public RemoteUrlWSDTO createRemoteUrlService(long userId,String remoteId,String remoteUrl,String urlType) {

        UrlDBModel urlDBModel = new UrlDBModel();

        urlDBModel.setUrl(remoteUrl);
        urlDBModel.setUrlType(urlType);
        urlDBModel.setBaseType(AppConstant.REMOTE_URL);
        urlDBModel.setOwnerId(remoteId);
        urlDBModel.setuDate(appUtils.getCurrentTimeStamp());
        urlDBModel.setcDate(appUtils.getCurrentTimeStamp());
        urlDBModel.setStatus(1);

        return new RemoteUrlWSDTO(urlRepository.save(urlDBModel));
    }

    public RemoteUrlWSDTO updateRemoteUrlService(long userId,long urlId,String remoteId,String remoteUrl,String urlType) {

        Optional<UrlDBModel> urlDBModel = urlRepository.findById(urlId);
        if (urlDBModel.isPresent()){

            urlDBModel.get().setUrl(remoteUrl);
            urlDBModel.get().setUrlType(urlType);
            urlDBModel.get().setOwnerId(remoteId);
            urlDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            urlDBModel.get().setStatus(1);

            return new RemoteUrlWSDTO(urlRepository.save(urlDBModel.get()));
        }
        return null;
    }

    public RemoteUrlWSDTO removeRemoteUrlService(long userId,long urlId) {

        Optional<UrlDBModel> urlDBModel = urlRepository.findById(urlId);
        if (urlDBModel.isPresent()) {
            urlRepository.delete(urlDBModel.get());
            return new RemoteUrlWSDTO(urlDBModel.get());
        }
        return null;
    }



}
