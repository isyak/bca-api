package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TransactionResponse implements Serializable {

    @JsonProperty("TransactionID")
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }
}
