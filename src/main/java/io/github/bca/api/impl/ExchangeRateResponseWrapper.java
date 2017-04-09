package io.github.bca.api.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bca.api.ExchangeRate;

import java.io.Serializable;
import java.util.List;

class ExchangeRateResponseWrapper implements Serializable {

    @JsonProperty("RateDetail")
    private List<ExchangeRate> exchangeRateList;

    List<ExchangeRate> getExchangeRateList() {
        return exchangeRateList;
    }
}
