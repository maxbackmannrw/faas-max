package com.faas.core.base.model.ws.utility.content.dto;

import com.faas.core.base.model.db.utility.UrlDBModel;

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
