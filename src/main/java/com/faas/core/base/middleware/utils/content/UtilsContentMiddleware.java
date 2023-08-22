package com.faas.core.base.middleware.utils.content;

import com.faas.core.base.framework.utils.content.UtilsContentFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.content.ContentTypeWSModel;
import com.faas.core.base.model.ws.utils.content.dto.ContentTypeWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UtilsContentMiddleware {


    @Autowired
    UtilsContentFramework utilsContentFramework;


    public ContentTypeWSModel getAllContentTypes(long userId) {

        ContentTypeWSModel response = new ContentTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ContentTypeWSDTO> contentTypeWSDTOS = utilsContentFramework.getAllContentTypesService(userId);
        if (contentTypeWSDTOS != null){
            response.setContentTypes(contentTypeWSDTOS);
        }

        general.setOperation("getAllContentTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ContentTypeWSModel getContentTypesByBaseType(long userId,String baseType) {

        ContentTypeWSModel response = new ContentTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ContentTypeWSDTO> contentTypeWSDTOS = utilsContentFramework.getContentTypesByBaseTypeService(baseType);
        if (contentTypeWSDTOS != null){
            response.setContentTypes(contentTypeWSDTOS);
        }

        general.setOperation("getContentTypesByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ContentTypeWSModel getContentType(long userId, long typeId) {

        ContentTypeWSModel response = new ContentTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ContentTypeWSDTO> contentTypeWSDTOS = new ArrayList<>();

        ContentTypeWSDTO contentTypeWSDTO = utilsContentFramework.getContentTypeService(typeId);
        if (contentTypeWSDTO != null){
            contentTypeWSDTOS.add(contentTypeWSDTO);
        }

        response.setContentTypes(contentTypeWSDTOS);
        general.setOperation("getContentType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ContentTypeWSModel createContentType(long userId, String contentType,String baseType) {

        ContentTypeWSModel response = new ContentTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ContentTypeWSDTO> contentTypeWSDTOS = new ArrayList<>();

        ContentTypeWSDTO contentTypeWSDTO = utilsContentFramework.createContentTypeService(contentType,baseType);
        if (contentTypeWSDTO != null){
            contentTypeWSDTOS.add(contentTypeWSDTO);
        }

        response.setContentTypes(contentTypeWSDTOS);
        general.setOperation("createContentType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ContentTypeWSModel updateContentType(long userId,long typeId,String contentType,String baseType) {

        ContentTypeWSModel response = new ContentTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ContentTypeWSDTO> contentTypeWSDTOS = new ArrayList<>();

        ContentTypeWSDTO contentTypeWSDTO = utilsContentFramework.updateContentTypeService(typeId,contentType,baseType);
        if (contentTypeWSDTO != null){
            contentTypeWSDTOS.add(contentTypeWSDTO);
        }

        response.setContentTypes(contentTypeWSDTOS);
        general.setOperation("updateContentType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ContentTypeWSModel removeContentType(long userId, long typeId) {

        ContentTypeWSModel response = new ContentTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ContentTypeWSDTO> contentTypeWSDTOS = new ArrayList<>();

        ContentTypeWSDTO contentTypeWSDTO = utilsContentFramework.removeContentTypeService(typeId);
        if (contentTypeWSDTO != null){
            contentTypeWSDTOS.add(contentTypeWSDTO);
        }

        response.setContentTypes(contentTypeWSDTOS);
        general.setOperation("removeContentType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
