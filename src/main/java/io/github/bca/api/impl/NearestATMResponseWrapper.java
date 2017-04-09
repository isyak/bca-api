package io.github.bca.api.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bca.api.ATM;

import java.io.Serializable;
import java.util.List;

class NearestATMResponseWrapper implements Serializable {

    @JsonProperty("ATMDetails")
    private List<ATM> atmList;

    List<ATM> getAtmList() {
        return atmList;
    }
}