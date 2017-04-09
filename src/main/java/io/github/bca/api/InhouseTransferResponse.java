package io.github.bca.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Date;

public class InhouseTransferResponse extends TransactionResponse {

    @JsonProperty("TransactionDate")
    private Date transactionDate;

    @JsonProperty("ReferenceID")
    private String referenceId;

    @JsonProperty("Status")
    private String status;

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "InhouseTransferResponse{" +
                "transactionId='" + getTransactionId() + '\'' +
                ", transactionDate=" + transactionDate +
                ", referenceId='" + referenceId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}