package com.faas.core.data.ws.base.utilz.config;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.utilz.config.dto.CityWSDTO;

import java.util.List;

public class CityWSModel {

    private GeneralWSModel general;
    private List<CityWSDTO> cities;


    public CityWSModel() {
    }

    public CityWSModel(GeneralWSModel general, List<CityWSDTO> cities) {
        this.general = general;
        this.cities = cities;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CityWSDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityWSDTO> cities) {
        this.cities = cities;
    }
}
