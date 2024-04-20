package com.faas.core.base.model.ws.utility.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utility.content.dto.UrlWSDTO;

import java.util.List;

public class UrlWSModel {

    private GeneralWSModel general;
    private List<UrlWSDTO> urls;

    public UrlWSModel() {
    }

    public UrlWSModel(GeneralWSModel general, List<UrlWSDTO> urls) {
        this.general = general;
        this.urls = urls;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<UrlWSDTO> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlWSDTO> urls) {
        this.urls = urls;
    }
}
