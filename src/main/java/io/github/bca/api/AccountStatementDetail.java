package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountStatementDetail implements Serializable {

    @JsonProperty("TransactionDate")
    private String transactionDate;

    @JsonProperty("BranchCode")
    private String branchCode;

    @JsonProperty("TransactionType")
    private TransactionType transactionType;

    @JsonProperty("TransactionAmount")
    private BigDecimal amount;

    @JsonProperty("TransactionName")
    private String name;

    @JsonProperty("Trailer")
    private String remark;

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return "AccountStatementDetail{" +
                "branchCode='" + branchCode + '\'' +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}
