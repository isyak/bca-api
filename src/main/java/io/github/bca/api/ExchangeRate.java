package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class ExchangeRate implements Serializable {

    @JsonProperty("LastUpdate")
    private Timestamp lastUpdate;

    @JsonProperty("CurrencyCode")
    private String currencyCode;

    @JsonProperty("Buy")
    private BigDecimal buyRate;

    @JsonProperty("Sell")
    private BigDecimal sellRate;

    @JsonProperty("Middle")
    private BigDecimal middleRate;

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    public BigDecimal getMiddleRate() {
        return middleRate;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "lastUpdate=" + lastUpdate +
                ", currencyCode='" + currencyCode + '\'' +
                ", buyRate=" + buyRate +
                ", sellRate=" + sellRate +
                ", middleRate=" + middleRate +
                '}';
    }
}
