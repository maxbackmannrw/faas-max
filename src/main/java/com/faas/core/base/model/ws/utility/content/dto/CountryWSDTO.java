package com.faas.core.base.model.ws.utility.content.dto;

import com.faas.core.base.model.db.utility.CountryDBModel;

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
