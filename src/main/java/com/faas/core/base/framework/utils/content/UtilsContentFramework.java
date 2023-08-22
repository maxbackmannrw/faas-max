package com.faas.core.base.framework.utils.content;

import com.faas.core.base.model.db.utils.content.ContentTypeDBModel;
import com.faas.core.base.model.ws.utils.content.dto.ContentTypeWSDTO;
import com.faas.core.base.repo.utils.content.ContentTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class UtilsContentFramework {


    @Autowired
    ContentTypeRepository contentTypeRepository;

    @Autowired
    AppUtils appUtils;


    public List<ContentTypeWSDTO> getAllContentTypesService(long userId) {

        List<ContentTypeWSDTO> contentTypeWSDTOS = new ArrayList<>();
        List<ContentTypeDBModel> contentTypeDBModels = contentTypeRepository.findByStatus(1);
        for (ContentTypeDBModel contentTypeDBModel : contentTypeDBModels) {
            contentTypeWSDTOS.add(new ContentTypeWSDTO(contentTypeDBModel));
        }
        return contentTypeWSDTOS;
    }

    public List<ContentTypeWSDTO> getContentTypesByBaseTypeService(String baseType) {

        List<ContentTypeWSDTO> contentTypeWSDTOS = new ArrayList<>();
        List<ContentTypeDBModel> contentTypeDBModels = contentTypeRepository.findByBaseType(baseType);
        for (ContentTypeDBModel contentTypeDBModel : contentTypeDBModels) {
            contentTypeWSDTOS.add(new ContentTypeWSDTO(contentTypeDBModel));
        }
        return contentTypeWSDTOS;
    }


    public ContentTypeWSDTO getContentTypeService(long typeId) {

        Optional<ContentTypeDBModel> contentTypeDBModel = contentTypeRepository.findById(typeId);
        if (contentTypeDBModel.isPresent()) {
            return new ContentTypeWSDTO(contentTypeDBModel.get());
        }
        return null;
    }


    public ContentTypeWSDTO createContentTypeService(String contentType, String baseType) {

        ContentTypeDBModel contentTypeDBModel = new ContentTypeDBModel();
        contentTypeDBModel.setContentType(contentType);
        contentTypeDBModel.setBaseType(baseType);
        contentTypeDBModel.setuDate(appUtils.getCurrentTimeStamp());
        contentTypeDBModel.setcDate(appUtils.getCurrentTimeStamp());
        contentTypeDBModel.setStatus(1);

        return new ContentTypeWSDTO(contentTypeRepository.save(contentTypeDBModel));
    }


    public ContentTypeWSDTO updateContentTypeService(long typeId, String contentType, String baseType) {

        Optional<ContentTypeDBModel> contentTypeDBModel = contentTypeRepository.findById(typeId);
        if (contentTypeDBModel.isPresent()) {
            contentTypeDBModel.get().setContentType(contentType);
            contentTypeDBModel.get().setBaseType(baseType);
            contentTypeDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return new ContentTypeWSDTO(contentTypeRepository.save(contentTypeDBModel.get()));
        }
        return null;
    }


    public ContentTypeWSDTO removeContentTypeService(long typeId) {

        Optional<ContentTypeDBModel> contentTypeDBModel = contentTypeRepository.findById(typeId);
        if (contentTypeDBModel.isPresent()) {
            contentTypeRepository.delete(contentTypeDBModel.get());
            return new ContentTypeWSDTO(contentTypeDBModel.get());
        }
        return null;
    }


}
