package com.faas.core.base.model.ws.utilz.config.dto;

import com.faas.core.data.db.utilz.CityDBModel;

public class CityWSDTO {

    private CityDBModel city;

    public CityWSDTO() {
    }

    public CityWSDTO(CityDBModel city) {
        this.city = city;
    }

    public CityDBModel getCity() {
        return city;
    }

    public void setCity(CityDBModel city) {
        this.city = city;
    }
}
