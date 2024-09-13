package com.faas.core.base.model.ws.utilz.config.dto;

import com.faas.core.base.model.db.utilz.CountryDBModel;

public class CountryWSDTO {

    private CountryDBModel country;

    public CountryWSDTO() {
    }

    public CountryWSDTO(CountryDBModel country) {
        this.country = country;
    }

    public CountryDBModel getCountry() {
        return country;
    }

    public void setCountry(CountryDBModel country) {
        this.country = country;
    }
}
