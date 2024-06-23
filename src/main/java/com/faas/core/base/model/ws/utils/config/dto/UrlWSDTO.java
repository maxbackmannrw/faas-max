package com.faas.core.base.model.ws.utils.config.dto;

import com.faas.core.base.model.db.utils.UrlDBModel;

public class UrlWSDTO {

   private UrlDBModel url;

    public UrlWSDTO() {
    }

    public UrlWSDTO(UrlDBModel url) {
        this.url = url;
    }

    public UrlDBModel getUrl() {
        return url;
    }

    public void setUrl(UrlDBModel url) {
        this.url = url;
    }
}
