package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class AccountStatement implements Serializable {

    @JsonProperty("Currency")
    private String currencyCode;

    @JsonProperty("StartBalance")
    private BigDecimal startBalance;

    @JsonProperty("Data")
    private List<AccountStatementDetail> accountStatementDetailList;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public BigDecimal getStartBalance() {
        return startBalance;
    }

    public List<AccountStatementDetail> getAccountStatementDetailList() {
        return accountStatementDetailList;
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
                "currencyCode='" + currencyCode + '\'' +
                ", startBalance=" + startBalance +
                ", accountStatementDetailList=" + accountStatementDetailList +
                '}';
    }
}
