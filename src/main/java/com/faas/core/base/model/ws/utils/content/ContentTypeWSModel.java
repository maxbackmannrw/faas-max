package com.faas.core.base.model.ws.utils.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.content.dto.ContentTypeWSDTO;

import java.util.List;

public class ContentTypeWSModel {

    private GeneralWSModel general;
    private List<ContentTypeWSDTO> contentTypes;


    public ContentTypeWSModel() {
    }

    public ContentTypeWSModel(GeneralWSModel general, List<ContentTypeWSDTO> contentTypes) {
        this.general = general;
        this.contentTypes = contentTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ContentTypeWSDTO> getContentTypes() {
        return contentTypes;
    }

    public void setContentTypes(List<ContentTypeWSDTO> contentTypes) {
        this.contentTypes = contentTypes;
    }
}
