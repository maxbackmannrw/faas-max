package com.faas.core.base.framework.utility.content;

import com.faas.core.base.model.db.utility.UrlDBModel;
import com.faas.core.base.model.ws.utility.content.dto.DataTypeWSDTO;
import com.faas.core.base.model.ws.utility.content.dto.UrlWSDTO;
import com.faas.core.base.repo.utility.UrlRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UtilityUrlFramework {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    AppUtils appUtils;


    public List<UrlWSDTO> getAllUrlsService(long userId) {

        List<UrlWSDTO>urlWSDTOS = new ArrayList<>();
        List<UrlDBModel> urlDBModels = urlRepository.findByStatus(1);
        for (UrlDBModel urlDBModel : urlDBModels) {
            urlWSDTOS.add(new UrlWSDTO(urlDBModel));
        }
        return urlWSDTOS;
    }

    public List<UrlWSDTO> getUrlsByBaseTypeService(long userId,String baseType) {

        List<UrlWSDTO>urlWSDTOS = new ArrayList<>();
        List<UrlDBModel> urlDBModels = urlRepository.findByBaseType(baseType);
        for (UrlDBModel urlDBModel : urlDBModels) {
            urlWSDTOS.add(new UrlWSDTO(urlDBModel));
        }
        return urlWSDTOS;
    }

    public List<UrlWSDTO> getUrlsByOwnerIdService(long userId,String baseType, String ownerId) {

        List<UrlWSDTO>urlWSDTOS = new ArrayList<>();
        List<UrlDBModel> urlDBModels = urlRepository.findByBaseTypeAndOwnerId(baseType,ownerId);
        for (UrlDBModel urlDBModel : urlDBModels) {
            urlWSDTOS.add(new UrlWSDTO(urlDBModel));
        }
        return urlWSDTOS;
    }

    public UrlWSDTO getUrlService(long userId, long urlId) {

        Optional<UrlDBModel> urlDBModel = urlRepository.findById(urlId);
        if (urlDBModel.isPresent()){
            return new UrlWSDTO(urlDBModel.get());
        }
        return null;
    }

    public UrlWSDTO createUrlService(long userId,String url,String urlType,String baseType,String ownerId) {

        UrlDBModel urlDBModel = new UrlDBModel();
        urlDBModel.setUrl(url);
        urlDBModel.setUrlType(urlType);
        urlDBModel.setBaseType(baseType);
        urlDBModel.setOwnerId(ownerId);
        urlDBModel.setuDate(appUtils.getCurrentTimeStamp());
        urlDBModel.setcDate(appUtils.getCurrentTimeStamp());
        urlDBModel.setStatus(1);

        return new UrlWSDTO(urlRepository.save(urlDBModel));
    }

    public UrlWSDTO updateUrlService(long userId,long urlId,String url,String urlType,String ownerId) {

        Optional<UrlDBModel> urlDBModel = urlRepository.findById(urlId);
        if (urlDBModel.isPresent()){

            urlDBModel.get().setUrl(url);
            urlDBModel.get().setUrlType(urlType);
            urlDBModel.get().setOwnerId(ownerId);
            urlDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            urlDBModel.get().setcDate(appUtils.getCurrentTimeStamp());
            urlDBModel.get().setStatus(1);

            return new UrlWSDTO(urlRepository.save(urlDBModel.get()));
        }
        return null;
    }

    public UrlWSDTO removeUrlService(long userId,long urlId) {

        Optional<UrlDBModel> urlDBModel = urlRepository.findById(urlId);
        if (urlDBModel.isPresent()){
            urlRepository.delete(urlDBModel.get());
            return new UrlWSDTO(urlDBModel.get());
        }
        return null;
    }


}
