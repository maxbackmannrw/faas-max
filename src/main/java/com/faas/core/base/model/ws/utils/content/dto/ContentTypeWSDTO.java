package com.faas.core.base.model.ws.utils.content.dto;

import com.faas.core.base.model.db.utils.content.ContentTypeDBModel;

public class ContentTypeWSDTO {

    private ContentTypeDBModel contentType;

    public ContentTypeWSDTO() {
    }

    public ContentTypeWSDTO(ContentTypeDBModel contentType) {
        this.contentType = contentType;
    }

    public ContentTypeDBModel getContentType() {
        return contentType;
    }

    public void setContentType(ContentTypeDBModel contentType) {
        this.contentType = contentType;
    }
}
