package com.faas.core.base.model.ws.utils.config;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.config.dto.CountryWSDTO;

import java.util.List;

public class CountryWSModel {

    private GeneralWSModel general;
    private List<CountryWSDTO>countries;

    public CountryWSModel() {
    }

    public CountryWSModel(GeneralWSModel general, List<CountryWSDTO> countries) {
        this.general = general;
        this.countries = countries;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CountryWSDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryWSDTO> countries) {
        this.countries = countries;
    }
}
