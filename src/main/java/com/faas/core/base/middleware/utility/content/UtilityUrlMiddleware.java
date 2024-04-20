package com.faas.core.base.middleware.utility.content;

import com.faas.core.base.framework.utility.content.UtilityUrlFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utility.content.UrlWSModel;
import com.faas.core.base.model.ws.utility.content.dto.DataTypeWSDTO;
import com.faas.core.base.model.ws.utility.content.dto.UrlWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UtilityUrlMiddleware {


    @Autowired
    UtilityUrlFramework utilityUrlFramework;


    public UrlWSModel getAllUrls(long userId) {

        UrlWSModel response = new UrlWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<UrlWSDTO> urlWSDTOS = utilityUrlFramework.getAllUrlsService(userId);
        if (urlWSDTOS != null){
            response.setUrls(urlWSDTOS);
        }

        general.setOperation("getAllUrls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public UrlWSModel getUrlsByBaseType(long userId,String baseType) {

        UrlWSModel response = new UrlWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<UrlWSDTO> urlWSDTOS = utilityUrlFramework.getUrlsByBaseTypeService(userId,baseType);
        if (urlWSDTOS != null){
            response.setUrls(urlWSDTOS);
        }

        general.setOperation("getUrlsByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public UrlWSModel getUrlsByOwnerId(long userId,String baseType, String ownerId) {

        UrlWSModel response = new UrlWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<UrlWSDTO> urlWSDTOS = utilityUrlFramework.getUrlsByOwnerIdService(userId,baseType,ownerId);
        if (urlWSDTOS != null){
            response.setUrls(urlWSDTOS);
        }

        general.setOperation("getUrlsByOwnerId");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public UrlWSModel getUrl(long userId, long urlId) {

        UrlWSModel response = new UrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UrlWSDTO> urlWSDTOS = new ArrayList<>();

        UrlWSDTO urlWSDTO = utilityUrlFramework.getUrlService(userId,urlId);
        if (urlWSDTO != null){
            urlWSDTOS.add(urlWSDTO);
        }

        response.setUrls(urlWSDTOS);
        general.setOperation("getUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public UrlWSModel createUrl(long userId,String url,String urlType,String baseType,String ownerId) {

        UrlWSModel response = new UrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UrlWSDTO> urlWSDTOS = new ArrayList<>();

        UrlWSDTO urlWSDTO = utilityUrlFramework.createUrlService(userId,url,urlType,baseType,ownerId);
        if (urlWSDTO != null){
            urlWSDTOS.add(urlWSDTO);
        }

        response.setUrls(urlWSDTOS);
        general.setOperation("createUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public UrlWSModel updateUrl(long userId,long urlId,String url,String urlType,String ownerId) {

        UrlWSModel response = new UrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UrlWSDTO> urlWSDTOS = new ArrayList<>();

        UrlWSDTO urlWSDTO = utilityUrlFramework.updateUrlService(userId,urlId,url,urlType,ownerId);
        if (urlWSDTO != null){
            urlWSDTOS.add(urlWSDTO);
        }

        response.setUrls(urlWSDTOS);
        general.setOperation("updateUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public UrlWSModel removeUrl(long userId,long urlId) {

        UrlWSModel response = new UrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<UrlWSDTO> urlWSDTOS = new ArrayList<>();

        UrlWSDTO urlWSDTO = utilityUrlFramework.removeUrlService(userId,urlId);
        if (urlWSDTO != null){
            urlWSDTOS.add(urlWSDTO);
        }

        response.setUrls(urlWSDTOS);
        general.setOperation("removeUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
